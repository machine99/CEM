package com.baolian.entity.map.comp;

import com.baolian.entity.map.BaseResult;
import com.baolian.entity.map.Timizable;
import com.baolian.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Result的时间比较器
 * Created by tomxie on 2017/5/4 22:29.
 */
public class ResultDateComparator<T extends Timizable> implements Comparator<T> {
    private String pattern;

    public ResultDateComparator(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int compare(T o1, T o2) {
        try {
            Date date1 = DateUtils.parse(o1.getDate(), pattern);
            Date date2 = DateUtils.parse(o2.getDate(), pattern);
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
