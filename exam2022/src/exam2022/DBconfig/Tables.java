package exam2022.DBconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {

    public static void main (String[] args) throws SQLException {

        Connection crDb = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin123");
        Statement st = crDb.createStatement();
        String createDb =
                "CREATE DATABASE IF NOT EXISTS quizDb";
        st.execute(createDb);
        System.out.println("- Schema/DB quizDb created");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizDb", "root", "admin123");
        Statement stm = con.createStatement();

////    CREATE TABLE multichoiceQuiz:
        String createTableMultichoiceQuiz =
                "CREATE TABLE `quizDb`.`multichoiceQuiz` (" +
                        "`id` int," +
                        "`Question` varchar(60)," +
                        "`answerA` varchar(30)," +
                        "`answerB` varchar(30)," +
                        "`answerC` varchar(30)," +
                        "`answerD` varchar(30)," +
                        "`correctAnswer` varchar(30)," +
                        "PRIMARY KEY (`id`));";
        stm.execute(createTableMultichoiceQuiz);
        System.out.println("- Table multichoiceQuiz created");


////        ADD QUESTIONS TO THE MULTIPLE CHOICE TABLE:
        Statement multiQuestions = con.createStatement();
        String addQuestions = "INSERT INTO multichoiceQuiz VALUES ('1', 'Heart of Gold is a song by?', 'a. Bob Dylan', 'b. Metallica', 'c. Neill Young', 'd. Rolling Stones', 'c'), " +
                "('2', 'Metallica have written which song?', 'a. Nothing else matters', 'b. Thunderstruck', 'c. When the man comes around', 'd. Another brick in the wall', 'a')," +
                "('3', 'What is the nationality of Ozzy Osbourne?', 'a. Germany', 'b. USA', 'c. England', 'd. Ireland', 'c')," +
                "('4', 'Which artist became famous through the band AC/DC?', 'a. Neill Young', 'b. Brian Young', 'c. Steve Young', 'd. Angus Young', 'd'), " +
                "('5', 'Which country is the home of U2?', 'a. Italy', 'b. Ireland', 'c. Scotland', 'd. Wales', 'b')," +
                "('6', 'What kind of tree is it Fools Garden named a song after?', 'a. Orange-tree', 'b. Pineapple-tree', 'c. Oak-tree', 'd. Lemon-tree', 'd');";
        multiQuestions.execute(addQuestions);
        System.out.println("- MultipleQuestions added");


////    CREATE TABLE binaryQuiz:
        Statement binTable = con.createStatement();
        String createTableBinaryQuiz =
                "CREATE TABLE `quizDb`.`binaryQuiz` (" +
                        "`id` int," +
                        "`Question` varchar(60)," +
                        "`correctAnswer` varchar(3)," +
                        "PRIMARY KEY (`id`));";
        binTable.execute(createTableBinaryQuiz);
        System.out.println("- Table binaryQuiz created");

////        ADD QUESTIONS TO THE BINARY TABLE:
        Statement binQuestions = con.createStatement();
        String addBinQuestions = "INSERT INTO binaryQuiz VALUES ('1', 'NFL is an acronym for National Football League', 'y')," +
                "('2', 'The quarterback is kicking the ball', 'n')," +
                "('3', 'Tom Brady is the most decorated player in NFL history', 'y')," +
                "('4', 'A game last for 60 minutes of actual gameplay', 'y')," +
                "('5', 'Official NFL matches are only played in USA', 'n')," +
                "('6', 'Superbowl is played once every second year', 'n')";
        binQuestions.execute(addBinQuestions);
        System.out.println("- BinaryQuestions added");

//    CREATE TABLE scoreTable
        String createTableScoreTable =
                "CREATE TABLE `quizDb`.`scoreTable` (" +
                        "`id` int NOT NULL AUTO_INCREMENT," +
                        "`user` varchar(20)," +
                        "`score` int," +
                        "`topic` varchar(20)," +
                        "PRIMARY KEY (`id`));";

        stm.execute(createTableScoreTable);
        con.close();
        System.out.println("- Table scoreTable created");

    }
}
