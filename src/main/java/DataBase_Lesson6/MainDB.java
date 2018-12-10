package DataBase_Lesson6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class MainDB {
    private static int size = 10;
    private static Students[] students;
    private static String nameTable = "students";


    public static void main(String[] args) {
        DriverManagerDataSource dataSource = makeConnectToDB();

        makeStudentssArray(size);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Создаем базу данных или подключаемся к существующей");


        ClearTableAndMakeNew(jdbcTemplate);


        for (Students student : students) {
            jdbcTemplate.update("insert into students (name, assessment) values(?,?)", student.getName(),student.getAssessment());
        }
    }

    private static void ClearTableAndMakeNew(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("drop table if exists " + nameTable);
        jdbcTemplate.execute("create table " + nameTable +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name varchar(255), assessment double)");
    }

    private static DriverManagerDataSource makeConnectToDB() {
        DriverManagerDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUsername("");
        dataSource.setUrl("jdbc:sqlite:sample.db");
        dataSource.setPassword("");
        return dataSource;
    }

    private static void makeStudentssArray(int size) {
        students = new Students[size];
        for (int i = 0; i < size; i++) {
            students[i] = new Students("Студент" + i, 1.5 + i);
        }
    }

}
