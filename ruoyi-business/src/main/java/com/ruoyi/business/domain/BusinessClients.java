package com.ruoyi.business.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 伙伴列对象 business_clients
 * 
 * @author eudora
 * @date 2024-04-10
 */
public class BusinessClients extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long clientId;

    /** 伙伴名称 */
    @Excel(name = "伙伴名称")
    private String clientName;

    /** 类型 */
    @Excel(name = "类型")
    private Long clientType;

    /** 行业(Ref: gb_industry) */
    @Excel(name = "行业(Ref: gb_industry)")
    private Long industryId;

    /** Logo */
    @Excel(name = "Logo")
    private String logo;

    /** 网址 */
    @Excel(name = "网址")
    private String website;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    /** 税号 */
    @Excel(name = "税号")
    private String taxCode;

    /** 银行账号 */
    @Excel(name = "银行账号")
    private String bankAccount;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bank;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 签约公司 */
    @Excel(name = "签约公司")
    private Long deptId;

    /** 销售人员 */
    @Excel(name = "销售人员")
    private String loginName;

    /** 售后服务 */
    @Excel(name = "售后服务")
    private String support;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String status;

    /** 机会开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "机会开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opputunityDate;

    /** 项目预计金额 */
    @Excel(name = "项目预计金额")
    private BigDecimal projectEta;

    /** 产品预计金额 */
    @Excel(name = "产品预计金额")
    private BigDecimal productEta;

    /** 服务预计金额 */
    @Excel(name = "服务预计金额")
    private BigDecimal serviceEta;

    /** 项目预计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目预计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date projectEtdate;

    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }
    public void setClientName(String clientName) 
    {
        this.clientName = clientName;
    }

    public String getClientName() 
    {
        return clientName;
    }
    public void setClientType(Long clientType) 
    {
        this.clientType = clientType;
    }

    public Long getClientType() 
    {
        return clientType;
    }
    public void setIndustryId(Long industryId) 
    {
        this.industryId = industryId;
    }

    public Long getIndustryId() 
    {
        return industryId;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public String getWebsite() 
    {
        return website;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setTaxCode(String taxCode) 
    {
        this.taxCode = taxCode;
    }

    public String getTaxCode() 
    {
        return taxCode;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }
    public void setBank(String bank) 
    {
        this.bank = bank;
    }

    public String getBank() 
    {
        return bank;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setSupport(String support) 
    {
        this.support = support;
    }

    public String getSupport() 
    {
        return support;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setOpputunityDate(Date opputunityDate) 
    {
        this.opputunityDate = opputunityDate;
    }

    public Date getOpputunityDate() 
    {
        return opputunityDate;
    }
    public void setProjectEta(BigDecimal projectEta) 
    {
        this.projectEta = projectEta;
    }

    public BigDecimal getProjectEta() 
    {
        return projectEta;
    }
    public void setProductEta(BigDecimal productEta) 
    {
        this.productEta = productEta;
    }

    public BigDecimal getProductEta() 
    {
        return productEta;
    }
    public void setServiceEta(BigDecimal serviceEta) 
    {
        this.serviceEta = serviceEta;
    }

    public BigDecimal getServiceEta() 
    {
        return serviceEta;
    }
    public void setProjectEtdate(Date projectEtdate) 
    {
        this.projectEtdate = projectEtdate;
    }

    public Date getProjectEtdate() 
    {
        return projectEtdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientId", getClientId())
            .append("clientName", getClientName())
            .append("clientType", getClientType())
            .append("industryId", getIndustryId())
            .append("logo", getLogo())
            .append("website", getWebsite())
            .append("address", getAddress())
            .append("tel", getTel())
            .append("taxCode", getTaxCode())
            .append("bankAccount", getBankAccount())
            .append("bank", getBank())
            .append("contact", getContact())
            .append("mobile", getMobile())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("source", getSource())
            .append("deptId", getDeptId())
            .append("loginName", getLoginName())
            .append("support", getSupport())
            .append("status", getStatus())
            .append("opputunityDate", getOpputunityDate())
            .append("projectEta", getProjectEta())
            .append("productEta", getProductEta())
            .append("serviceEta", getServiceEta())
            .append("projectEtdate", getProjectEtdate())
            .toString();
    }
}
