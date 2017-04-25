package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black_scholes;

import org.junit.Test;
import org.vollib.j_vollib.black_scholes.greeks.Analytical;
import org.vollib.j_vollib.black_scholes.greeks.Numerical;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class GreeksTest {

    private static final double EPSILON = 1e-9;
    private static final double S = 49, K = 50, sigma = 0.2, r = 0.05, t = 0.3846;

    @Test
    public void test_analytical_delta() {
        double put = Analytical.delta('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.delta('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.delta('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.delta('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_gamma() {
        double put = Analytical.gamma('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.gamma('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.gamma('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.gamma('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_rho() {
        double put = Analytical.rho('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.rho('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.rho('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.rho('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_theta() {
        double put = Analytical.theta('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.theta('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.theta('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.theta('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_analytical_vega() {
        double put = Analytical.vega('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.vega('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Analytical.vega('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Analytical.vega('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_delta() {
        double put = Numerical.delta('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.delta('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.delta('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.delta('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_gamma() {
        double put = Numerical.gamma('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.gamma('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.gamma('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.gamma('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_rho() {
        double put = Numerical.rho('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.rho('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.rho('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.rho('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_theta() {
        double put = Numerical.theta('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.theta('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.theta('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.theta('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

    @Test
    public void test_numerical_vega() {
        double put = Numerical.vega('p', S, K, t, r, sigma);
        double put_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.vega('p', S, K, t, r, sigma);
        assertEquals(put, put_j_ref, EPSILON);

        double call = Numerical.vega('c', S, K, t, r, sigma);
        double call_j_ref = org.vollib.j_vollib.j_ref.black_scholes.greeks.Numerical.vega('c', S, K, t, r, sigma);
        assertEquals(call, call_j_ref, EPSILON);
    }

}
