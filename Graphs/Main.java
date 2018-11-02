class Main{
    public static void main(String[] args) {
        // Graph graph = new Graph(8);
        // graph.addEdge(0, 1);;
        // graph.addEdge(0, 4);
        // graph.addEdge(1, 2);
        // graph.addEdge(1, 3);
        // graph.addEdge(1, 4);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 4);

        // //cycle introduction
        // //graph.addEdge(3, 1);

        // graph.addEdge(5, 6);
        // graph.addEdge(6, 7);

        //graph.print();
        //graph.BFS(0);

        //graph.DFS(0);

        //graph.disconnectedDFS();

        //graph.topologicalSort();

        //System.out.println(graph.isCyclic());

        //graph.topologicalSortKahns();


        Graph graph = new Graph(6);
    graph.addEdge(5, 2);
    graph.addEdge(5, 0);
    graph.addEdge(4, 0);
    graph.addEdge(4, 1);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);

        graph.allTopologicalSorts();
    }
}