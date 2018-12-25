package com.haochen.consumer.base.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "common")
public interface CommonService {

    @RequestMapping("/cloud")
    String cloud(@RequestParam("name") String name);
}
