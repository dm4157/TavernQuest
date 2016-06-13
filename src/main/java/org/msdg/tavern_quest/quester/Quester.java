package org.msdg.tavern_quest.quester;

/**
 * 探索者
 * 无所畏惧的探索者
 *
 * 根据雇主提供的坐标, 找到雇主想吃的食材, 交给厨师去烹饪
 * 探索者要主动去申领任务
 * Created by mw4157 on 16/6/8.
 */
public interface Quester {

    /**
     * 老板娘:复活吧,我的勇士
     *
     * 用于探索者执行任务超时, 由老板娘调用来复活探索者
     * 就是重置探索者,初始化,让探索者可以继续领取新任务
     */
    void resurge();


}
