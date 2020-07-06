package com.ipidipi;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("-> run");
//        task_1();
//        task_2();
//        task_3();
//        task_4();
//        task_5();
//        task_6();
//        task_7();
//        task_8();
//        task_9();
        task_10();
    }

    public static void randomArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
    }

    public static void task_1() {
        System.out.println("-> task_1");
        int n = 100;
        double[] array = new double[n];
        randomArray(array);
        double max;
        double min;
        double avg = 0;
        min = max = array[0];

        for (double v : array) {
            if (max < v) {
                max = v;
            }
            if (min > v) {
                min = v;
            }
            avg += v / array.length;
        }
        System.out.println("max: = " + max);
        System.out.println("min: = " + min);
        System.out.println("avg: = " + avg);
    }

    public static void task_2() {
        System.out.println("-> task_2");
        int n = 100;
        double[] array = new double[n];
        randomArray(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] < array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void task_3() {
        System.out.println("-> task_3");
        boolean isPrime;
        for (int i = 2; i <= 10; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }

    public static int[] removeElement(int[] array, int val) {
        int offset = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                offset++;
            } else {
                array[i - offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length - offset);
    }

    public static void task_4() {
        System.out.println("-> task_4");
        int[] array = {0, 1, 2, 5, 2, 3, 0, 4, 2, 2, 7};
        int val = 2;
        System.out.println(Arrays.toString(removeElement(array, val)));

    }

    public static void task_5() {
        Vector[] vectors = Vector.generate(3);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].scalarProduct(vectors[1]));
        System.out.println(vectors[0].crossProduct(vectors[1]));
        System.out.println(vectors[0].cos(vectors[1]));
        System.out.println(vectors[0].add(vectors[1]));
        System.out.println(vectors[0].subtract(vectors[1]));
    }

    public static void task_6() {
        RandomForArray array = new RandomForArray(new int[]{1, 2, 3}, new int[]{5, 10, 15});
        for (int i = 0; i < 10; i++) {
            System.out.println(array.getRandom());
        }
    }

    public static void task_7() {
        MyList<String> list = new MyList<>();
        list.add("Hello");
        list.add("world");
        System.out.println(list.get(1));
    }

    public static void task_8() {
        double[] array = generateRandomArray(100000000);
        Arrays.sort(array);

        long time = System.currentTimeMillis(); // текущее время, unix-time
        System.out.println(bruteForce(array, 0.5));
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        System.out.println(binarySearchRecursively(array, 0.5));
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int bruteForce(double[] array, double key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public static int binarySearchRecursively(double[] sortedArray, double key) {
        return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
    }

    private static int binarySearchRecursively
            (double[] sortedArray, double key, int low, int high) {
        int middle = (low + high) / 2; // середина

        if (high < low) { // больше делить нечего
            return -1;
        }

        if (key == sortedArray[middle]) { // если нашёлся
            return middle;
        } else if (key < sortedArray[middle]) { // ищем в левой половине
            return binarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return binarySearchRecursively( // ищем в правой половине
                    sortedArray, key, middle + 1, high);
        }
    }

    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void task_9() {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            System.out.println(tree.add(i));
        }
        System.out.println(tree.containsNode(5));
    }
    public static void task_10() {
        Ball ball = new Ball(4.5);
        Cylinder cylyinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(3, 10);

        Box box = new Box(1000);

        System.out.println(box.add(ball)); // ok
        System.out.println(box.add(cylyinder)); // ok
        System.out.println(box.add(pyramid)); // failed
    }
}

