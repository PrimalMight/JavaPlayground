public class Path {
    private Integer distance;
    private Graph graph;
    private Vertex startVertex;

    public Path(Graph graph, String startVertex) {
        this.distance = 0;
        this.graph = graph;
        this.startVertex = graph.getVertexByValue(startVertex);

    }

    public Integer getDistance() {
        return this.distance;
    }

    public void addVertex(String key){
        Vertex nextHopVertex = this.graph.getVertexByValue(key);
        Integer nextHopDistance = this.startVertex.getDistance(nextHopVertex);
        distance += nextHopDistance;
        this.startVertex = nextHopVertex;
        
    }

   
}
