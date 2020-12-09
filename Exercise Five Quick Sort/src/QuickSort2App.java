class QuickSort2App
{
    public static void main(String[] args)
    {
        int maxSize = 8;             // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array


            arr.insert(43);
        arr.insert(71);
        arr.insert(29);
        arr.insert(65);
        arr.insert(31);
        arr.insert(9);
        arr.insert(17);
        arr.insert(55);



        arr.display();                // display items
        arr.quickSort();              // quicksort them
        arr.display();                // display them again
    }  // end main()
}  // end class QuickSort2App