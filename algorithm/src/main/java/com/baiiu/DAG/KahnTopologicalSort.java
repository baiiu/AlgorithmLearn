package com.baiiu.DAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/4/26 15:41
 * description: Kahn's algorithm
 */
class KahnTopologicalSort {

    /*
        L ← Empty list that will contain the sorted elements
        S ← Set of all nodes with no incoming edges

        while S is non-empty do
            remove a node n from S
            add n to tail of L
            for each node m with an edge e from n to m do
                remove edge e from the graph
                if m has no other incoming edges then
                    insert m into S
        if graph has edges then
            return error (graph has at least one cycle)
        else
            return L (a topologically sorted order)
     */

    private Graph mGraph;
    private List<Vertex> mSortResult;// 拓扑排序后结果，即 L
    private Stack<Vertex> mSetOfZeroIndegree; // 入度为0的顶点队列,即 S

    private Map<Vertex, Integer> mIndegrees; //记录每个顶点当前的入度

    KahnTopologicalSort(Graph graph) {
        this.mGraph = graph;
        mSortResult = new ArrayList<>();
        mSetOfZeroIndegree = new Stack<>();
        mIndegrees = new HashMap<>();

        //初始化节点入读
        for (Vertex vertex : graph.getNodes()) {
            int incomingEdges = graph.getIncomingEdges(vertex);

            mIndegrees.put(vertex, incomingEdges);

            if (incomingEdges == 0) {
                mSetOfZeroIndegree.push(vertex);
            }
        }

        System.out.println(mIndegrees);
        System.out.println(mSetOfZeroIndegree);
    }

    List<Vertex> kahnSort() {

        while (!mSetOfZeroIndegree.isEmpty()) {
            System.out.println(mIndegrees);

            Vertex poll = mSetOfZeroIndegree.pop();
            mSortResult.add(poll);

            List<Vertex> outgoingNodes = mGraph.getOutgoingNodes(poll);
            if (outgoingNodes == null) {
                continue;
            }

            for (Vertex vertex : outgoingNodes) {
                int degree = mIndegrees.get(vertex);
                --degree;
                if (0 == degree) {
                    mSetOfZeroIndegree.push(vertex);
                }
                mIndegrees.put(vertex, degree);
            }

        }


        return mSortResult;
    }

}
