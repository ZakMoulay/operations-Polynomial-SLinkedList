 public static void main(String[] args) {

            String s = "(-4.5)X^1+(-2.5)X^0+1X^3";
            String t = "1X^2+1X^0";
            TheGraphGrades.Polynomial p = new TheGraphGrades.Polynomial(s);
            TheGraphGrades.Polynomial q = new TheGraphGrades.Polynomial(t);

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
