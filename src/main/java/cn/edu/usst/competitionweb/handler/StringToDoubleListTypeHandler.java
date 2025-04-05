package cn.edu.usst.competitionweb.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@MappedTypes(List.class)
public class StringToDoubleListTypeHandler extends BaseTypeHandler<List<Double>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    List<Double> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    @Override
    public List<Double> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertStringToDoubleList(value);
    }

    @Override
    public List<Double> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertStringToDoubleList(value);
    }

    @Override
    public List<Double> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertStringToDoubleList(value);
    }

    private List<Double> convertStringToDoubleList(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Collections.emptyList();
        }
        try {
            return Stream.of(value.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Double::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("无法将字符串转换为双精度列表: " + value, e);
        }
    }
}
