package com.ruoyi.business.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商机列对象 opportunity
 * 
 * @author Eudora
 * @date 2024-04-19
 */
public class Opportunity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商机ID */
    private Long opportunityId;

    /** 客户ID，关联到business_clients表的client_id */
    @Excel(name = "客户ID")
    private Long clientId;

    private BusinessClients clients;

    /** 商机描述 */
    @Excel(name = "商机描述")
    private String opportunityDescription;

    /** 销售人员 */
    @Excel(name = "销售人员")
    private String salesperson;

    /** 商机来源 */
    @Excel(name = "商机来源")
    private String opportunitySource;

    /** 商机开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "商机开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opportunityDate;

    /** 项目预计金额 */
    @Excel(name = "项目预计金额")
    private BigDecimal projectEstimatedAmount;

    /** 产品预计金额 */
    @Excel(name = "产品预计金额")
    private BigDecimal productEstimatedAmount;

    /** 服务预计金额 */
    @Excel(name = "服务预计金额")
    private BigDecimal serviceEstimatedAmount;

    /** 项目预计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目预计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date projectEstimatedDate;

    public void setOpportunityId(Long opportunityId) 
    {
        this.opportunityId = opportunityId;
    }

    public Long getOpportunityId() 
    {
        return opportunityId;
    }
    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }
    public void setOpportunityDescription(String opportunityDescription) 
    {
        this.opportunityDescription = opportunityDescription;
    }

    public String getOpportunityDescription() 
    {
        return opportunityDescription;
    }
    public void setSalesperson(String salesperson) 
    {
        this.salesperson = salesperson;
    }

    public String getSalesperson() 
    {
        return salesperson;
    }
    public void setOpportunitySource(String opportunitySource) 
    {
        this.opportunitySource = opportunitySource;
    }

    public String getOpportunitySource() 
    {
        return opportunitySource;
    }
    public void setOpportunityDate(Date opportunityDate) 
    {
        this.opportunityDate = opportunityDate;
    }

    public Date getOpportunityDate() 
    {
        return opportunityDate;
    }
    public void setProjectEstimatedAmount(BigDecimal projectEstimatedAmount) 
    {
        this.projectEstimatedAmount = projectEstimatedAmount;
    }

    public BigDecimal getProjectEstimatedAmount() 
    {
        return projectEstimatedAmount;
    }
    public void setProductEstimatedAmount(BigDecimal productEstimatedAmount) 
    {
        this.productEstimatedAmount = productEstimatedAmount;
    }

    public BigDecimal getProductEstimatedAmount() 
    {
        return productEstimatedAmount;
    }
    public void setServiceEstimatedAmount(BigDecimal serviceEstimatedAmount) 
    {
        this.serviceEstimatedAmount = serviceEstimatedAmount;
    }

    public BigDecimal getServiceEstimatedAmount() 
    {
        return serviceEstimatedAmount;
    }
    public void setProjectEstimatedDate(Date projectEstimatedDate) 
    {
        this.projectEstimatedDate = projectEstimatedDate;
    }

    public Date getProjectEstimatedDate() 
    {
        return projectEstimatedDate;
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
            .append("opportunityId", getOpportunityId())
            .append("clientId", getClientId())
            .append("opportunityDescription", getOpportunityDescription())
            .append("salesperson", getSalesperson())
            .append("opportunitySource", getOpportunitySource())
            .append("opportunityDate", getOpportunityDate())
            .append("projectEstimatedAmount", getProjectEstimatedAmount())
            .append("productEstimatedAmount", getProductEstimatedAmount())
            .append("serviceEstimatedAmount", getServiceEstimatedAmount())
            .append("projectEstimatedDate", getProjectEstimatedDate())
            .toString();
    }
}
