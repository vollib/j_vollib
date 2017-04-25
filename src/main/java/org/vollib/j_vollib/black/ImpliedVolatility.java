package org.vollib.j_vollib.black;

import org.vollib.j_lets_be_rational.LetsBeRational;
import org.vollib.j_vollib.helper.Constants;
import org.vollib.j_vollib.helper.Flag;
import org.vollib.j_vollib.helper.exceptions.PriceIsAboveMaximum;
import org.vollib.j_vollib.helper.exceptions.PriceIsBelowIntrinsic;

/**
 * Created by Maricris on 19/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(
            double discounted_option_price, double F, double K, double r, double t, char flag)
            throws PriceIsAboveMaximum, PriceIsBelowIntrinsic {

        return implied_volatility_of_discounted_option_price(discounted_option_price, F, K, r, t, flag);
    }

    public static double implied_volatility_of_discounted_option_price(
            double discounted_option_price, double F, double K, double r, double t, char flag)
            throws PriceIsAboveMaximum, PriceIsBelowIntrinsic {

        double q = Flag.valueOf(flag).doubleValue();
        double deflater = Math.exp(-r * t);
        double undiscounted_option_price = discounted_option_price / deflater;
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

    public static double normalised_implied_volatility(double beta, double x, char flag) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.normalised_implied_volatility_from_a_transformed_rational_guess(beta, x, q);
    }

    public static double normalised_implied_volatility_limited_iterations(double beta, double x, char flag, int N) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.normalised_implied_volatility_from_a_transformed_rational_guess_with_limited_iterations(
                beta, x, q, N);
    }

    public static double implied_volatility_of_undiscounted_option_price(
            double undiscounted_option_price, double F, double K, double t, char flag) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.implied_volatility_from_a_transformed_rational_guess(
                undiscounted_option_price, F, K, t, q);
    }

    public static double implied_volatility_of_undiscounted_option_price_limited_iterations(
            double undiscounted_option_price, double F, double K, double t, char flag, int N) {
        double q = Flag.valueOf(flag).doubleValue();
        return LetsBeRational.implied_volatility_from_a_transformed_rational_guess_with_limited_iterations(
                undiscounted_option_price, F, K, t, q, N);
    }

}
