package football.services;

import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by Evegeny on 17/10/2016.
 */
public interface CustomUdf extends UDF1<String,String>{
    String name();
}
