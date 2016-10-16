package songs;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 16/10/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class TopWordsServiceTest {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private TopWordsService topWordsService;

    @Test
    public void topX() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java", "groovy", "groovy"));
        assertEquals("groovy",topWordsService.topX(rdd,1).get(0));
    }

}













