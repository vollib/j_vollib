package org.vollib.j_vollib.j_ref;

import org.junit.Test;
import org.vollib.j_vollib.TestUtil;
import org.vollib.j_vollib.j_ref.black_scholes_merton.BlackScholesMerton;
import org.vollib.j_vollib.j_ref.black_scholes_merton.ImpliedVolatility;
import org.vollib.j_vollib.j_ref.black_scholes_merton.greeks.Analytical;
import org.vollib.j_vollib.j_ref.black_scholes_merton.greeks.Numerical;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class BlackScholesMertonTest {

    private static final double EPSILON = 1e-6;

    private static Map<String, List<Double>> testData = TestUtil.loadTestData();

    private static int SIZE = testData.get("S").size();

    private static double q = 0;

    @Test
    public void test_prices() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("bs_call").get(i);
            double actual_call = BlackScholesMerton.black_scholes_merton('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("bs_put").get(i);
            double actual_put = BlackScholesMerton.black_scholes_merton('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_analytical_delta() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CD").get(i);
            double actual_call = Analytical.delta('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PD").get(i);
            double actual_put = Analytical.delta('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_analytical_theta() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CT").get(i);
            double actual_call = Analytical.theta('c', S, K, t, r, sigma, q) * 365.0;
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PT").get(i);
            double actual_put = Analytical.theta('p', S, K, t, r, sigma, q) * 365.0;
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_analytical_gamma() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CG").get(i);
            double actual_call = Analytical.gamma('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PG").get(i);
            double actual_put = Analytical.gamma('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_analytical_vega() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CV").get(i);
            double actual_call = Analytical.vega('c', S, K, t, r, sigma, q) / 0.01;
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PV").get(i);
            double actual_put = Analytical.vega('p', S, K, t, r, sigma, q) / 0.01;
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_analytical_rho() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CR").get(i);
            double actual_call = Analytical.rho('c', S, K, t, r, sigma, q) / 0.01;
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PR").get(i);
            double actual_put = Analytical.rho('p', S, K, t, r, sigma, q) / 0.01;
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_numerical_delta() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CD").get(i);
            double actual_call = Numerical.delta('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PD").get(i);
            double actual_put = Numerical.delta('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_numerical_theta() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CT").get(i) / 365.0;
            double actual_call = Numerical.theta('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, 1);

            double expected_put = testData.get("PT").get(i) / 365.0;
            double actual_put = Numerical.theta('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, 1);
        }
    }

    @Test
    public void test_numerical_gamma() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CG").get(i);
            double actual_call = Numerical.gamma('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, EPSILON);

            double expected_put = testData.get("PG").get(i);
            double actual_put = Numerical.gamma('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, EPSILON);
        }
    }

    @Test
    public void test_numerical_vega() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CV").get(i) * 0.01;
            double actual_call = Numerical.vega('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, 0.01);

            double expected_put = testData.get("PV").get(i) * 0.01;
            double actual_put = Numerical.vega('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, 0.01);
        }
    }

    @Test
    public void test_numerical_rho() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double expected_call = testData.get("CR").get(i) * 0.01;
            double actual_call = Numerical.rho('c', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_call, actual_call, 0.001);

            double expected_put = testData.get("PR").get(i) * 0.01;
            double actual_put = Numerical.rho('p', S, K, t, r, sigma, q);
            assertEquals("Error at " + i, expected_put, actual_put, 0.001);
        }
    }

    @Test
    public void test_implied_volatility() {
        for (int i = 0; i < SIZE; i++) {
            double S = testData.get("S").get(i);
            double K = testData.get("K").get(i);
            double t = testData.get("t").get(i);
            double r = testData.get("R").get(i);
            double sigma = testData.get("v").get(i);

            double call = BlackScholesMerton.black_scholes_merton('c', S, K, t, r, sigma, q);
            double put = BlackScholesMerton.black_scholes_merton('p', S, K, t, r, sigma, q);

            try {
                double iv_call = ImpliedVolatility.implied_volatility(call, S, K, t, r, q, 'c');
                assertEquals("Error at " + i, sigma, iv_call, 0.0001);
            } catch (Exception ex) {
                System.out.println("could not calculate iv");
            }

            try {
                double iv_put = ImpliedVolatility.implied_volatility(put, S, K, t, r, q, 'p');
                if (iv_put != 1.0E-12) {
                    assertEquals("Error at " + i, sigma, iv_put, 0.001);
                }
            } catch (Exception ex) {
                System.out.println("could not calculate iv");
            }

        }
    }

}
