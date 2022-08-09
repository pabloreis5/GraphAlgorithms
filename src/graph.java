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