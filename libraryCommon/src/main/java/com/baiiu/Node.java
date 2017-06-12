package com.baiiu;

/**
 * author: baiiu
 * date: on 17/5/26 13:08
 * description: 链表
 */
public class Node {
    public String data;
    public Node next;
    public int numberData;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public Node(int numberData) {
        this.numberData = numberData;
    }

    @Override
    public String toString() {
        return "[" + data + ", " + numberData + "]";
    }
}
