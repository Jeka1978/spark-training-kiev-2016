package songs;

import lombok.Setter;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.List;

/**
 * Created by Evegeny on 16/10/2016.
 */
@Service
public class TopWordsServiceImpl implements TopWordsService {

    @AutowiredBroadcast
    private Broadcast<UserConfig> userConfigBroadcast;


    @Override
    public List<String> topX(JavaRDD<String> lines, int x) {
        return lines.map(String::toLowerCase)
                .flatMap(WordsUtil::getWords)
                .filter(word->!this.userConfigBroadcast.value().garbage.contains(word))
                .mapToPair(word->new Tuple2<>(word,1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2).take(x);
    }
}



















