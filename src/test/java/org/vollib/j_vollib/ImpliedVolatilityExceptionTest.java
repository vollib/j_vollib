package org.vollib.j_vollib;

import org.junit.Test;
import org.vollib.j_vollib.helper.Constants;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

import static org.junit.Assert.assertEquals;


/**
 * Created by Maricris on 23/04/2017.
 */
public class ImpliedVolatilityExceptionTest {

    @Test(expected = PriceIsAboveMaximum.class)
    public void test_price_is_above_maximum() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 1.28989026125e-20,
        F = 1.0,
        r = 0.01,
        price = 1.16714097354e-20,
        t = 10.0;
        char flag = 'p';
        org.vollib.j_vollib.black.ImpliedVolatility.implied_volatility(price, F, K, r, t, flag);
    }

    @Test(expected = PriceIsBelowIntrinsic.class)
    public void test_price_is_below_intrinsic() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 77.5259748863,
                F = 1.0,
                r = 0.01,
                price = 69.2435655288,
                t = 10.0;
        char flag = 'p';
        org.vollib.j_vollib.black.ImpliedVolatility.implied_volatility(price, F, K, r, t, flag);
    }

    @Test(expected = PriceIsAboveMaximum.class)
    public void test_bs_price_above_maximum() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 1e-20,
                F = 1.0,
                r = 0.01,
                price = 1e-20,
                t = 10.0;
        char flag = 'p';
        Double iv = org.vollib.j_vollib.black.ImpliedVolatility.implied_volatility(1e-21, F, K, r, t, flag);
        assertEquals(2.702730627206159, iv, Constants.EPSILON);
        org.vollib.j_vollib.black.ImpliedVolatility.implied_volatility(price, F, K, r, t, flag);
    }

    @Test(expected = PriceIsBelowIntrinsic.class)
    public void test_bs_price_below_intrinsic() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 2e4,
                F = 1.0,
                r = 0.01,
                price = 1e4,
                t = 10.0;
        double S = F * Math.exp(-r * t);
        char flag = 'p';
        org.vollib.j_vollib.black_scholes.ImpliedVolatility.implied_volatility(price, S, K, t, r, flag);
    }

    @Test(expected = PriceIsBelowIntrinsic.class)
    public void test_bsm_price_below_intrinsic() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 1e10,
                F = 1.0,
                r = 0.01,
                price = 1e9,
                t = 10.0,
                q = 0.03;
        double S = F * Math.exp(-r * t);
        char flag = 'p';
        org.vollib.j_vollib.black_scholes_merton.ImpliedVolatility.implied_volatility(price, S, K, t, r, q, flag);
    }

    @Test(expected = PriceIsAboveMaximum.class)
    public void test_bsm_price_above_maximum() throws PriceIsBelowIntrinsic, PriceIsAboveMaximum {
        double K = 1e10,
                F = 1.0,
                r = 0.01,
                price = 1e10,
                t = 10.0,
                q = 0.03;
        double S = F * Math.exp(-r * t);
        char flag = 'p';
        org.vollib.j_vollib.black_scholes_merton.ImpliedVolatility.implied_volatility(price, S, K, t, r, q, flag);
    }

}
