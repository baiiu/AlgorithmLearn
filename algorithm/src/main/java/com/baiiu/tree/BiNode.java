package com.baiiu.tree;

/**
 * author: baiiu
 * date: on 17/5/19 14:57
 * description:
 */
public class BiNode {

    public String data;
    public BiNode lChild;
    public BiNode rChild;

    public BiNode() {
    }

    public BiNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
