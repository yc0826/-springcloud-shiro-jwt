package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.entity.MstRollBaseEntity;
import com.haochen.provider.auth.service.MstRollBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/role")
public class RoleController  {

    private final MstRollBaseService roleService;

    @Autowired
    public RoleController(MstRollBaseService roleService) {
        this.roleService = roleService;
    }


    @PostMapping(value = "/findPage")
    public  List<MstRollBaseEntity> findPage(@RequestBody Map<String, Object> paramMap) {
       return roleService.findPage(paramMap);
    }

    @PostMapping(value = "/count")
    public Integer count(@RequestBody Map<String, Object> paramMap) {
        return roleService.count(paramMap);
    }


    @PostMapping(value = "/findByCode")
    public MstRollBaseEntity findByCode(String rollCode) {
        return roleService.findByCode(rollCode);
    }

    @PostMapping(value = "/findBySubsyCodes")
    public List<MstRollBaseEntity> findBySubsyCodes(String subsyCodes) {
        return roleService.findBySubsyCodes(subsyCodes);
    }

}
