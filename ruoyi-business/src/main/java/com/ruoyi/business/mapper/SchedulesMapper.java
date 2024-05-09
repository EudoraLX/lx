package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.Schedules;

/**
 * schedulesMapper接口
 * 
 * @author eudora
 * @date 2024-04-10
 */
public interface SchedulesMapper 
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
     * 删除schedules
     * 
     * @param scheduleId schedules主键
     * @return 结果
     */
    public int deleteSchedulesByScheduleId(Long scheduleId);

    /**
     * 批量删除schedules
     * 
     * @param scheduleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchedulesByScheduleIds(String[] scheduleIds);
}
