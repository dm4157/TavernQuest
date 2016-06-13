package org.msdg.tavern_quest.goods;

/**
 * 破碎虚空(过渡页描述)
 *
 * 描述破碎虚空坐标的特征,便于探索者探索破碎虚空,然后找到目标位面
 *
 * PS:过渡页面是指不存在抽取字段的页面,只是为了找到目标页面
 * Created by mw4157 on 16/6/5.
 */
public class Mars {

    /** 破碎虚空ID */
    private int id;
    /** 定位类型, 1=选择器,xpath,正则表达式, 2=列表生成器 */
    private int type;
    /**
     * 可以写选择器(无特殊),xpath(以'//'开头),正则表达式(程序添加开头'/'),
     *
     * 列表规则:
     * {page}   页码占位符, 适合翻页规则是页码的, 与条目占位二选一必填, 如page=1, page=2
     * {item}   条目占位符, 适合翻页规则是条数的, 与页码占位二选一必填, 如item=10, item=20
     * {size}   页容占位符, 有的列表可以自定义页容, 非必须
     * {charset}编码占位符, 有的列表不传编码会乱, 非必须
     *
     * 例子:
     * // TODO 列表规则例子
     * */
    private String position;

    /** 起始偏移量, 默认从0开始, 如果从1开始这里写1 */
    private int offset;
    /** 定位总页数, 与定位总条数二选一必填, 可以写选择器,xpath,正则表达式 */
    private String totalPage;
    /** 定位总条数, 与定位总页数二选一必填, 可以写选择器,xpath,正则表达式 */
    private String totalItem;
    /** 页面容量, 每页多少条, 如果填写了定位总条数, 则必填 */
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
