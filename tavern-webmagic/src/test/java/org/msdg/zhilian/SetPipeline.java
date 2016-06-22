package org.msdg.zhilian;

import io.netty.util.internal.ConcurrentSet;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Set;

/**
 * Created by mw4157 on 16/6/22.
 */
public class SetPipeline implements Pipeline {
    public static Set<Position> positionSet = new ConcurrentSet<>();
    @Override
    public void process(ResultItems resultItems, Task task) {
        positionSet.addAll(resultItems.get("positions"));
        System.out.println("---> 最新记录:" + positionSet.size());
    }
}
