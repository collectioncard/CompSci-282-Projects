/**
 * This project is a bit rushed due to finals n stuff coming up. The code is not nearly as good as my usual projects,
 *  but it seems to work just fine.
 *
 * 2020 Thomas Wessel
 */

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A'); //index 0
        graph.addVertex('B'); //index 1
        graph.addVertex('C'); //index 2
        graph.addVertex('D'); //index 3
        graph.addVertex('E'); //index 4

        graph.addEdge(0, 1); //link A and B
        graph.addEdge(1, 2); //link B and C
        graph.addEdge(0, 3); //link A and D
        graph.addEdge(3, 4); //link D and E
        graph.addEdge(0, 2); //link A and C

        graph.printUnvisited();
        graph.printConnections();

    }
}
