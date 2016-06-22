package org.msdg.tavern_quest.instance;

import org.msdg.tavern_quest.goods.Entrust;
import org.msdg.tavern_quest.goods.chip.Progress;
import org.msdg.tavern_quest.goods.chip.Task;

import java.util.List;

/**
 * 副本
 * 1. 缓存委托全部内容
 * 2. 管理任务进度
 * Created by mw4157 on 16/6/6.
 */
public interface Instance {

    /**
     * 激活委托
     * 自动记录第一个任务,无需额外记录
     * @param entrust    委托内容
     */
    void activateEntrust(Entrust entrust);

    /**
     * 委托进度
     * @param entrustId 委托id
     * @return          委托进度实体
     */
    Progress entrustProgress(int entrustId);

    /**
     * 从缓存中获得委托内容
     * @param id    委托ID
     * @return      委托内容实体
     */
    Entrust getEntrust(int id);

    /**
     * 发布新任务
     * @param newTask       新任务内容
     */
    void releaseTask(Task newTask);

    /**
     * 批量发布新任务
     * @param newTaskList   新任务列表,拥有共同的父级任务
     */
    void releaseTask(List<Task> newTaskList);

    /**
     * 执行任务
     * @param task 要执行的任务
     */
    void executeTask(Task task);

    /**
     * 完成任务
     * @param task  已完成的任务
     */
    void completeTask(Task task);
}
