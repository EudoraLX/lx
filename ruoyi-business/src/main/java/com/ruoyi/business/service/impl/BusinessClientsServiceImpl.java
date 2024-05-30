package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessClientsMapper;
import com.ruoyi.business.domain.BusinessClients;
import com.ruoyi.business.service.IBusinessClientsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 伙伴列Service业务层处理
 * 
 * @author eudora
 * @date 2024-04-10
 */
@Service
public class BusinessClientsServiceImpl implements IBusinessClientsService 
{
    @Autowired
    private BusinessClientsMapper businessClientsMapper;

    /**
     * 查询伙伴列
     * 
     * @param clientId 伙伴列主键
     * @return 伙伴列
     */
    @Override
    public BusinessClients selectBusinessClientsByClientId(Long clientId)
    {
        return businessClientsMapper.selectBusinessClientsByClientId(clientId);
    }

    @Override
    public BusinessClients selectBusinessClientsByClientName(String clientName)
    {
        return businessClientsMapper.selectBusinessClientsByClientName(clientName);
    }
    /**
     * 查询伙伴列列表
     * 
     * @param businessClients 伙伴列
     * @return 伙伴列
     */
    @Override
    public List<BusinessClients> selectBusinessClientsList(BusinessClients businessClients)
    {
        return businessClientsMapper.selectBusinessClientsList(businessClients);
    }

    /**
     * 新增伙伴列
     * 
     * @param businessClients 伙伴列
     * @return 结果
     */
    @Override
    public int insertBusinessClients(BusinessClients businessClients)
    {
        businessClients.setCreateTime(DateUtils.getNowDate());
        return businessClientsMapper.insertBusinessClients(businessClients);
    }

    /**
     * 修改伙伴列
     * 
     * @param businessClients 伙伴列
     * @return 结果
     */
    @Override
    public int updateBusinessClients(BusinessClients businessClients)
    {
        businessClients.setUpdateTime(DateUtils.getNowDate());
        return businessClientsMapper.updateBusinessClients(businessClients);
    }

    /**
     * 批量删除伙伴列
     * 
     * @param clientIds 需要删除的伙伴列主键
     * @return 结果
     */
    @Override
    public int deleteBusinessClientsByClientIds(String clientIds)
    {
        return businessClientsMapper.deleteBusinessClientsByClientIds(Convert.toStrArray(clientIds));
    }

    /**
     * 删除伙伴列信息
     * 
     * @param clientId 伙伴列主键
     * @return 结果
     */
    @Override
    public int deleteBusinessClientsByClientId(Long clientId)
    {
        return businessClientsMapper.deleteBusinessClientsByClientId(clientId);
    }

    @Override
    public List<String> getAllClients() {
        return businessClientsMapper.getAllClients();
    }


}
