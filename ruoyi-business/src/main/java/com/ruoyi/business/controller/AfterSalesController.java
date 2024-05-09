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
import com.ruoyi.business.domain.AfterSales;
import com.ruoyi.business.service.IAfterSalesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 售后记录Controller
 * 
 * @author Eudora
 * @date 2024-04-19
 */
@Controller
@RequestMapping("/business/aftersales")
public class AfterSalesController extends BaseController
{
    private String prefix = "business/aftersales";

    @Autowired
    private IAfterSalesService afterSalesService;

    @RequiresPermissions("business:aftersales:view")
    @GetMapping()
    public String aftersales()
    {
        return prefix + "/aftersales";
    }

    /**
     * 查询售后记录列表
     */
    @RequiresPermissions("business:aftersales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AfterSales afterSales)
    {
        startPage();
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        return getDataTable(list);
    }

    @RequiresPermissions("business:aftersales:list")
    @PostMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo clientList(@PathVariable("id") Long id,AfterSales afterSales)
    {
        startPage();
        afterSales.setOpportunityId(id);
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        return getDataTable(list);
    }

    /**
     * 导出售后记录列表
     */
    @RequiresPermissions("business:aftersales:export")
    @Log(title = "售后记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AfterSales afterSales)
    {
        List<AfterSales> list = afterSalesService.selectAfterSalesList(afterSales);
        ExcelUtil<AfterSales> util = new ExcelUtil<AfterSales>(AfterSales.class);
        return util.exportExcel(list, "售后记录数据");
    }

    /**
     * 新增售后记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存售后记录
     */
    @RequiresPermissions("business:aftersales:add")
    @Log(title = "售后记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.insertAfterSales(afterSales));
    }

    /**
     * 修改售后记录
     */
    @RequiresPermissions("business:aftersales:edit")
    @GetMapping("/edit/{afterSalesId}")
    public String edit(@PathVariable("afterSalesId") Long afterSalesId, ModelMap mmap)
    {
        AfterSales afterSales = afterSalesService.selectAfterSalesByAfterSalesId(afterSalesId);
        mmap.put("afterSales", afterSales);
        return prefix + "/edit";
    }

    /**
     * 修改保存售后记录
     */
    @RequiresPermissions("business:aftersales:edit")
    @Log(title = "售后记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AfterSales afterSales)
    {
        return toAjax(afterSalesService.updateAfterSales(afterSales));
    }

    /**
     * 删除售后记录
     */
    @RequiresPermissions("business:aftersales:remove")
    @Log(title = "售后记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(afterSalesService.deleteAfterSalesByAfterSalesIds(ids));
    }
}
