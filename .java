import java.util.StringTokenizer;

public class Polynomial {
    private SinglyLinkedList<Term> p;

    public Polynomial(String st) {
        p = new SinglyLinkedList<>();
        StringTokenizer st1 = new StringTokenizer(st,"+");
        while ( st1.hasMoreTokens()) {
            String term = st1.nextToken();
            StringTokenizer st2 = new StringTokenizer(term,"()x^");
            String cff = st2.nextToken();
            String pww = st2.nextToken();
            double coeff = Double.parseDouble(cff);
            int pow = Integer.parseInt(pww);
            Term newTerm = new Term(coeff,pow);
            Node<Term> newNode = new Node<Term>(newTerm,null);
            System.out.println(newNode);
        }

    }

    //add auxilary methods and/or constructors

    public Polynomial add(Polynomial q) {
    SinglyLinkedList<Term> result = new SinglyLinkedList<Term>();
    Node<Term> p1 = p.head;
    Node<Term> p2 = q.head;
    Node<Term> p3 =
    while ( p1 != null && p2 != null ) {
        if ( p1 == null) {
            p3.next = p2;
            break;
        }
        else if ( p2 == null) {
            p3.next = p3;
            break;
        }
        else if ( p1.getData().getPow() == p2.getData().getPow()) {

          double newCoef = p1.getData().getPow() + p2.getData().getPow();
          // call sort method
          p1 = p1.getNext();
          p2 = p2.getNext();
        }
        else if ( p1.getData().getPow() > p2.getData().getPow()) {
            // call sort method
            p1 = p1.getNext();
        }
        else if ( p1.getData().getPow() < p2.getData().getPow()) {
            // call sort method
            p2 = p2.getNext();
        }
    }

    }
   /**
    public Polynomial subtract(Polynomial q) {
        //add code

     }

    public Polynomial multiply(Polynomial q) {
        //add code

     }

    public String toString() {
        //add code

     } **/
        public static void main(String[] args) {

            String s = "(-4.5)X^1+(-2.5)X^0+1X^3";
            String t = "1X^2+1X^0";
            TheGraphGrades.Polynomial p = new TheGraphGrades.Polynomial(s);
            TheGraphGrades.Polynomial q = new TheGraphGrades.Polynomial(t);

            System.out.println("Polynomial p: " + p);
            System.out.println("Polynomial q: " + q);
            //System.out.println("p+q: " + p.add(q));
            //System.out.println("p-q: " + p.subtract(q));
            //System.out.println("p*q: " + p.multiply(q));
            System.out.println();

            s = "1X^0+(-1)X^1+2X^2+(-2)X^0";
            t = "(-1)X^0+1X^5";
            p = new TheGraphGrades.Polynomial(s);
            q = new TheGraphGrades.Polynomial(t);

            System.out.println("Polynomial p: " + p);
            System.out.println("Polynomial q: " + q);
            //System.out.println("p+q: " + p.add(q));
            //System.out.println("p-q: " + p.subtract(q));
            //System.out.println("p*q: " + p.multiply(q));

        }
    }
    
    public class SinglyLinkedList<T> {
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
        
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T d) {
        data = d;
    }

    public void setNext(Node<T> n) {
        next = n;
    }

    public String toString() {
        String ans = "";
        //Node<T> node = this;
        if (this != null) {
            ans += this.data;
            Node<T> node = this.next;
            if (node != null) ans = ans + "-->" + node.data;
        }
        return ans;

    }
}
        
public class Term {


        private double coeff ;
        private int pow;
        public Term() {
            coeff = 0;
            pow = 0;
        }
        // add constructors and auxiliary methods
        public Term(double c, int p) {
            coeff = c;
            pow = p;
        }
        public double getCoeff() { return coeff; }
        public int getPow() { return pow; }

        public void setCoeff(double c) { coeff = c;}
        public void setPow(int p) { pow = p; }
}
