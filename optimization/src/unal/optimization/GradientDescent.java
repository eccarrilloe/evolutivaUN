package unal.optimization;

import unal.functions.OptimizableFunction;
import java.util.Arrays;

public class GradientDescent implements Optimizable {
  private int iterations;
  private double alpha;

  public GradientDescent(double alpha, int iterations) {
    this.alpha = alpha;
    this.iterations = iterations;
  }

  public double[] optimize(OptimizableFunction f) {
    double[] x0 = f.getInitialPoint();
    double[] results = new double[this.iterations + 1];

    results[0] = f.f(x0);

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();
      double[] gradient = f.gradient(x1);

      for (int j = 0; j < x1.length; j++) {
        x1[j] += -(this.alpha * gradient[j]);
      }

      results[i + 1] = f.f(x1);


      x0 = x1;
    }

    System.out.println(Arrays.toString(results));
    System.out.println();
    
    return results;
  }
}
