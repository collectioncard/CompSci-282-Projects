/* Code adopted from Advanced Data Structures by Robert Lafore */

public class TestArrayInsNoDups {
    public static void main(String[] args) {
        int maxSize = 10;            // array size
        ArrayIns arr = new ArrayIns(maxSize);  // create the array

        arr.insert(33);               // insert 10 items
        arr.insert(99);
        arr.insert(22);
        arr.insert(33);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items
        arr.insertionSort();          // insertion-sort them
        arr.display();                // display them again       
        arr.noDups();                 // remove duplicates
        arr.display();
    }  // end main()



}
