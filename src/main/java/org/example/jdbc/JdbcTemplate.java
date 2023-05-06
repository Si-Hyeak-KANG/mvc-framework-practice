package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// JDBC 라이브러리
public class JdbcTemplate {

    public void executeUpdate(String sql, PreparedStatementSetter pss) throws SQLException {

        // try-with-resources 를 사용하면, 자원을 자동으로 종료할 수 있음.
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pss.setter(pstmt);
            pstmt.executeUpdate();
        }
    }

    public Object executeQuery(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pss.setter(pstmt);
            ResultSet rs = pstmt.executeQuery();
            Object obj = null;

            if (rs.next()) {
                obj = rowMapper.map(rs);
            }

            return obj;
        }
    }
}
