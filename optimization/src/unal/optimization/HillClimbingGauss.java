package unal.optimization;

import unal.functions.OptimizableFunction;
import java.util.Random;

public class HillClimbingGauss implements Optimizable {
  private double sigma;
  private int iterations;
  private Random random;

  public HillClimbingGauss(double sigma, int iterations) {
    this.sigma = sigma;
    this.iterations = iterations;
    this.random = new Random();
  }

  public double[] optimize(OptimizableFunction f) {
    double[] x0 = f.getInitialPoint();
    double[] results = new double[this.iterations + 1];

    results[0] = f.f(x0);

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();

      for (int j = 0; j < x1.length; j++) {
          double ran = this.random.nextGaussian() * this.sigma;
          x1[j] += ran;
      }

      if (f.f(x1) <= f.f(x0)) {
          x0 = x1;
      }

      results[i + 1] = f.f(x0);
    }

    return results;
  }
}
