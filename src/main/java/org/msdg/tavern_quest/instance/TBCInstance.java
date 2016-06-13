package org.msdg.tavern_quest.instance;

import org.msdg.tavern_quest.disaster.ProgressException;
import org.msdg.tavern_quest.goods.Entrust;
import org.msdg.tavern_quest.goods.chip.Progress;
import org.msdg.tavern_quest.goods.chip.Task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 燃烧的远征
 *
 * 只是一个默认的副本实现,哈哈
 * Created by mw4157 on 16/6/6.
 */
public class TBCInstance implements Instance{

    /** 委托缓存 */
    private Map<Integer, Entrust> entrustMap;

    /** 委托进度缓存 */
    private Map<String, Progress> entrustProgressMap;

    /** 任务进度缓存 */
    private Map<String, Progress> taskProgressMap;

    /**
     * 小单例
     */
    private TBCInstance() {
        entrustMap = new ConcurrentHashMap<>();
        entrustProgressMap = new ConcurrentHashMap<>();
        taskProgressMap = new ConcurrentHashMap<>();
    }
    private static class TBCInstanceHandler {
        private static TBCInstance instance = new TBCInstance();
    }
    public static TBCInstance instance() {
        return TBCInstanceHandler.instance;
    }

    /**
     * 激活委托
     * 自动记录第一个任务,无需额外记录
     */
    @Override
    public void activateEntrust(Entrust entrust) {
        // 缓存委托
        entrustMap.put(entrust.getId(), entrust);

        // 委托进度
        Progress entrustProgress = new Progress(String.valueOf(entrust.getId()));
//        entrustProgress.updateTask(originTask.getType(), Progress.RELEASED, 1);
        entrustProgressMap.put(entrustProgress.getId(), entrustProgress);

        // 原始任务进度,即第一个任务,这个任务大多数情况下与委托相同
//        Progress taskProgress = new Progress(originTask.getUuid());
//        taskProgressMap.put(taskProgress.getId(), taskProgress);
    }

    @Override
    public Progress entrustProgress(int entrustId) {
        return null;
    }

    @Override
    public Entrust getEntrust(int id) {
        return null;
    }

    /**
     * 发布新任务
     * 更新任务记录
     * @param newTask       新任务内容
     */
    @Override
    public void releaseTask(Task newTask) {
        // 更新父任务进度
        updateParentTask(newTask, Progress.RELEASED, 1);

        // 创建进度
        createProgressForTask(newTask);
    }

    /**
     * 批量发布新任务
     * @param newTaskList   新任务列表,拥有共同的父级任务
     */
    @Override
    public void releaseTask(List<Task> newTaskList) {
        if (newTaskList.size() == 0) {
            return;
        }

        // 更新父任务的进度
        updateParentTask(newTaskList.get(0), Progress.RELEASED, newTaskList.size());

        // 为每个任务添加一个进度, 进度默认为0
        newTaskList.stream().forEach(newTask -> createProgressForTask(newTask));
    }

    @Override
    public void executeTask(Task task) {

    }

    @Override
    public void completeTask(Task task) {

    }

    /**
     * 更新父任务的进度
     * @param newTask   子任务代表,主要为了找到父任务
     * @param num       新发布的数量
     */
    private void updateParentTask(Task newTask, short type, int num) {
        Progress parentProgress;
        if (newTask.getParentUuid() == null) {
            parentProgress = entrustProgressMap.get(newTask.getEntrustId());
        } else {
            parentProgress = taskProgressMap.get(newTask.getParentUuid());
        }

        // 更新父任务的进度
        if (null == parentProgress) {
            throw new ProgressException("父任务进度丢失");
        }
        parentProgress.updateTask(newTask.getType(), type, num);
    }

    /**
     * 给新任务建立一个新进度
     */
    private void createProgressForTask(Task newTask) {
        Progress newTaskProgress = new Progress(newTask.getUuid(), newTask.getParentUuid());
        taskProgressMap.put(newTaskProgress.getId(), newTaskProgress);
    }
}
