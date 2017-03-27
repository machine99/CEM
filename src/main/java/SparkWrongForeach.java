import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;

/**
 * Created by tomxie on 2016/3/23 21:35.
 */
public class SparkWrongForeach {
    static int counter = 0;

    public static void main(String[] args) {
        SparkConf sc = new SparkConf().setMaster("yarn-client").setAppName("SparkWrongForeach");
        JavaSparkContext context = new JavaSparkContext(sc);


        JavaRDD<Integer> rdd = context.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        rdd.collect().foreach(new VoidFunction<Integer>() {
            public void call(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

    }
}
