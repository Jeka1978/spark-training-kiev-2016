package football.config;

import football.infra.aop.ShowDataFrameAspect;
import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 16/10/2016.
 */
@Configuration
@Profile("default")
@EnableAspectJAutoProxy
public class DevConfig {
    @Bean
    public SparkConf sparkConf(){
        return new SparkConf().setMaster("local")
                .setAppName("football");
    }

    @Bean
    public ShowDataFrameAspect showDataFrameAspect(){
        return new ShowDataFrameAspect();
    }


}
