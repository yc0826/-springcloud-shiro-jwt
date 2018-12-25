package com.haochen.consumer.auth.service;

import com.haochen.consumer.auth.entity.MstSubsyBaseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "subsy")
public interface SubsyBaseService {


    @RequestMapping(value = "/findPage", method = RequestMethod.POST)
    List<MstSubsyBaseEntity> findSubsyListBySubsyCodes(Map<String, Object> paramMap);
}
