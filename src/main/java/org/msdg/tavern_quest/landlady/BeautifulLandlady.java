package org.msdg.tavern_quest.landlady;

import org.msdg.tavern_quest.goods.Entrust;
import org.msdg.tavern_quest.goods.chip.Task;
import org.msdg.tavern_quest.instance.Instance;
import org.msdg.tavern_quest.instance.TBCInstance;
import org.msdg.tavern_quest.quester.Quester;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 漂亮的老板娘
 *
 * 不知道做事靠谱不...
 * Created by mw4157 on 16/6/6.
 */
public class BeautifulLandlady implements Landlady{

    private Instance instance = TBCInstance.instance();

    /** 任务板 */
    private ConcurrentLinkedQueue<Task> taskBoard = new ConcurrentLinkedQueue<>();

    /** 任务登记处 */
    private Map<String, TaskRecord> recordMap = new ConcurrentHashMap<>();

    /**
     * 小单例
     */
    private BeautifulLandlady() {
        new Thread(() -> {
            recordMap.entrySet().stream().forEach(entry -> {
                //TODO 判断任务超时
            });
        }).start();
    }
    private static class BeautifulLandladyHandler {
        private static BeautifulLandlady landlady = new BeautifulLandlady();
    }
    public static BeautifulLandlady instance() {
        return BeautifulLandladyHandler.landlady;
    }

    /**
     * 申领一个任务
     * 探索者才会申领
     * @param quester   探索者本人
     * @return  一个尚未完成的任务
     */
    @Override
    public Task todo(Quester quester) {
        Task task = taskBoard.poll();
        recordMap.put(task.getUuid(), record(task, quester));
        return task;
    }

    /**
     * 接受委托并发布
     * 要放到Instance中缓存并管理进度
     * 同时生成第一个task任务交由探索者执行
     * @param entrust   委托内容
     */
    @Override
    public void releaseEntrust(Entrust entrust) {
        Task originTask = new Task() {
            {
                setEntrustId(entrust.getId());
                setOrigin(entrust.getOrigin());
                setMarsId(entrust.getMarsId());
                setPlaneId(entrust.getPlaneId());
            }
        };

        // 激活任务进度
        instance.activateEntrust(entrust);
        // 发布任务
        issueTask(originTask);
    }

    /**
     * 发布任务, 可被其他探索者认领
     * 探索者接受任务后,完成任务.在执行的过程中也会发布新的任务
     */
    @Override
    public void issueTask(Task task) {
        // 在副本管理器中添加新发布的任务
        instance.releaseTask(task);

        // 把任务贴到墙上
        taskBoard.add(task);
    }

    /**
     * 一次性发布多个任务, 可被其他探索者认领
     */
    @Override
    public void issueTask(List<Task> taskList) {
        instance.releaseTask(taskList);
        taskBoard.addAll(taskList);
    }

    @Override
    public void complete(Task task) {

    }

    /**
     * 创建一份任务记录
     * @param task      探索任务
     * @param quester   探索者
     * @return          任务领取记录
     */
    public TaskRecord record(Task task, Quester quester) {
        return new TaskRecord(task, new Date(), quester);
    }

    /**
     * 任务领取记录
     */
    private class TaskRecord {
        /** 子任务 */
        private Task task;
        /** 申领时间 */
        private Date start;
        /** 申领的探索者 */
        private Quester quester;

        TaskRecord(Task task, Date start, Quester quester) {
            this.task = task;
            this.start = start;
            this.quester = quester;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Quester getQuester() {
            return quester;
        }

        public void setQuester(Quester quester) {
            this.quester = quester;
        }
    }
}
