package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * schedules对象 schedules
 * 
 * @author eudora
 * @date 2024-04-10
 */
public class Schedules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long scheduleId;

    /** 客户 */
    @Excel(name = "客户")
    private Long clientId;


    /** 计划日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scheduleDate;

    /** 计划描述 */
    @Excel(name = "计划描述")
    private String scheduleDescription;

    /** 客户信息 */
    @Excel(name = "客户表")
    private BusinessClients clients;

    public void setScheduleId(Long scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId() 
    {
        return scheduleId;
    }
    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }
    public void setScheduleDate(Date scheduleDate) 
    {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleDate() 
    {
        return scheduleDate;
    }
    public void setScheduleDescription(String scheduleDescription) 
    {
        this.scheduleDescription = scheduleDescription;
    }

    public String getScheduleDescription() 
    {
        return scheduleDescription;
    }

    public BusinessClients getClients() {
        if(clients == null)
        {
            clients = new BusinessClients();
        }
        return clients;
    }

    public void setClients(BusinessClients clients) {
        this.clients = clients;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("clientId", getClientId())
            .append("scheduleDate", getScheduleDate())
            .append("scheduleDescription", getScheduleDescription())
            .toString();
    }
}
