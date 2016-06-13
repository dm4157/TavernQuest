package org.msdg.tavern_quest.landlady;

import org.msdg.tavern_quest.goods.Entrust;
import org.msdg.tavern_quest.goods.chip.Task;
import org.msdg.tavern_quest.quester.Quester;

import java.util.List;

/**
 * 酒馆老板娘
 *
 * 负责接受委托,发布任务
 * 雇主可以发布委托(主动执行爬虫任务,或者定时更新都认为是发布委托)
 * 探索者拆分后的委托可以在此发布
 * Created by mw4157 on 16/6/6.
 */
public interface Landlady {

    /**
     * 申领一个任务
     * 探索者才会申领
     * @param quester   探索者本人
     * @return  一个尚未完成的任务
     */
    Task todo(Quester quester);

    /**
     * 发布委托
     * 委托会在instance中缓存,并实时记录执行进度
     * 发布委托后老板娘会创建第一个任务
     * @param entrust   委托内容
     */
    void releaseEntrust(Entrust entrust);

    /**
     * 发布任务, 可被其他探索者认领
     * 探索者接受任务后,完成任务.在执行的过程中也会发布新的任务
     */
    void issueTask(Task task);

    /**
     * 一次性发布多个任务, 可被其他探索者认领
     */
    void issueTask(List<Task> taskList);

    /**
     * 完成任务
     * 将任务结果送给追踪者, 由其补完所有结果
     */
    void complete(Task task);
}
