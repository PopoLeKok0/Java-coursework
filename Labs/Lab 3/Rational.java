public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
      this.numerator = numerator;
      this.denominator = 1;    
    }

    public Rational(int numerator, int denominator) {
       if (denominator < 0) {
      denominator = -1 * denominator;
      numerator = -1 * numerator;
      }
    this.numerator = numerator;
    this.denominator = denominator;
    reduce();
    }
    

    // getters

    public int getNumerator() {
       return numerator;
    }

    public int getDenominator() {
       return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
       int plusNumerator=(this.numerator*other.denominator)+(other.numerator*this.denominator);
       int communDenominator=other.denominator*this.denominator;
         return new Rational(plusNumerator,communDenominator);
    }

    public static Rational plus(Rational a, Rational b) {
         return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int gcd = gcd(this.numerator,this.denominator);
      this.numerator = this.numerator/gcd;
      this.denominator = this.denominator/gcd;
      
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      if(a<0){
        a *= -1;
      }
      if(b<0){
        b *= -1;
      }
      while (a != b)
          if (a > b)
             a = a - b;
          else
             b = b - a;
      return a;
    }

    public int compareTo(Rational other) {
       int communDenominator = this.denominator*other.denominator;
      Rational thisNum = new Rational(this.numerator*other.denominator,communDenominator);
      Rational otherNum = new Rational(other.numerator*this.denominator,communDenominator);
      if(thisNum.numerator == otherNum.numerator){
        return 0;
      }
      else if(thisNum.numerator > otherNum.numerator){
        return 5;
    }
       else {
        return -5;
      }
      
    }
    
    public boolean equals(Rational other) {
      return(this.numerator == other.numerator && this.denominator == other.denominator);
    }
    public String toString() {
      String result;
      if (denominator == 1) {
          result =Integer.toString(numerator);
      } else {
          result =this.numerator+"/"+this.denominator;
      }
      return result;
    }
  }