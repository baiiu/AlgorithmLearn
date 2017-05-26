package com.example;

/**
 * author: baiiu
 * date: on 17/5/26 13:08
 * description: 链表
 */
class Node {
    String data;
    Node next;

    Node() {
    }

    Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
