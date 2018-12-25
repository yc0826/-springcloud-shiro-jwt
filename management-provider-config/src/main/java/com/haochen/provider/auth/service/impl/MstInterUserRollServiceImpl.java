package com.haochen.provider.auth.service.impl;

import com.haochen.provider.auth.dto.InterUserRollDto;
import com.haochen.provider.auth.entity.MstInterUserBaseEntity;
import com.haochen.provider.auth.entity.MstInterUserRollEntity;
import com.haochen.provider.auth.repo.IMstInterUserBaseDao;
import com.haochen.provider.auth.repo.IMstInterUserRollDao;
import com.haochen.provider.auth.service.MstInterUserRollService;
import com.haochen.provider.auth.service.MstRollBaseService;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author YangChao
 */
@Service
public class MstInterUserRollServiceImpl implements MstInterUserRollService {

    @Autowired
    private IMstInterUserRollDao mstInterUserRollDao;

    @Resource
    private IMstInterUserBaseDao mstInterUserBaseDao;

    @Autowired
    private MstRollBaseService mstRollBaseService;

    @Override
    public void deleteAuthorization(String userCodeAndSubsyCode) {
        String[] strs = userCodeAndSubsyCode.split(",");
        mstInterUserRollDao.deleteUserRollByUserCode(strs[0], strs[1]);
    }


    @Override
    public List<InterUserRollDto> findPage(Map<String, Object> paramMap) {
        List<InterUserRollDto> list = mstInterUserRollDao.findPage(paramMap);
        list.forEach((InterUserRollDto userRoe) -> {
            String[] rollCodes = userRoe.getRollCodes().split(",");
            userRoe.setRollNames(mstRollBaseService.findNamesByRollCodes(rollCodes));
        });
        return list;
    }

    @Override
    public Integer count(Map<String, Object> paramMap) {
        return mstInterUserRollDao.count(paramMap);
    }

    @Override
    public void createAuthorization(MstInterUserRollEntity authorization) {
        updateAuthorization(null, authorization);
    }

    @Override
    public void updateAuthorization(String userCodeAndSubsyCode, MstInterUserRollEntity authorization) {
        if (StringUtils.hasText(userCodeAndSubsyCode)) {
            deleteUserRollByUserCode(userCodeAndSubsyCode);
        } else {
            mstInterUserRollDao.deleteUserRollByUserCode(authorization.getInterUserCode(), authorization.getSubsyCode());
        }
        String[] rollCodeArray = authorization.getRollCodes().split(",");
        for (String rollCode : rollCodeArray) {
            Map<String, Object> paramMap = new HashMap<>(5);
            paramMap.put("interUserCode", authorization.getInterUserCode());
            paramMap.put("subsyCode", authorization.getSubsyCode());
            paramMap.put("rollCode", rollCode);
            paramMap.put("crtTime", new Date());
            paramMap.put("crtUserCode", authorization.getCrtUserCode());
            mstInterUserRollDao.insertUserRoll(paramMap);
        }
    }

    private void deleteUserRollByUserCode(String userCodeAndSubsyCode) {
        String[] strs = userCodeAndSubsyCode.split(",");
        mstInterUserRollDao.deleteUserRollByUserCode(strs[0], strs[1]);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        MstInterUserBaseEntity user = mstInterUserBaseDao.findByUsername(userName);
        if (user == null) {
            return Collections.emptySet();
        }
        List<String> roleCodes = mstInterUserRollDao.findByUserCode(user.getInterUserCode());
        if (CollectionUtils.isEmpty(roleCodes)) {
            return Collections.emptySet();
        }
        final int size = roleCodes.size();
        return mstRollBaseService.findPermissions(roleCodes.toArray(new String[size]));
    }

    @Override
    public Set<String> findRoles(String username) {
        MstInterUserBaseEntity user = mstInterUserBaseDao.findByUsername(username);
        if (user == null) {
            return Collections.emptySet();
        }

        List<String> roleCodes = mstInterUserRollDao.findByUserCode( user.getInterUserCode());
        if (CollectionUtils.isEmpty(roleCodes)) {
            return Collections.emptySet();
        }
        final int size = roleCodes.size();
        return mstRollBaseService.findRoles(roleCodes.toArray(new String[size]));
    }

    @Override
    public MstInterUserRollEntity findByUserCodeAndSubsyCode(String userCodeAndSubsyCode) {
        String[] strs = userCodeAndSubsyCode.split(",");
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("userCode", strs[0]);
        paramMap.put("subsyCode", strs[1]);
        MstInterUserRollEntity userRoe = mstInterUserRollDao.findEntityByUserCodeAndSubsyCode(paramMap);
        String[] rollCodes = userRoe.getRollCodes().split(",");
        userRoe.setRollNames(mstRollBaseService.findNamesByRollCodes(rollCodes));
        return userRoe;
    }

    @Override
    public Integer getCount() {
        return mstInterUserRollDao.getCount();
    }

    //-- user-defined end --
}
