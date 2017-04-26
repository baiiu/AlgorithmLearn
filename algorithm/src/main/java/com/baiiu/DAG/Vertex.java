package com.baiiu.DAG;

/**
 * author: baiiu
 * date: on 17/4/26 14:39
 * description: 顶点
 */
class Vertex {

    String name;


    Vertex(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return name != null ? name.equals(vertex.name) : vertex.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    @Override
    public String toString() {
        return name + " ";
    }
}
