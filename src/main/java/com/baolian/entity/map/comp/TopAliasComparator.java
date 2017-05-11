package com.baolian.entity.map.comp;

import com.baolian.entity.map.TopAliasResult;

import java.util.Comparator;

/**
 * 门户评分比较器
 * Created by tomxie on 2017/5/10 15:19.
 */
public class TopAliasComparator implements Comparator<TopAliasResult> {
    @Override
    public int compare(TopAliasResult o1, TopAliasResult o2) {
        return -o1.getQoe().compareTo(o2.getQoe());
    }
}
