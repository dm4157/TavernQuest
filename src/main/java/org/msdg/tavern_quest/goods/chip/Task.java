package org.msdg.tavern_quest.goods.chip;

import java.util.Map;
import java.util.UUID;

/**
 * 任务
 * 由委托分解而来
 * 描述一些细化的具体任务,仅供探索者参考
 * Created by mw4157 on 16/6/6.
 */
public class Task {
    public static final short MARS = 1;
    public static final short PLANE = 2;

    /** 随机生成的UUID */
    private String uuid;
    /** 父任务的UUID */
    private String parentUuid;
    /** 所属委托ID */
    private int entrustId;
    /** 任务类型, 1-破碎虚空(过渡页任务), 2-目标位面(目标页任务) */
    private short type;

    /** 任务要寻找的元素名, 追踪者使用这个值将结果合并到上一级结果中 */
    private String materialName;

    /** 起始url, 是一个具体的http地址 */
    private String origin;
    /** 破碎虚空ID, 描述过渡页面的规则 */
    private int MarsId;
    /** 目标位面ID, 描述目标页面的规则 */
    private int planeId;

    /** 材料集合, 即任务执行结果 */
    private Map<String, Object> materialMap;

    public synchronized String getUuid() {
        if (null == uuid) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public int getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(int entrustId) {
        this.entrustId = entrustId;
    }

    public short getType() {
        if (type == 0) {
            synchronized(this) {
                // 初始化type
                if (type == 0) {

                }
            }
        }
        return type;
    }

    public void setType(short type) {
        this.type = type;
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Map<String, Object> getMaterialMap() {
        return materialMap;
    }

    public void setMaterialMap(Map<String, Object> materialMap) {
        this.materialMap = materialMap;
    }
}
