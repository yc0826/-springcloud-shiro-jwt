package com.haochen.consumer.auth.service;


import com.haochen.consumer.auth.dto.MenuDto;
import com.haochen.consumer.auth.dto.MenuTreeDto;
import com.haochen.consumer.auth.entity.CfgSysResoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author YangChao
 */
@FeignClient(value = "management-provider", path = "resource")
public interface CfgSysResoService {


//    List<CfgSysResoEntity> findMenus(Set<String> permissions);

    @PostMapping(value = "/findAll")
    List<MenuTreeDto> findAll();

    @PostMapping(value = "/findByCode")
    CfgSysResoEntity findByCode(String resoCode);

//    void createResource(CfgSysResoEntity resource);
//
//    void updateResource(CfgSysResoEntity resource);
//
//    void deleteResource(String resoCode);

//    Set<String> findPermissions(Set<String> resoCodes);
//
//    Set<CfgSysResoEntity> findResoSetByRollCode(String rollCode);

    @PostMapping(value = "/findModule")
    List<CfgSysResoEntity> findModule(@RequestBody Set<String> permissions);

    @PostMapping(value = "/findMenus")
    List<CfgSysResoEntity> findMenus(@RequestBody MenuDto menuDto);

    @PostMapping(value = "/getCheckedNodesByRoleCode")
    List<String> getCheckedNodesByRoleCode(@RequestParam("roleCode") String roleCode);

//    String findParentCodeByChildUrl(String url);
}
