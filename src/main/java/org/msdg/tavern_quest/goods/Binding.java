package org.msdg.tavern_quest.goods;

/**
 * 魔法封印(分组)
 *
 * 有的位面存在无序的材料,单纯使用坐标无法定位
 * 可以先用封印确定一个范围,然后根据特征材料名获取材料
 *
 * PS: 原理是通过确定的定位获得分组区域的DOM,然后根据key定位抽取key字段,同理抽取value字段
 * 然后构建map, 取值时就可以通过key字段获得value值.
 * 比如:  楼盘名称   XXX楼盘
 *       描述      这是一个奇怪的楼盘
 * 合成:  Map.put("楼盘名称", "XXX楼盘");
 *       Map.put("描述", "这是一个奇怪的楼盘");
 * Created by mw4157 on 16/6/5.
 */
public class Binding {

    /** 封印id */
    private int id;
    /** 封印名 */
    private String name;
    /** 封印定位, 确定分组的元素, 可以写选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/') */
    private String position;
    /** key值定位, 可以写选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/'), 需保证抽取数量与value一致 */
    private String keyPosition;
    /** value定位, 可以写选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/'), 需保证抽取数量与key一致 */
    private String valuePosition;

    /** 所属位面ID */
    private int planeId;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getKeyPosition() {
        return keyPosition;
    }

    public void setKeyPosition(String keyPosition) {
        this.keyPosition = keyPosition;
    }

    public String getValuePosition() {
        return valuePosition;
    }

    public void setValuePosition(String valuePosition) {
        this.valuePosition = valuePosition;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }
}
