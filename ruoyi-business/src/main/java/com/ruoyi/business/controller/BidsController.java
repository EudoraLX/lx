package com.ruoyi.business.controller;

import java.util.List;

import com.ruoyi.business.domain.Bids;
import com.ruoyi.business.service.IBidsService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投标记录Controller
 * 
 * @author Eudora
 * @date 2024-04-19
 */
@Controller
@RequestMapping("/business/Bids")
public class BidsController extends BaseController
{
    private String prefix = "business/Bids";

    @Autowired
    private IBidsService bidsService;

    @RequiresPermissions("business:Bids:view")
    @GetMapping()
    public String Bids()
    {
        return prefix + "/Bids";
    }

    /**
     * 查询投标记录列表
     */
    @RequiresPermissions("business:Bids:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Bids bids)
    {
        startPage();
        List<Bids> list = bidsService.selectBidsList(bids);
        return getDataTable(list);
    }

    /**
     * 导出投标记录列表
     */
    @RequiresPermissions("business:Bids:export")
    @Log(title = "投标记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Bids bids)
    {
        List<Bids> list = bidsService.selectBidsList(bids);
        ExcelUtil<Bids> util = new ExcelUtil<Bids>(Bids.class);
        return util.exportExcel(list, "投标记录数据");
    }

    /**
     * 新增投标记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存投标记录
     */
    @RequiresPermissions("business:Bids:add")
    @Log(title = "投标记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Bids bids)
    {
        return toAjax(bidsService.insertBids(bids));
    }

    /**
     * 修改投标记录
     */
    @RequiresPermissions("business:Bids:edit")
    @GetMapping("/edit/{bidId}")
    public String edit(@PathVariable("bidId") Long bidId, ModelMap mmap)
    {
        Bids bids = bidsService.selectBidsByBidId(bidId);
        mmap.put("bids", bids);
        return prefix + "/edit";
    }

    /**
     * 修改保存投标记录
     */
    @RequiresPermissions("business:Bids:edit")
    @Log(title = "投标记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bids bids)
    {
        return toAjax(bidsService.updateBids(bids));
    }

    /**
     * 删除投标记录
     */
    @RequiresPermissions("business:Bids:remove")
    @Log(title = "投标记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bidsService.deleteBidsByBidIds(ids));
    }
}
