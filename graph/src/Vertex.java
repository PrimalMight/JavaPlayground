import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    private String data;
    private ArrayList<Edge> edges;
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    public Integer getDistance(Vertex endVertex) {
        for (Edge edge : this.edges) {
            if (edge.getEnd().equals(endVertex)) {
                return edge.getWeight();
            }
        }
        return null;
    }


    public void print(boolean showWeight) {
        String message = "";
        message += this.data + " --> ";
        HashMap<String, Integer> namesWeights = new HashMap<String, Integer>();
        for (Edge edge : this.edges) {
            namesWeights.put(edge.getEnd().getData(), edge.getWeight());
        }
        for(String key : namesWeights.keySet()){
            message += key + "(" + namesWeights.get(key) + ") ";
        }
        System.out.println(message);
    }
}
