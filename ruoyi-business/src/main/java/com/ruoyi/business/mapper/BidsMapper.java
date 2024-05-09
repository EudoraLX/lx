package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.Bids;

/**
 * 投标记录Mapper接口
 * 
 * @author Eudora
 * @date 2024-04-19
 */
public interface BidsMapper 
{
    /**
     * 查询投标记录
     * 
     * @param bidId 投标记录主键
     * @return 投标记录
     */
    public Bids selectBidsByBidId(Long bidId);

    /**
     * 查询投标记录列表
     * 
     * @param bids 投标记录
     * @return 投标记录集合
     */
    public List<Bids> selectBidsList(Bids bids);

    /**
     * 新增投标记录
     * 
     * @param bids 投标记录
     * @return 结果
     */
    public int insertBids(Bids bids);

    /**
     * 修改投标记录
     * 
     * @param bids 投标记录
     * @return 结果
     */
    public int updateBids(Bids bids);

    /**
     * 删除投标记录
     * 
     * @param bidId 投标记录主键
     * @return 结果
     */
    public int deleteBidsByBidId(Long bidId);

    /**
     * 批量删除投标记录
     * 
     * @param bidIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBidsByBidIds(String[] bidIds);
}
