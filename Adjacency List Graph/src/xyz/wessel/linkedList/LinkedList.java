package xyz.wessel.linkedList;

/**
 * The LinkedList ADT class
 */
public class LinkedList {

    //this will be the head of the LinkedList
    private Node head;
    private Node current;
    private int numOfNodes;


    public LinkedList(){
        head = null;
        current = null;
        numOfNodes = 0;
    }

    public LinkedList(Object dataObj){
        //TODO: implement this
    }

    public boolean isEmpty(){
        if(numOfNodes == 0){
            return true;
        }else{
            return false;
        }
    }

    //adds a node to the end of the list
    public void insert(Object dataObj){
        //first create a new node obj
        Node toAdd = new Node(dataObj, null);
        //check to see if there is a node at the head
        if(head == null){
            //we should do a sanity check here
            if(current == null){
                head = toAdd;
                current = head;
            }
            //this is an unsuported state, throw an exception
            throw new IllegalStateException("Head/Current mismatch in Linklist");
        }else{
            //the list should already be established
            current.setNextNode(toAdd);
            current = current.getNextNode();
        }
    }

    public void insertHead(Object dataObj){
        //first create a new Node object
        Node toAdd = new Node(dataObj, null);

        //Check to see if a list exists already
        if(head == null){
            //make sure that current is null too
            if(current == null){
                head = toAdd;
                current = head;
            }else{
                //this should never happen but I want the program to fail fast if it does
                throw new IllegalStateException("Head/Current mismatch in Linklist");
            }
        }else{
            //new head and keep current the same
            toAdd.setNextNode(head);
            head = toAdd;
        }
    }

    public void deleteHead(){

    }

    public void delete(){

    }



}
