package com.haochen.consumer.auth.service;


import com.haochen.consumer.auth.entity.MstRollBaseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "role" )
public interface MstRollBaseService {

    @RequestMapping(value = "/findByCode", method = RequestMethod.POST)
    MstRollBaseEntity findByCode(@RequestParam("rollCode") String rollCode);

    @RequestMapping(value = "/findPage", method = RequestMethod.POST)
    List<MstRollBaseEntity> findPage(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    Integer count(@RequestBody Map<String, Object> paramMap);

    @RequestMapping(value = "/findBySubsyCodes", method = RequestMethod.POST)
    List<MstRollBaseEntity> findBySubsyCodes(@RequestParam("subsyCodes") String subsyCodes);

}
