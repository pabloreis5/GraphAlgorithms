class graph{
  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;

  public graph(int countNodes){
    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes]; 
  }

  public void addEdge(int source, int sink, int weight){
    if (source < 0|| source > this.countNodes -1 || sink < 0 || sink > this.countNodes -1 || weight <= 0){
      System.err.println("Invalid edge: " + source + sink + weight);
      return;
    }
    
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
    
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