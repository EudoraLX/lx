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
 * @date 2024-04-19
 */
public class AfterSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 售后ID */
    private Long afterSalesId;

    /** 商机ID，关联到Opportunity表的OpportunityID */
    @Excel(name = "商机ID")
    private Long opportunityId;

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
    public void setOpportunityId(Long opportunityId) 
    {
        this.opportunityId = opportunityId;
    }

    public Long getOpportunityId() 
    {
        return opportunityId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("afterSalesId", getAfterSalesId())
            .append("opportunityId", getOpportunityId())
            .append("afterSalesDescription", getAfterSalesDescription())
            .append("afterSalesResult", getAfterSalesResult())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
