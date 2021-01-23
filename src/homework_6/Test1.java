package homework_6;

import org.junit.Assert;
import org.junit.Test;

public class Test1 {

    @Test(expected = RuntimeException.class)
    public void test_getArrayAfterLastFour_1(){
        int[] testArray = {1,2,3,8,5,6,7,8,9,0};
        Main.getArrayAfterLastFour(testArray);
    }
    @Test
    public void test_getArrayAfterLastFour_2(){
        int[] testArray = {1,2,3,4,5,6,7,8,9,0};
        int[] resultArray = {5,6,7,8,9,0};
        Assert.assertArrayEquals(resultArray,Main.getArrayAfterLastFour(testArray));
    }
    @Test
    public void test_getArrayAfterLastFour_3(){
        int[] testArray = {1,2,3,4};
        int[] resultArray = {};
        Assert.assertArrayEquals(resultArray,Main.getArrayAfterLastFour(testArray));
    }

    @Test
    public void test_isArrayHasOnlyOneAndFour_1(){
        int[] testArray = {1,4,1,4,1,1,1,4,4,4};
        Assert.assertTrue(Main.isArrayHasOnlyOneAndFour(testArray));
    }

    @Test
    public void test_isArrayHasOnlyOneAndFour_2(){
        int[] testArray = {1,1,1,1,1};
        Assert.assertFalse(Main.isArrayHasOnlyOneAndFour(testArray));
    }

    @Test
    public void test_isArrayHasOnlyOneAndFour_3(){
        int[] testArray = {4,4,4,4};
        Assert.assertFalse(Main.isArrayHasOnlyOneAndFour(testArray));
    }
    @Test
    public void test_isArrayHasOnlyOneAndFour_4(){
        int[] testArray = {1,4,1,4,1,1,1,4,4,3};
        Assert.assertFalse(Main.isArrayHasOnlyOneAndFour(testArray));
    }
}
