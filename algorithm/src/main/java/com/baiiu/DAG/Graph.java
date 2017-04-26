package com.baiiu.DAG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * author: baiiu
 * date: on 17/4/26 11:52
 * description: 有向无环图
 * 图的邻接表表示法
 */
@SuppressWarnings("unused")
class Graph {

    // 图的表示：Map的key即所有顶点，value即与所关联的顶点
    private Map<Vertex, List<Vertex>> mGraph = new HashMap<>();


    // 添加一个节点
    void addNode(Vertex vertex) {
        if (mGraph.containsKey(vertex)) {
            return;
        }

        mGraph.put(vertex, null);
    }


    //添加一个有向边, node --> edge
    void addEdge(Vertex node, Vertex edge) {
        if (!mGraph.containsKey(node)) {
            //不包含该节点肯定不行
            return;
        }

        if (!mGraph.containsKey(edge)) {
            // 该图中都没有该节点，如何连边？先去添加node
            return;
        }


        List<Vertex> edges = mGraph.get(node);

        if (edges == null) {
            edges = new ArrayList<>();
            mGraph.put(node, edges);
        }

        edges.add(edge);
    }

    /**
     * 顶点个数
     */
    int nodesCount() {
        return mGraph.size();
    }

    /**
     * 获取节点的入度
     */
    int getIncomingEdges(Vertex node) {
        //获取所有其他节点指向它的个数
        Collection<List<Vertex>> values = mGraph.values();

        int incomingEdges = 0;

        for (List<Vertex> value : values) {
            if (value == null) continue;

            if (value.contains(node)) {
                ++incomingEdges;
            }
        }

        return incomingEdges;
    }

    List<Vertex> getIncomingNodes(Vertex node) {
        Collection<List<Vertex>> values = mGraph.values();

        List<Vertex> list = new ArrayList<>();

        for (List<Vertex> value : values) {
            if (value == null) continue;

            if (value.contains(node)) {
                list.add(node);
            }
        }

        return list;
    }


    /**
     * 获取节点的出度
     */
    int getOutgoingEdges(Vertex node) {
        if (!mGraph.containsKey(node)) {
            return 0;
        }

        return mGraph.get(node).size();
    }

    List<Vertex> getOutgoingNodes(Vertex node) {
        if (!mGraph.containsKey(node)) {
            return null;
        }

        return mGraph.get(node);
    }


    Set<Vertex> getNodes() {
        return mGraph.keySet();
    }

}

