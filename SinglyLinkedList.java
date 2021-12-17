public class SinglyLinkedList <T> {
    private Node<T> head,tail;
    private int size;
    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
    public T getHead() {
        if ( head == null )
            return null;
        return head.getData(); }
    public T getTail() {
        if ( tail == null )
            return null;
        return tail.getData();
    }
    public void ShiftHead(){
        head = head.getNext();
        size--;
    }
    public Node<T> getHeadNode() {
        return head;
    }
    public Node<T> getLastNode() {
        return tail;

    }

    public void addFirst(T d) {
        Node<T> newNode = new Node<T>(d, head);
        head = newNode;
        if (size == 0)
            tail = head;
        size++;
    }
    public void addLast(T d){
        Node<T> newNode = new Node<T>(d,null);
        if ( isEmpty()) head = tail = newNode;
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

}
