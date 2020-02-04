package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_lcm_20_25() {
	assertEquals(100, Rational.lcm(20,25));
    }
    
    @Test
    public void test_lcm_1_1() {
	assertEquals(1, Rational.lcm(1,1));
    }
    
    @Test
    public void test_lcm_n5_2() {
	assertEquals(10, Rational.lcm(-5,2));
    }

    @Test
    public void test_lcm_0_15() {
	assertEquals(0, Rational.lcm(0,15));
    }

    @Test
    public void test_plus_0_AND_0() {
        Rational p =  new Rational(0, 15);
        Rational q = new Rational (0,1);
        Rational s = p.plus(q);
	assertEquals("0", s.toString());
    }

    @Test
    public void test_plus_n1_5_AND_1_4() {
        Rational p =  new Rational(-1, 5);
        Rational q = new Rational (1,4);
        Rational s = p.plus(q);
	assertEquals("1/20", s.toString());
    }

    @Test
    public void test_plus_1_AND_2_19() {
        Rational p =  new Rational(1, 1);
        Rational q = new Rational (2,19);
        Rational s = p.plus(q);
	assertEquals("21/19", s.toString());
    }

    @Test
    public void test_sum_n1_AND_1_12() {
        Rational p =  new Rational(-1, 1);
        Rational q = new Rational (1,12);
        Rational s = Rational.sum(p, q);
	assertEquals("-11/12", s.toString());
    }

    @Test
    public void test_sum_1_2_AND_1_3() {
        Rational p =  new Rational(1, 2);
        Rational q = new Rational (1,3);
        Rational s = Rational.sum(p, q);
	assertEquals("5/6", s.toString());
    }

    @Test
    public void test_sum_0_AND_1_5() {
        Rational p =  new Rational(0, 1);
        Rational q = new Rational (1,5);
        Rational s = Rational.sum(p, q);
	assertEquals("1/5", s.toString());
    }

    @Test
    public void test_sum_1_5_AND_0() {
        Rational p =  new Rational(1, 5);
        Rational q = new Rational (0,5);
        Rational s = Rational.sum(p, q);
	assertEquals("1/5", s.toString());
    }

    @Test
    public void test_minus_1_AND_0() {
        Rational p =  new Rational(1, 1);
        Rational q = new Rational (0,1);
        Rational s = p.minus(q);
	assertEquals("1", s.toString());
    }

    @Test
    public void test_minus_1_8_AND_1_12() {
        Rational p =  new Rational(1, 8);
        Rational q = new Rational (1,12);
        Rational s = p.minus(q);
	assertEquals("1/24", s.toString());
    }

    @Test
    public void test_minus_3_5_AND_n1_5() {
        Rational p =  new Rational(3, 5);
        Rational q = new Rational (-1,5);
        Rational s = p.minus(q);
	assertEquals("4/5", s.toString());
    }

    @Test
    public void test_difference_0_AND_0(){
        Rational p = new Rational(0,1);
        Rational q = new Rational(0,1);
        Rational s = Rational.difference(p,q);
        assertEquals("0",s.toString());
    }

    @Test
    public void test_difference_1_2_AND_1_3(){
        Rational p = new Rational(1,2);
        Rational q = new Rational(1,3);
        Rational s = Rational.difference(p,q);
        assertEquals("1/6",s.toString());
    }

    @Test
    public void test_difference_n1_3_AND_1_4(){
        Rational p = new Rational(-1,3);
        Rational q = new Rational(1,4);
        Rational s = Rational.difference(p,q);
        assertEquals("-7/12",s.toString());
    }

    @Test
    public void test_reciprocal_1_3(){
        Rational p = new Rational(1,3);
        Rational q = p.reciprocalOf();
        assertEquals("3",q.toString());
    }
      
    @Test
    public void test_reciprocal_n1_3(){
        Rational p = new Rational(-1,3);
        Rational q = p.reciprocalOf();
        assertEquals("-3",q.toString());
    }
      
    @Test
    public void test_reciprocal_4(){
        Rational p = new Rational(4,1);
        Rational q = p.reciprocalOf();
        assertEquals("1/4",q.toString());
    }
  
    @Test
    public void test_dividedBy_15_by_5(){
        Rational p = new Rational(5,1);
        Rational q = new Rational(15,1);
        Rational s = q.dividedBy(p);
        assertEquals("3",s.toString());
    }
   
    @Test
    public void test_dividedBy_n2_3_by_5(){
        Rational p = new Rational(-2,3);
        Rational q = new Rational(5,1);
        Rational s = p.dividedBy(q);
        assertEquals("-2/15",s.toString());
    }

    @Test
    public void test_dividedBy_0_1_by_4_20(){
        Rational p = new Rational(0,1);
        Rational q = new Rational(4,20);
        Rational s = p.dividedBy(q);
        assertEquals("0",s.toString());
    }


    @Test
    public void test_quotient_12_AND_n3(){
        Rational p = new Rational(12,1);
        Rational q = new Rational(-3,1);
        Rational s = Rational.quotient(p,q);
        assertEquals("-4",s.toString());
    }

    @Test
    public void test_quotient_1_3_AND_1_6(){
        Rational p = new Rational(1,3);
        Rational q = new Rational(1,6);
        Rational s = Rational.quotient(p,q);
        assertEquals("2",s.toString());
    }

    @Test
    public void test_quotient_0_AND_1(){
        Rational p = new Rational(0,1);
        Rational q = new Rational(1,1);
        Rational s = Rational.quotient(p,q);
        assertEquals("0",s.toString());
    }


    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }
 
    
}