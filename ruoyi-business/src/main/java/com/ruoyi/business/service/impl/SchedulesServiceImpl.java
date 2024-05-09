package com.ruoyi.business.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.ruoyi.business.domain.BusinessClients;
import com.ruoyi.business.mapper.BusinessClientsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.SchedulesMapper;
import com.ruoyi.business.domain.Schedules;
import com.ruoyi.business.service.ISchedulesService;
import com.ruoyi.common.core.text.Convert;

/**
 * schedulesService业务层处理
 * 
 * @author eudora
 * @date 2024-04-10
 */
@Service
public class SchedulesServiceImpl implements ISchedulesService 
{
    @Autowired
    private SchedulesMapper schedulesMapper;
    
    @Autowired
    private BusinessClientsMapper clientsMapper;

    /**
     * 查询schedules
     * 
     * @param scheduleId schedules主键
     * @return schedules
     */
    @Override
    public Schedules selectSchedulesByScheduleId(Long scheduleId)
    {
        return schedulesMapper.selectSchedulesByScheduleId(scheduleId);
    }

    /**
     * 查询schedules列表
     * 
     * @param schedules schedules
     * @return schedules
     */
    @Override
    public List<Schedules> selectSchedulesList(Schedules schedules)
    {
        return schedulesMapper.selectSchedulesList(schedules);
    }

    /**
     * 新增schedules
     * 
     * @param schedules schedules
     * @return 结果
     */
    @Override
    public int insertSchedules(Schedules schedules)
    {
        return schedulesMapper.insertSchedules(schedules);
    }

    /**
     * 修改schedules
     * 
     * @param schedules schedules
     * @return 结果
     */
    @Override
    public int updateSchedules(Schedules schedules)
    {
        return schedulesMapper.updateSchedules(schedules);
    }

    /**
     * 批量删除schedules
     * 
     * @param scheduleIds 需要删除的schedules主键
     * @return 结果
     */
    @Override
    public int deleteSchedulesByScheduleIds(String scheduleIds)
    {
        return schedulesMapper.deleteSchedulesByScheduleIds(Convert.toStrArray(scheduleIds));
    }

    /**
     * 删除schedules信息
     * 
     * @param scheduleId schedules主键
     * @return 结果
     */
    @Override
    public int deleteSchedulesByScheduleId(Long scheduleId)
    {
        return schedulesMapper.deleteSchedulesByScheduleId(scheduleId);
    }

    @Override
    public int createSchedule(Long clientId, Date scheduleDate, String scheduleDescription) {
        BusinessClients client = clientsMapper.selectBusinessClientsByClientId(clientId);
        if (client != null) {
            Schedules schedule = new Schedules();
            schedule.setClientId(client.getClientId());
            schedule.setScheduleDate(scheduleDate);
            schedule.setScheduleDescription(scheduleDescription);
            return schedulesMapper.insertSchedules(schedule);
        }
        return -1;
    }
}
