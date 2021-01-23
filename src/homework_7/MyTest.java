package homework_7;


public class MyTest extends Anno{

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
    @Test(priority=1)
    public void test_1(){
        System.out.println("Test_1");
    }
    @Test(priority=2)
    public void test_2(){
        System.out.println("Test_2");
    }
    @Test(priority=4)
    public void test_3(){
        System.out.println("Test_3");
    }
    @Test(priority=2)
    public void test_4(){
        System.out.println("Test_4");
    }
    @Test(priority=3)
    public void test_5(){
        System.out.println("Test_5");
    }
    @Test(priority=5)
    public void test_6(){
        System.out.println("Test_6");
    }

}
