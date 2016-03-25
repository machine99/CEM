import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tomxie on 2016/3/22 11:06.
 */
//
public final class SparkJavaWordCount {
    private static final Pattern SPACE = Pattern.compile("\\W");

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("yarn-client").setAppName("SparkJavaWordCount");
        JavaSparkContext context = new JavaSparkContext(sparkConf);

        JavaRDD<String> lines = context.textFile("hdfs://master:8020/test/spark/data/SparkTestData.txt");
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String s) throws Exception {
                return Arrays.asList(SPACE.split(s));
            }
        });

        JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<String, Integer> tuple2 : output) {
            System.out.println(tuple2._1() + ":" + tuple2._2());
        }
        context.stop();
        System.out.println("github");
    }
}
