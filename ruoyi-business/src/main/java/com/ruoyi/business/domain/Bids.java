package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 投标记录对象 bids
 * 
 * @author Eudora
 * @date 2024-04-19
 */
public class Bids extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 投标ID */
    private Long bidId;

    /** 商机ID，关联到Opportunity表的OpportunityID */
    @Excel(name = "商机ID")
    private Long opportunityId;

    private BusinessClients clients;

    /** 投标结果 */
    @Excel(name = "投标结果")
    private String bidResult;

    /** 投标方式 */
    @Excel(name = "投标方式")
    private String bidMethod;

    /** 总服务时长 */
    @Excel(name = "总服务时长")
    private Long totalServiceDuration;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    public void setBidId(Long bidId) 
    {
        this.bidId = bidId;
    }

    public Long getBidId() 
    {
        return bidId;
    }
    public void setOpportunityId(Long opportunityId) 
    {
        this.opportunityId = opportunityId;
    }

    public Long getOpportunityId() 
    {
        return opportunityId;
    }
    public void setBidResult(String bidResult) 
    {
        this.bidResult = bidResult;
    }

    public String getBidResult() 
    {
        return bidResult;
    }
    public void setBidMethod(String bidMethod) 
    {
        this.bidMethod = bidMethod;
    }

    public String getBidMethod() 
    {
        return bidMethod;
    }
    public void setTotalServiceDuration(Long totalServiceDuration) 
    {
        this.totalServiceDuration = totalServiceDuration;
    }

    public Long getTotalServiceDuration() 
    {
        return totalServiceDuration;
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
            .append("bidId", getBidId())
            .append("opportunityId", getOpportunityId())
            .append("bidResult", getBidResult())
            .append("bidMethod", getBidMethod())
            .append("totalServiceDuration", getTotalServiceDuration())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
