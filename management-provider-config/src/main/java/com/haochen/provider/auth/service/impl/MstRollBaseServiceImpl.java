package com.haochen.provider.auth.service.impl;

import com.haochen.provider.auth.entity.MstRollBaseEntity;
import com.haochen.provider.auth.repo.IMstRollBaseDao;
import com.haochen.provider.auth.service.CfgSysResoService;
import com.haochen.provider.auth.service.MstRollBaseService;
import com.haochen.common.Constants;
import com.haochen.common.utils.BizCodeGeneratorUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author YangChao
 */
@Service
public class MstRollBaseServiceImpl implements MstRollBaseService {

    @Resource
    private IMstRollBaseDao mstRollBaseDao;
	
    @Resource
    private CfgSysResoService cfgSysResoService;

    @Override
    public List<MstRollBaseEntity> findAll() {
        return mstRollBaseDao.queryAll();
    }

    @Override
    public MstRollBaseEntity findByCode(String rollCode) {
        MstRollBaseEntity role = mstRollBaseDao.findByCode(rollCode);
        role.setCfgSysResoEntitySet( cfgSysResoService.findResoSetByRollCode(role.getRollCode()));
        return role;
    }

    @Override
    public List<MstRollBaseEntity> findPage(Map<String, Object> map) {
        return mstRollBaseDao.findPage(map);
    }

    @Override
    public Integer count(Map<String, Object> paramMap) {
        return mstRollBaseDao.count(paramMap);
    }

    @Override
    public MstRollBaseEntity createRole(MstRollBaseEntity role) {
        role.setRollCode(BizCodeGeneratorUtil.getBizCode(BizCodeGeneratorUtil.TblNameIntiEnum.MST_ROLL_BASE));
        role.setCrtTime(new Date());
        mstRollBaseDao.insert(role);
        insertRoleResource(role);
        return role;
    }

    private void insertRoleResource(MstRollBaseEntity role){
        if (!CollectionUtils.isEmpty(role.getResoCodeList())) {
            role.getResoCodeList().forEach(resoCode -> {
                Map<String, Object> paramMap = new HashMap<>(4);
                paramMap.put("rollCode", role.getRollCode());
                paramMap.put("resoCode", resoCode);
                paramMap.put("resoOperCode", "00050003");
                paramMap.put("crtUserCode", role.getCrtUserCode());
                mstRollBaseDao.insertRoleResource(paramMap);
            });
        }
    }

    @Override
    public MstRollBaseEntity updateRole(MstRollBaseEntity role) {
        MstRollBaseEntity rollBaseEntity = mstRollBaseDao.findByCode(role.getRollCode());
        role.setMstRollBaseId(rollBaseEntity.getMstRollBaseId());
        role.setVerNum(rollBaseEntity.getVerNum());
        mstRollBaseDao.updateById(role);
        mstRollBaseDao.deleteRoleResource(role.getRollCode());
        insertRoleResource(role);
        return role;
    }

    @Override
    public void deleteRoleByCode(String rollCode) {
        mstRollBaseDao.deleteRoleResource(rollCode);
        mstRollBaseDao.deleteRoleByCode(rollCode);
    }

    @Override
    public Set<String> findRoles(String... roleCodes) {
        Set<String> roles = new HashSet<>();
        String roleNames = mstRollBaseDao.findNamesByRollCodes(roleCodes);
        if(StringUtils.hasText(roleNames)) {
            String[] rolleArray = roleNames.split(",");
            Collections.addAll(roles, rolleArray);
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(String[] roleCodes) {
        Set<String> resoCodes = mstRollBaseDao.findResourceCodesByRoleCodes(roleCodes);
        if (!CollectionUtils.isEmpty(resoCodes)) {
            return cfgSysResoService.findPermissions(resoCodes);
        }
        return null;
    }

    @Override
    public String findNamesByRollCodes(String[] rollCodes) {
        return mstRollBaseDao.findNamesByRollCodes(rollCodes);
    }

    @Override
    public List<MstRollBaseEntity> findBySubsyCodes(String subsyCodes) {
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("flag", 0);
        if(subsyCodes.contains(Constants.PLATFORM_SUBSY_CODE)) {
            paramMap.put("flag", 1);
        }
        return mstRollBaseDao.findByFilter(paramMap);
    }


    //-- user-defined end --
}
