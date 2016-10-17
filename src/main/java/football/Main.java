package football;

import football.config.Config;
import football.services.FlowService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 17/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\util\\hadoop-common-2.2.0-bin-master\\");
        FlowService flowService = new AnnotationConfigApplicationContext(Config.class).getBean(FlowService.class);
        flowService.doWork();
    }
}
