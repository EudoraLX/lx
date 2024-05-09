package com.ruoyi.business.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.business.domain.*;
import com.ruoyi.business.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * schedulesController
 * 
 * @author eudora
 * @date 2024-04-10
 */
@Controller
@RequestMapping("/business/schedules")
public class SchedulesController extends BaseController
{
    private String prefix = "business/schedules";

    @Autowired
    private ISchedulesService schedulesService;

    @Autowired
    private IBusinessClientsService businessClientsService;

    @Autowired
    private IOpportunityService opportunityService;

    @Autowired
    private IBidsService bidsService;

    @Autowired
    private IAfterSalesService afterSalesService;

    @RequiresPermissions("business:schedules:view")
    @GetMapping()
    public String schedules()
    {
        return prefix + "/schedules";
    }

    /**
     * 查询schedules列表
     */
    @RequiresPermissions("business:schedules:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Schedules schedules)
    {
        startPage();
        List<Schedules> list = schedulesService.selectSchedulesList(schedules);
        return getDataTable(list);
    }

    public String getClientName(Long clientId){
        BusinessClients client = businessClientsService.selectBusinessClientsByClientId(clientId);
        return client.getClientName();
    }

    /**
     * 导出schedules列表
     */
    @RequiresPermissions("business:schedules:export")
    @Log(title = "schedules", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Schedules schedules)
    {
        List<Schedules> list = schedulesService.selectSchedulesList(schedules);
        ExcelUtil<Schedules> util = new ExcelUtil<Schedules>(Schedules.class);
        return util.exportExcel(list, "schedules数据");
    }

    /**
     * 新增schedules
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存schedules
     */
    @RequiresPermissions("business:schedules:add")
    @Log(title = "schedules", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Schedules schedules)
    {
        return toAjax(schedulesService.insertSchedules(schedules));
    }

    /**
     * 修改schedules
     */
    @RequiresPermissions("business:schedules:edit")
    @GetMapping("/edit/{scheduleId}")
    public String edit(@PathVariable("scheduleId") Long scheduleId, ModelMap mmap)
    {
        Schedules schedules = schedulesService.selectSchedulesByScheduleId(scheduleId);
        mmap.put("schedules", schedules);
        return prefix + "/edit";
    }

    /**
     * 修改保存schedules
     */
    @RequiresPermissions("business:schedules:edit")
    @Log(title = "schedules", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Schedules schedules)
    {
        return toAjax(schedulesService.updateSchedules(schedules));
    }

    /**
     * 删除schedules
     */
    @RequiresPermissions("business:schedules:remove")
    @Log(title = "schedules", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(schedulesService.deleteSchedulesByScheduleIds(ids));
    }

    @PostMapping("/indexAdd")
    @ResponseBody
    public AjaxResult createSchedule(@RequestParam String clientName,
                                     @RequestParam Date scheduleDate,
                                     @RequestParam String scheduleDescription) {
        try {
            BusinessClients client = businessClientsService.selectBusinessClientsByClientName(clientName);
            if(client!=null){
                return toAjax(schedulesService.createSchedule(client.getClientId(), scheduleDate, scheduleDescription));
            }else {
                return AjaxResult.error("没有这个客户，请先添加客户！");
            }
        } catch (Exception e) {
            return AjaxResult.error("出错了！");
        }
    }
    @PostMapping("/getList")
    @ResponseBody
    public ResponseEntity<Object> getList() {
        Schedules schedules = new Schedules();
        List<Schedules> schedulesList = schedulesService.selectSchedulesList(schedules);
        return new ResponseEntity<>(JSON.toJSON(schedulesList), HttpStatus.OK);
    }


    @GetMapping("/showClient/{id}")
    public String showClient(@PathVariable("id") Long scheduleId, ModelMap mmap)
    {
        Schedules schedules = schedulesService.selectSchedulesByScheduleId(scheduleId);
        BusinessClients clients = businessClientsService.selectBusinessClientsByClientId(schedules.getClientId());
        Opportunity opportunity = opportunityService.selectOpportunityByOpportunityId(clients.getClientId());
        Bids bids = bidsService.selectBidsByBidId(opportunity.getOpportunityId());
        AfterSales afterSales = afterSalesService.selectAfterSalesByAfterSalesId(opportunity.getOpportunityId());
        mmap.put("businessClients", clients);
        mmap.put("opportunity" , opportunity);
        mmap.put("bids", bids);
        mmap.put("afterSales" , afterSales);
        return prefix + "/showClient";
    }

}
