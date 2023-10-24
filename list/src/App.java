public class App {
    public static void main(String[] args) throws Exception {
        MyList listik = new MyList();

        listik.addFirst(1);
        listik.addFirst(2);
        listik.addFirst(3);
        listik.addFirst(4);

        System.out.println(listik.toString());

        listik.removeFirst();

        System.out.println(listik.toString());
    }
}
