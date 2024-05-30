package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BusinessClients;

/**
 * 伙伴列Service接口
 * 
 * @author eudora
 * @date 2024-04-10
 */
public interface IBusinessClientsService 
{
    /**
     * 查询伙伴列
     * 
     * @param clientId 伙伴列主键
     * @return 伙伴列
     */
    public BusinessClients selectBusinessClientsByClientId(Long clientId);

    public BusinessClients selectBusinessClientsByClientName(String clientName);

    /**
     * 查询伙伴列列表
     * 
     * @param businessClients 伙伴列
     * @return 伙伴列集合
     */
    public List<BusinessClients> selectBusinessClientsList(BusinessClients businessClients);

    /**
     * 新增伙伴列
     * 
     * @param businessClients 伙伴列
     * @return 结果
     */
    public int insertBusinessClients(BusinessClients businessClients);

    /**
     * 修改伙伴列
     * 
     * @param businessClients 伙伴列
     * @return 结果
     */
    public int updateBusinessClients(BusinessClients businessClients);

    /**
     * 批量删除伙伴列
     * 
     * @param clientIds 需要删除的伙伴列主键集合
     * @return 结果
     */
    public int deleteBusinessClientsByClientIds(String clientIds);

    /**
     * 删除伙伴列信息
     * 
     * @param clientId 伙伴列主键
     * @return 结果
     */
    public int deleteBusinessClientsByClientId(Long clientId);

    public List<String> getAllClients();
}
