import java.util.ArrayList;

public class graphList {
    private int countNodes;
    private int countEdges;
    private ArrayList<ArrayList<Edge>> adjList;

    public graphList(int countNodes) {
        this.countNodes = countNodes;
        adjList = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; ++i) {
            adjList.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int source, int sink, int weight) {
        if (source < 0 || source > this.countNodes - 1
                || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
            System.err.println("Invalid edge: " + source + sink + weight);
            return;
        }
        adjList.get(source).add(new Edge(source, sink, weight));
        this.countEdges++;
    }

    public void addEdgeUnoriented(int source, int sink, int weight) {
        addEdge(source, sink, weight);
        addEdge(sink, source, weight);
    }

    public int degree(int node){
        if(node<0 || node > this.countNodes-1){
          System.err.println("Invalid Node: " + node);
        }
        return this.adjList.get(node).size();
      }

    public int highestDegree(){
        int highest = 0;

        for(int i=0; i<this.adjList.size(); i++){
            int degree = this.degree(i);
            if(degree(i)>highest){
               highest=degree;
            }
        }
        return highest;
    }
    public int lowestDegree(){
        int lowest = this.countNodes;
    
        for(int i=1; i<this.adjList.size(); i++){
          int degree = this.degree(i);
          if(degree(i)<lowest){
            lowest=degree;
          }
        }
        return lowest;
    }

    
    






    public int getCountNodes() {
        return countNodes;
    }
    public void setCountNodes(int countNodes) {
        this.countNodes = countNodes;
    }
    public int getCountEdges() {
        return countEdges;
    }
    public void setCountEdges(int countEdges) {
        this.countEdges = countEdges;
    }
    public ArrayList<ArrayList<Edge>> getAdjList() {
        return adjList;
    }
    public void setAdjList(ArrayList<ArrayList<Edge>> adjList) {
        this.adjList = adjList;
    }

    public String toString(){
        String str = "";
        
        for(int i=0; i<this.adjList.size(); i++){
            str+= i + ": ";
            for(int j=0; j<this.adjList.get(i).size(); j++){
                str += this.adjList.get(i).get(j) + " ";
            }
            str += "\n";
        }
        return str;
    }





}


