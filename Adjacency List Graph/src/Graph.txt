/**
 * This class creates a graph using the linked list class located in the linkedList package
 */

public class Graph {

    //for simplicity, this graph will use an array to hold the adjacency list (the book says this is ok, so it should be good)
    int MAX_SIZE = 20;
    int numberOFVertices = 0;
    LinkedList[] adjList = new LinkedList[MAX_SIZE];

    public void addVertex(char label){
        adjList[numberOFVertices] = new LinkedList(new Vertex(label));
        numberOFVertices++;
    }

    public void addEdge(int firstIndex, int secondIndex){
        adjList[firstIndex].insert(adjList[secondIndex].getVertexAtIndex(0));
    }

    //what we will do here is loop through everything and only print out vertices that do not have the
    // 'haveVisited' boolean set to true. After we print, we change it to true.
    public void printUnvisited(){
        System.out.println("Vertices in the graph:");
        for(int i = 0; i < numberOFVertices; i++){

            boolean isVisited = false;
            while(!isVisited){
                Vertex test = adjList[i].getUnvisited();
                if(test == null){
                    isVisited = true;
                }else{
                    System.out.println("Vertex: " + test.getLabel());
                }
            }
        }
    }

    public void printConnections(){
        for(int i = 0; i < numberOFVertices; i++){
            System.out.print("\nVertex '" + adjList[i].getVertexAtIndex(0).getLabel() + "' is connected to vertices: ");
            for(int j = 1; j < adjList[i].getSize(); j++){
                System.out.print(adjList[i].getVertexAtIndex(j).getLabel() + " ");
            }
        }
    }
    
}
