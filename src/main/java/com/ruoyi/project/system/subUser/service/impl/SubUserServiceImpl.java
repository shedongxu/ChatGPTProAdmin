package com.ruoyi.project.system.subUser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.subUser.mapper.SubUserMapper;
import com.ruoyi.project.system.subUser.domain.SubUser;
import com.ruoyi.project.system.subUser.service.ISubUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 订阅用户管理Service业务层处理
 * 
 * @author sdx
 * @date 2023-04-24
 */
@Service
public class SubUserServiceImpl implements ISubUserService 
{
    @Autowired
    private SubUserMapper subUserMapper;

    /**
     * 查询订阅用户管理
     * 
     * @param id 订阅用户管理主键
     * @return 订阅用户管理
     */
    @Override
    public SubUser selectSubUserById(Long id)
    {
        return subUserMapper.selectSubUserById(id);
    }

    /**
     * 查询订阅用户管理列表
     * 
     * @param subUser 订阅用户管理
     * @return 订阅用户管理
     */
    @Override
    public List<SubUser> selectSubUserList(SubUser subUser)
    {
        return subUserMapper.selectSubUserList(subUser);
    }

    /**
     * 新增订阅用户管理
     * 
     * @param subUser 订阅用户管理
     * @return 结果
     */
    @Override
    public int insertSubUser(SubUser subUser)
    {
        return subUserMapper.insertSubUser(subUser);
    }

    /**
     * 修改订阅用户管理
     * 
     * @param subUser 订阅用户管理
     * @return 结果
     */
    @Override
    public int updateSubUser(SubUser subUser)
    {
        return subUserMapper.updateSubUser(subUser);
    }

    /**
     * 批量删除订阅用户管理
     * 
     * @param ids 需要删除的订阅用户管理主键
     * @return 结果
     */
    @Override
    public int deleteSubUserByIds(String ids)
    {
        return subUserMapper.deleteSubUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订阅用户管理信息
     * 
     * @param id 订阅用户管理主键
     * @return 结果
     */
    @Override
    public int deleteSubUserById(Long id)
    {
        return subUserMapper.deleteSubUserById(id);
    }
}
