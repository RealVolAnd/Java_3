package homework_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        // первый метод возвращает все после последнй четверки
        int[] resultArrray1 = getArrayAfterLastFour(array1);
        System.out.println(Arrays.toString(resultArrray1));

        // второй метод возвращает false если в массиве нет 1 и 4, или есть число отличное от 1 и 4
        int[] array2 = {4, 4, 4, 1, 4, 4, 4};
        System.out.println(isArrayHasOnlyOneAndFour(array2));

    }

    public static int[] getArrayAfterLastFour(int[] intArray) {
        int[] result = null;
        int fourPos = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 4) fourPos = i;
        }

        if (fourPos == 0) {
            throw new RuntimeException("No 4 was found");
        }

        result = Arrays.copyOfRange(intArray, fourPos + 1, intArray.length);
        return result;
    }


    public static boolean isArrayHasOnlyOneAndFour(int[] intArray) {
        boolean result = false, one = false, four = false, wrongNumber = false;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 1 && intArray[i] != 4) return false;
            if (intArray[i] == 1) one = true;
            if (intArray[i] == 4) four = true;

        }

        return (one & four);
    }

}
