package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.OpportunityMapper;
import com.ruoyi.business.domain.Opportunity;
import com.ruoyi.business.service.IOpportunityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商机列Service业务层处理
 * 
 * @author Eudora
 * @date 2024-04-19
 */
@Service
public class OpportunityServiceImpl implements IOpportunityService 
{
    @Autowired
    private OpportunityMapper opportunityMapper;

    /**
     * 查询商机列
     * 
     * @param opportunityId 商机列主键
     * @return 商机列
     */
    @Override
    public Opportunity selectOpportunityByOpportunityId(Long opportunityId)
    {
        return opportunityMapper.selectOpportunityByOpportunityId(opportunityId);
    }

    /**
     * 查询商机列列表
     * 
     * @param opportunity 商机列
     * @return 商机列
     */
    @Override
    public List<Opportunity> selectOpportunityList(Opportunity opportunity)
    {
        return opportunityMapper.selectOpportunityList(opportunity);
    }

    /**
     * 新增商机列
     * 
     * @param opportunity 商机列
     * @return 结果
     */
    @Override
    public int insertOpportunity(Opportunity opportunity)
    {
        return opportunityMapper.insertOpportunity(opportunity);
    }

    /**
     * 修改商机列
     * 
     * @param opportunity 商机列
     * @return 结果
     */
    @Override
    public int updateOpportunity(Opportunity opportunity)
    {
        return opportunityMapper.updateOpportunity(opportunity);
    }

    /**
     * 批量删除商机列
     * 
     * @param opportunityIds 需要删除的商机列主键
     * @return 结果
     */
    @Override
    public int deleteOpportunityByOpportunityIds(String opportunityIds)
    {
        return opportunityMapper.deleteOpportunityByOpportunityIds(Convert.toStrArray(opportunityIds));
    }

    /**
     * 删除商机列信息
     * 
     * @param opportunityId 商机列主键
     * @return 结果
     */
    @Override
    public int deleteOpportunityByOpportunityId(Long opportunityId)
    {
        return opportunityMapper.deleteOpportunityByOpportunityId(opportunityId);
    }
}
