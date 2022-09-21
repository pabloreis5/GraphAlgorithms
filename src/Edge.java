public class Edge {
    private int source, sink, weight; //origem, destino, peso

    public Edge(int source, int sink, int weight) {
        this.source = source;
        this.sink = sink;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getSink() {
        return sink;
    }

    public void setSink(int sink) {
        this.sink = sink;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + source + "," + sink + "," + weight + ")";
    }

    

    
}




