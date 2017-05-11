package com.baolian.entity.map;

import java.io.Serializable;
import java.util.Objects;

/**
 * BRAS平均qoe的bean类
 * Created by tomxie on 2017/5/3 20:58.
 */
public class TotalBRASQoeResult extends TotalBaseResult {

    //BRAS
    private String brasName;

    public TotalBRASQoeResult(String brasName) {
        super(null);
        this.brasName = brasName;
    }


    public TotalBRASQoeResult(String brasName, String date) {
        super(date);
        this.brasName = brasName;
    }

    public String getBrasName() {
        return brasName;
    }

    public void setBrasName(String brasName) {
        this.brasName = brasName;
    }

    @Override
    public String toString() {
        return String.format("%s,%f,%f,%f,%f,%f,%s", brasName,
                super.getPingAvgQoe(), super.getHttpAvgQoe(), super.getSpeedAvgQoe(),
                super.getGameAvgQoe(), super.getYoukuAvgQoe(), super.getDate());
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == this) {
    //         return true;
    //     }
    //     if (obj instanceof TotalBRASQoeResult) {
    //         return this.brasName.equals(((TotalBRASQoeResult) obj).getBrasName());
    //     }
    //     return false;
    // }
}
