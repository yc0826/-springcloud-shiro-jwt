package com.haochen.consumer.auth.controller;

import com.haochen.common.Constants;
import com.haochen.common.Response;
import com.haochen.common.utils.ResultHelper;
import com.haochen.consumer.auth.dto.InterUserRollDto;
import com.haochen.consumer.auth.dto.UserRollQueryDto;
import com.haochen.consumer.auth.entity.MstInterUserRollEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.consumer.auth.service.MstRollBaseService;
import com.haochen.consumer.auth.service.SubsyBaseService;
import com.haochen.consumer.base.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/authorization")
public class AuthorizationController extends BaseController {

    private final MstInterUserRollService authorizationService;
    private final MstInterUserBaseService userService;
    private final MstRollBaseService roleService;
    private final SubsyBaseService subsyBaseService;

    @Autowired
    public AuthorizationController(MstInterUserRollService authorizationService, MstInterUserBaseService userService, MstRollBaseService roleService, SubsyBaseService subsyBaseService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
        this.roleService = roleService;
        this.subsyBaseService = subsyBaseService;
    }




    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getAuthorizationList")
    public Response getAuthorizationList(UserRollQueryDto userRollQueryDto) {
        Map<String, Object> paramMap = new HashMap<>(8);
        paramMap.put("start", userRollQueryDto.getStart());
        paramMap.put("size", userRollQueryDto.getPageSize());
        Map<String, Object> resultMap =new HashMap<>(2);
        List<InterUserRollDto> authorizationList = authorizationService.findPage(paramMap);
        resultMap.put("authorizationList", authorizationList);
        resultMap.put("count", authorizationService.count(paramMap));
        return ResultHelper.successResp(resultMap);
    }

    @RequiresPermissions("authorization:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        MstInterUserRollEntity authorization = new MstInterUserRollEntity();
        model.addAttribute("authorization", authorization);
        model.addAttribute("op", "新增");
        return "auth/authorization/edit";
    }

//    @RequiresPermissions("authorization:create")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//
//    public Map<String, Object> create(MstInterUserRollEntity authorization) {
//        Map<String, Object> resultMap = new HashMap<>(2);
//        resultMap.put("status", 200);
//        try {
//            authorization.setCrtUserCode(getCurrentUserCode());
//            authorizationService.createAuthorization(authorization);
//        } catch (Exception e) {
//            resultMap.put("status", 500);
//            resultMap.put("errorMsg", "新建授权异常，请联系管理员");
//        }
//        return resultMap;
//    }

//    @RequiresPermissions("authorization:update")
//    @RequestMapping(value = "/{userCodeAndSubsyCode}/update", method = RequestMethod.GET)
//    public String showUpdateForm(@PathVariable("userCodeAndSubsyCode") String userCodeAndSubsyCode, Model model) {
//        setCommonData(model);
//        model.addAttribute("authorization", authorizationService.findByUserCodeAndSubsyCode(userCodeAndSubsyCode));
//        model.addAttribute("op", "修改");
//        return "auth/authorization/edit";
//    }

//    @RequiresPermissions("authorization:update")
//    @RequestMapping(value = "/{userCodeAndSubsyCode}/update", method = RequestMethod.POST)
//
//    public Map<String, Object> update(@PathVariable("userCodeAndSubsyCode") String userCodeAndSubsyCode, MstInterUserRollEntity authorization) {
//        Map<String, Object> resultMap = new HashMap<>(2);
//        resultMap.put("status", 200);
//        try {
//            authorization.setCrtUserCode(getCurrentUserCode());
//            authorizationService.updateAuthorization(userCodeAndSubsyCode, authorization);
//        } catch (Exception e) {
//            resultMap.put("status", 500);
//            resultMap.put("errorMsg", "编辑授权异常，请联系管理员");
//        }
//        return resultMap;
//    }


//    @RequiresPermissions("authorization:delete")
//    @RequestMapping(value = "/{userCodeAndSubsyCode}/delete", method = RequestMethod.POST)
//
//    public Map<String, Object> delete(@PathVariable("userCodeAndSubsyCode") String userCodeAndSubsyCode) {
//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("status", 200);
//        try {
//            authorizationService.deleteAuthorization(userCodeAndSubsyCode);
//        } catch (Exception e) {
//            resultMap.put("status", 500);
//            resultMap.put("errorMsg", "删除授权异常");
//        }
//        return resultMap;
//    }

    private void setCommonData(Model model) {
        model.addAttribute("userList", userService.findBySubsyCodes(getCurrentUserSubsyCodes()));
        model.addAttribute("roleList", roleService.findBySubsyCodes(getCurrentUserSubsyCodes()));
        Map<String, Object> paramMap = new HashMap<>();
        if (!getCurrentUserSubsyCodes().contains(Constants.PLATFORM_SUBSY_CODE)) {
            String[] subsyCodes = getCurrentUserSubsyCodes().split(",");
            paramMap.put("subsyCodes", subsyCodes);
        }
        model.addAttribute("subsyList", subsyBaseService.findSubsyListBySubsyCodes(paramMap));
    }


}
