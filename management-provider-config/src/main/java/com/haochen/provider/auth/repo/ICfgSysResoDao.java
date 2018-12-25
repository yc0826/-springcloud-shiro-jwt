package com.haochen.provider.auth.repo;

import com.haochen.provider.auth.dto.MenuTreeDto;
import com.haochen.provider.auth.entity.CfgSysResoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChao
 */
@Mapper
public interface ICfgSysResoDao {


    int updateById(CfgSysResoEntity cfgSysResoEntity);

    void insert(CfgSysResoEntity cfgSysResoEntity);

    CfgSysResoEntity queryById(String id);

    CfgSysResoEntity queryByCondition(Map map);

    List<CfgSysResoEntity> queryList(CfgSysResoEntity cfgSysResoEntity);

    List<CfgSysResoEntity> queryList(Map map);

    List<CfgSysResoEntity> queryAll();

    int queryCount(CfgSysResoEntity cfgSysResoEntity);

    int deleteById(String id);

    int deleteLogicById(String id);

    int updateByCondition(CfgSysResoEntity cfgSysResoEntity);

    CfgSysResoEntity findByCode(String resoCode);




    //-- user-defined start --

    List<CfgSysResoEntity> findAll();

    Set<CfgSysResoEntity> findResoSetByRollCode(String rollCode);

    void deleteLogicByResCode(String parentResoCodeArray);

    void deleteOperLogicByResCode(String parentResoCodeArray);

    List<CfgSysResoEntity> findByParentCode(String resoCode);

    Set<String> findfindPermissionsByResoCodes(List<String> resoCodes);

    String getWebResoMaxCode();


    List<CfgSysResoEntity> findByPermissions(List<String> permissions);

    List<CfgSysResoEntity> findMenusByParentCode(Map<String, Object> paramMap);

    String findParentCodeByChildUrl(String url);

    List<MenuTreeDto> findMenusByParenCode(String parentCode);

    List<String> getCheckedNodesByRoleCode(String roleCode);


    //-- user-defined end --
}