package com.ruoyi.project.system.log.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.log.mapper.ChatMsgLogMapper;
import com.ruoyi.project.system.log.domain.ChatMsgLog;
import com.ruoyi.project.system.log.service.IChatMsgLogService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 聊天日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class ChatMsgLogServiceImpl implements IChatMsgLogService 
{
    @Autowired
    private ChatMsgLogMapper chatMsgLogMapper;

    /**
     * 查询聊天日志
     * 
     * @param id 聊天日志主键
     * @return 聊天日志
     */
    @Override
    public ChatMsgLog selectChatMsgLogById(Long id)
    {
        return chatMsgLogMapper.selectChatMsgLogById(id);
    }

    /**
     * 查询聊天日志列表
     * 
     * @param chatMsgLog 聊天日志
     * @return 聊天日志
     */
    @Override
    public List<ChatMsgLog> selectChatMsgLogList(ChatMsgLog chatMsgLog)
    {
        return chatMsgLogMapper.selectChatMsgLogList(chatMsgLog);
    }

    /**
     * 新增聊天日志
     * 
     * @param chatMsgLog 聊天日志
     * @return 结果
     */
    @Override
    public int insertChatMsgLog(ChatMsgLog chatMsgLog)
    {
        chatMsgLog.setCreateTime(DateUtils.getNowDate());
        return chatMsgLogMapper.insertChatMsgLog(chatMsgLog);
    }

    /**
     * 修改聊天日志
     * 
     * @param chatMsgLog 聊天日志
     * @return 结果
     */
    @Override
    public int updateChatMsgLog(ChatMsgLog chatMsgLog)
    {
        return chatMsgLogMapper.updateChatMsgLog(chatMsgLog);
    }

    /**
     * 批量删除聊天日志
     * 
     * @param ids 需要删除的聊天日志主键
     * @return 结果
     */
    @Override
    public int deleteChatMsgLogByIds(String ids)
    {
        return chatMsgLogMapper.deleteChatMsgLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除聊天日志信息
     * 
     * @param id 聊天日志主键
     * @return 结果
     */
    @Override
    public int deleteChatMsgLogById(Long id)
    {
        return chatMsgLogMapper.deleteChatMsgLogById(id);
    }
}
