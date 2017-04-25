package org.vollib.j_vollib.black_scholes;

import org.vollib.j_lets_be_rational.LetsBeRational;
import org.vollib.j_vollib.helper.Constants;
import org.vollib.j_vollib.helper.Flag;
import org.vollib.j_vollib.helper.Helper;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

/**
 * Created by Maricris on 19/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(double price, double S, double K, double t, double r, char flag) throws PriceIsAboveMaximum, PriceIsBelowIntrinsic {
        double q = Flag.valueOf(flag).doubleValue();
        double deflater = Math.exp(-r * t);
        double undiscounted_option_price = price / deflater;
        double F = Helper.forward_price(S, t, r);

        double sigma_calc = LetsBeRational.implied_volatility_from_a_transformed_rational_guess(
                undiscounted_option_price, F, K, t, q);

        if (sigma_calc == Constants.FLOAT_MAX) {
            throw new PriceIsAboveMaximum();
        } else if (sigma_calc == Constants.MINUS_FLOAT_MAX) {
            throw new PriceIsBelowIntrinsic();
        } else {
            return sigma_calc;
        }
    }

}
