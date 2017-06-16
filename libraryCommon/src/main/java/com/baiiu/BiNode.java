package com.baiiu;

/**
 * auther: baiiu
 * time: 17/5/29 29 23:09
 * description:
 */
public class BiNode {
    public String data;
    public int numberData;
    public BiNode lChild;
    public BiNode rChild;

    public BiNode() {
    }

    public BiNode(String data) {
        this.data = data;
    }

    public BiNode(int numberData) {
        this.numberData = numberData;
    }

    @Override
    public String toString() {
        return data;
    }


}
