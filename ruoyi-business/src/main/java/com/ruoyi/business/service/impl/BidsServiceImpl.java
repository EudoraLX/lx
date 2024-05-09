package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BidsMapper;
import com.ruoyi.business.domain.Bids;
import com.ruoyi.business.service.IBidsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 投标记录Service业务层处理
 * 
 * @author Eudora
 * @date 2024-04-19
 */
@Service
public class BidsServiceImpl implements IBidsService 
{
    @Autowired
    private BidsMapper bidsMapper;

    /**
     * 查询投标记录
     * 
     * @param bidId 投标记录主键
     * @return 投标记录
     */
    @Override
    public Bids selectBidsByBidId(Long bidId)
    {
        return bidsMapper.selectBidsByBidId(bidId);
    }

    /**
     * 查询投标记录列表
     * 
     * @param bids 投标记录
     * @return 投标记录
     */
    @Override
    public List<Bids> selectBidsList(Bids bids)
    {
        return bidsMapper.selectBidsList(bids);
    }

    /**
     * 新增投标记录
     * 
     * @param bids 投标记录
     * @return 结果
     */
    @Override
    public int insertBids(Bids bids)
    {
        return bidsMapper.insertBids(bids);
    }

    /**
     * 修改投标记录
     * 
     * @param bids 投标记录
     * @return 结果
     */
    @Override
    public int updateBids(Bids bids)
    {
        return bidsMapper.updateBids(bids);
    }

    /**
     * 批量删除投标记录
     * 
     * @param bidIds 需要删除的投标记录主键
     * @return 结果
     */
    @Override
    public int deleteBidsByBidIds(String bidIds)
    {
        return bidsMapper.deleteBidsByBidIds(Convert.toStrArray(bidIds));
    }

    /**
     * 删除投标记录信息
     * 
     * @param bidId 投标记录主键
     * @return 结果
     */
    @Override
    public int deleteBidsByBidId(Long bidId)
    {
        return bidsMapper.deleteBidsByBidId(bidId);
    }
}
