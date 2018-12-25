package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.dto.InterUserRollDto;
import com.haochen.provider.auth.service.MstInterUserRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    private final MstInterUserRollService mstInterUserRollService;

    @Autowired
    public AuthorizationController(MstInterUserRollService mstInterUserRollService) {
        this.mstInterUserRollService = mstInterUserRollService;
    }


    @PostMapping(value = "/findPage")
    public List<InterUserRollDto> findPage(@RequestBody Map<String, Object> paramMap) {
        return mstInterUserRollService.findPage(paramMap);
    }

    @PostMapping(value = "/count")
    public Integer count(@RequestBody Map<String, Object> paramMap) {
        return mstInterUserRollService.count(paramMap);
    }

    @PostMapping(value = "/findPermissions")
    public Set<String> findPermissions(@RequestParam("userName") String userName) {
        return mstInterUserRollService.findPermissions(userName);
    }

    @PostMapping(value = "/findRoles")
    public Set<String> findRoles(String userName) {
        return mstInterUserRollService.findRoles(userName);
    }


}
