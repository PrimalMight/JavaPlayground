public class App {
    public static void main(String[] args) throws Exception {
        Graph myGraph = new Graph(true, false);
        Vertex vert1 = myGraph.addVertex("1");
        Vertex vert2 = myGraph.addVertex("2");
        Vertex vert3 = myGraph.addVertex("3");
        Vertex vert4 = myGraph.addVertex("4");
        Vertex vert5 = myGraph.addVertex("5");
        Vertex vert6 = myGraph.addVertex("6");
        Vertex vert7 = myGraph.addVertex("7");
        Vertex vert8 = myGraph.addVertex("8");

        myGraph.addEdge(vert1, vert2, 4);
        myGraph.addEdge(vert2, vert3, 24);
        myGraph.addEdge(vert3, vert4, 9);
        myGraph.addEdge(vert3, vert6, 23);
        myGraph.addEdge(vert3, vert5, 18);
        myGraph.addEdge(vert4, vert5, 11);
        myGraph.addEdge(vert4, vert8, 7);
        myGraph.addEdge(vert5, vert6, 5);
        myGraph.addEdge(vert5, vert7, 10);
        myGraph.addEdge(vert5, vert8, 14);
        myGraph.addEdge(vert6, vert1, 6);
        myGraph.addEdge(vert6, vert7, 8);
        myGraph.addEdge(vert7, vert1, 16);
        myGraph.addEdge(vert7, vert8, 21);
        
        myGraph.print();
    }
}
