class Main {
  
  public static void main(String[] args) {
    graph g1 = new graph(4);
    g1.addEdge(0,1,1);
    g1.addEdge(1,0,1);
    g1.addEdge(0,3,1);
    g1.addEdge(3,0,1);

    System.out.println(g1.toString());
    System.out.println("---------------");
    System.out.println(g1.complement());
    //System.out.println("HIGHEST DEGREE: " + g1.highestDegree());
    //System.out.println("LOWEST DEGREE: " + g1.lowestDegree());

  }




  
}