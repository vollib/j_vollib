package org.vollib.j_vollib.black_scholes_merton;

import org.vollib.j_lets_be_rational.LetsBeRational;
import org.vollib.j_vollib.helper.Constants;
import org.vollib.j_vollib.helper.Flag;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

/**
 * Created by Maricris on 19/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(double price, double S, double K, double t, double r, double q, char flag) throws PriceIsAboveMaximum, PriceIsBelowIntrinsic {
        double deflater = Math.exp(-r * t);
        double undiscounted_option_price = price / deflater;

        double F = S * Math.exp((r - q) * t);

        double sigma_calc = LetsBeRational.implied_volatility_from_a_transformed_rational_guess(
                undiscounted_option_price, F, K, t, Flag.valueOf(flag).doubleValue());

        if (sigma_calc == Constants.FLOAT_MAX) {
            throw new PriceIsAboveMaximum();
        } else if (sigma_calc == Constants.MINUS_FLOAT_MAX) {
            throw new PriceIsBelowIntrinsic();
        } else {
            return sigma_calc;
        }
    }

}
