package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.dto.MenuDto;
import com.haochen.provider.auth.dto.MenuTreeDto;
import com.haochen.provider.auth.entity.CfgSysResoEntity;
import com.haochen.provider.auth.service.CfgSysResoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final CfgSysResoService cfgSysResoService;

    @Autowired
    public ResourceController(CfgSysResoService cfgSysResoService) {
        this.cfgSysResoService = cfgSysResoService;
    }


    @PostMapping(value = "/findModule")
    public List<CfgSysResoEntity> findModule(@RequestBody Set<String> permissions) {
        return cfgSysResoService.findModule(permissions);
    }

    @PostMapping(value = "/findMenus")
    public List<CfgSysResoEntity> findMenus(@RequestBody MenuDto menuDto) {
        return cfgSysResoService.findMenus(menuDto.getPermissions(), menuDto.getResCode());
    }

    @PostMapping(value = "/findByCode")
    public CfgSysResoEntity findByCode(String resoCode) {
        return cfgSysResoService.findByCode(resoCode);
    }

    @PostMapping(value = "/findAll")
    public List<MenuTreeDto> findAll() {
        return cfgSysResoService.findAllMenu();
    }


    @PostMapping(value = "/getCheckedNodesByRoleCode")
    public List<String> getCheckedNodesByRoleCode(@RequestParam("roleCode") String roleCode) {
        return cfgSysResoService.getCheckedNodesByRoleCode(roleCode);
    }


}
