package by.borisevich.phone.book.tool.converter.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by dima on 10/7/16.
 */
public class ProcessResultSetUtil {
    public static List resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(50);
        while (rs.next()) {
            HashMap row = new HashMap(columns);
            for (int i = 1; i <= columns; ++i) {
                int finalI = i;
                int type = md.getColumnType(i);
                row.put(md.getColumnName(i), catchNPE((a, b, c) -> mapObject(rs, finalI, type), rs, i, md.getColumnType(i), ""));
            }
            list.add(row);
        }

        return list;
    }

    private static String mapObject(ResultSet rs, Integer pos, Integer type) {
        String result = "";
        try {
            if (type == Types.TIMESTAMP) {
                result = rs.getTimestamp(pos).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString();
            } else if (type == Types.DECIMAL) {
                result = rs.getBigDecimal(pos).toString();
            } else
                result = rs.getObject(pos).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String catchNPE(Function3<ResultSet, Integer, Integer, String> func, ResultSet rs, Integer pos, Integer type, String def) {
        try {
            return Optional.ofNullable(func.apply(rs, pos, type)).orElse(def);
        } catch (NullPointerException npe) {
            return def;
        }
    }
}
