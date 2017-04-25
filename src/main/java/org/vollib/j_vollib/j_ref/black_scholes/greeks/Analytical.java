package org.vollib.j_vollib.j_ref.black_scholes.greeks;

import org.vollib.j_vollib.helper.Flag;

import static org.vollib.j_vollib.helper.Helper.norm_cdf;
import static org.vollib.j_vollib.helper.Helper.norm_pdf;
import static org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.d1;
import static org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.d2;

/**
 * Created by Maricris on 23/04/2017.
 */
public class Analytical {

    public static double delta(char flag, double S, double K, double t, double r, double sigma) {
        double d_1 = d1(S, K, t, r, sigma);

        if (Flag.valueOf(flag) == Flag.PUT)
            return norm_cdf(d_1) - 1.0;
        else
            return norm_cdf(d_1);
    }

    public static double theta(char flag, double S, double K, double t, double r, double sigma) {
        double two_sqrt_t = 2 * Math.sqrt(t);

        double D1 = d1(S, K, t, r, sigma);
        double D2 = d2(S, K, t, r, sigma);

        double first_term = (-S * norm_pdf(D1) * sigma) / two_sqrt_t;

        if (Flag.valueOf(flag) == Flag.CALL) {
            double second_term = r * K * Math.exp(-r * t) * norm_cdf(D2);
            return (first_term - second_term) / 365.0;
        } else {
            double second_term = r * K * Math.exp(-r * t) * norm_cdf(-D2);
            return (first_term + second_term) / 365.0;
        }
    }

    public static double gamma(char flag, double S, double K, double t, double r, double sigma) {
        double d_1 = d1(S, K, t, r, sigma);
        double v_squared = Math.pow(sigma, 2);
        return norm_pdf(d_1) / (S * sigma * Math.sqrt(t));
    }

    public static double vega(char flag, double S, double K, double t, double r, double sigma) {
        double d_1 = d1(S, K, t, r, sigma);
        return S * norm_pdf(d_1) * Math.sqrt(t) * 0.01;
    }

    public static double rho(char flag, double S, double K, double t, double r, double sigma) {
        double d_2 = d2(S, K, t, r, sigma);
        double e_to_the_minus_rt = Math.exp(-r * t);
        if (Flag.valueOf(flag) == Flag.CALL)
            return t * K * e_to_the_minus_rt * norm_cdf(d_2) * .01;
        else
            return -t * K * e_to_the_minus_rt * norm_cdf(-d_2) * .01;
    }

}
