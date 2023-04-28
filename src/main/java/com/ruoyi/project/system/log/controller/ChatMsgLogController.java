package com.ruoyi.project.system.log.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.log.domain.ChatMsgLog;
import com.ruoyi.project.system.log.service.IChatMsgLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 聊天日志Controller
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/log")
public class ChatMsgLogController extends BaseController
{
    private String prefix = "system/log";

    @Autowired
    private IChatMsgLogService chatMsgLogService;

    @RequiresPermissions("system:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询聊天日志列表
     */
    @RequiresPermissions("system:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ChatMsgLog chatMsgLog)
    {
        startPage();
        List<ChatMsgLog> list = chatMsgLogService.selectChatMsgLogList(chatMsgLog);
        return getDataTable(list);
    }

    /**
     * 导出聊天日志列表
     */
    @RequiresPermissions("system:log:export")
    @Log(title = "聊天日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ChatMsgLog chatMsgLog)
    {
        List<ChatMsgLog> list = chatMsgLogService.selectChatMsgLogList(chatMsgLog);
        ExcelUtil<ChatMsgLog> util = new ExcelUtil<ChatMsgLog>(ChatMsgLog.class);
        return util.exportExcel(list, "聊天日志数据");
    }

    /**
     * 新增聊天日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存聊天日志
     */
    @RequiresPermissions("system:log:add")
    @Log(title = "聊天日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ChatMsgLog chatMsgLog)
    {
        return toAjax(chatMsgLogService.insertChatMsgLog(chatMsgLog));
    }

    /**
     * 修改聊天日志
     */
    @RequiresPermissions("system:log:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ChatMsgLog chatMsgLog = chatMsgLogService.selectChatMsgLogById(id);
        mmap.put("chatMsgLog", chatMsgLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存聊天日志
     */
    @RequiresPermissions("system:log:edit")
    @Log(title = "聊天日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ChatMsgLog chatMsgLog)
    {
        return toAjax(chatMsgLogService.updateChatMsgLog(chatMsgLog));
    }

    /**
     * 删除聊天日志
     */
    @RequiresPermissions("system:log:remove")
    @Log(title = "聊天日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(chatMsgLogService.deleteChatMsgLogByIds(ids));
    }
}
