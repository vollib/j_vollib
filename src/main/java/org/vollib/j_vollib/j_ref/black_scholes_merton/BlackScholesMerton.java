package org.vollib.j_vollib.j_ref.black_scholes_merton;

import org.vollib.j_vollib.helper.Flag;

import static org.vollib.j_vollib.helper.Helper.norm_cdf;

/**
 * Created by Maricris on 22/04/2017.
 */
public class BlackScholesMerton {

    public static double black_scholes_merton(char flag, double S, double K, double t, double r, double sigma, double q) {
        if (Flag.valueOf(flag) == Flag.CALL) {
            return bsm_call(S, K, t, r, sigma, q);
        } else {
            return bsm_put(S, K, t, r, sigma, q);
        }
    }

    public static double bsm_call(double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        double D2 = d2(S, K, t, r, sigma, q);
        return S * Math.exp(-q * t) * norm_cdf(D1) - K * Math.exp(-r * t) * norm_cdf(D2);
    }

    public static double bsm_put(double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        double D2 = d2(S, K, t, r, sigma, q);
        return K * Math.exp(-r * t) * norm_cdf(-D2) - S * Math.exp(-q * t) * norm_cdf(-D1);
    }

    public static double d1(double S, double K, double t, double r, double sigma, double q) {
        double numerator = Math.log(S / K) + ((r - q) + sigma * sigma / 2.0) * t;
        double denominator = sigma * Math.sqrt(t);
        return numerator / denominator;
    }

    public static double d2(double S, double K, double t, double r, double sigma, double q) {
        return d1(S, K, t, r, sigma, q) - sigma * Math.sqrt(t);
    }

}
