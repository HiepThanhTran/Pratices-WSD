package com.fh.services;

import com.fh.pojo.Choice;
import com.fh.pojo.Question;
import com.fh.utils.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionServices {

    public List<Question> getQuestions(int n) throws SQLException {
        List<Question> ques = new ArrayList<>();
        try (Connection conn = JDBC.getConn()) {
            CallableStatement stm = conn.prepareCall("{ CALL getQuestions(?) }");
            stm.setInt(1, n);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                ques.add(q);
            }
        }

        return ques;
    }

    public Question addQuestion(Question q, List<Choice> choices) throws SQLException {
        try (Connection conn = JDBC.getConn()) {
            conn.setAutoCommit(false);

            CallableStatement stm = conn.prepareCall("{ CALL createQuestion(?, ?, ?) }");
            stm.setString("id", q.getId());
            stm.setString("content", q.getContent());
            stm.setInt("category_id", q.getCategoryID());
            stm.executeUpdate();

            for (Choice c : choices) {
                stm = conn.prepareCall("{ CALL createChoice(?, ?, ?, ?) }");
                stm.setString("id", c.getId());
                stm.setString("content", c.getContent());
                stm.setBoolean("is_correct", c.isCorrect());
                stm.setString("question_id", c.getQuestionID());
                stm.executeUpdate();
            }

            conn.commit();

            return q;
        }
    }
}
