import java.util.LinkedList;

public class Node{
    private String data;
    private LinkedList<Edge> edges;

    public Node(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addEdge(Node endNode, Integer weight){
        edges.add(new Edge(this, endNode, weight));
    }

    public void removeEdge(Node toRemove){
        edges.removeIf(edge -> edge)
    }






}