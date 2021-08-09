package Homework2;

import java.util.Arrays;

public class Homework2 {

        public static void main (String[] args) {
            //     smenaChisel();
            //    massiv2();
            //    massiv3();
            //     diagonal();
            //    minmax();
            //    checkBalance();
                sdvig();
        }

        public static void smenaChisel (){
            // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
            int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
            System.out.println("Изначальный массив " + Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0){ //меняем 0 на 1
                    arr[i] =1;
                } else if (arr[i] == 1) { //меняем 1 на 0
                    if (arr[i] == 1){
                        arr[i] =0;
                    }
                }
            }
            System.out.println("Изменённый массив  " + Arrays.toString(arr));
        }

        public static void massiv2(){
            // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
            int [] arr = new int[8];
            int y = 0;
            for (int i = 0; i < arr.length; i++) {
                arr [i] = arr[i] + y; //увеличиваем последующие значения массива на 3
                y = y + 3;
            }
            System.out.println("Массив " + Arrays.toString(arr));
        }

        public static void massiv3() {
            // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
            int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            System.out.println("Исходный массив " + Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++){
                if (arr[i] < 6){            //  значения массива меньше 6 увеличиваем на 2
                    arr[i] = arr[i] * 2;
                }
            }
            System.out.println("Полученный массив " + Arrays.toString(arr));
        }

        public static void diagonal(){
            //Создать квадратный двумерный целочисленный массив (количество строк и столбцов
            //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
            int[][] arr = new int [6][6];
            int m = arr.length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < m; j++){
                    if (i == j || j == m - 1 - i) { //заполняем диагонали массива[][] единицами
                        arr[i][j] = 1;
                    } else arr[i][j] = 0;
                    System.out.print(arr[i][j] + " "); //заполняем i строку данными
                }
                System.out.println();
            }
        }

        public static void minmax(){
// ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
            int[] arr = {5,7,3,-67,9,2,1,9,356};
            int min = arr[0], max = arr[0], i = 0; //обнуляем значения переменных
            for (i = 0; i < arr.length; i++){
                if (arr[i] < min){  // поиск минимального значение
                    min = arr[i];
                } else if (arr[i] > max) {  // поиск максимального значения
                    max = arr[i];
                }
            }
            System.out.println("min = " + min + ". max = " + max);
        }

        public static void checkBalance(){
//** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
            int [] arr = {2, 2, 2, 1, 2, 2,10,1};
            int sum = 0, i = 0, suml = 0,sumr = 0, k = 0;
            for (i = 0; i < arr.length; i++){
                sum = sum + arr[i]; // поиск суммы всего массива
            }
            System.out.println("Количество элементов массива = " + arr.length + " . Сумма элементов = " + sum);
            if (sum % 2 == 0) {
                int half = sum / 2;
                for (i=0; suml < half;i++){ //поиск суммы слева
                    suml = arr[i] + suml;
                    k = i; // на каком эл-те остановились
                }
                for (i = k + 1; i < arr.length; i++){ // поиск суммы справа, (k+1) - т.к. продолжаем со следующего эл-та массива
                    sumr = arr[i] + sumr;
                }
            } else System.out.println("Сумма не делится без остатка");
            if (suml == sumr) {
                System.out.println("Сумма первых " + (k+1) + " элементов массива = " + suml);
                System.out.println("Сумма остальных " + (arr.length - (k+1)) + " элементов массива = " + sumr);
            } else System.out.println("false");

        }


        public static void sdvig(){
            //**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
            // или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы
            // смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
            // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5,
            //6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
            int[] arr = {5,3,9,2,7};
            System.out.println("Данный массив " + Arrays.toString(arr));
            int n = -3, a = 0;     // n - это сдвиг, a - временная переменная для эл-та массива
            int l = arr.length -1; //номер последнего эл-та
            if (n > 0){
                System.out.println("Сдвигаем вправо");
                for (int i=0; i < n; i++){
                    a = arr[l]; // запоминаю последний элемент массива
                    for (int j = l; j >= 1; j-- ){ // передвигаю элементы
                        arr[j] = arr[j-1];
                    }
                    arr[0] = a;
                }
            } else if (n < 0){
                System.out.println("Сдвигаем влево");
                for (int i=0; i < Math.abs(n); i++){
                    a = arr[0]; // запоминаю последний элемент массива
                    for (int j = 0; j < l; j++ ){ // передвигаю элементы
                        arr[j] = arr[j+1];
                    }
                    arr[l] = a;
                }    }

            System.out.println("Массив со сдвигом " + n + Arrays.toString(arr));
        }
}