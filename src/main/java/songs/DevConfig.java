package songs;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 16/10/2016.
 */
@Configuration
@Profile("default")
public class DevConfig {
    @Bean
    public SparkConf sparkConf(){
        return new SparkConf().setMaster("local").setAppName("songs");
    }

}
