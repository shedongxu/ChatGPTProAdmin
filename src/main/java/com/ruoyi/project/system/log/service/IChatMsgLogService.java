package com.ruoyi.project.system.log.service;

import java.util.List;
import com.ruoyi.project.system.log.domain.ChatMsgLog;

/**
 * 聊天日志Service接口
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
public interface IChatMsgLogService 
{
    /**
     * 查询聊天日志
     * 
     * @param id 聊天日志主键
     * @return 聊天日志
     */
    public ChatMsgLog selectChatMsgLogById(Long id);

    /**
     * 查询聊天日志列表
     * 
     * @param chatMsgLog 聊天日志
     * @return 聊天日志集合
     */
    public List<ChatMsgLog> selectChatMsgLogList(ChatMsgLog chatMsgLog);

    /**
     * 新增聊天日志
     * 
     * @param chatMsgLog 聊天日志
     * @return 结果
     */
    public int insertChatMsgLog(ChatMsgLog chatMsgLog);

    /**
     * 修改聊天日志
     * 
     * @param chatMsgLog 聊天日志
     * @return 结果
     */
    public int updateChatMsgLog(ChatMsgLog chatMsgLog);

    /**
     * 批量删除聊天日志
     * 
     * @param ids 需要删除的聊天日志主键集合
     * @return 结果
     */
    public int deleteChatMsgLogByIds(String ids);

    /**
     * 删除聊天日志信息
     * 
     * @param id 聊天日志主键
     * @return 结果
     */
    public int deleteChatMsgLogById(Long id);
}