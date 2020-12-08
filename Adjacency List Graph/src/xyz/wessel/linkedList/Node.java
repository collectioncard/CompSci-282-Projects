package xyz.wessel.linkedList;

/**
 * A simple node class that contains references to a data item and a reference to
 * the next node item
 */
public class Node {
    private Node nextNode;
    private Object dataObj;

    public Node(){
        dataObj = null;
        nextNode = null;
    }

    public Node(Object dataObj, Node nextNode){
        this.nextNode = nextNode;
        this.dataObj = dataObj;
    }


    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getDataObj() {
        return dataObj;
    }

    public void setDataObj(Object dataObj) {
        this.dataObj = dataObj;
    }
}
