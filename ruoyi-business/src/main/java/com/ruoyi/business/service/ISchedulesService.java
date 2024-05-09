package com.ruoyi.business.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import com.ruoyi.business.domain.Schedules;

/**
 * schedulesService接口
 * 
 * @author eudora
 * @date 2024-04-10
 */
public interface ISchedulesService 
{
    /**
     * 查询schedules
     * 
     * @param scheduleId schedules主键
     * @return schedules
     */
    public Schedules selectSchedulesByScheduleId(Long scheduleId);

    /**
     * 查询schedules列表
     * 
     * @param schedules schedules
     * @return schedules集合
     */
    public List<Schedules> selectSchedulesList(Schedules schedules);

    /**
     * 新增schedules
     * 
     * @param schedules schedules
     * @return 结果
     */
    public int insertSchedules(Schedules schedules);

    /**
     * 修改schedules
     * 
     * @param schedules schedules
     * @return 结果
     */
    public int updateSchedules(Schedules schedules);

    /**
     * 批量删除schedules
     * 
     * @param scheduleIds 需要删除的schedules主键集合
     * @return 结果
     */
    public int deleteSchedulesByScheduleIds(String scheduleIds);

    /**
     * 删除schedules信息
     * 
     * @param scheduleId schedules主键
     * @return 结果
     */
    public int deleteSchedulesByScheduleId(Long scheduleId);

    public int createSchedule(Long clientId, Date scheduleDate, String scheduleDescription);
}
