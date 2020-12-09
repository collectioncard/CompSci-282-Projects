
/**
 *
 * @author zrafique with modifications from Thomas Wessel
 */
public class ArrayIns {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items

   //--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
   {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
   }

   //--------------------------------------------------------------
   public void insert(long value)    // put element into array
   {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
   }

   //--------------------------------------------------------------
   public void display()             // displays array contents
   {
      for (int j = 0; j < nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
   }

   //--------------------------------------------------------------
   public void insertionSort() {
      int in;
      for (int out = 1; out < nElems; out++) {
         long temp = a[out];
         in = out;
         while (in > 0 && a[in - 1] >= temp) // until one is smaller,
         {
            a[in] = a[in - 1]; // shift item right,
            in--;
         }
         a[in] = temp;
      } 
   }  // end insertionSort()

   public void noDups() {
      //array is already sorted
      long newArray[] = new long[nElems];
      //first element will always be unique - add it to the new array
      long prev = a[0];
      newArray[0] = a[0];
      //keep track of the current highest position of the new array
      int position = 1; //starts at 1 because we copied the first item already

      //loop through the rest of the array and remove duplicates
      for (int i = 0; i < a.length; i++) {
         //first check to see if prev is the same as current
         if (a[i] != prev) {
            newArray[position] = a[i];
            position++;
         }
         prev = a[i];
      }

      //I dont like the trail of 0s this leaves, we can remove them by creating
      // an additional array and copying the data from the nodups array. This System call will just copy memory to
      // the final array and will not have the time complexity of using a for loop for it. (As long as the system's implementation is good)
      long[] finalArray = new long[position];
      System.arraycopy(newArray, 0, finalArray, 0, position);

      //finally, replace the array reference with the new one
      a = finalArray;
      //we also need to update nElems bc we changed the size of it
      nElems = position;
   }
}


