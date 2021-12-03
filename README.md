# operations-Polynomial-SLinkedList
Giving two polynomials in form of string, add/sub/mul 2 polynomials using singly linked lists.
import java.util.StringTokenizer;

public class Polynomial {
    private SinglyLinkedList<Term> p;

    public Polynomial(String st) {
        p = new SinglyLinkedList<>();
        if ( st == null )
            return;
        StringTokenizer st1 = new StringTokenizer(st,"+");
        while ( st1.hasMoreTokens()) {
            String term = st1.nextToken();
            StringTokenizer st2 = new StringTokenizer(term,"()Xx^");
            String cff = st2.nextToken();
            String pww = st2.nextToken();
            double coeff = Double.parseDouble(cff);
            int pow = Integer.parseInt(pww);
            Term newTerm = new Term(coeff,pow);
            this.insertTermInOrder(newTerm,1);
            //p.addFirst(newTerm);
        }

    }
    public void insertTermInOrder(Term t, int sign){
        if ( t.getCoeff() == 0 )
            return;
        t = new Term(t.getCoeff()*sign,t.getPow());
       if ( p.isEmpty())
           p.addFirst(t);
       else if (p.getHead().getPow() < t.getPow())
           p.addFirst(t);
       else if ( t.getPow() < p.getTail().getPow())
           p.addLast(t);
       else if ( p.getHead().getPow() == t.getPow() ) {
           double newCoeff = p.getHead().getCoeff() + t.getCoeff();
           if ( newCoeff == 0 ){
               p.ShiftHead();
           } else {
           p.getHead().setCoeff(newCoeff); }
       } else {
           Node<Term> left = p.getHeadNode();
           Node<Term> right = left.getNext();
           Node<Term> newNode = new Node<Term>(t,null);
           while (true ) {
               if ( newNode.getData().getPow() > right.getData().getPow()  ) {
                   newNode.setNext(right);
                   left.setNext(newNode);
                   break;
               }
               if ( newNode.getData().getPow() == right.getData().getPow() ) {
                   double newCoeff = right.getData().getCoeff() + newNode.getData().getCoeff();
                   if ( newCoeff == 0) {
                       left.setNext(right.getNext());
                       break;
                   }
                   right.getData().setCoeff(newCoeff);
                   break;
               }
                 left = left.getNext();
               right = right.getNext();
           }


       }





    }
    public static double T(Node<Term> first)
    {
        double ans= 0;
        Node<Term> current = first;
        while ( current != null)
        {
           ans += current.getData().getCoeff();
           current = current.getNext();
        }
        return ans;
    }

    //add auxilary methods and/or constructors

    public Polynomial add(Polynomial q) {
        Polynomial result = new Polynomial(null);    // insert each term in result
        for (Polynomial r : new Polynomial[]{this, q}) {
            Node<Term> current = r.p.getHeadNode();
            while (current != null) {
                result.insertTermInOrder(current.getData(),1);
                current = current.getNext();
            }
        }
        return result;
    }



    public Polynomial subtract(Polynomial q) {
        Polynomial result = new Polynomial(null);    // insert each term in result
        for (Polynomial r : new Polynomial[]{this, q}) {
            Node<Term> current = r.p.getHeadNode();
            while (current != null) {
               int sign = 1;
               if ( r == q)
                   sign = -1;

                result.insertTermInOrder(current.getData(),sign);
                current = current.getNext();
            }
        }
        return result;

     }

    public Polynomial multiply(Polynomial q) {
        Polynomial result = new Polynomial(null);
        Node<Term> outer = p.getHeadNode();
        while( outer != null ){
             Term outerTerm = outer.getData();
            Node<Term> inner = q.p.getHeadNode();
            while( inner != null ){
                Term innerTerm = inner.getData();

                double newCoeff = innerTerm.getCoeff() * outerTerm.getCoeff();
                int newPow = innerTerm.getPow() + outerTerm.getPow();
                Term combinedTerm = new Term(newCoeff, newPow);
                result.insertTermInOrder(combinedTerm,1);
                inner = inner.getNext();
            }
            outer = outer.getNext();
        }
    return result;
    }

    public String toString() {
        String ans = "";
        Node<Term> current = p.getHeadNode();
        while( current != null ){

            ans += current.getData();
            current = current.getNext();
            if ( current != null )
                ans += "+";
        }
        return ans;
    }

        public static void main(String[] args) {

            String s = "(-4.5)X^1+(-2.5)X^0+1X^3";
            String t = "1X^2+1X^0";
            TheGraphGrades.Polynomial p = new TheGraphGrades.Polynomial(s);
            TheGraphGrades.Polynomial q = new TheGraphGrades.Polynomial(t);
            System.out.println(T(p.p.getHeadNode()));
            System.out.println("Polynomial p: " + p);
            System.out.println("Polynomial q: " + q);
            System.out.println("p+q: " + p.add(q));
            System.out.println("p-q: " + p.subtract(q));
            System.out.println("p*q: " + p.multiply(q));
            System.out.println();

            s = "1X^0+(-1)X^1+2X^2+(-2)X^0";
            t = "(-1)X^0+1X^5";
            p = new TheGraphGrades.Polynomial(s);
            q = new TheGraphGrades.Polynomial(t);

            System.out.println("Polynomial p: " + p);
            System.out.println("Polynomial q: " + q);
            System.out.println("p+q: " + p.add(q));
            System.out.println("p-q: " + p.subtract(q));
            System.out.println("p*q: " + p.multiply(q));

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



}public class Node<T> {
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

        public String toString() {
            if ( pow == 0 )
                return coeff + "";
            if ( pow == 1 )
                return "(" + coeff + ")X";
            return "(" + coeff + ")X^" + pow;
        }
}
