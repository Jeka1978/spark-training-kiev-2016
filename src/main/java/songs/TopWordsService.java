package songs;

import org.apache.spark.api.java.JavaRDD;

import java.util.List;

/**
 * Created by Evegeny on 16/10/2016.
 */
public interface TopWordsService {
    List<String> topX(JavaRDD<String> lines, int x);
}
