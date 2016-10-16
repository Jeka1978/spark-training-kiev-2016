package songs;

import org.apache.spark.SparkConf;
import org.apache.spark.broadcast.TorrentBroadcast;
import org.apache.spark.storage.BroadcastBlockId;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Evegeny on 16/10/2016.
 */
@Configuration
@Profile("prod")
public class ProdConfig {
    @Bean

    public SparkConf conf(){
        SparkConf conf = new SparkConf().setAppName("topX");
        conf.set("spark.serializer","org.apache.spark.serializer.KryoSerializer");
        conf.set("spark.kryo.registrationRequired","false");
        Reflections com = new Reflections("songs");
        Set<Class<? extends Serializable>> classes = com.getSubTypesOf(Serializable.class);
        Class[] ourClasses = classes.toArray(new Class[classes.size()]);
        conf.registerKryoClasses(new Class[]{Object[].class, HashMap.class, ArrayList.class,LinkedHashSet.class,TorrentBroadcast.class,BroadcastBlockId.class});
        conf.registerKryoClasses(ourClasses);
        return conf;
    }
}

