package com.haochen.consumer.base.controller;

import com.haochen.common.Response;
import com.haochen.common.utils.ResultHelper;
import com.haochen.consumer.auth.dto.MenuDto;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.consumer.base.service.CommonService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    private final CommonService commonService;
    private final CfgSysResoService resoService;
    private final MstInterUserRollService userRoleService;

    @Autowired
    public CommonController(CommonService commonService, CfgSysResoService resoService, MstInterUserRollService userRoleService) {
        this.commonService = commonService;
        this.resoService = resoService;
        this.userRoleService = userRoleService;
    }


    @RequestMapping("/cloud")

    public String cloud(String name) {
        return commonService.cloud(name);
    }



    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/getMenus")
    public Response getMenus(@RequestParam String resCode) {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        Set<String> permissions = userRoleService.findPermissions(userName);
        MenuDto menuDto = new MenuDto();
        menuDto.setPermissions(permissions);
        menuDto.setResCode(resCode);
        return ResultHelper.successResp(resoService.findMenus(menuDto));
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getModule")
    public Response getModule() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        if (userName == null) {
            throw new UnauthorizedException("User didn't existed!");
        }
        Set<String> permissions = userRoleService.findPermissions(userName);
        return ResultHelper.successResp(resoService.findModule(permissions));
    }
}
