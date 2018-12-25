package com.haochen.provider.auth.service;

import com.haochen.provider.auth.entity.MstSubsyBaseEntity;
import com.haochen.provider.auth.dto.SubsyComboDto;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
public interface SubsyBaseService {


    List<MstSubsyBaseEntity> findAll();

    Integer count(Map<String, Object> paramMap);



    MstSubsyBaseEntity findByCode(String subsyCode);



    void update(MstSubsyBaseEntity mstSubsyBaseEntity);

    String getSubsyNamesByCodes(String subsyCodes);

    List<SubsyComboDto> getSubsyListByUserCode(String userCode);

    List<MstSubsyBaseEntity> findSubsyListBySubsyCodes(Map<String,Object> paramMap);
}
