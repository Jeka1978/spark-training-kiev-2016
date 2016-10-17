package songs.linkedIn;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.StructField;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.*;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class EmployeeResolver {
    public List<String> findCheapestEmployees(DataFrame dataFrame, int salary) {
        dataFrame.show();
        dataFrame.printSchema();
        StructField[] fields = dataFrame.schema().fields();
        Arrays.stream(fields).forEach(System.out::println);
        dataFrame = dataFrame.withColumn("salary", size(col("keywords")).multiply(col("age").multiply(10)));
        DataFrame frame = dataFrame.select(explode(col("keywords")).as("keyword"));
        frame.show();
        Row first = frame.groupBy(col("keyword")).count().orderBy(col("count").desc())
                .first();
        String mostPopular = first.getAs("keyword");
        System.out.println("mostPopular = " + mostPopular);
        dataFrame = dataFrame.where(col("salary").leq(salary).and(array_contains(col("keywords"), mostPopular)));
        List<Row> rows = dataFrame.select("name").collectAsList();
        return rows.stream().map(row -> row.getAs("name").toString()).collect(Collectors.toList());
    }
}













