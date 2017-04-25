package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black;

import org.junit.Test;
import org.vollib.j_vollib.black.greeks.Analytical;
import org.vollib.j_vollib.black.greeks.Numerical;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class GreeksTest {

    private static final double EPSILON = 1e-9;
    private static final double F = 100, K = 90, sigma = 0.2, r = 0.02, t = 0.5;

    @Test
    public void test_analytical_delta() {
        double put = Analytical.delta('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.delta('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.delta('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.delta('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_gamma() {
        double put = Analytical.gamma('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.gamma('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.gamma('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.gamma('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_rho() {
        double put = Analytical.rho('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.rho('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.rho('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.rho('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_theta() {
        double put = Analytical.theta('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.theta('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.theta('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.theta('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_vega() {
        double put = Analytical.vega('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.vega('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.vega('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Analytical.vega('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_delta() {
        double put = Numerical.delta('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.delta('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.delta('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.delta('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_gamma() {
        double put = Numerical.gamma('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.gamma('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.gamma('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.gamma('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_rho() {
        double put = Numerical.rho('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.rho('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.rho('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.rho('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_theta() {
        double put = Numerical.theta('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.theta('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.theta('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.theta('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_vega() {
        double put = Numerical.vega('p', F, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.vega('p', F, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.vega('c', F, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black.greeks.Numerical.vega('c', F, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

}
