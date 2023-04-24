package com.ruoyi.project.system.subUser.controller;

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
import com.ruoyi.project.system.subUser.domain.SubUser;
import com.ruoyi.project.system.subUser.service.ISubUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 订阅用户管理Controller
 * 
 * @author sdx
 * @date 2023-04-24
 */
@Controller
@RequestMapping("/system/subUser")
public class SubUserController extends BaseController
{
    private String prefix = "system/subUser";

    @Autowired
    private ISubUserService subUserService;

    @RequiresPermissions("system:subUser:view")
    @GetMapping()
    public String subUser()
    {
        return prefix + "/subUser";
    }

    /**
     * 查询订阅用户管理列表
     */
    @RequiresPermissions("system:subUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SubUser subUser)
    {
        startPage();
        List<SubUser> list = subUserService.selectSubUserList(subUser);
        return getDataTable(list);
    }

    /**
     * 导出订阅用户管理列表
     */
    @RequiresPermissions("system:subUser:export")
    @Log(title = "订阅用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SubUser subUser)
    {
        List<SubUser> list = subUserService.selectSubUserList(subUser);
        ExcelUtil<SubUser> util = new ExcelUtil<SubUser>(SubUser.class);
        return util.exportExcel(list, "订阅用户管理数据");
    }

    /**
     * 新增订阅用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订阅用户管理
     */
    @RequiresPermissions("system:subUser:add")
    @Log(title = "订阅用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SubUser subUser)
    {
        return toAjax(subUserService.insertSubUser(subUser));
    }

    /**
     * 修改订阅用户管理
     */
    @RequiresPermissions("system:subUser:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SubUser subUser = subUserService.selectSubUserById(id);
        mmap.put("subUser", subUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存订阅用户管理
     */
    @RequiresPermissions("system:subUser:edit")
    @Log(title = "订阅用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SubUser subUser)
    {
        return toAjax(subUserService.updateSubUser(subUser));
    }

    /**
     * 删除订阅用户管理
     */
    @RequiresPermissions("system:subUser:remove")
    @Log(title = "订阅用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(subUserService.deleteSubUserByIds(ids));
    }
}
