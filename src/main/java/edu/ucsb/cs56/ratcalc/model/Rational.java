package edu.ucsb.cs56.ratcalc.model;

/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }

	 /** 
	least common multiple of a and b
	@param a first number
	@param b second number
	@return lcm of a and b
    */
	public static int lcm(int a, int b){
		if(a == 0 || b == 0){
				 return 0;
		}
		return java.lang.Math.abs(a*b/gcd(a,b));
	}

	/** 
	adds rational number r
	@param r Rational number
	@return sum of this number plus r
    */
	public Rational plus(Rational r){
		int temp = lcm(this.denom, r.denom);
		int temp1 = temp/this.denom;
		int temp2 = temp/r.denom;
		int common = this.num;  
		Rational first = new Rational(this.num*temp1 + r.num*temp2, temp);
		return first;
	} 

	/** 
	sum of two rationals a and b
	@param a Rational number
	@param b Rational number
	@return a+b
    */
	public static Rational sum(Rational a, Rational b){
		int temp = lcm(a.denom, b.denom);
		int temp1 = temp/a.denom;
		int temp2 = temp/b.denom;
		int common = a.num;  
		Rational first = new Rational(a.num*temp1 + b.num*temp2, temp);
		return first;
	}

	/**
	returns this number minus r
	@param r Rational number
	@return this number minus r
	 */
	public Rational minus(Rational r){
			Rational temp = new Rational (-1 * r.num, r.denom);
			return this.plus(temp);
	}

	/**
	return difference of a and b
	@param a Rational number
	@param b Rational number
	@return returns a-b
	 */
	public static Rational difference(Rational a, Rational b){
		Rational temp = new Rational (-1 * b.num, b.denom);
			return Rational.sum(temp, a);
	}

	/**
	return reciprocal of Rational number
	@return reciprocal (swap numerator and denominator).
	 */
	public Rational reciprocalOf(){
		if(this.num == 0){
				throw new ArithmeticException("Cannot have reciprocal of 0");
		}
		
		int swap = this.num;
		this.num = this.denom;
		this.denom = swap;

		if(this.denom < 0){
			this.denom *= -1;
			this.num *= -1;
			}

		return this;
	}


	/**
	 return this divided by Rational r
	 @param r Rational number
	 @return returns this number divided by r
	 */
	public Rational dividedBy(Rational r){
		Rational tmp = r.reciprocalOf();
		return this.times(tmp);
	}

	/**
	returns a divided by b
	@param a Rational number
	@param b Rational number
	@return a divided by b
	 */
	public static Rational quotient(Rational a, Rational b){
		Rational tmp = b.reciprocalOf();
		return Rational.product(a, tmp);
	}


	public Rational() {
	this.num = 1;
	this.denom = 1;

    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	
	this.num = num;
	this.denom = denom;

	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
	if(this.denom < 0){
		this.denom *= -1;
		this.num *= -1;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
