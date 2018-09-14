package unal.optimization;

import unal.functions.OptimizableFunction;
import java.util.Random;

public class HillClimbingPowerLaw implements Optimizable {
  private double alpha;
  private int iterations;

  public HillClimbingPowerLaw(double alpha, int iterations) {
    this.alpha = alpha;
    this.iterations = iterations;
  }

  public double[] optimize(OptimizableFunction f) {
    double[] x0 = f.getInitialPoint();
    double[] results = new double[this.iterations + 1];

    results[0] = f.f(x0);

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();

      for (int j = 0; j < x1.length; j++) {
          double rand = Math.pow(1 - Math.random(), (1 / ( 1 - this.alpha)));
          rand = Math.random() > 0.5 ? rand : -rand;
          x1[j] += rand;
      }

      if (f.f(x1) <= f.f(x0)) {
          x0 = x1;
      }

      results[i + 1] = f.f(x0);
    }

    return results;
  }
}
