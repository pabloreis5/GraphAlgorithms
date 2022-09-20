import java.io.IOException;

class Main {
  
  public static void main(String[] args) throws IOException{
    graph g1 = new graph("src/graph1.txt");
    g1.floyd_warshall();
    
    

  }
}