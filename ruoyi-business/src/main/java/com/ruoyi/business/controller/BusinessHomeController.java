package com.ruoyi.business.controller;

import java.util.List;

import com.ruoyi.business.domain.BusinessClients;
import com.ruoyi.business.service.IBusinessClientsService;
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
import com.ruoyi.business.domain.Schedules;
import com.ruoyi.business.service.ISchedulesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * homeController
 *
 * @author eudora
 * @date 2024-04-10
 */
@Controller
@RequestMapping("/business/home")
public class BusinessHomeController extends BaseController
{
    private String prefix = "business/home";

    @Autowired
    private ISchedulesService schedulesService;

    @Autowired
    private IBusinessClientsService businessClientsService;

    @RequiresPermissions("business:home:view")
    @GetMapping()
    public String home()
    {
        return prefix + "/index";
    }

    @PostMapping("")
    @ResponseBody
    public AjaxResult addSave(Schedules schedules)
    {
        return toAjax(schedulesService.insertSchedules(schedules));
    }
//    @GetMapping("/getEventList")
//    @ResponseBody
//    public AjaxResult getEventList() {
//        return toAjax();
//    }


}

