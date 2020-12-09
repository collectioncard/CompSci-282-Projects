public class TestDequeue {
    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue(10);
        dequeue.insertLeft(10);
        dequeue.insertLeft(20);
        dequeue.insertRight(30);
        dequeue.insertRight(40);





        System.out.println(dequeue.removeLeft());   //remove 20
        System.out.println(dequeue.removeLeft());   //remove 10
        System.out.println(dequeue.removeRight());  //remove 40
        System.out.println(dequeue.removeRight());  //remove 30
    }
}
