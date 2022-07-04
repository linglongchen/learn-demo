package com.example.demo.alg;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 7/3/2022 9:42 PM
 */
public class MaxHeap {
    private ArrayList<Integer> data;
    private int curSize;
    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
        this.curSize = 0;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    /**
     * 返回索引的父节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index-1)/2;
    }

    /**
     * 返回当前节点的左子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 +1;
    }

    /**
     * 返回当前节点的右子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void swap(int i,int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j,tmp);
    }

    public void add(Integer element) {
        data.add(element);
        shipUp(data.size()-1);
    }
    public void shipUp(int index) {
        while (index > 0 && data.get(parent(index)) < data.get(index)) {
            swap(index,parent(index));
            index = parent(index);
        }
    }

    public int findMax() {
        if (data.size() == 0) {
            System.out.println("堆为空");
        }
        return data.get(0);
    }

    public int delElement() {
        int max = findMax();
        swap(0,data.size()-1);
        data.remove(data.size()-1);
        shitDown(0);
        return max;
    }

    public void shitDown(int index) {
        while (leftChild(index) < data.size()) {
            int j = leftChild(index);
            if (j + 1 < data.size() && data.get(j) < data.get(j+1)) {
                j = rightChild(index);
            }
            if (data.get(index) >= data.get(j)) {
                break;
            }
            swap(index,j);
            index = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(7);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(9);
        for (int i = 0; i < maxHeap.data.size(); i++) {
            System.out.println(maxHeap.data.get(i));
        }
        maxHeap.delElement();
        for (int i = 0; i < maxHeap.data.size(); i++) {
            System.out.println("========"+maxHeap.data.get(i));
        }
    }
}
