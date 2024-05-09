package com.ruoyi.business.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BusinessClients;
import com.ruoyi.business.service.IBusinessClientsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 伙伴列Controller
 * 
 * @author eudora
 * @date 2024-04-10
 */
@Controller
@RequestMapping("/business/clients")
public class BusinessClientsController extends BaseController
{
    private String prefix = "business/clients";

    @Autowired
    private IBusinessClientsService businessClientsService;

    @RequiresPermissions("business:clients:view")
    @GetMapping()
    public String clients()
    {
        return prefix + "/clients";
    }

    /**
     * 查询伙伴列列表
     */
    @RequiresPermissions("business:clients:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusinessClients businessClients)
    {
        startPage();
        List<BusinessClients> list = businessClientsService.selectBusinessClientsList(businessClients);
        return getDataTable(list);
    }

    /**
     * 导出伙伴列列表
     */
    @RequiresPermissions("business:clients:export")
    @Log(title = "伙伴列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusinessClients businessClients)
    {
        List<BusinessClients> list = businessClientsService.selectBusinessClientsList(businessClients);
        ExcelUtil<BusinessClients> util = new ExcelUtil<BusinessClients>(BusinessClients.class);
        return util.exportExcel(list, "伙伴列数据");
    }

    /**
     * 新增伙伴列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存伙伴列
     */
    @RequiresPermissions("business:clients:add")
    @Log(title = "伙伴列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusinessClients businessClients)
    {
        return toAjax(businessClientsService.insertBusinessClients(businessClients));
    }

    /**
     * 修改伙伴列
     */
    @RequiresPermissions("business:clients:edit")
    @GetMapping("/edit/{clientId}")
    public String edit(@PathVariable("clientId") Long clientId, ModelMap mmap)
    {
        BusinessClients businessClients = businessClientsService.selectBusinessClientsByClientId(clientId);
        mmap.put("businessClients", businessClients);
        return prefix + "/edit";
    }

    /**
     * 修改保存伙伴列
     */
    @RequiresPermissions("business:clients:edit")
    @Log(title = "伙伴列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusinessClients businessClients)
    {
        return toAjax(businessClientsService.updateBusinessClients(businessClients));
    }

    /**
     * 删除伙伴列
     */
    @RequiresPermissions("business:clients:remove")
    @Log(title = "伙伴列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(businessClientsService.deleteBusinessClientsByClientIds(ids));
    }
}
