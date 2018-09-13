package unal.optimization;

import unal.functions.OptimizableFunction;

public class GradientDescent implements Optimizable {
  private int iterations;
  private double alpha;

  public GradientDescent(double alpha, int iterations) {
    this.alpha = alpha;
    this.iterations = iterations;
  }

  public double[] optimize(OptimizableFunction f) {
    double[] x0 = f.getInitialPoint();

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();
      double[] gradient = f.gradient(x1);

      for (int j = 0; j < x1.length; j++) {
        x1[j] += -(this.alpha * gradient[j]);
      }

      System.out.println(String.format("#%d: [%.8f, %.8f] => %.8f", i + 1, x1[0], x1[1], f.f(x1)));

      x0 = x1;
    }

    return x0;
  }
}
