package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.dto.InterUserDto;
import com.haochen.provider.auth.dto.UserInfoOutputBean;
import com.haochen.provider.auth.entity.MstInterUserBaseEntity;
import com.haochen.provider.auth.entity.MstInterUserDtlEntity;
import com.haochen.provider.auth.entity.TranInterUserTokenEntity;
import com.haochen.provider.auth.service.MstInterUserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final MstInterUserBaseService userService;

    @Autowired
    public UserController(MstInterUserBaseService userService) {
        this.userService = userService;
    }

    @PostMapping("/findPage")
    public List<InterUserDto> findPage(@RequestBody Map<String, Object> paramMap) {
        return userService.findPage(paramMap);
    }

    @PostMapping(value = "/count")
    public Integer count(@RequestBody Map<String, Object> paramMap) {
        return userService.count(paramMap);
    }


    @PostMapping(value = "/findByCode")
    public MstInterUserBaseEntity findByCode(@RequestParam String userCode) {
        return userService.findByCode(userCode);
    }


    @PostMapping(value = "/findByUsername")
    public MstInterUserBaseEntity findByUsername(@RequestParam("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @PostMapping(value = "/findDtlByUserCode")
    public MstInterUserDtlEntity findDtlByUserCode(String userCode) {
        return userService.findDtlByUserCode(userCode);
    }


    @PostMapping(value = "/findBySubsyCodes")
    public List<MstInterUserBaseEntity> findBySubsyCodes(String subsyCodes) {
        return userService.findBySubsyCodes(subsyCodes);
    }

    @PostMapping(value = "/findRoleCodeByUserCode")
    public List<String> findRoleCodeByUserCode(@RequestParam("userCode") String userCode) {
        return userService.findRoleCodeByUserCode(userCode);
    }


    @GetMapping(value = "/getUserInfo")
    public UserInfoOutputBean getUserInfo(@RequestParam("userName") String userName) {
        return userService.getUserInfo(userName);
    }


    @PostMapping(value = "/updateJwtToken")
    public void updateJwtToken(@RequestBody TranInterUserTokenEntity tranInterUserTokenEntity) {
        userService.updateJwtToken(tranInterUserTokenEntity);
    }

    @GetMapping(value = "/checkJwtToken")
    public Integer checkJwtToken(@RequestParam("token") String token) {
        return userService.checkJwtToken(token);
    }
}
