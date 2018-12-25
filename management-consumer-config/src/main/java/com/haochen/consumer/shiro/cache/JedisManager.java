package com.haochen.consumer.shiro.cache;

import com.haochen.common.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YangChao
 */
@SuppressWarnings("unchecked")
public class JedisManager {

    private JedisPool jedisPool;

    private Jedis getJedis() {
        Jedis jedis;
        try {
            jedis = getJedisPool().getResource();
        } catch (JedisConnectionException e) {
        	throw new JedisConnectionException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jedis;
    }

    private void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis == null) {
            return;
        }
        jedis.close();
    }

    byte[] getValueByKey(int dbIndex, byte[] key) {
        Jedis jedis = null;
        byte[] result;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            result = jedis.get(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
        return result;
    }

    void deleteByKey(int dbIndex, byte[] key) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            Long result = jedis.del(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    void saveValueByKey(int dbIndex, byte[] key, byte[] value, int expireTime) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(key, value);
            if (expireTime > 0) {
                jedis.expire(key, expireTime);
            }

        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

	/**
	 * 获取所有Session
	 * @param dbIndex
	 * @param redisShiroSession
	 */
    public Collection<Session> allSession(int dbIndex, String redisShiroSession) {
		Jedis jedis = null;
        boolean isBroken = false;
        Set<Session> sessions = new HashSet<>();
		try {
            jedis = getJedis();
            jedis.select(dbIndex);
            
            Set<byte[]> byteKeys = jedis.keys((JedisShiroSessionRepository.REDIS_SHIRO_ALL).getBytes());  
            if (byteKeys != null && byteKeys.size() > 0) {  
                for (byte[] bs : byteKeys) {  
                	Session obj = SerializeUtil.deserialize(jedis.get(bs),
                    		 Session.class);
                     if(obj != null){
                    	 sessions.add(obj);  
                     }
                }  
            }  
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            returnResource(jedis, isBroken);
        }
        return sessions;
	}
}
