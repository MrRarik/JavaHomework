/**
 * level 2, lesson 2
 * @author Maluy Yaroslav
 * @version data 30.07.19
 */

package exception;

public class Main {
    //3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
// и вывести результат расчета.
    public static void main(String[] args) {
        String[][] arr = {{"1","1","1","1"},
                          {"1","1","1","1"},
                          {"1","1","1","1"},
                          {"1","1","1","1"}};
        try {
            System.out.println("Сумма: " + checkArray(arr));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка!");
            e.printStackTrace();
            System.out.println("Размер масива должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка");
            e.printStackTrace();
            System.out.println("Исправте символ " + arr[e.i][e.j] + " на цифру");
            System.out.println("Ячейка ошибки: " + "[" + e.i + "]" + "[" + e.j + "]");
        }
    }
    //1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    // при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    //2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
    // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    // должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

    public static int checkArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int a = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr.length; j++) {
                try {
                    a += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return a;
    }
}
