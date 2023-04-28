package com.ruoyi.project.system.subUser.mapper;

import java.util.List;
import com.ruoyi.project.system.subUser.domain.SubUser;

/**
 * 订阅用户管理Mapper接口
 * 
 * @author sdx
 * @date 2023-04-24
 */
public interface SubUserMapper 
{
    /**
     * 查询订阅用户管理
     * 
     * @param id 订阅用户管理主键
     * @return 订阅用户管理
     */
    public SubUser selectSubUserById(Long id);

    /**
     * 查询订阅用户管理列表
     * 
     * @param subUser 订阅用户管理
     * @return 订阅用户管理集合
     */
    public List<SubUser> selectSubUserList(SubUser subUser);

    /**
     * 新增订阅用户管理
     * 
     * @param subUser 订阅用户管理
     * @return 结果
     */
    public int insertSubUser(SubUser subUser);

    /**
     * 修改订阅用户管理
     * 
     * @param subUser 订阅用户管理
     * @return 结果
     */
    public int updateSubUser(SubUser subUser);

    /**
     * 删除订阅用户管理
     * 
     * @param id 订阅用户管理主键
     * @return 结果
     */
    public int deleteSubUserById(Long id);

    /**
     * 批量删除订阅用户管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubUserByIds(String[] ids);

    /**
     * 通过授权密钥查询订阅用户信息
     *
     * @param code 授权密钥
     * @return 订阅用户信息
     */
    SubUser selectSubUserByCode(String code);
}
