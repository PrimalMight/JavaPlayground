import java.util.HashMap;

public class Graph {
  //private ArrayList<Vertex> vertices;
  private HashMap<String, Vertex> vertices;
  private boolean isWeighted;
  private boolean isDirected;

  public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
    this.vertices = new HashMap<String, Vertex>();
    this.isWeighted = inputIsWeighted;
    this.isDirected = inputIsDirected;
  }

  public Vertex addVertex(String data) {
    Vertex newVertex = new Vertex(data);
    //this.vertices.add(newVertex);
    this.vertices.put(data, newVertex);
    return newVertex;
  }

  public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
    if (!this.isWeighted) {
      weight = null;
    }
    vertex1.addEdge(vertex2, weight);
    if (!this.isDirected) {
      vertex2.addEdge(vertex1, weight);
    }
  }

  public void removeEdge(Vertex vertex1, Vertex vertex2) {
    vertex1.removeEdge(vertex2);

    if (!this.isDirected) {
      vertex2.removeEdge(vertex1);
    }
  }

  public void removeVertex(String key) {
    this.vertices.remove(key);
  }

  public HashMap<String, Vertex> getVertices() {
    return this.vertices;
  }

  public boolean isWeighted() {
    return this.isWeighted;
  }

  public boolean isDirected() {
    return this.isDirected;
  }

  public Vertex getVertexByValue(String value) {
    if(this.vertices.containsKey(value)) {
      return this.vertices.get(value);
    }
    return null;
  }

  public Integer getDistanceBetweenVertices(String v1, String v2){
    Vertex vertex1 = this.vertices.get(v1);
    Vertex vertex2 = this.vertices.get(v2);
    if(vertex1 == null || vertex2 == null){
      return null;
    }
    return vertex1.getDistance(vertex2);
  
  }

  public void print() {
    for(String key: this.vertices.keySet()) {
      vertices.get(key).print(isWeighted);
    }
  }


	
}