package xyz.wessel.linkedList;

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

    public LinkedList(Object dataObj){
        insert(dataObj);
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
            if(tail == null){
                head = toAdd;
                tail = head;
            }
            //this is an unsuported state, throw an exception
            throw new IllegalStateException("Head/tail mismatch in Linklist");
        }else{
            //the list should already be established
            tail.setNextNode(toAdd);
            tail = tail.getNextNode();
        }
    }

    public void insertHead(Object dataObj){
        //first create a new Node object
        Node toAdd = new Node(dataObj, null);

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

    //because we use an object for our data, this will not work most of the time
    public void display(){
        Node iterator = head;
        while(iterator != tail){
            System.out.println("[" + iterator.getDataObj().toString() + "]");
        }
        System.out.println("[" + iterator.getDataObj().toString() + "]");
    }





}
