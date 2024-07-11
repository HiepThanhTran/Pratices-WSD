package com.fh.services;

import com.fh.utils.JDBC;
import com.fh.pojo.Choice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoiceServices {

    public List<Choice> getChoices(String id) throws SQLException {
        List<Choice> choices = new ArrayList<>();
        try ( Connection conn = JDBC.getConn()) {
            CallableStatement stm = conn.prepareCall("{ CALL getChoices(?) }");
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"),
                        rs.getBoolean("is_correct"), rs.getString("question_id"));
                choices.add(c);
            }
        }

        return choices;
    }
}
