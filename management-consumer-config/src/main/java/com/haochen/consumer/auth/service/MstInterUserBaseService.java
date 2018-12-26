package com.haochen.consumer.auth.service;


import com.haochen.common.exception.SystemException;
import com.haochen.consumer.auth.dto.InterUserDto;
import com.haochen.consumer.auth.dto.UserInfoOutputBean;
import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.entity.MstInterUserDtlEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "user")
public interface MstInterUserBaseService {

    @PostMapping(value = "/findByCode")
    MstInterUserBaseEntity findByCode(@RequestParam("userCode") String userCode);

    @PostMapping(value = "/findByUsername")
    MstInterUserBaseEntity findByUsername(@RequestParam("userName") String userName);

    @PostMapping(value = "/findPage")
    List<InterUserDto> findPage(Map<String, Object> paramMap);

    @PostMapping(value = "/count")
    Integer count(Map<String, Object> paramMap);

    @PostMapping(value = "/createUser")
    void createUser(MstInterUserBaseEntity user) throws SystemException;

    @PostMapping(value = "/updateUser")
    void updateUser(MstInterUserBaseEntity user) throws SystemException;

    @PostMapping(value = "/deleteUser")
    void deleteUser(String interUserCode);

//    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
//    void changePassword(String interUserCode, String newPassword);

    @PostMapping(value = "/findBySubsyCodes")
    List<MstInterUserBaseEntity> findBySubsyCodes(@RequestParam("subsyCodes") String subsyCodes);

    @PostMapping(value = "/findDtlByUserCode")
    MstInterUserDtlEntity findDtlByUserCode(String userCode);

    @PostMapping(value = "/findRoleCodeByUserCode")
    List<String> findRoleCodeByUserCode(@RequestParam("userCode") String userCode);

    @GetMapping(value = "/getUserInfo")
    UserInfoOutputBean getUserInfo(@RequestParam("userName") String userName);


}
