package com.example.demo.alg;

/**
 * @author chenlingl
 * @version 1.0
 * @description 优先队列
 * @date 7/1/2022 11:08 PM
 */
public class PriorityQueue {
    private int[] data;
    private int size;
    private int capacity;


    public PriorityQueue(int maxSize) {
        this.data = new int[maxSize];
        this.size = 0;
        this.capacity = maxSize;
    }

    public void add(int element) {
        //达到最大容量不允许再插入元素
        if (size == capacity) {
            System.out.println("堆已满");
            return;
        }
        //没达到则直接插入到数组中
        data[size++] = element;
        //将插入的元素做从下向上的转换
        shitUp(size - 1);
    }

    public void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 从下向上转换
     * @param index
     */
    public void shitUp(int index) {
        //索引大于0且如果当前索引的值大于父节点的值，则做交换
        while (index > 0 && data[index] > data[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int pollMax() {
        if (size == 0) {
            System.out.println("堆中没有元素");
            return -1;
        }
        int tmp = data[0];
        swap(0,size-1);
        data[size-1] = 0;
        size--;
        shitDown(0);
        return tmp;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }



    public void shitDown(int index) {
        while (leftChild(index) <= size) {
            int j = leftChild(index);
            //判断当前节点的左孩子是否小于右孩子，如果小于则右孩子更大，将更大的与当前索引的值做比较
            if (j + 1 < size && data[j] < data[j + 1]) {
                j = rightChild(index);
            }
            //如果当前索引的值大于等于最大的右孩子，则不做处理，否则交换值
            if (data[index] >= data[j]) {
                break;
            }
            swap(index,j);
            index = j;
        }
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(3);
        priorityQueue.add(2);
        for (int i = 0; i < priorityQueue.data.length; i++) {
            System.out.println("***" + priorityQueue.data[i]);
        }
        priorityQueue.pollMax();
        priorityQueue.pollMax();
        for (int i = 0; i < priorityQueue.data.length; i++) {
            System.out.println("===" + priorityQueue.data[i]);
        }

    }


}
