package com.haochen.consumer.shiro.filter;

import com.haochen.consumer.auth.entity.CfgSysResoEntity;
import com.haochen.consumer.auth.entity.MstInterUserBaseEntity;
import com.haochen.consumer.auth.service.CfgSysResoService;
import com.haochen.consumer.auth.service.MstInterUserBaseService;
import com.haochen.consumer.auth.service.MstInterUserRollService;
import com.haochen.common.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @author YangChao
 */
public class SimpleFilter extends PathMatchingFilter {

    @Autowired
    private MstInterUserBaseService mstInterUserBaseService;
    @Autowired
    private MstInterUserRollService mstInterUserRollService;
    @Autowired
    private CfgSysResoService cfgSysResoService;

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)  {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Session session = SecurityUtils.getSubject().getSession();
        MstInterUserBaseEntity user = (MstInterUserBaseEntity) session.getAttribute(Constants.CURRENT_USER);
        if(user == null) {
            user = mstInterUserBaseService.findByUsername(username);
        }
        session.setAttribute(Constants.CURRENT_USER, user);

        Set<String> permissions = (Set<String>) session.getAttribute("permissions");
        if (CollectionUtils.isEmpty(permissions)) {
            permissions = mstInterUserRollService.findPermissions(username);
        }
        session.setAttribute("permissions", permissions);
        List<CfgSysResoEntity> module = (List<CfgSysResoEntity>) session.getAttribute("module");
        if (CollectionUtils.isEmpty(module)) {
            module = cfgSysResoService.findModule(permissions);
        }
        session.setAttribute("module", module);
        Set<String> roles = (Set<String>) session.getAttribute("roles");
        if (CollectionUtils.isEmpty(roles)) {
            roles = mstInterUserRollService.findRoles(username);
        }
        session.setAttribute("roles", roles);
        String parentResoCode = request.getParameter("parentResoCode");
        if(!StringUtils.hasText(parentResoCode)) {
            parentResoCode = (String) session.getAttribute("parentResoCode");
        }
        if(StringUtils.hasText(parentResoCode)) {
            session.setAttribute("parentResoCode", parentResoCode);
        }
        String resoCode = request.getParameter("resoCode");
        if(!StringUtils.hasText(resoCode)) {
            resoCode = (String) session.getAttribute("resoCode");
        }
        session.setAttribute("resoCode", resoCode);
        String childResoCode = request.getParameter("childResoCode");
        if(!StringUtils.hasText(childResoCode)) {
            childResoCode = (String) session.getAttribute("childResoCode");
        }
        session.setAttribute("childResoCode", childResoCode);
        return Boolean.TRUE;
    }
}
