package com.haochen.provider.auth.service.impl;

import com.haochen.common.Constants;
import com.haochen.provider.auth.dto.MenuTreeDto;
import com.haochen.provider.auth.entity.CfgSysResoEntity;
import com.haochen.provider.auth.repo.ICfgSysResoDao;
import com.haochen.provider.auth.service.CfgSysResoService;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author YangChao
 */
@Service
public class CfgSysResoServiceImpl implements CfgSysResoService {

    @Resource
    private ICfgSysResoDao cfgSysResoDao;


    @Override
    public List<CfgSysResoEntity> findMenus(Set<String> permissions) {
        List<CfgSysResoEntity> allResources = findWithChildren(permissions, null);
        List<CfgSysResoEntity> menus = new ArrayList<>();
        initMenus(menus, permissions, allResources);
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, CfgSysResoEntity resource) {
        if (StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CfgSysResoEntity> findMenus(Set<String> permissions, String resCode) {
        List<CfgSysResoEntity> allResources = findWithChildren(permissions, resCode);
        List<CfgSysResoEntity> menus = new ArrayList<>();
        initMenus(menus, permissions, allResources);
        return menus;
    }

    private void initMenus(List<CfgSysResoEntity> menus, Set<String> permissions, List<CfgSysResoEntity> allResources) {
        for (CfgSysResoEntity resource : allResources) {
            if ("0".equals(resource.getParentResoCode())) {
                continue;
            }
            if (!Constants.MENU.equals(resource.getResoTypeCode())) {
                continue;
            }
            if (!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
    }

    @Override
    public List<CfgSysResoEntity> findModule(Set<String> permissions) {
        List<String> permissionList = new ArrayList<>(permissions);

        try {
            return cfgSysResoDao.findByPermissions(permissionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CfgSysResoEntity> findAll() {
        List<CfgSysResoEntity> list = cfgSysResoDao.findAll();
        List<CfgSysResoEntity> sortList = new ArrayList<>();
        sortList(list, "0", sortList);
        return sortList;
    }

    private void sortList(List<CfgSysResoEntity> list, String resoCode, List<CfgSysResoEntity> sortList) {
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                CfgSysResoEntity cfgSysResoEntity = list.get(i);
                if (cfgSysResoEntity.getParentResoCode().equals(resoCode)) {
                    sortList.add(cfgSysResoEntity);
                    list.remove(i);
                    i--;
                    this.sortList(list, cfgSysResoEntity.getResoCode(), sortList);
                }
            }
        }
    }

    @Override
    public List<MenuTreeDto> findAllMenu() {
        return initWithChildren("0", 0);
    }

    private List<MenuTreeDto> initWithChildren(String parentCode, int depth) {
        List<MenuTreeDto> list = cfgSysResoDao.findMenusByParenCode(parentCode);
        if (!CollectionUtils.isEmpty(list)) {
            depth++;
            for (MenuTreeDto menuTreeDto : list) {
                menuTreeDto.setDepth(depth - 1);
                List<MenuTreeDto> menuTreeDtoList = this.initWithChildren(menuTreeDto.getId(), depth);
                if (!CollectionUtils.isEmpty(menuTreeDtoList)) {
                    menuTreeDto.setChildren(menuTreeDtoList);
                    menuTreeDto.setChild_num(menuTreeDtoList.size());
                }

            }
        }
        return list;
    }

    private List<CfgSysResoEntity> findWithChildren(Set<String> permissions, String parentResoCode) {
//
        return null;
    }

    @Override
    public CfgSysResoEntity findByCode(String resoCode) {
        return cfgSysResoDao.findByCode(resoCode);
    }

    @Override
    public void createResource(CfgSysResoEntity resource) {
        resource.setResoCode(cfgSysResoDao.getWebResoMaxCode());
        resource.setResoPlatCode("00050003");
        resource.setCrtTime(new Date());
        cfgSysResoDao.insert(resource);
    }

    @Override
    public void updateResource(CfgSysResoEntity resource) {
        CfgSysResoEntity r = findByCode(resource.getResoCode());
        resource.setCfgSysResoId(r.getCfgSysResoId());
        resource.setVerNum(r.getVerNum());
        resource.setUpdTime(new Date());
        cfgSysResoDao.updateById(resource);
    }

    @Override
    public void deleteResource(String resoCode) {
        deleteLogicByResCode(resoCode);
    }

    private void deleteLogicByResCode(String resoCode) {
        List<CfgSysResoEntity> resoEntityList = cfgSysResoDao.findByParentCode(resoCode);
        for (CfgSysResoEntity resoEntity : resoEntityList) {
            cfgSysResoDao.deleteLogicByResCode(resoEntity.getResoCode());
            cfgSysResoDao.deleteOperLogicByResCode(resoEntity.getResoCode());
        }
        cfgSysResoDao.deleteLogicByResCode(resoCode);
        cfgSysResoDao.deleteOperLogicByResCode(resoCode);
    }

    @Override
    public Set<String> findPermissions(Set<String> resoCodes) {
        List<String> codeList = new ArrayList<>(resoCodes);
        return cfgSysResoDao.findfindPermissionsByResoCodes(codeList);
    }

    @Override
    public Set<CfgSysResoEntity> findResoSetByRollCode(String rollCode) {
        return cfgSysResoDao.findResoSetByRollCode(rollCode);
    }

    @Override
    public String findParentCodeByChildUrl(String url) {
        return cfgSysResoDao.findParentCodeByChildUrl(url);
    }

    @Override
    public List<String> getCheckedNodesByRoleCode(String roleCode) {
        return cfgSysResoDao.getCheckedNodesByRoleCode(roleCode);
    }


    //-- user-defined end --
}
