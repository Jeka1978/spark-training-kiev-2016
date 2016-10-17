package football.services;

import org.apache.spark.sql.DataFrame;

/**
 * Created by Evegeny on 17/10/2016.
 */
public interface DataAppender {
    DataFrame appendColumns(DataFrame dataFrame);
}
