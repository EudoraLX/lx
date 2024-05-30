package com.ruoyi.business.service.impl;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.AfterSalesMapper;
import com.ruoyi.business.domain.AfterSales;
import com.ruoyi.business.service.IAfterSalesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 售后记录Service业务层处理
 *
 * @author Eudora
 * @date 2024-05-13
 */
@Service
public class AfterSalesServiceImpl implements IAfterSalesService
{
    @Autowired
    private AfterSalesMapper afterSalesMapper;

    /**
     * 查询售后记录
     *
     * @param afterSalesId 售后记录主键
     * @return 售后记录
     */
    @Override
    public AfterSales selectAfterSalesByAfterSalesId(Long afterSalesId)
    {
        return afterSalesMapper.selectAfterSalesByAfterSalesId(afterSalesId);
    }

    /**
     * 查询售后记录列表
     *
     * @param afterSales 售后记录
     * @return 售后记录
     */
    @Override
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales)
    {
        return afterSalesMapper.selectAfterSalesList(afterSales);
    }

    /**
     * 新增售后记录
     *
     * @param afterSales 售后记录
     * @return 结果
     */
    @Override
    public int insertAfterSales(AfterSales afterSales)
    {
        return afterSalesMapper.insertAfterSales(afterSales);
    }

    /**
     * 修改售后记录
     *
     * @param afterSales 售后记录
     * @return 结果
     */
    @Override
    public int updateAfterSales(AfterSales afterSales)
    {
        return afterSalesMapper.updateAfterSales(afterSales);
    }

    /**
     * 批量删除售后记录
     *
     * @param afterSalesIds 需要删除的售后记录主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesByAfterSalesIds(String afterSalesIds)
    {
        return afterSalesMapper.deleteAfterSalesByAfterSalesIds(Convert.toStrArray(afterSalesIds));
    }

    /**
     * 删除售后记录信息
     *
     * @param afterSalesId 售后记录主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesByAfterSalesId(Long afterSalesId)
    {
        return afterSalesMapper.deleteAfterSalesByAfterSalesId(afterSalesId);
    }
}
