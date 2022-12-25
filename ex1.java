import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        Exercise2 exercise2 = new Exercise2();
        exercise1.execute();
        exercise2.execute();
    }

}

class Exercise1{

    public Exercise1(){}

    class CustomException extends RuntimeException{
        public CustomException(String message) {
            super(message);
        }
    }

    public void execute() {
        exerciseA();
        exerciseB();
        exerciseС();
        exerciseD();
    }

    private void exerciseA(){
        getExceptionA();
        getExceptionB();
        getExceptionC();
    }

    private void exerciseB(){
        String[][] arr = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { //NullPointerException если переданный массив равен нулю
            for (int j = 0; j < 5; j++) { //ArrayIndexOutOfBoundsException если размерность меньше 5
                int val = Integer.parseInt(arr[i][j]); //NumberFormatException если не сможем преобразовать строку в инт
                sum += val;
            }
        }
        System.out.println(sum);
    }

    private void exerciseС(){
        try {
            int[] arrayA = {1, 2, 3};
            int[] arrayB = {2, 3, 4};
            System.out.println(Arrays.toString(arrayDifference(arrayA, arrayB)));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private void exerciseD(){
        try {
            int[] arrayA = {1, 2, 3};
            int[] arrayB = {2, 3, 4};
            System.out.println(Arrays.toString(arrayDivide(arrayA, arrayB)));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private int[] arrayDifference(int[] arrayA, int[] arrayB) {
        if (arrayA == null || arrayB == null) throw new CustomException("Arrays must not be null");
        else if (arrayA.length != arrayB.length) throw new CustomException("Arrays sizes must be equal");
        else {
            int[] result = new int[arrayA.length];
            for (int i = 0; i < arrayA.length; i++) {
                result[i] = arrayA[i] - arrayB[i];
            }
            return result;
        }
    }

    private float[] arrayDivide(int[] arrayA, int[] arrayB) {
        if (arrayA == null || arrayB == null) throw new CustomException("Arrays must not be null");
        else if (arrayA.length != arrayB.length) throw new CustomException("Arrays sizes must be equal");
        else {
            float[] result = new float[arrayA.length];
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayB[i] == 0) throw new CustomException("Divide by 0");
                result[i] = ((float) arrayA[i]) / arrayB[i];
            }
            return result;
        }
    }

    private void getExceptionA(){
        try {
            Integer.parseInt("error");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().toString());
        }
    }

    private void getExceptionB(){
        try {
            String a = null;
            System.out.println(a.toLowerCase(Locale.ROOT));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().toString());
        }
    }

    private void getExceptionC(){
        try {
            int[] array = new int[7];
            System.out.println(array[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().toString());
        }
    }
}







class Exercise2 {
    public Exercise2() {}

    public void execute() {
        exerciseA();
        exerciseB();
        exerciseC();
        exerciseD();
    }

    private void exerciseA() {
        Scanner in = new Scanner(System.in);
        String regexpPattern = "[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)";
        while (true) {
            String input = in.nextLine();
            if (input.matches(regexpPattern)) {
                float result = Float.parseFloat(input);
                System.out.println("You entered " + result);
                break;
            } else {
                System.out.println("incorrect input");
            }
        }
    }

    private void exerciseB() {
        int[] intArray = new int[10];
        intArray[8] = 6; //если массив передается параметром, эти 2 строчки не нужны

        int d = 0;
        if (d == 0) System.out.println("divide by 0");
        else if (intArray == null) System.out.println("array must not be null");
        else if (intArray.length < 9) System.out.println("element num 8 will be not available");
        else {
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
    }

    private void exerciseC() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

    private void exerciseD() {
        Scanner in = new Scanner(System.in);
        String regexpPattern = "\\s+";
        while (true) {
            String input = in.nextLine().replaceAll(regexpPattern,"");
            if (!input.isBlank()) {
                System.out.println("You entered " + input);
                break;
            } else {
                System.out.println("incorrect input");
            }
        }
    }
}