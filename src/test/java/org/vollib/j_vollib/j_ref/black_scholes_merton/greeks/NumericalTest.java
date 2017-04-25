package org.vollib.j_vollib.j_ref.black_scholes_merton.greeks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class NumericalTest {

    private static final double EPSILON = 0.0001;

    private static double S = 1000.0, K = 1000.0, r = 0.05, t = 0.1, sigma = 0.3, q = 0.05;

    @Test
    public void testDelta() throws Exception {
        assertEquals(
                Analytical.delta('c', S, K, t, r, sigma, q),
                Numerical.delta('c', S, K, t, r, sigma, q),
                EPSILON);
        assertEquals(
                Analytical.delta('p', S, K, t, r, sigma, q),
                Numerical.delta('p', S, K, t, r, sigma, q),
                EPSILON);
    }

    @Test
    public void testTheta() throws Exception {
        assertEquals(
                Analytical.theta('c', S, K, t, r, sigma, q),
                Numerical.theta('c', S, K, t, r, sigma, q),
                0.01);
        assertEquals(
                Analytical.theta('p', S, K, t, r, sigma, q),
                Numerical.theta('p', S, K, t, r, sigma, q),
                0.01);
    }

    @Test
    public void testVega() throws Exception {
        assertEquals(
                Analytical.vega('c', S, K, t, r, sigma, q),
                Numerical.vega('c', S, K, t, r, sigma, q),
                EPSILON);
        assertEquals(
                Analytical.vega('p', S, K, t, r, sigma, q),
                Numerical.vega('p', S, K, t, r, sigma, q),
                EPSILON);
    }

    @Test
    public void testRho() throws Exception {
        assertEquals(
                Analytical.rho('c', S, K, t, r, sigma, q),
                Numerical.rho('c', S, K, t, r, sigma, q),
                EPSILON);
        assertEquals(
                Analytical.rho('p', S, K, t, r, sigma, q),
                Numerical.rho('p', S, K, t, r, sigma, q),
                EPSILON);
    }

    @Test
    public void testGamma() throws Exception {
        assertEquals(
                Analytical.gamma('c', S, K, t, r, sigma, q),
                Numerical.gamma('c', S, K, t, r, sigma, q),
                EPSILON);
        assertEquals(
                Analytical.gamma('p', S, K, t, r, sigma, q),
                Numerical.gamma('p', S, K, t, r, sigma, q),
                EPSILON);
    }

}