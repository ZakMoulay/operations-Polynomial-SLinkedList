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
