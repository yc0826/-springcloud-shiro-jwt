package com.haochen.consumer.auth.controller;

import com.haochen.consumer.auth.dto.MenuDto;
import com.haochen.consumer.auth.entity.CfgSysResoEntity;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.base.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author YangChao
 */
@RestController
public class IndexController extends BaseController {

    private final CfgSysResoService resourceService;

    @Autowired
    public IndexController(CfgSysResoService resourceService) {
        this.resourceService = resourceService;
    }


    @RequestMapping("/")
    public String index() {
        if (getCurrentUser() == null) {
            return "redirect:/login";
        }
        //判断商户号非空，直接返回主界面
        if (StringUtils.hasText(getCurrentUser().getSubsyCodes())) {
            return "redirect:/menus?parentResoCode=82";
        }
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("/menus")
    public String menus(String parentResoCode) {
        Session session = SecurityUtils.getSubject().getSession();
        session.removeAttribute("resoCode");
        session.removeAttribute("childResoCode");

        Set<String> permissions = (Set<String>) session.getAttribute("permissions");
        MenuDto menuDto = new MenuDto();
        menuDto.setPermissions(permissions);
        menuDto.setResCode(parentResoCode);
        List<CfgSysResoEntity> menus = resourceService.findMenus(menuDto);
        if (!CollectionUtils.isEmpty(menus)) {
            session.setAttribute("menus", menus);
        }

        return "main";
    }

    @RequestMapping("/uiTest")
    public String welcome() {
        return "abc";
    }

    @RequestMapping("/checkTest")
    public String check() {
        return "check";
    }


}
