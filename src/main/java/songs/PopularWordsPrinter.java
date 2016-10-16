package songs;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 16/10/2016.
 */
@Service
public class PopularWordsPrinter {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private TopWordsService topWordsService;

    public void printTopX(String pathToDir, int x) {
        JavaRDD<String> rddLines = sc.textFile(pathToDir);
        List<String> popularWords = topWordsService.topX(rddLines, x);
        popularWords.forEach(System.out::println);
    }
}













