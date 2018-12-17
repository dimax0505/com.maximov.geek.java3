package MyTestCase;

import MyTestLib.AfterSuite;
import MyTestLib.BeforeSuite;
import MyTestLib.Test;

public class TestOfTest {

    @BeforeSuite
    public void prepare() {
        System.out.println("Этот код выполнился перед всеми тестами");
    }


    @AfterSuite
    public void finised() {
        System.out.println("Этот код выполняется после всех тестов");
    }


    @Test(priority = Test.Priority.Level0)
    public void testPriority0() {
        System.out.println("Этот тест выполнится самым первым из тестов");
    }

    @Test(priority = Test.Priority.Level1)
    public void testPriority1() {
        System.out.println("Этот тест с первым приоритетом");
    }

    @Test(priority = Test.Priority.Level8)
    public void testPriority8() {
        System.out.println("Этот тест с восьмым приоритетом");
    }

    @Test(priority = Test.Priority.Level8)
    public void testPriority8Two() {
        System.out.println("Еще один тест с восьмым приоритетом");
    }

    @Test(priority = Test.Priority.Level8)
    public void testPriority8Three() {
        System.out.println("И Еще один тест с восьмым приоритетом");
    }

}
