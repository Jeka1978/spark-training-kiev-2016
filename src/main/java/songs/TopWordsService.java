package songs;

import org.apache.spark.api.java.JavaRDD;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Evegeny on 16/10/2016.
 */
public interface TopWordsService extends Serializable {
    List<String> topX(JavaRDD<String> lines, int x);
}
