package com.haochen.provider.auth.service.impl;

import com.haochen.provider.auth.entity.MstInterUserSubsyEntity;
import com.haochen.provider.auth.repo.IMstInterUserSubsyDao;
import com.haochen.provider.auth.service.MstInterUserSubsyService;
import com.haochen.common.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MstInterUserSubsyServiceImpl
 *
 * @author humin
 * @date 2017/9/14
 */
@Service
public class MstInterUserSubsyServiceImpl implements MstInterUserSubsyService {

    @Resource
    private IMstInterUserSubsyDao mstInterUserSubsyDao;

//    @Override
//    public List<MstInterUserSubsyEntity> getUserSubsyListByInterUserCode(String interUserCode) {
//        return this.mstInterUserSubsyDao.getUserSubsyListByInterUserCode(interUserCode);
//    }

    @Override
    public List<MstInterUserSubsyEntity> getUserSubsyListByDeptCode(Map params) {
        return this.mstInterUserSubsyDao.getUserSubsyListByDeptCode(params);
    }

    @Override
    public int queryCount(MstInterUserSubsyEntity mstInterUserSubsyEntity) {
        return this.mstInterUserSubsyDao.queryCount(mstInterUserSubsyEntity);
    }

    /**
     * 根据interUserCode和subsyCode查找是否存在
     */
    @Override
    public boolean isInterUserExsist(String interUserCode, String subsyCode) {
        MstInterUserSubsyEntity mstInterUserSubsyEntity = new MstInterUserSubsyEntity();
        mstInterUserSubsyEntity.setInterUserCode(interUserCode);
        mstInterUserSubsyEntity.setSubsyCode(subsyCode);
        return this.mstInterUserSubsyDao.queryCount(mstInterUserSubsyEntity) != 0;
    }

    /**
     * 根据内部用户code获取所属会所信息
     *
     * @param interUserCode
     * @return
     */
    @Override
    public List<Map> getInterUserSubsyInfoListByUserCode(String interUserCode) {
        return this.mstInterUserSubsyDao.getInterUserSubsyListByUserCode(interUserCode);
    }

    /**
     * 根据内部用户code获取他所属的所有会所code
     *
     * @param interUserCode
     * @return
     */
    @Override
    public List<String> getInterUserSubsyCodeListByUserCode(String interUserCode) {
        List<String> result = new ArrayList<>();
        List<Map> interUserSubsyList = this.getInterUserSubsyInfoListByUserCode(interUserCode);
        if (!CollectionUtils.isEmpty(interUserSubsyList)) {
            //遍历每个会所查找部门和角色信息
            for (Map map : interUserSubsyList) {
                String subsyCode = map.get("subsyCode").toString();
                if (!StringUtil.isEmpty(subsyCode)) {
                    result.add(subsyCode);
                }
            }
        }
        return result;
    }

    /**
     * 检查内部用户是否属于给予判断的会所code
     *
     * @param interUserCode
     * @param subsyCode
     * @return
     */
    @Override
    public boolean isSubsyCodeBelongToInterUser(String interUserCode, String subsyCode) {
        if (StringUtil.isEmpty(interUserCode) || StringUtil.isEmpty(subsyCode)) {
            return false;
        }
        List<String> subsyCodeList = this.getInterUserSubsyCodeListByUserCode(interUserCode);
        if (CollectionUtils.isEmpty(subsyCodeList)) {
            return false;
        }
        if (subsyCodeList.contains(subsyCode)) {
            return true;
        } else {
            return false;
        }
    }


    //-- user-defined end --}

}