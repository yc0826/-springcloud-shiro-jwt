package com.haochen.consumer.auth.controller;

import com.haochen.common.Constants;
import com.haochen.common.Response;
import com.haochen.common.exception.SystemException;
import com.haochen.common.utils.ResultHelper;
import com.haochen.consumer.auth.dto.*;
import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.base.controller.BaseController;
import com.haochen.consumer.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    private final MstInterUserBaseService userService;

    @Autowired
    public UserController(MstInterUserBaseService userService) {
        this.userService = userService;
    }



    @PostMapping("/login")
    public Response login(@RequestBody LoginInputBean loginDto) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUsername(), loginDto.getPassword());
        subject.login(token);

        MstInterUserBaseEntity user = (MstInterUserBaseEntity) subject.getPrincipal();
        String newToken = JwtUtils.sign(user.getUserName(), user.getSalt(), 3600) ;
        LoginOutputBean loginOutputBean = new LoginOutputBean();
        loginOutputBean.setToken(newToken);
        return ResultHelper.successResp(loginOutputBean);
    }

    @GetMapping("/info")
    public Response info() {
        MstInterUserBaseEntity mstInterUserBaseEntity = (MstInterUserBaseEntity) SecurityUtils.getSubject().getPrincipal();
        UserInfoOutputBean userInfoOutputBean = userService.getUserInfo(mstInterUserBaseEntity.getUserName());
        return ResultHelper.successResp(userInfoOutputBean);
    }

    @PostMapping("/logout")
    public Response logout() {
        return ResultHelper.successResp();
    }



    @RequiresPermissions("user:view")
    @RequestMapping()
    public String list(Model model) {
        setCommonData(model);
        return "auth/user/list";
    }


    @RequiresPermissions("user:view")

    @GetMapping("/getInterUserListData")
    public Response getInterUserListData(UserListDto userListDto) {
        Map<String, Object> paramMap = new HashMap<>(6);
        paramMap.put("start", userListDto.getStart());
        paramMap.put("size", userListDto.getPageSize());
        List<InterUserDto> userList = userService.findPage(paramMap);
        Map<String, Object> resultMap =new HashMap<>(2);
        resultMap.put("userList", userList);
        resultMap.put("userCount", userService.count(paramMap));
        return ResultHelper.successResp(resultMap);
    }


    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new MstInterUserBaseEntity());
        model.addAttribute("op", "新增");
        return "auth/user/add";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Map<String, Object> create(MstInterUserBaseEntity user) {
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put("status", 200);
        user.setCrtUserCode(getCurrentUserCode());

        try {
            userService.createUser(user);
        } catch (SystemException e) {
            resultMap.put("status", 500);
            resultMap.put("errorMsg", e.getMessage());
        }
        return resultMap;
    }





    @RequiresPermissions("user:update")
    @PostMapping(value = "/{interUserCode}/update")
    public Map<String, Object> update(@PathVariable("interUserCode") String interUserCode, MstInterUserBaseEntity user) {
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("status", 200);
        try {
            MstInterUserBaseEntity m = userService.findByCode(interUserCode);
            user.setUpdUserCode(getCurrentUserCode());
            user.setVerNum(m.getVerNum());
            userService.updateUser(user);
        } catch (SystemException e) {
            resultMap.put("status", 500);
            resultMap.put("errorMsg", e.getMessage());
        }
        return resultMap;
    }

//    @RequiresPermissions("user:validate")
//    @RequestMapping(value = "/{interUserCode}/validate", method = RequestMethod.POST)
//
//    public Map<String, Object> validate(@PathVariable("interUserCode") String interUserCode) {
//        Map<String, Object> resultMap = new HashMap<>(2);
//        userService.validate(interUserCode, getCurrentUserCode());
//        resultMap.put("status", 200);
//        return resultMap;
//    }


    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/{interUserCode}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("interUserCode") String interUserCode, Model model) {
        setCommonData(model);
        model.addAttribute("user", userService.findByCode(interUserCode));
        model.addAttribute("op", "删除");
        return "auth/user/add";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/{interUserCode}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("interUserCode") String interUserCode, RedirectAttributes redirectAttributes) {
        userService.deleteUser(interUserCode);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/user";
    }


    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{interUserCode}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("interUserCode") String interUserCode, Model model) {
        model.addAttribute("user", userService.findByCode(interUserCode));
        model.addAttribute("op", "修改密码");
        return "auth/user/changePassword";
    }

//    @RequestMapping(value = "/getSubsyListByUserCode", method = RequestMethod.GET)
//
//    public List<SubsyComboDto> getSubsyListByUserCode(String userCode) {
//        return subsyBaseService.getSubsyListByUserCode(userCode);
//    }



    @RequestMapping(value = "/changeMyPassword", method = RequestMethod.GET)
    public String showChangeMyPasswordForm(HttpServletRequest request, Model model) {
        model.addAttribute("user", userService.findByCode(getCurrentUserCode()));
        model.addAttribute("originUrl", request.getHeader("referer"));
        model.addAttribute("op", "修改密码");
        return "auth/user/changePassword";
    }




    /**
     * 接口请求会话是否alive
     */
    @RequestMapping("/checkSessionAlive")
    public  String checkSessionAlive() {
        return getCurrentUserCode();
    }


    private void setCommonData(Model model) {
        Map<String, Object> paramMap = new HashMap<>(2);
        if (!getCurrentUserSubsyCodes().contains(Constants.PLATFORM_SUBSY_CODE)) {
            String[] subsyCodes = getCurrentUserSubsyCodes().split(",");
            paramMap.put("subsyCodes", subsyCodes);
        }
//        model.addAttribute("subsyList", subsyBaseService.findSubsyListBySubsyCodes(paramMap));
    }


}
