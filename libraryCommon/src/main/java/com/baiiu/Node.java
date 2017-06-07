package com.baiiu;

/**
 * author: baiiu
 * date: on 17/5/26 13:08
 * description: 链表
 */
public class Node {
    public String data;
    public Node next;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
