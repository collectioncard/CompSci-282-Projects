/**
 * 2020 Thomas Wessel - CompSci 282
 *
 * This class creates a double sided queue. Most code is original, but some was sourced from the book if I had an issue.
 *  The website 'geeksForGeeks' was also used to help with an algorithm.
 */

public class Dequeue {
    //create reference to global array with size defined by constructor
    private int[] intArray;

    //keep track of the front and back of the circular queue
    private int head;
    private int tail;

    //keep track of the total size of the array
    private int arraySize;

    //keep track of the number of elements in the queue
    private int numOfElements;


    public Dequeue(int size){
        //set global size property
        arraySize = size;
        //create array
        intArray = new int[size];
        //create reference to the head and the tail of the circular queue
        head = -1;     //neither has a proper value at the moment
        tail = -1;
        //set the number of elements in the queue to 0
        numOfElements = 0;
    }

    public void insertRight(int value){
        //Make sure the array is not full
        if(isFull()){
            //cant do much in terms of a custom exception - just gonna throw this for now
            throw new ArrayIndexOutOfBoundsException("No room to add anything the the right of the queue!");
        }
        //if the array is empty, we have to fix head and tail references
        if(head == -1){
            head = 0;
            tail = 0;
        }
        //check to see if end is in a valid location and move it based on that
        else if(tail == numOfElements - 1){
            tail = 0;
        }else{
            tail++;
        }
        //push value into new tail
        intArray[tail] = value;
        numOfElements++;
    }

    public void insertLeft(int value){
        //first make sure the array is not full
        if(isFull()){
            //cant do much in terms of a custom exception - just gonna throw this for now
            throw new ArrayIndexOutOfBoundsException("No room to add anything the the left of the queue!");
        }
        //if the array is empty, we have to fix head and tail references
        if(head == -1){
            head = 0;
            tail = 0;
        } else if(head == 0){//check to see if front is at the beginning of the array
            head = arraySize - 1;
        }else{
            head--;
        }
        //push value to new head
        intArray[head] = value;
        numOfElements++;
    }

    public int removeRight(){
        //ensure that the array is not empty
        if(isEmpty()){
            //cant do much in terms of a custom exception - just gonna throw this for now
            throw new ArrayIndexOutOfBoundsException("Nothing in the queue to remove!");
        }
        //grab the we are removing from the array so we can return it later
        int temp = intArray[tail];

        //check to see if there is only one element in the array
        if(numOfElements == 1){
            //get value and invalidate head and tail
            head = -1;
            tail = -1;
        }else if(tail == 0){ // have to move tail to the end of the array
            tail = arraySize - 1;
        }else{
            tail--;
        }
        //remove one from the count of elements in the array
        numOfElements--;//This doesnt remove the value from the array, but it doesnt matter
        return temp;
    }

    public int removeLeft(){
        //ensure that the array isn't empty
        if(isEmpty()){
            //cant do much in terms of a custom exception - just gonna throw this for now
            throw new ArrayIndexOutOfBoundsException("Nothing in the queue to remove!");
        }
        //grab the value that we are removing
        int temp = intArray[head];

        //if there is only one, just remove everything
        if(numOfElements == 1){
            head = -1;
            tail = -1;
        }else if(head == arraySize - 1){
            head = 0;
        }else{
            head++;
        }
        numOfElements--;
        return temp;
    }

    public boolean isEmpty(){
        if(numOfElements == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(numOfElements == arraySize){
            return true;
        }
        return false;
    }
}
