package org.msdg.tavern_quest.goods;

/**
 * 材料(抽取字段)
 *
 * 雇主想要的东西
 * Created by mw4157 on 16/6/5.
 */
public class Material {

    /** 材料id */
    private int id;
    /** 材料名 */
    private String name;
    /** 简介 */
    private String intro;

    /** 所属委托ID, 与封印ID二选一必填 */
    private Integer entrustId;
    /** 所属封印ID, 与委托ID二选一必填 */
    private Integer bindingId;

    /** 定位类型, 1=选择器, xpath, 正则表达式, 3=委托 */
    private int type;
    /**
     * 定位规则, 可写
     * 选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/'),
     * 封印的key(当bingdingId有值时),
     * 子委托的ID
     */
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public Integer getBindingId() {
        return bindingId;
    }

    public void setBindingId(Integer bindingId) {
        this.bindingId = bindingId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
