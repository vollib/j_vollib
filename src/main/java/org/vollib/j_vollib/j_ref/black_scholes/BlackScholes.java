package org.vollib.j_vollib.j_ref.black_scholes;

import org.vollib.j_vollib.helper.Flag;

import static org.vollib.j_vollib.helper.Helper.norm_cdf;

/**
 * Created by Maricris on 22/04/2017.
 */
public class BlackScholes {

    public static double black_scholes(char flag, double S, double K, double t, double r, double sigma) {
        double e_to_the_minus_rt = Math.exp(-r * t);
        double D1 = d1(S, K, t, r, sigma);
        double D2 = d2(S, K, t, r, sigma);
        if (Flag.valueOf(flag) == Flag.CALL) {
            return S * norm_cdf(D1) - K * e_to_the_minus_rt * norm_cdf(D2);
        } else {
            return -S * norm_cdf(-D1) + K * e_to_the_minus_rt * norm_cdf(-D2);
        }
    }

    public static double d1(double S, double K, double t, double r, double sigma) {
        double sigma_squared = sigma * sigma;
        double numerator = Math.log(S / K) + (r + sigma_squared / 2.) * t;
        double denominator = sigma * Math.sqrt(t);

        return numerator / denominator;
    }

    public static double d2(double S, double K, double t, double r, double sigma) {
        return d1(S, K, t, r, sigma) - sigma * Math.sqrt(t);
    }

}
