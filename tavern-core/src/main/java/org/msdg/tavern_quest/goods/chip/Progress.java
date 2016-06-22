package org.msdg.tavern_quest.goods.chip;

/**
 * 进度
 * 委托进度  任务进度
 * Created by mw4157 on 16/6/6.
 */
public class Progress {
    public static final short RELEASED = 1;
    public static final short EXECUTING = 2;
    public static final short COMPLETED = 3;

    /** 委托或者任务的ID */
    private String id;
    /** 父级ID */
    private String parentId;

    /** 已发布的破碎虚空的任务数量 */
    private volatile int marsReleased;
    /** 进行中的破碎虚空的任务数量 */
    private volatile int marsExecuting;
    /** 已完成的破碎虚空的任务数量*/
    private volatile int marsCompleted;

    /** 已发布的目标位面的任务数量 */
    private volatile int planeReleased;
    /** 进行中的目标位面的任务数量 */
    private volatile int planeExecuting;
    /** 已完成的目标位面的任务数量*/
    private volatile int planeCompleted;

    public Progress(String id) {
        this.id = id;
    }

    public Progress(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    /**
     * 更新任务进度
     * @param taskType  任务类型, 1-破碎虚空, 2-目标位面
     * @param eventType 事件类型, 1-released, 2-executing, 3-completed
     * @param num       变更数量
     */
    public synchronized  void updateTask(short taskType, short eventType, int num) {
        if (taskType == Task.MARS) {
            switch (eventType) {
                case RELEASED:
                    marsReleased += num;
                    break;
                case EXECUTING:
                    marsExecuting += num;
                    break;
                case COMPLETED:
                    marsCompleted += num;
                    break;
            }
        } else if (taskType == Task.PLANE) {
            switch (eventType) {
                case RELEASED:
                    planeReleased += num;
                    break;
                case EXECUTING:
                    planeExecuting += num;
                    break;
                case COMPLETED:
                    planeCompleted += num;
                    break;
            }
        }
    }

    /**
     * 任务是否已经完成
     * @return  true 任务已经完成, false任务尚未完成
     */
    public synchronized boolean isDone() {
        return marsReleased+marsExecuting+planeReleased+planeExecuting == 0;
    }

    /**
     * 破碎虚空任务总数
     */
    public int marsTotal() {
        return marsReleased + marsExecuting + marsCompleted;
    }

    /**
     * 破碎虚空任务进度
     */
    public double marsProgress() {
        return progress(marsCompleted, marsTotal());
    }

    /**
     * 目标位面任务总数
     */
    public int planeTotal() {
        return planeReleased + planeExecuting + planeCompleted;
    }

    /**
     * 目标位面任务进度
     */
    public double planeProgress() {
        return progress(planeCompleted, planeTotal());
    }

    /**
     * 计算进度
     * @param completed 完成任务数
     * @param total     总任务数, 0 则进度算0
     * @return          完成任务数/总任务数
     */
    private double progress(int completed, int total) {
        if (total > 0) {
            return completed * 1.0 / total;
        } else {
            return 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getMarsReleased() {
        return marsReleased;
    }

    public void setMarsReleased(int marsReleased) {
        this.marsReleased = marsReleased;
    }

    public int getMarsExecuting() {
        return marsExecuting;
    }

    public void setMarsExecuting(int marsExecuting) {
        this.marsExecuting = marsExecuting;
    }

    public int getMarsCompleted() {
        return marsCompleted;
    }

    public void setMarsCompleted(int marsCompleted) {
        this.marsCompleted = marsCompleted;
    }

    public int getPlaneReleased() {
        return planeReleased;
    }

    public void setPlaneReleased(int planeReleased) {
        this.planeReleased = planeReleased;
    }

    public int getPlaneExecuting() {
        return planeExecuting;
    }

    public void setPlaneExecuting(int planeExecuting) {
        this.planeExecuting = planeExecuting;
    }

    public int getPlaneCompleted() {
        return planeCompleted;
    }

    public void setPlaneCompleted(int planeCompleted) {
        this.planeCompleted = planeCompleted;
    }
}
