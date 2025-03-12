package com.backend.handler;

import com.backend.enums.CheckResultEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(CheckResultEnum.class)
public class CheckResultEnumTypeHandler extends BaseTypeHandler<CheckResultEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CheckResultEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public CheckResultEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return rs.wasNull() ? null : CheckResultEnum.getByCode(code);
    }

    @Override
    public CheckResultEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return rs.wasNull() ? null : CheckResultEnum.getByCode(code);
    }

    @Override
    public CheckResultEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return cs.wasNull() ? null : CheckResultEnum.getByCode(code);
    }
} 