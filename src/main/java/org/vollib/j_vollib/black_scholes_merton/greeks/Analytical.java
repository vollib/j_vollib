package org.vollib.j_vollib.black_scholes_merton.greeks;

import org.vollib.j_vollib.helper.Flag;

import static org.vollib.j_lets_be_rational.NormalDistribution.norm_cdf;
import static org.vollib.j_lets_be_rational.NormalDistribution.norm_pdf;
import static org.vollib.j_vollib.j_ref.black_scholes_merton.BlackScholesMerton.d1;
import static org.vollib.j_vollib.j_ref.black_scholes_merton.BlackScholesMerton.d2;

/**
 * Created by Maricris on 23/04/2017.
 */
public class Analytical {

    public static double delta(char flag, double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        if (Flag.valueOf(flag) == Flag.PUT) {
            return -Math.exp(-q * t) * norm_cdf(-D1);
        } else {
            return Math.exp(-q * t) * norm_cdf(D1);
        }
    }

    public static double theta(char flag, double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        double D2 = d2(S, K, t, r, sigma, q);

        double first_term = (S * Math.exp(-q*t) * norm_pdf(D1) * sigma) / (2 * Math.sqrt(t));

        if (Flag.valueOf(flag) == Flag.CALL) {
            double second_term = -q * S * Math.exp(-q*t) * norm_cdf(D1);
            double third_term = r * K * Math.exp(-r*t) * norm_cdf(D2);
            return - (first_term + second_term + third_term) / 365.0;
        } else {
            double second_term = -q * S * Math.exp(-q*t) * norm_cdf(-D1);
            double third_term = r * K * Math.exp(-r*t) * norm_cdf(-D2);
            return (-first_term + second_term + third_term) / 365.0;
        }
    }

    public static double gamma(char flag, double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        double numerator = Math.exp(-q*t) * norm_pdf(D1);
        double denominator = S * sigma * Math.sqrt(t);

        return numerator / denominator;
    }

    public static double vega(char flag, double S, double K, double t, double r, double sigma, double q) {
        double D1 = d1(S, K, t, r, sigma, q);
        return S * Math.exp(-q*t) * norm_pdf(D1) * Math.sqrt(t) * 0.01;
    }

    public static double rho(char flag, double S, double K, double t, double r, double sigma, double q) {
        double D2 = d2(S, K, t, r, sigma, q);

        if (Flag.valueOf(flag) == Flag.CALL)
            return t * K * Math.exp(-r*t) * norm_cdf(D2) * .01;
        else
            return -t * K * Math.exp(-r*t) * norm_cdf(-D2) * .01;
    }

}
