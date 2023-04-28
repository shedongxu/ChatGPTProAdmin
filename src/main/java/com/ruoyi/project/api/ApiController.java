package com.ruoyi.project.api;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.log.domain.ChatMsgLog;
import com.ruoyi.project.system.log.service.IChatMsgLogService;
import com.ruoyi.project.system.subUser.domain.SubUser;
import com.ruoyi.project.system.subUser.service.ISubUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 系统外部接口
 * 
 * @author sdxl
 */
@Controller
@RequestMapping("/api")
public class ApiController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ISubUserService subUserService;

    @Autowired
    private IChatMsgLogService chatMsgLogService;

    /**
     * 通过授权密钥查询订阅用户信息
     */
    @GetMapping("/subUser/{code}")
    @ResponseBody
    public AjaxResult subUser(@PathVariable("code") String code)
    {
        SubUser subUser = subUserService.selectSubUserByCode(code);
        return AjaxResult.success(subUser);
    }

    /**
     * 新增保存聊天日志
     */
    @PostMapping("/chatMsgLog/add")
    @ResponseBody
    public AjaxResult add(ChatMsgLog chatMsgLog)
    {
        return toAjax(chatMsgLogService.insertChatMsgLog(chatMsgLog));
    }


}
