package org.vollib.j_vollib.j_ref.black.greeks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 22/04/2017.
 */
public class AnalyticalTest {

    private final double EPSILON = 1.0e-12;

    @Test
    public void testDelta() throws Exception {
        double F = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        double actual = Analytical.delta(flag, F, K, t, r, sigma);
        double expected = 0.45107017482201828;
        assertEquals(expected, actual, EPSILON);
    }

    @Test
    public void testTheta() throws Exception {
        double F = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;

        double actual_call = Analytical.theta('c', F, K, t, r, sigma);
        double expected_call = -0.00816236877462;
        assertEquals(expected_call, actual_call, EPSILON);

        double actual_put = Analytical.theta('p', F, K, t, r, sigma);
        double expected_put = -0.00802799155312;
        assertEquals(expected_put, actual_put, EPSILON);
    }


    @Test
    public void testGamma() throws Exception {
        double F = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        double actual = Analytical.gamma(flag, F, K, t, r, sigma);
        double expected = 0.0640646705882;
        assertEquals(expected, actual, EPSILON);
    }

    @Test
    public void testVega() throws Exception {
        double F = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;
        char flag = 'c';
        double actual = Analytical.vega(flag, F, K, t, r, sigma);
        double expected = 0.118317785624;
        assertEquals(expected, actual, EPSILON);
    }

    @Test
    public void testRho() throws Exception {
        double F = 49, K = 50, r = 0.05, t = 0.3846, sigma = 0.2;

        double actual_call = Analytical.rho('c', F, K, t, r, sigma);
        double expected_call = -0.0074705380059582258;
        assertEquals(expected_call, actual_call, EPSILON);

        double actual_put = Analytical.rho('p', F, K, t, r, sigma);
        double expected_put = -0.011243286001308292;
        assertEquals(expected_put, actual_put, EPSILON);
    }

}