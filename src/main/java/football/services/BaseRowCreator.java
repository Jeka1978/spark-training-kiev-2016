package football.services;

import football.data.UserConfig;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class BaseRowCreator implements Serializable {
    @Autowired
    private UserConfig userConfig;

    public Row createRowFromLine(String line) {
        Map<String, String> map = FieldMapperUtils.getMap(line);
        List<String> columnValues = new ArrayList<>();
        for (String columnName : userConfig.columnNames) {
            columnValues.add(map.get(columnName));
        }
        return RowFactory.create(columnValues.toArray());
    }



}








