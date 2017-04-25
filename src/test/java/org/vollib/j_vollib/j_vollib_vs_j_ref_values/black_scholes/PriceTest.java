package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black_scholes;

import org.junit.Test;
import org.vollib.j_vollib.black_scholes.BlackScholes;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class PriceTest {

    private static final double EPSILON = 1e-12;
    private static final double S = 100, K = 90, sigma = 0.2, r = 0.01, t = 0.5;

    @Test
    public void test_black_put() {
        char flag = 'p';
        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        assertEquals(price, price_j_ref, EPSILON);
    }

    @Test
    public void test_black_call() {
        char flag = 'c';
        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        assertEquals(price, price_j_ref, EPSILON);
    }

}
