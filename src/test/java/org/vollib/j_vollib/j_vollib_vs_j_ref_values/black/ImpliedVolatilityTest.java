package org.vollib.j_vollib.j_vollib_vs_j_ref_values.black;

import org.junit.Test;
import org.vollib.j_vollib.black.Black;
import org.vollib.j_vollib.black.ImpliedVolatility;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maricris on 23/04/2017.
 */
public class ImpliedVolatilityTest {

    private static final double EPSILON = 1e-12;
    private static final double F = 100, K = 100, sigma = 0.2, t = 0.5, r = 0.02;

    @Test
    public void test_implied_volatility_put() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        char flag = 'p';
        double price = Black.black(flag, F, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black.Black.black(flag, F, K, t, r, sigma);

        double iv = ImpliedVolatility.implied_volatility(price, F, K, t, r, flag);
        double iv_j_ref = org.vollib.j_vollib.j_ref.black.ImpliedVolatility.implied_volatility(price_j_ref, F, K, t, r, flag);
        assertEquals(iv, iv_j_ref, EPSILON);
    }

    @Test
    public void test_implied_volatility_call() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        char flag = 'c';
        double price = Black.black(flag, F, K, t, r, sigma);
        double price_j_ref = org.vollib.j_vollib.j_ref.black.Black.black(flag, F, K, t, r, sigma);

        double iv = ImpliedVolatility.implied_volatility(price, F, K, t, r, flag);
        double iv_j_ref = org.vollib.j_vollib.j_ref.black.ImpliedVolatility.implied_volatility(price_j_ref, F, K, t, r, flag);
        assertEquals(iv, iv_j_ref, EPSILON);
    }

}
