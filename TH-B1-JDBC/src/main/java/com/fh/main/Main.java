package com.fh.main;

import com.fh.pojo.Choice;
import com.fh.pojo.Question;
import com.fh.services.ChoiceServices;
import com.fh.services.QuestionServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        QuestionServices ss = new QuestionServices();
        ChoiceServices cc = new ChoiceServices();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter question name: ");
        String qname = sc.nextLine();
        Question q1 = new Question(UUID.randomUUID().toString(), qname, 1);

        List<Choice> choices = new ArrayList<>();
        Choice c1 = new Choice(UUID.randomUUID().toString(), "choice 1", false, q1.getId());
        choices.add(c1);
        Choice c2 = new Choice(UUID.randomUUID().toString(), "choice 2", true, q1.getId());
        choices.add(c2);
        Choice c3 = new Choice(UUID.randomUUID().toString(), "choice 3", false, q1.getId());
        choices.add(c3);
        Choice c4 = new Choice(UUID.randomUUID().toString(), "choice 4", false, q1.getId());
        choices.add(c4);

        Question q = ss.addQuestion(q1, choices);
        choices = cc.getChoices(q.getId());
        System.out.println(q.getContent());
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, choices.get(i).getContent());
        }
    }
}
