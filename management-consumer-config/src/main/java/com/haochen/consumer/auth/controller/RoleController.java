package com.haochen.consumer.auth.controller;

import com.haochen.common.Response;
import com.haochen.common.utils.ResultHelper;
import com.haochen.consumer.auth.dto.RoleListDto;
import com.haochen.consumer.auth.entity.MstRollBaseEntity;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.auth.service.MstRollBaseService;
import com.haochen.consumer.base.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    private final MstRollBaseService roleService;

    private final CfgSysResoService resourceService;

    @Autowired
    public RoleController(MstRollBaseService roleService, CfgSysResoService resourceService) {
        this.roleService = roleService;
        this.resourceService = resourceService;
    }






    @RequiresPermissions("role:view")
    @RequestMapping()
    public String list() {
        return "auth/role/list";
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/roleList")
    public Response roleList(RoleListDto roleListDto) {
        Map<String, Object> paramMap = new HashMap<>(6);
        paramMap.put("start", roleListDto.getStart());
        paramMap.put("size", roleListDto.getPageSize());
        List<MstRollBaseEntity> roleList = roleService.findPage(paramMap);
        Map<String, Object> resultMap =new HashMap<>(2);
        resultMap.put("roleList", roleList);
        resultMap.put("roleCount", roleService.count(paramMap));
        return ResultHelper.successResp(resultMap);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/findMenus")
    public Response findMenus(String roleCode) {
        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("menus", resourceService.findAll());
        paramMap.put("checkedNodes", resourceService.getCheckedNodesByRoleCode(roleCode));
        return ResultHelper.successResp(paramMap);
    }

}
