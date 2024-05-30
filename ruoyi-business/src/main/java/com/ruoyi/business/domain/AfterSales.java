package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 售后记录对象 after_sales
 *
 * @author Eudora
 * @date 2024-05-13
 */
public class AfterSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 售后ID */
    private Long afterSalesId;

    private BusinessClients clients;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long clientId;

    /** 服务人员 */
    @Excel(name = "服务人员")
    private String servicePersonnel;

    /** 服务时长 */
    @Excel(name = "服务时长")
    private Long serviceDuration;

    /** 剩余服务时长 */
    @Excel(name = "剩余服务时长")
    private Long remainingDuration;

    /** 售后描述 */
    @Excel(name = "售后描述")
    private String afterSalesDescription;

    /** 售后结果 */
    @Excel(name = "售后结果")
    private String afterSalesResult;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    public void setAfterSalesId(Long afterSalesId)
    {
        this.afterSalesId = afterSalesId;
    }

    public Long getAfterSalesId()
    {
        return afterSalesId;
    }
    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    public Long getClientId()
    {
        return clientId;
    }
    public void setServicePersonnel(String servicePersonnel)
    {
        this.servicePersonnel = servicePersonnel;
    }

    public String getServicePersonnel()
    {
        return servicePersonnel;
    }
    public void setServiceDuration(Long serviceDuration)
    {
        this.serviceDuration = serviceDuration;
    }

    public Long getServiceDuration()
    {
        return serviceDuration;
    }
    public void setRemainingDuration(Long remainingDuration)
    {
        this.remainingDuration = remainingDuration;
    }

    public Long getRemainingDuration()
    {
        return remainingDuration;
    }
    public void setAfterSalesDescription(String afterSalesDescription)
    {
        this.afterSalesDescription = afterSalesDescription;
    }

    public String getAfterSalesDescription()
    {
        return afterSalesDescription;
    }
    public void setAfterSalesResult(String afterSalesResult)
    {
        this.afterSalesResult = afterSalesResult;
    }

    public String getAfterSalesResult()
    {
        return afterSalesResult;
    }
    public void setCreationTime(Date creationTime)
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime()
    {
        return creationTime;
    }

    public BusinessClients getClients() {
        return clients;
    }

    public void setClients(BusinessClients clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("afterSalesId", getAfterSalesId())
                .append("clientId", getClientId())
                .append("servicePersonnel", getServicePersonnel())
                .append("serviceDuration", getServiceDuration())
                .append("remainingDuration", getRemainingDuration())
                .append("afterSalesDescription", getAfterSalesDescription())
                .append("afterSalesResult", getAfterSalesResult())
                .append("creationTime", getCreationTime())
                .toString();
    }
}
