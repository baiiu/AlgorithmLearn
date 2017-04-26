package com.baiiu.DAG;

/**
 * author: baiiu
 * date: on 17/4/26 15:14
 * description:
 */
public class ZZTest {

    public static void main(String[] args) {

        Graph graph = new Graph();

        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex five = new Vertex("5");
        Vertex seven = new Vertex("7");
        Vertex eight = new Vertex("8");
        Vertex nine = new Vertex("9");
        Vertex ten = new Vertex("10");
        Vertex eleven = new Vertex("11");

        // 添加结点
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(five);
        graph.addNode(seven);
        graph.addNode(eight);
        graph.addNode(nine);
        graph.addNode(ten);
        graph.addNode(eleven);

        // 添加边
        graph.addEdge(three, eight);
        graph.addEdge(three, ten);
        graph.addEdge(five, eleven);
        graph.addEdge(seven, eleven);
        graph.addEdge(seven, eight);
        graph.addEdge(eight, nine);
        graph.addEdge(eleven, two);
        graph.addEdge(eleven, nine);
        graph.addEdge(eleven, ten);

        //graph.addEdge(two, five);//添加一个环


        /*
        including:
            5, 7, 3, 11, 8, 2, 9, 10 (visual left-to-right, top-to-bottom)
            3, 5, 7, 8, 11, 2, 9, 10 (smallest-numbered available vertex first)
            5, 7, 3, 8, 11, 10, 9, 2 (fewest edges first)
            7, 5, 11, 3, 10, 8, 9, 2 (largest-numbered available vertex first)
            5, 7, 11, 2, 3, 8, 9, 10 (attempting top-to-bottom, left-to-right)
            3, 7, 8, 5, 11, 10, 2, 9 (arbitrary)
         */

        System.out.println(new KahnTopologicalSort(graph).kahnSort());
        System.out.println(new DFSTopologicalSort(graph).DFSSort());

    }

}
