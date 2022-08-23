class Main {
  
  public static void main(String[] args) {
    graph g1 = new graph(9);
    g1.addEdgeUnoriented(7, 5, 1);
    g1.addEdgeUnoriented(7, 1, 1);
    g1.addEdgeUnoriented(7, 2, 1);
    g1.addEdgeUnoriented(1, 0, 1);
    g1.addEdgeUnoriented(1, 4, 1);
    g1.addEdgeUnoriented(2, 3, 1);
    g1.addEdgeUnoriented(5, 6, 1);
    g1.addEdgeUnoriented(6, 8, 1);

    System.out.println(g1.busca_largura(7));
    System.out.println(g1.connected());




    // graph g1 = new graph(4);
    // g1.addEdge(0,1,1);
    // g1.addEdge(1,0,1);
    // g1.addEdge(0,3,1);
    // g1.addEdge(3,0,1);

    // System.out.println("#### G1 ###");
    // System.out.println(g1);
    // System.out.println("degree(0): " + g1.degree(0)); // 2
    // System.out.println("degree(1): " + g1.degree(1)); // 1
    // System.out.println("degree(2): " + g1.degree(2)); // 0
    // System.out.println("degree(3): " + g1.degree(3)); // 1
    // System.out.println("highestDegree: " + g1.highestDegree()); // 2
    // System.out.println("lowestDegree: " + g1.lowestDegree()); // 0
    // System.out.println("density: " + g1.density());
    // System.out.println(" .... G1 COMPLEMENT .... ");
    // System.out.println(g1.complement());

    // graph g2 = new graph(3);
    // g2.addEdge(0, 1, 1);
    // g2.addEdge(1, 0, 1);
    // System.out.println("#### G2 ###");
    // System.out.println(g2);
    // System.out.println("g2 is subGraph? " + g1.subGraph(g2)); // true
    // graph g3 = new graph(4);
    // g3.addEdge(1, 3, 1);
    // g3.addEdge(3, 1, 1);
    // System.out.println("g3 is subGraph? " + g1.subGraph(g3)); // false
  

  }
}