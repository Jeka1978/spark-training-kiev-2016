package football.services;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.functions;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class StupidDataAppender implements DataAppender {
    @Override
    public DataFrame appendColumns(DataFrame dataFrame) {
        return dataFrame.withColumn("devil",
                functions.lit("666"));
    }
}
