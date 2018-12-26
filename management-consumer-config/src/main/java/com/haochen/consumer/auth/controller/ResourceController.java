package com.haochen.consumer.auth.controller;

import com.haochen.common.Response;
import com.haochen.common.utils.ResultHelper;
import com.haochen.consumer.auth.entity.CfgSysResoEntity;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.base.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    private final CfgSysResoService resourceService;

    @Autowired
    public ResourceController(CfgSysResoService resourceService) {
        this.resourceService = resourceService;
    }


    @RequiresPermissions("resource:view")
    @RequestMapping()
    public String list(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
        return "auth/resource/list";
    }


    @GetMapping("/findMenus")
    public Response findMenus() {
        return ResultHelper.successResp(resourceService.findAll());
    }



    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentResoCode}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentResoCode") String parentResoCode, Model model) {
        CfgSysResoEntity parent = resourceService.findByCode(parentResoCode);
        model.addAttribute("parent", parent);
        CfgSysResoEntity child = new CfgSysResoEntity();
        child.setParentResoCode(parentResoCode);
        child.setParentResoCodes(parent.makeSelfAsParentCodes());
        model.addAttribute("resource", child);
        model.addAttribute("op", "新 增子节点");
        return "auth/resource/edit";
    }

//    @RequiresPermissions("resource:create")
//    @RequestMapping(value = "/{parentResoCode}/appendChild", method = RequestMethod.POST)
//    public String create(CfgSysResoEntity resource, RedirectAttributes redirectAttributes) {
//        resource.setCrtUserCode(getCurrentUserCode());
//        resourceService.createResource(resource);
//        redirectAttributes.addFlashAttribute("msg", "新 增子节点成功");
//        return "redirect:/resource";
//    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{resoCode}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("resoCode") String resoCode, Model model) {
        model.addAttribute("resource", resourceService.findByCode(resoCode));
        model.addAttribute("op", "修改");
        return "auth/resource/edit";
    }

//    @RequiresPermissions("resource:update")
//    @RequestMapping(value = "/{resoCode}/update", method = RequestMethod.POST)
//    public String update(CfgSysResoEntity resource, RedirectAttributes redirectAttributes) {
//        resource.setUpdUserCode(getCurrentUserCode());
//        resourceService.updateResource(resource);
//        redirectAttributes.addFlashAttribute("msg", "修改成功");
//        return "redirect:/resource";
//    }
//
//    @RequiresPermissions("resource:delete")
//    @RequestMapping(value = "/{resoCode}/delete", method = RequestMethod.GET)
//    public String delete(@PathVariable("resoCode") String resoCode, RedirectAttributes redirectAttributes) {
//        resourceService.deleteResource(resoCode);
//        redirectAttributes.addFlashAttribute("msg", "删除成功");
//        return "redirect:/resource";
//    }


}
