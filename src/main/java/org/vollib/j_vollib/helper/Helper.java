package org.vollib.j_vollib.helper;


import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by Maricris on 19/04/2017.
 */
public class Helper {


    static UnivariateSolver solver = new BrentSolver(1e-15, 1e-15, 0);
    static NormalDistribution norm = new NormalDistribution();


    public static double forward_price(double S, double t, double r) {
        return S/Math.exp(-r*t);
    }

    public static double norm_cdf(double x) {
        return norm.cumulativeProbability(x);
    }

    public static double norm_pdf(double x) {
        return org.vollib.j_lets_be_rational.Constants.ONE_OVER_SQRT_TWO_PI * Math.exp(-0.5 * x * x);
    }

    public static double brent(UnivariateFunction f) {
        return solver.solve(1000, f, 1e-12, 100);
    }

}
