package DataBase_Lesson6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Connection {
    JdbcTemplate jdbcTemplate;

   public Connection(){
        DriverManagerDataSource dataSource = new SingleConnectionDataSource("jdbc:sqlite:sample.db", true);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
