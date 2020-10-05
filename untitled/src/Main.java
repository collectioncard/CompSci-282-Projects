public class Main {

    static int theNumber;
    public static void main(String[] args){
        theNumber = 10;
        int theAnswer = triangle(theNumber); System.out.println("Triangle="+theAnswer); } // end main()
    //-------------------------------------------------------------
    public static int triangle(int n)
    { if(n==1)
        return 1; else
        return( n + triangle(n-1) ); }
    //-------------------------------------------------------------

}
