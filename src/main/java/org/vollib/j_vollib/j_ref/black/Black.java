package org.vollib.j_vollib.j_ref.black;

import org.vollib.j_vollib.helper.Flag;

import static org.vollib.j_vollib.helper.Helper.norm_cdf;

/**
 * Created by Maricris on 19/04/2017.
 */
public class Black {

    public static double d1(double F, double K, double t, double r, double sigma) {
        double sigma_squared = sigma * sigma;
        double numerator = Math.log(F / K) + sigma_squared * t / 2.0;
        double denominator = sigma * Math.sqrt(t);
        return numerator / denominator;
    }

    public static double d2(double F, double K, double t, double r, double sigma) {
        return d1(F, K, t, r, sigma) - sigma * Math.sqrt(t);
    }

    public static double black_call(double F, double K, double t, double r, double sigma) {
        double deflater = Math.exp(-r * t);
        double ND1 = norm_cdf(d1(F, K, t, r, sigma));
        double ND2 = norm_cdf(d2(F, K, t, r, sigma));

        return deflater * (F * ND1 - K * ND2);
    }

    public static double black_put(double F, double K, double t, double r, double sigma) {
        double deflater = Math.exp(-r * t);
        double NOfMinusD1 = norm_cdf(-d1(F, K, t, r, sigma));
        double NOfMinusD2 = norm_cdf(-d2(F, K, t, r, sigma));
        return deflater * (-F * NOfMinusD1 + K * NOfMinusD2);
    }

    public static double black(char flag, double F, double K, double t, double r, double sigma) {
        if (Flag.valueOf(flag) == Flag.CALL) {
            return black_call(F, K, t, r, sigma);
        } else {
            return black_put(F, K, t, r, sigma);
        }
    }

}
