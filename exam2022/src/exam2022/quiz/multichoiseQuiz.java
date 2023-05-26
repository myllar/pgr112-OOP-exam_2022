package exam2022.quiz;

import java.sql.*;
import java.util.Scanner;

public class multichoiseQuiz {

    public static void main() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizDb", "root", "admin123");
        String userInput;
        int score = 0;
        PreparedStatement p;
        ResultSet rs;
        String userName;

        Scanner input = new Scanner(System.in);
            System.out.println("Enter username \n");
            userName = input.next();

            System.out.println("Hello " + userName + "! Welcome to the music-quiz \n " + "get ready: \n");

        input.nextLine();

        try {
            String selectQuiz = "SELECT * FROM multichoiceQuiz ORDER BY RAND()";
            p = con.prepareStatement(selectQuiz);
            rs = p.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                String answerA = rs.getString("answerA");
                String answerB = rs.getString("answerB");
                String answerC = rs.getString("answerC");
                String answerD = rs.getString("answerD");
                String correctAnswer = rs.getString("correctAnswer");
                System.out.println(id + ") " + question + "\n" + answerA + "\n" + answerB + "\n" + answerC + "\n" + answerD + "\n");

                userInput = input.nextLine();

            if (userInput.equals(correctAnswer)) {
                    score++;
                    System.out.println("Yes! Current score is: " + score + "\n");
            }else {
                    System.out.println("wrong answer... correct answer was " + correctAnswer + ". Score: " + score + ".\n");
                    }
            }

        Statement st = con.createStatement();
        String saveScore = "INSERT INTO scoreTable (user, score, topic)" + "VALUES ('"+userName+"', '"+score+"', 'Music')";
        int rs2 = st.executeUpdate(saveScore);
        while (rs.next()) {
            System.out.println("score saved. ");
        }
        st.close();



        System.out.println("Thank you for playing, " + userName + ". Your final score was: " + score + ". \n Your highscore has been added to the registry!");

        } catch (SQLException e) {
        System.out.println();
        }

    }
}
