package com.haochen.provider.auth.controller;

import com.haochen.provider.auth.entity.MstSubsyBaseEntity;
import com.haochen.provider.auth.service.SubsyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/subsy")
public class SubsyController {

    private final SubsyBaseService subsyBaseService;

    @Autowired
    public SubsyController(SubsyBaseService subsyBaseService) {
        this.subsyBaseService = subsyBaseService;
    }

    @RequestMapping(value = "/findPage", method = RequestMethod.POST)

    public List<MstSubsyBaseEntity> findSubsyListBySubsyCodes(@RequestBody Map<String, Object> paramMap) {
        return subsyBaseService.findSubsyListBySubsyCodes(paramMap);
    }
}
