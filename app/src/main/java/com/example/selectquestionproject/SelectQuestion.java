package com.example.selectquestionproject;

import android.view.MotionEvent;
import android.view.View;

import com.example.selectquestionproject.zhujie.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 选择问题，确定N个数中第K个最大值
 * 方法一：冒泡排序（递减）后，K位置元素
 * 方法二：取前K个元素递减排序放到数组中，剩余元素与最后一个元素对比，若小于则忽略，大于则放到数组相应位置并移除最后一个元素
 */
@User(user = "father", id = 2)
public class SelectQuestion {

    private static List<Integer> lists = new ArrayList<>();
    private static int[] datas = new int[]{2, 8, 11, 16, 1, 10, 21, 7, 9};

    List<String>[] a = new ArrayList[10];

    public static void main(String[] args) {
        printK();
    }

    public static void printK() {
        System.out.println("请输入K：");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if (k > datas.length) {
            System.out.println("K范围超出，请重新输入");
            printK();
        } else {
            maoPaoSort(k, datas);
        }
    }

    /**
     * 冒泡排序
     * @param ints
     */
    public static void maoPaoSort(int k, int... ints) {
        if (ints == null||ints.length == 0) {
            return;
        }
        int flag;
        for (int i = 0;i < ints.length - 1;i ++) {
            for (int j = 0;j < ints.length - 1 - i;j++) {
                if (ints[j] < ints[j+1]) {
                    flag = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = flag;
                }
            }
        }

        System.out.println("排序后的结果是：");
        for (int a : ints) {
            System.out.println(a);
        }

        System.out.println("K大的数为:" + ints[k - 1]);
    }

    private void setViewAnimation(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

}
