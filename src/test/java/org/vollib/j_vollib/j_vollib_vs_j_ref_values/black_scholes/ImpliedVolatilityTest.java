package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black_scholes;

import org.junit.Test;
import org.vollib.j_vollib.black_scholes.BlackScholes;
import org.vollib.j_vollib.black_scholes.ImpliedVolatility;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class ImpliedVolatilityTest {

    private static final double EPSILON = 1e-12;
    private static final double S = 100, K = 100, sigma = 0.232323232, t = 0.5, r = 0.01;

    @Test
    public void test_implied_volatility_put() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        char flag = 'p';
        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.black_scholes(flag, S, K, t, r, sigma);

        double iv = ImpliedVolatility.implied_volatility(price, S, K, t, r, flag);
        double iv_j_ref = org.vollib.j_vollib.j_ref.black_scholes.ImpliedVolatility.implied_volatility(price_j_ref, S, K, t, r, flag);
        assertEquals(iv, iv_j_ref, EPSILON);
    }

    @Test
    public void test_implied_volatility_call() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        char flag = 'c';
        double price = BlackScholes.black_scholes(flag, S, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.black_scholes(flag, S, K, t, r, sigma);

        double iv = ImpliedVolatility.implied_volatility(price, S, K, t, r, flag);
        double iv_j_ref = org.vollib.j_vollib.j_ref.black_scholes.ImpliedVolatility.implied_volatility(price_j_ref, S, K, t, r, flag);
        assertEquals(iv, iv_j_ref, EPSILON);
    }

}
