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
}
