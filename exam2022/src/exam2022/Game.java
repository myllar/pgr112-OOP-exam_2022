package exam2022;

import exam2022.quiz.binaryQuiz;
import exam2022.quiz.multichoiseQuiz;

import java.sql.*;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws SQLException {

        String topic;

        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Type your preferred quiz to start with \n " +
                "a (NFL) \n b (Music) ");

        topic = input.next();

        if (topic.equals("a")) {
            System.out.println("You have chosen the NFL quiz! \n questions is answered with y/n \n");
            binaryQuiz.main();

        } else if (topic.equals("b")) {
            System.out.println("You have chosen the Music quiz! \n Answer by typing the letter of selected alternative.\n");
            multichoiseQuiz.main();

        } else {
            System.out.println("try again");

        }
    }
}