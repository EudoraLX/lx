package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.Opportunity;

/**
 * 商机列Service接口
 * 
 * @author Eudora
 * @date 2024-04-19
 */
public interface IOpportunityService 
{
    /**
     * 查询商机列
     * 
     * @param opportunityId 商机列主键
     * @return 商机列
     */
    public Opportunity selectOpportunityByOpportunityId(Long opportunityId);

    /**
     * 查询商机列列表
     * 
     * @param opportunity 商机列
     * @return 商机列集合
     */
    public List<Opportunity> selectOpportunityList(Opportunity opportunity);

    /**
     * 新增商机列
     * 
     * @param opportunity 商机列
     * @return 结果
     */
    public int insertOpportunity(Opportunity opportunity);

    /**
     * 修改商机列
     * 
     * @param opportunity 商机列
     * @return 结果
     */
    public int updateOpportunity(Opportunity opportunity);

    /**
     * 批量删除商机列
     * 
     * @param opportunityIds 需要删除的商机列主键集合
     * @return 结果
     */
    public int deleteOpportunityByOpportunityIds(String opportunityIds);

    /**
     * 删除商机列信息
     * 
     * @param opportunityId 商机列主键
     * @return 结果
     */
    public int deleteOpportunityByOpportunityId(Long opportunityId);
}
