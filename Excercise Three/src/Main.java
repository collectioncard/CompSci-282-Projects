public class Main {

    public static void main(String[] args) {
        CircularLinkList cll = new CircularLinkList();

        cll.display();

        cll.insert(1, 10);
        cll.insert(2, 20);
        cll.insert(3, 30);
        cll.insert(4, 40);
        cll.display();

        Link f = cll.find(1);
        if (f != null) {
            System.out.print("Found Link: ");
            f.displayLink();
        }
        Link d = cll.delete(1);
        if (d != null) {
            System.out.print("Deleted Link: ");
            d.displayLink();
        }
        cll.display();

        while(cll.current != null) {
            Link t = cll.delete(cll.current.key);
            System.out.print("Deleted Link");
            t.displayLink();
        }
        cll.display();
    }
}
