import java.util.Arrays;

class ArrayIns {

    private long[] theArray;
    private int numOfElements;

    //keep track of copies and comparisons & copies
    private int numOfCopies;
    private int numOfComparisons;


    public ArrayIns(int max){
        theArray = new long[max];
        numOfElements = 0;
        numOfElements = 0;
        numOfComparisons = 0;
    }


    public void insert(long toInsert){
        theArray[numOfElements] = toInsert;
        numOfElements++;
    }

    public void display(){
        System.out.print("A=");
        for(long number : theArray){
            System.out.print(number + " ");
        }
        System.out.println("\nNumber of Copies: " + numOfCopies);
        System.out.println("Number of Comparisons: " + numOfComparisons);
    }

    public void quickSort(){
        recQuickSort(0, (numOfElements - 1));
    }

    public void recQuickSort(int left, int right){
        int size = right - left + 1;

        if(size <= 3){
            manualSort(left, right);
        }else{
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recQuickSort(left, (partition - 1));
            recQuickSort((partition + 1), right);
        }

        //at this point we will have done at least one comparison
        numOfComparisons++;
    }

    public long medianOf3(int left, int right){
        int center = (left + right) / 2;

        if(theArray[left] > theArray[center]){
            swap(left, center);
        }
        if(theArray[left] > theArray[right]){
            swap(left, right);
        }
        if(theArray[center] > theArray[right]){
            swap(center, right);
        }

        //three comparisons have been done at this point
        numOfComparisons += 3;

        swap(center, (right - 1));
        System.out.println("median pivot is: " + theArray[right - 1]);
        return theArray[right - 1];
    }

    public void swap(int index1, int index2){
        long temp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = temp;

        //three copies were done
        numOfCopies += 3;
    }

    public int partitionIt(int left, int right, long pivot){
        int leftPointer = left;
        int rightPointer = right - 1;

        while(true){
            while(theArray[++leftPointer] < pivot){
                //This is intentionally left empty
            }
            while(theArray[--rightPointer] > pivot){
                //This is intentionally left empty
            }

            if(leftPointer >= rightPointer){
                break;
            }else{
                swap(leftPointer, rightPointer);
            }

            //one comparison was performed
            numOfComparisons++;
        }

        swap(leftPointer, (right - 1));
        System.out.println("part " + Arrays.toString(theArray));
        return leftPointer;
    }

    public void manualSort(int left, int right){
        int size = right - left + 1;

        if(size <= 1){
            //we dont need to do anything
        }else if(size == 2){
            if(theArray[left] > theArray[right]){
                swap(left, right);
            }
            //one comparison was performed
            numOfComparisons++;
        }else{//doesnt count as a comparison bc it doesnt compare
            if(theArray[left] > theArray[right - 1]){
                swap(left, (right - 1));
            }
            if(theArray[left] > theArray[right]){
                swap(left, right);
            }
            if(theArray[right - 1] > theArray[right]){
                swap((right - 1), right);
            }
            //three comparisons were performed
            numOfComparisons += 3;
        }
        //two additional comparisons were done for the external if statements
        numOfComparisons+= 2;
    }
}