package com.haochen.consumer.auth.service;


import com.haochen.consumer.auth.dto.InterUserRollDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "authorization")
public interface MstInterUserRollService {


//    void deleteAuthorization(String userCodeAndSubsyCode);

    @PostMapping(value = "/findPage")
    List<InterUserRollDto> findPage(Map<String, Object> paramMap);

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    Integer count(Map<String, Object> paramMap);

//    void createAuthorization(MstInterUserRollEntity authorization);
//
//    void updateAuthorization(String userCodeAndSubsyCode, MstInterUserRollEntity authorization);

    @RequestMapping(value = "/findPermissions", method = RequestMethod.POST)
    Set<String> findPermissions(@RequestParam("userName") String userName);

    @RequestMapping(value = "/findRoles", method = RequestMethod.POST)
    Set<String> findRoles(@RequestParam("userName") String userName);

//    MstInterUserRollEntity findByUserCodeAndSubsyCode(String userCodeAndSubsyCode);


}
