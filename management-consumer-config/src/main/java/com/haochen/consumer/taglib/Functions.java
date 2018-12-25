package com.haochen.consumer.taglib;

import com.haochen.consumer.auth.entity.CfgSysResoEntity;
import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.entity.MstRollBaseEntity;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstRollBaseService;
import com.haochen.common.utils.SpringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author YangChao
 */
public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        return iterable != null && CollectionUtils.contains(iterable.iterator(), element);
    }

    public static String username(String userCode) {
        MstInterUserBaseEntity user = getUserService().findByCode(userCode);
        if (user == null) {
            return "";
        }
        return user.getUserName();
    }


    public static String roleName(String rollCode) {
        MstRollBaseEntity role = getRoleService().findByCode(rollCode);
        if (role == null) {
            return "";
        }
        return role.getRollDesc();
    }

    public static String roleNames(Collection<String> roleCodes) {
        return getCollectString(roleCodes);
    }

    public static String resourceName(String resoCode) {
        CfgSysResoEntity resource = getResourceService().findByCode(resoCode);
        if (resource == null) {
            return "";
        }
        return resource.getResoName();
    }

    public static String resourceNames(Collection<String> resoCodes) {
        return getCollectString(resoCodes);
    }




    private static String getCollectString(Collection<String> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (String resoCode : collection) {
            CfgSysResoEntity resource = getResourceService().findByCode(resoCode);
            if (resource == null) {
                return "";
            }
            s.append(resource.getResoName());
            s.append(",");
        }

        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }


    private static MstRollBaseService roleService;
    private static CfgSysResoService resourceService;
    private static MstInterUserBaseService userService;

    private static MstInterUserBaseService getUserService() {
        if (userService == null) {
            userService = SpringUtils.getBean(MstInterUserBaseService.class);
        }
        return userService;
    }


    private static MstRollBaseService getRoleService() {
        if (roleService == null) {
            roleService = SpringUtils.getBean(MstRollBaseService.class);
        }
        return roleService;
    }

    private static CfgSysResoService getResourceService() {
        if (resourceService == null) {
            resourceService = SpringUtils.getBean(CfgSysResoService.class);
        }
        return resourceService;
    }
}

