package ru.otus.java.basic.homeworks.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ArrayUtilTest {

    @Test
    void takeArrayAfterWithMultipleOne() {
        int[] input = {2, 3, 1, 4, 5, 1, 8, 9};
        int[] output = ArrayUtil.takeArrayAfterOne(input);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(output.length, 2);
        Assertions.assertArrayEquals(output, new int[]{8, 9});
    }

    @Test
    void takeArrayAfterWithSingleOne() {
        int[] input = new int[]{5, 6, 1, 4, 3, 2};
        int[] output = ArrayUtil.takeArrayAfterOne(input);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(output.length, 3);
        Assertions.assertArrayEquals(output, new int[]{4, 3, 2});
    }

    @Test
    void takeArrayAfterWithoutOne() {
        int[] input = new int[]{4, 3, 2};
        Assertions.assertThrows(RuntimeException.class, () -> ArrayUtil.takeArrayAfterOne(input), "отсутсвует 1 в входном массиве");
    }

    @Test
    void checkArrayOnOneAndTwo() {
        Assertions.assertAll(
                () -> {
                    int[] arr = new int[]{1, 2, 1, 2};
                    Assertions.assertTrue(ArrayUtil.checkArrayOnOneAndTwo(arr));
                },
                () -> {
                    int[] arr = new int[]{1, 2};
                    Assertions.assertTrue(ArrayUtil.checkArrayOnOneAndTwo(arr));
                },
                () -> {
                    int[] arr = new int[]{1, 3};
                    Assertions.assertFalse(ArrayUtil.checkArrayOnOneAndTwo(arr));
                },
                () -> {
                    int[] arr = new int[]{2, 3};
                    Assertions.assertFalse(ArrayUtil.checkArrayOnOneAndTwo(arr));
                },
                () -> {
                    int[] arr = new int[]{1, 2, 3};
                    Assertions.assertFalse(ArrayUtil.checkArrayOnOneAndTwo(arr));
                }
        );
    }
}