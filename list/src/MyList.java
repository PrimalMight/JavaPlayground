public class MyList {
    public Node prvni = new Node(0, null);
    

    public int addFirst(int value){
        try{
            prvni.next = new Node(value, prvni.next);
            return 0;
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public Node removeFirst(){
        Node toRemove = prvni.next;
        prvni.next = prvni.next.next;
        return toRemove;
    }

    public boolean isEmpty(){
        return prvni.next == null;
    }

    public Node getFirst(){
        return prvni.next;
    }

    public String toString(){
        String repre = "";
        Node current = prvni.next;
        while(current != null){
            repre += current.value;
            repre += " --> ";
            current = current.next;
        }
        repre += "null";
        return repre;
    }
}
