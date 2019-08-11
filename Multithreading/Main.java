package Multithreading;

/**
 * lesson 5, level 2
 * @author Yarolav Maluy
 * @version data 11.08.19
 */
//1. Необходимо написать два метода, которые делают следующее:
//1) Создают одномерный длинный массив;
//2) Заполняют этот массив единицами;
//3) Засекают время выполнения: long a = System.currentTimeMillis();
//4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//5) Проверяется время окончания метода System.currentTimeMillis();
//6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//
//Отличие первого метода от второго:
//Первый просто бежит по массиву и вычисляет значения.
//Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
public class Main {
    static final int size = 1000000;
    static final int h = size/2;
  public static void main(String[] args) {
   float[] arr = new float[size];

   oneTread(arr);
   twoTread(arr);
  }

    static float[] changeArr(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    static float[] changeOn1(float[] arr) {
      for (int i = 0; i < arr.length ; i++) {
        arr[i]++;
    }
      return arr;
    }

  static void oneTread(float arr[]) {
     changeOn1(arr);
      long a = System.currentTimeMillis();
      changeArr(arr);
      System.out.println("Тест 1: " + (System.currentTimeMillis() - a));
  }

  static void twoTread(float arr[]) {
      changeOn1(arr);
      long a = System.currentTimeMillis();
      float[] arr1 = new float[h];
      float[] arr2 = new float[h];
      System.arraycopy(arr, 0, arr1, 0, h);
      System.arraycopy(arr, h, arr2, 0, h);

      new Thread() {
          public void run() {
              float[] oneArr = changeArr(arr1);
              System.arraycopy(arr1, 0, arr1, 0, oneArr.length);
          }
      }.start();

      new Thread() {
          public void run() {
              float[] twoArr = changeArr(arr2);
              System.arraycopy(twoArr, 0, arr2, 0, twoArr.length);
          }
      }.start();

      System.arraycopy(arr1, 0, arr, 0, h);
      System.arraycopy(arr2, 0, arr, h, h);
      System.out.println("Тест 2: " + (System.currentTimeMillis() - a));
  }
}
