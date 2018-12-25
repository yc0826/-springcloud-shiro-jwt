package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.dto.InterUserRollDto;
import com.haochen.provider.auth.service.MstInterUserRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private MstInterUserRollService mstInterUserRollService;


    @RequestMapping(value = "/findPage", method = RequestMethod.POST)

    public List<InterUserRollDto> findPage(@RequestBody Map<String, Object> paramMap) {
        return mstInterUserRollService.findPage(paramMap);
    }

    @RequestMapping(value = "/count", method = RequestMethod.POST)

    public Integer count(@RequestBody Map<String, Object> paramMap) {
        return mstInterUserRollService.count(paramMap);
    }

    @RequestMapping(value = "/findPermissions", method = RequestMethod.POST)

    public Set<String> findPermissions(@RequestParam("userName") String userName) {
        return mstInterUserRollService.findPermissions(userName);
    }

    @RequestMapping(value = "/findRoles", method = RequestMethod.POST)

    public Set<String> findRoles(String userName) {
        return mstInterUserRollService.findRoles(userName);
    }


}
