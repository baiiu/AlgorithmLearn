package com.baiiu.DAG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * auther: baiiu
 * time: 17/4/26 26 22:04
 * description: DFS,Depth-first search
 */
@SuppressWarnings("unused")
class DFSTopologicalSort {
    /*

        L ← Empty list that will contain the sorted nodes
        while there are unmarked nodes do
            select an unmarked node n
            visit(n)

        function visit(node n)
            if n has a temporary mark then stop (not a DAG)
            if n is not marked (i.e. has not been visited yet) then
                mark n temporarily
                for each node m with an edge from n to m do
                    visit(m)
                mark n permanently
                unmark n temporarily
                add n to head of L

     */
    private Graph mGraph;
    private List<Vertex> mSortResult;
    private Set<Vertex> mSortTmpMarked;

    DFSTopologicalSort(Graph graph) {
        this.mGraph = graph;
        mSortResult = new ArrayList<>();
        mSortTmpMarked = new HashSet<>();
    }

    List<Vertex> DFSSort() {
        mSortResult.clear();
        mSortTmpMarked.clear();

        for (Vertex vertex : mGraph.getNodes()) {
            dfs(vertex, mSortResult, mSortTmpMarked);
        }

        //Collections.reverse(mSortResult);
        return mSortResult;
    }

    private void dfs(Vertex node, List<Vertex> result, Set<Vertex> tmpMarked) {
        if (result.contains(node)) {
            return;
        }

        if (tmpMarked.contains(node)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }

        tmpMarked.add(node);

        List<Vertex> outgoingNodes = mGraph.getOutgoingNodes(node);
        if (outgoingNodes != null) {
            for (Vertex outgoingNode : outgoingNodes) {
                dfs(outgoingNode, result, tmpMarked);
            }
        }

        tmpMarked.remove(node);
        result.add(node);
    }

}
