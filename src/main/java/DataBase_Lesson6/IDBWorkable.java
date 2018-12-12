package DataBase_Lesson6;

import java.util.List;

public interface IDBWorkable {

    void addToDB(String name, double assesment);

    void delFromDB(String name);

    List<Students> readFromDB(String name);
}
