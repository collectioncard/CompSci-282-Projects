/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

/**
 *
 * @author zrafique
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
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort() {
      int in, out;
      for(out=1; out<nElems; out++) {
         long temp = a[out];
         in = out;
         while(in>0 && a[in-1] >= temp) // until one is smaller,
         {
            a[in] = a[in-1]; // shift item right,
            --in; }
         a[in] = temp;
      } // end for
    }  // end insertionSort()

   public void noDups(){
      //since this array is pre-sorted, we dont have to worry about that. We can just check against the previous element
      long newArray[] = new long[nElems];
      long prev = -1;
      int newIndex = 0;
      //loop through the old list
      for(int i = 0; i < a.length; i++){
         //first check to see if prev is the same as current
         if(a[i] != prev){
            newArray[newIndex] = a[i];
            newIndex++;
         }
         prev = a[i];

      }
      //finally, set the original a to the new array
      a = newArray;
   }
}
