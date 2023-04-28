package com.ruoyi.project.system.log.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 聊天日志对象 chat_msg_log
 * 
 * @author ruoyi
 * @date 2023-04-25
 */
public class ChatMsgLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 授权密钥 */
    @Excel(name = "授权密钥")
    private String code;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String name;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    /** 来源IP */
    @Excel(name = "来源IP")
    private String ip;

    /** url */
    @Excel(name = "url")
    private String url;

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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("content", getContent())
            .append("ip", getIp())
            .append("url", getUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
