package com.baolian.entity.map.comp;

import com.baolian.entity.map.BaseResult;
import com.baolian.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Result的比较器
 * Created by tomxie on 2017/5/4 22:29.
 */
public class ResultComparator<T extends BaseResult> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        try {
            Date date1 = DateUtils.parse(o1.getDate(), DateUtils.DATE_PATTERN);
            Date date2 = DateUtils.parse(o2.getDate(), DateUtils.DATE_PATTERN);
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
