import java.io.IOException;

class Main {
  
  public static void main(String[] args) throws IOException{
    graphList g1 = new graphList(3);
    g1.addEdge(0, 1, 10);
    g1.addEdge(0, 2, 20);
    g1.addEdge(2, 0, 15);
    
    System.out.println(g1);
  
  }
}