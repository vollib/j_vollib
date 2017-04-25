package org.vollib.j_vollib.j_ref.black.greeks;

import org.vollib.j_vollib.helper.Flag;
import org.vollib.j_vollib.j_ref.black.Black;

import static org.vollib.j_vollib.helper.Helper.norm_cdf;
import static org.vollib.j_vollib.helper.Helper.norm_pdf;
import static org.vollib.j_vollib.j_ref.black.Black.black;
import static org.vollib.j_vollib.j_ref.black.Black.d1;

/**
 * Created by Maricris on 22/04/2017.
 */
public class Analytical {

    public static double delta(char flag, double F, double K, double t, double r, double sigma) {
        double D1 = d1(F, K, t, r, sigma);
        if (Flag.valueOf(flag) == Flag.PUT) {
            return -Math.exp(-r * t) * norm_cdf(-D1);
        } else {
            return Math.exp(-r * t) * norm_cdf(D1);
        }
    }

    public static double theta(char flag, double F, double K, double t, double r, double sigma) {
        double e_to_the_minus_rt = Math.exp(-r * t);
        double two_sqrt_t = 2 * Math.sqrt(t);
        double D1 = d1(F, K, t, r, sigma);
        double D2 = Black.d2(F, K, t, r, sigma);

        double first_term = F * e_to_the_minus_rt * norm_pdf(D1) * sigma / two_sqrt_t;

        if (Flag.valueOf(flag) == Flag.CALL) {
            double second_term = -r * F * e_to_the_minus_rt * norm_cdf(D1);
            double third_term = r * K * e_to_the_minus_rt * norm_cdf(D2);
            return -(first_term + second_term + third_term) / 365.;
        } else {
            double second_term = -r * F * e_to_the_minus_rt * norm_cdf(-D1);
            double third_term = r * K * e_to_the_minus_rt * norm_cdf(-D2);
            return (-first_term + second_term + third_term) / 365.0;
        }
    }

    public static double gamma(char flag, double F, double K, double t, double r, double sigma) {
        double D1 = d1(F, K, t, r, sigma);
        return norm_pdf(D1) * Math.exp(-r * t) / (F * sigma * Math.sqrt(t));
    }

    public static double vega(char flag, double F, double K, double t, double r, double sigma) {
        double D1 = d1(F, K, t, r, sigma);
        return F * Math.exp(-r * t) * norm_pdf(D1) * Math.sqrt(t) * 0.01;
    }

    public static double rho(char flag, double F, double K, double t, double r, double sigma) {
        return -t * black(flag, F, K, t, r, sigma) * .01;
    }

}
