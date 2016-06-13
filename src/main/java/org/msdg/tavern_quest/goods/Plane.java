package org.msdg.tavern_quest.goods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 目标位面(目标页描述)
 *
 * 描述目标位面坐标的特征,便于探索者找到目标位面
 * 雇主想要的材料存在的位面
 * 探索者需要找到这里,并把材料带回交由厨师处理
 *
 * PS: 要抽取的字段都在目标页面上
 * Created by mw4157 on 16/6/5.
 */
public class Plane {

    /** 位面id */
    private int id;
    /** 从属位面 */
    private int parentId;
    /** 可以写选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/') */
    private String position;
    /** 所属委托 */
    private int entrustId;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(int entrustId) {
        this.entrustId = entrustId;
    }
}
