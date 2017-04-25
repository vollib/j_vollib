package org.vollib.j_vollib.j_ref.black_scholes_merton;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(double price, double S, double K, double t, double r, double q, char flag) {
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double sigma) {
                return price - BlackScholesMerton.black_scholes_merton(flag, S, K, t, r, sigma, q);
            }
        };

        UnivariateSolver solver = new BrentSolver(1e-15, 1e-15, 0);
        return solver.solve(1000, f, 1e-12, 100);
    }

}
