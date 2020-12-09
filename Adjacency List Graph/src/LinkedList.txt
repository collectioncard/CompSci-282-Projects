class Node{
    private Vertex vertex;
    private Node nextNode;

    public Node(Vertex vertex, Node nextNode){
        this.vertex = vertex;
        this.nextNode = nextNode;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

/**
 * The LinkedList ADT class
 */
public class LinkedList {

    //this will be the head of the LinkedList
    private Node head;
    private Node tail;
    private int numOfNodes;


    public LinkedList(){
        head = null;
        tail = null;
        numOfNodes = 0;
    }

    public LinkedList(Vertex newVertex){
        head = null;
        tail = null;
        numOfNodes = 0;
        insert(newVertex);
    }

    public boolean isEmpty(){
        if(numOfNodes == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getSize(){
        return numOfNodes;
    }


    public Vertex getVertexAtIndex(int index){
        //check to make sure that the index is valid
        if(index > numOfNodes){
            throw new IllegalArgumentException("That index does not exist!");
        }else{
            Node nodeAtIndex = head;
            for(int i = 0; i < index; i++){
                nodeAtIndex = nodeAtIndex.getNextNode();
            }
            return nodeAtIndex.getVertex();
        }
    }

    public Vertex getUnvisited(){
        //loop through the linked list until we find something that wasnt visited. return false if non-existent
        Node temp = head;
        while(temp != null){
            if(!temp.getVertex().isWasVisited()){
                temp.getVertex().setWasVisited(true);
                return temp.getVertex();
            }else{
                temp = temp.getNextNode();
            }
        }
        return null;
    }

    //adds a node to the end of the list
    public void insert(Vertex newVertex){
        //first create a new node obj
        Node toAdd = new Node(newVertex, null);
        //check to see if there is a node at the head
        if(head == null){
            //we should do a sanity check here
            if(tail == null){
                head = toAdd;
                tail = head;
            }else{
                //this is an unsuported state, throw an exception
                throw new IllegalStateException("Head/tail mismatch in Linklist");
            }

        }else{
            //the list should already be established
            tail.setNextNode(toAdd);
            tail = tail.getNextNode();
        }
        numOfNodes++;
    }

    public void insertHead(Vertex newVertex){
        //first create a new Node object
        Node toAdd = new Node(newVertex, null);

        //Check to see if a list exists already
        if(head == null){
            //make sure that tail is null too
            if(tail == null){
                head = toAdd;
                tail = head;
            }else{
                //this should never happen but I want the program to fail fast if it does
                throw new IllegalStateException("Head/tail mismatch in Linklist");
            }
        }else{
            //new head and keep tail the same
            toAdd.setNextNode(head);
            head = toAdd;
        }
        numOfNodes++;
    }

    public void deleteHead(){
        if(head == null){
            //do nothing, its already deleted
        }else if(head.getNextNode() == null){
            head = null;
            tail = null; 
        }else{
            head = head.getNextNode();
        }
    }

    public void delete(){
        //this operation is a bit more tricky
        if(numOfNodes <= 1){
            //we can just call delete head so it removes the head
            deleteHead();
        }else{
            //now we need to get the second to last node and keep a reference to it
            Node second = head;
            for(int i = 1; i < numOfNodes - 1; i++){
                second = second.getNextNode();
            }
            //now delete the reference to the last node and move tail over
            tail = second;
            tail.setNextNode(null);
        }
    }
}
