package org.vollib.j_vollib.helper;

/**
 * Created by Maricris on 22/04/2017.
 */
public class NumericalGreeks {

    private static double dS = .01;

    public static double delta(
            char flag,
            double S, double K, double t, double r, double sigma, double b,
            PricingFunction pricing_function) {

        if (t == 0.0)
            if (S == K)
                return Flag.valueOf(flag) == Flag.CALL ? 0.5 : -0.5;
            else if (S > K)
                return Flag.valueOf(flag) == Flag.CALL ? 1.0 : 0.0;
            else
                return Flag.valueOf(flag) == Flag.CALL ? 0.0 : -1.0;
        else
            return (pricing_function.call(flag, S + dS, K, t, r, sigma, b) - pricing_function.call(flag, S - dS, K, t, r, sigma, b)) / (2 * dS);

    }

    public static double theta(char flag, double S, double K, double t, double r, double sigma, double b, PricingFunction pricing_function) {
        if (t <= 1. / 365.)
            return pricing_function.call(flag, S, K, 0.00001, r, sigma, b) - pricing_function.call(flag, S, K, t, r, sigma, b);
        else
            return pricing_function.call(flag, S, K, t - 1. / 365., r, sigma, b) - pricing_function.call(flag, S, K, t, r, sigma, b);
    }

    public static double vega(char flag, double S, double K, double t, double r, double sigma, double b, PricingFunction pricing_function) {
        return (pricing_function.call(flag, S, K, t, r, sigma + 0.01, b) -
            pricing_function.call(flag, S, K, t, r, sigma - 0.01, b)) / 2.;
    }

    public static double rho(char flag, double S, double K, double t, double r, double sigma, double b, PricingFunction pricing_function) {
        return (pricing_function.call(flag, S, K, t, r + 0.01, sigma,  b + 0.01) -
            pricing_function.call(flag, S, K, t, r - 0.01, sigma, b - 0.01)) / 2.;
    }

    public static double gamma(char flag, double S, double K, double t, double r, double sigma, double b, PricingFunction pricing_function) {
        if (t == 0)
            return S == K ? Double.POSITIVE_INFINITY : 0.0;

        return (pricing_function.call(flag, S + dS, K, t, r, sigma, b) - 2. *
                pricing_function.call(flag, S, K, t, r, sigma, b) +
                pricing_function.call(flag, S - dS, K, t, r, sigma, b)) / Math.pow(dS, 2.0);
    }

    public interface PricingFunction {
        public double call(char flag, double F, double K, double t, double r, double sigma, double b);
    }

}
