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
import com.ruoyi.business.domain.Opportunity;
import com.ruoyi.business.service.IOpportunityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商机列Controller
 * 
 * @author Eudora
 * @date 2024-04-19
 */
@Controller
@RequestMapping("/business/opportunity")
public class OpportunityController extends BaseController
{
    private String prefix = "business/opportunity";

    @Autowired
    private IOpportunityService opportunityService;

    @RequiresPermissions("business:opportunity:view")
    @GetMapping()
    public String opportunity()
    {
        return prefix + "/opportunity";
    }

    /**
     * 查询商机列列表
     */
    @RequiresPermissions("business:opportunity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Opportunity opportunity)
    {
        startPage();
        List<Opportunity> list = opportunityService.selectOpportunityList(opportunity);
        return getDataTable(list);
    }

    /**
     * 导出商机列列表
     */
    @RequiresPermissions("business:opportunity:export")
    @Log(title = "商机列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Opportunity opportunity)
    {
        List<Opportunity> list = opportunityService.selectOpportunityList(opportunity);
        ExcelUtil<Opportunity> util = new ExcelUtil<Opportunity>(Opportunity.class);
        return util.exportExcel(list, "商机列数据");
    }

    /**
     * 新增商机列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商机列
     */
    @RequiresPermissions("business:opportunity:add")
    @Log(title = "商机列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Opportunity opportunity)
    {
        return toAjax(opportunityService.insertOpportunity(opportunity));
    }

    /**
     * 修改商机列
     */
    @RequiresPermissions("business:opportunity:edit")
    @GetMapping("/edit/{opportunityId}")
    public String edit(@PathVariable("opportunityId") Long opportunityId, ModelMap mmap)
    {
        Opportunity opportunity = opportunityService.selectOpportunityByOpportunityId(opportunityId);
        mmap.put("opportunity", opportunity);
        return prefix + "/edit";
    }

    /**
     * 修改保存商机列
     */
    @RequiresPermissions("business:opportunity:edit")
    @Log(title = "商机列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Opportunity opportunity)
    {
        return toAjax(opportunityService.updateOpportunity(opportunity));
    }

    /**
     * 删除商机列
     */
    @RequiresPermissions("business:opportunity:remove")
    @Log(title = "商机列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(opportunityService.deleteOpportunityByOpportunityIds(ids));
    }
}
