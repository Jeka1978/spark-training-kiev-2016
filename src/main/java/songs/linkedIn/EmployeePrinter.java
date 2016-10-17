package songs.linkedIn;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import songs.Config;

import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class EmployeePrinter {
    @Autowired
    private EmployeeResolver employeeResolver;

    @Autowired
    private SQLContext sqlContext;

    public void printEmployees() {
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*");
        List<String> employees = employeeResolver.findCheapestEmployees(dataFrame, 1200);
        employees.forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\util\\hadoop-common-2.2.0-bin-master\\");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(EmployeePrinter.class).printEmployees();
    }
}















