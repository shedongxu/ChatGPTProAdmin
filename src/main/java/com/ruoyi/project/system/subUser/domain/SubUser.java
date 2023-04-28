package com.ruoyi.project.system.subUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 订阅用户管理对象 sub_user
 * 
 * @author sdx
 * @date 2023-04-24
 */
public class SubUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 授权密钥 */
    @Excel(name = "授权密钥")
    private String code;

    /** 订阅到期时间 */
    @Excel(name = "订阅到期时间")
    private String expireTime;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String name;

    /** 剩余对话条数 */
    @Excel(name = "剩余对话条数")
    private int msgCount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setExpireTime(String expireTime)
    {
        this.expireTime = expireTime;
    }

    public String getExpireTime()
    {
        return expireTime;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("expireTime", getExpireTime())
            .append("name", getName())
            .append("remark", getRemark())
            .append("msgCount", getMsgCount())
            .toString();
    }
}
