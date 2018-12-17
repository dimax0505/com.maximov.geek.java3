package TestOneHW;

import DataBase_Lesson6.Connection;
import DataBase_Lesson6.IDBWorkable;
import DataBase_Lesson6.Students;
import DataBase_Lesson6.UserWorking;
import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ChangeDataBaseTest {

    private Connection con;
    private IDBWorkable idb;
    private Students stdTest = new Students("ТестовыйСтудент", 22.5);


    @Before
    public void prepare() {
        con = new Connection();
        idb = new UserWorking(con);

    }

    @After
    public void tearDown() {
        idb = null;
        con = null;

    }


    @Test
    public void atestAddDB() {
       idb.addToDB(stdTest.getName(),stdTest.getAssessment());
       stdTest.setId(idb.readFromDB(stdTest.getName()).get(0).getId());
       Assert.assertEquals(stdTest, idb.readFromDB(stdTest.getName()).get(0));
    }

    @Test
    public void btestReadDB() {
        stdTest.setId(idb.readFromDB(stdTest.getName()).get(0).getId());
        Assert.assertEquals(stdTest, idb.readFromDB(stdTest.getName()).get(0));
    }

    @Test
    public void ctestDeleteDB() {
        idb.delFromDB(stdTest.getName());
        Assert.assertNull(idb.readFromDB(stdTest.getName()));
    }
}
