package DataBase_Lesson6;

import java.util.List;

public class UserWorking implements IDBWorkable {

    private Connection con;

    public UserWorking(Connection con) {
        this.con = con;
    }


    @Override
    public void addToDB(String name, double assesment) {
        con.jdbcTemplate.update("insert into students (name, assessment) values(?,?)", name,assesment);
    }

    @Override
    public void delFromDB(String name) {
        con.jdbcTemplate.update("delete from students where name = ?", name);

    }

    @Override
    public List<Students> readFromDB(String name) {
        List<Students> results = con.jdbcTemplate.query(
                "select * from students where name = ?", new Object[]{name},
                (rs, rowNum) -> new Students(rs.getInt("ID"), rs.getString("name"),
                        rs.getDouble("assessment")));

        if (results.isEmpty()) {
            return null;
        } else {
            return results;
        }
    }
}
