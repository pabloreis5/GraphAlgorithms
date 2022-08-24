import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class graph{
  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;

  public graph(int countNodes){
    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes]; 
  }
  
  public graph(String fileName) throws IOException {
    File file = new File(fileName);
    FileReader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);

    // Read header
    String[] line = bufferedReader.readLine().split(" ");
    this.countNodes = (Integer.parseInt(line[0]));
    int fileLines = (Integer.parseInt(line[1]));

    // Create and fill adjMatrix with read edges
    this.adjMatrix = new int[this.countNodes][this.countNodes];
    for (int i = 0; i < fileLines; ++i) {
        String[] edgeInfo = bufferedReader.readLine().split(" ");
        int source = Integer.parseInt(edgeInfo[0]);
        int sink = Integer.parseInt(edgeInfo[1]);
        int weight = Integer.parseInt(edgeInfo[2]);
        addEdge(source, sink, weight);
    }
    bufferedReader.close();
    reader.close();
}

  public void addEdge(int source, int sink, int weight){
    if (source < 0|| source > this.countNodes -1 || sink < 0 || sink > this.countNodes -1 || weight <= 0){
      System.err.println("Invalid edge: " + source + sink + weight);
      return;
    }
    
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
  }

  public void addEdgeUnoriented(int u, int v, int w) {
    if (u < 0 || u > this.countNodes - 1
        || v < 0 || v > this.countNodes - 1 || w <= 0) {
      System.err.println("Invalid edge: " + u + v + w);
      return;
    }
    this.adjMatrix[u][v] = w;
    this.adjMatrix[v][u] = w;
    this.countEdges += 2;
  }

  
  public int degree(int node){
    int count = 0;
    if(node<0 || node > this.countNodes-1){
      System.err.println("Invalid Node: " + node);
    }

    for(int i=0; i < adjMatrix[node].length; i++){
      if(this.adjMatrix[node][i] != 0){
        count++;
      }
    }
    return count;
  }

  public int highestDegree(){
    int highest = 0;

    for(int i=0; i<this.adjMatrix.length; i++){
      int degree = this.degree(i);
      if(degree(i)>highest){
        highest=degree;
      }
    }
    return highest;
  }

  public int lowestDegree(){
    int lowest = this.adjMatrix.length;

    for(int i=1; i<this.adjMatrix.length; i++){
      int degree = this.degree(i);
      if(degree(i)<lowest){
        lowest=degree;
      }
    }
    return lowest;
  }

  public graph complement(){
    graph g2 = new graph(this.countNodes);

    for(int i=0; i<this.adjMatrix.length; i++){
      for(int j=0; j<this.adjMatrix.length; j++){
        if(this.adjMatrix[i][j] == 0 && i!=j){
          g2.addEdge(i, j, 1);
        }
      }
    }
    return g2;
  }
  public float density() {
    return (float) this.countEdges / (this.countNodes * (this.countNodes - 1));
  }

  public boolean subGraph(graph g2) {
    if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
      return false;
    for(int i = 0; i < g2.adjMatrix.length; ++i) {
      for(int j = 0; j < g2.adjMatrix[i].length; ++j) {
        if(g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  public ArrayList<Integer> busca_largura(int s){

    int[] desc = new int[this.countNodes];
    
    ArrayList<Integer> q = new ArrayList<>();
    ArrayList<Integer> r = new ArrayList<>();
    q.add(s);
    r.add(s);
    desc[s] = 1;

    while(q.size() > 0){
      int u = q.remove(0);
      for (int v=0; v<this.adjMatrix[u].length; v++ ) {
        if(this.adjMatrix[u][v] != 0){
          if(desc[v] == 0){
            q.add(v);
            r.add(v);
            desc[v]=1;
          }
          
        }
      }
    }
    return r;
  }

  public ArrayList<Integer> busca_prof(int s){
    int[] desc = new int[this.countNodes];
    
    ArrayList<Integer> S = new ArrayList<>();
    ArrayList<Integer> r = new ArrayList<>();
    S.add(s);
    r.add(s);
    desc[s] = 1;

    while(S.size() != 0){
      int u = S.get(S.size()-1);
      Boolean unstack = true;

      
      for(int v=0; v<this.adjMatrix[u].length; v++){
        if(this.adjMatrix[u][v] != 0 && desc[v] == 0){
          S.add(v);
          r.add(v);
          desc[v] = 1;
          unstack = false;
          break;
        }   
      }
      if(unstack){
        S.remove(S.size() - 1);
      }
    }
    return r;
  }


  public boolean connected(){
    return this.busca_largura(0).size() == this.countNodes;
  }


  public int getcountNodes(){
    return this.countNodes;
  }
  public int getcountEdges(){
    return this.countEdges;
  }
  public int[][] getcountMatrix(){
    return this.adjMatrix;
  }
  public String toString(){
    String str = "";
    
    for(int i=0; i<this.adjMatrix.length; i++){
      for(int j=0; j<this.adjMatrix[i].length; j++){
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }
  
}

/*
Grafo de estados (velha, xadrez)
Nó = Estado

*/