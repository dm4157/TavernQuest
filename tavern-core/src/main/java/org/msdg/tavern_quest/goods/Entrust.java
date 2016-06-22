package org.msdg.tavern_quest.goods;

/**
 * 委托(任务)
 * 雇主创建委托并发布
 * 老板娘根据委托创建第一个任务
 * 探索者接受任务, 如果大任务则分解成小任务交给老板娘, 如果是小任务直接完成交给厨师
 * 厨师处理探索者收集的材料
 * 追踪者将厨师做好的菜肴拼凑完整,并呈上
 * 看守人守护完整的菜肴,以便完成雇主的任务
 * Created by mw4157 on 16/6/5.
 */
public class Entrust {

    /** 任务ID */
    private int id;
    /** 父任务ID, 如果为null则是主要任务, 只有主任务可以主动发布和更新 */
    private int parentId;
    /** 任务名字 */
    private String name;
    /** 简介 */
    private String intro;

    /** 起始url, 是一个具体的http地址 */
    private String origin;
    /** 破碎虚空ID, 描述过渡页面的规则 */
    private int MarsId;
    /** 目标位面ID, 描述目标页面的规则 */
    private int planeId;

    /** 是否代理, true 需要代理 */
    private boolean needProxy;
    /** 更新周期的cron表达式 */
    private String updateCron;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getMarsId() {
        return MarsId;
    }

    public void setMarsId(int marsId) {
        MarsId = marsId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public boolean isNeedProxy() {
        return needProxy;
    }

    public void setNeedProxy(boolean needProxy) {
        this.needProxy = needProxy;
    }

    public String getUpdateCron() {
        return updateCron;
    }

    public void setUpdateCron(String updateCron) {
        this.updateCron = updateCron;
    }
}
