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

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();

      for (int j = 0; j < x1.length; j++) {
          double ran = this.random.nextGaussian() * this.sigma;
          x1[j] += ran;
      }

      if (f.f(x1) <= f.f(x0)) {
          x0 = x1;
      }

      System.out.println(String.format("#%d: [%.8f, %.8f] => %.8f", i + 1, x0[0], x0[1], f.f(x0)));
    }

    return x0;
  }
}
