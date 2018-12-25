package com.haochen.provider.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangChao
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/cloud")
    public String cloud(String name) {
        return "hello" + name + "---->2";
    }
}
