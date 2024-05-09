package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.AfterSales;

/**
 * 售后记录Mapper接口
 * 
 * @author Eudora
 * @date 2024-04-19
 */
public interface AfterSalesMapper 
{
    /**
     * 查询售后记录
     * 
     * @param afterSalesId 售后记录主键
     * @return 售后记录
     */
    public AfterSales selectAfterSalesByAfterSalesId(Long afterSalesId);

    /**
     * 查询售后记录列表
     * 
     * @param afterSales 售后记录
     * @return 售后记录集合
     */
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales);

    /**
     * 新增售后记录
     * 
     * @param afterSales 售后记录
     * @return 结果
     */
    public int insertAfterSales(AfterSales afterSales);

    /**
     * 修改售后记录
     * 
     * @param afterSales 售后记录
     * @return 结果
     */
    public int updateAfterSales(AfterSales afterSales);

    /**
     * 删除售后记录
     * 
     * @param afterSalesId 售后记录主键
     * @return 结果
     */
    public int deleteAfterSalesByAfterSalesId(Long afterSalesId);

    /**
     * 批量删除售后记录
     * 
     * @param afterSalesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAfterSalesByAfterSalesIds(String[] afterSalesIds);
}
