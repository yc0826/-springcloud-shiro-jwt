package com.haochen.provider.auth.service;


import com.haochen.provider.auth.dto.MenuTreeDto;
import com.haochen.provider.auth.entity.CfgSysResoEntity;

import java.util.List;
import java.util.Set;

/**
 * @author YangChao
 */
public interface CfgSysResoService {


    List<CfgSysResoEntity> findMenus(Set<String> permissions);

    List<CfgSysResoEntity> findAll();

    List<MenuTreeDto> findAllMenu();


    CfgSysResoEntity findByCode(String resoCode);

    void createResource(CfgSysResoEntity resource);

    void updateResource(CfgSysResoEntity resource);

    void deleteResource(String resoCode);

    Set<String> findPermissions(Set<String> resoCodes);

    Set<CfgSysResoEntity> findResoSetByRollCode(String rollCode);

    List<CfgSysResoEntity> findModule(Set<String> permissions);

    List<CfgSysResoEntity> findMenus(Set<String> permissions, String resCode);

    String findParentCodeByChildUrl(String url);

    List<String> getCheckedNodesByRoleCode(String roleCode);
}
