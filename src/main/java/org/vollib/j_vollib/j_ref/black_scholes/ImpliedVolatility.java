package org.vollib.j_vollib.j_ref.black_scholes;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;

import static org.vollib.j_vollib.j_ref.black_scholes.BlackScholes.black_scholes;

/**
 * Created by Maricris on 22/04/2017.
 */
public class ImpliedVolatility {

    public static double implied_volatility(double price, double S, double K, double t, double r, char flag) {
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double sigma) {
                return price - black_scholes(flag, S, K, t, r, sigma);
            }
        };

        UnivariateSolver solver = new BrentSolver(1e-15, 1e-15, 0);
        return solver.solve(1000, f, 1e-12, 100);
    }

}
