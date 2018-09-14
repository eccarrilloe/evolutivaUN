package unal.optimization;

import unal.functions.OptimizableFunction;

public class GradientDescentMomentum implements Optimizable {
  private int iterations;
  private double alpha;
  private double miu;

  public GradientDescentMomentum(double alpha, double miu, int iterations) {
    this.alpha = alpha;
    this.miu = miu;
    this.iterations = iterations;
  }

  public double[] optimize(OptimizableFunction f) {
    double[] x0 = f.getInitialPoint();
    double[] delta = new double[f.getDimensions()];

    for (int i = 0; i < delta.length; i++) {
      delta[i] = 0;
    }

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();
      double[] gradient = f.gradient(x1);

      for (int j = 0; j < x1.length; j++) {
        delta[j] = miu * delta[j] - gradient[j] * alpha;
        x1[j] += delta[j];
      }

      System.out.println(String.format("#%d: [%.8f, %.8f] => %.8f", i + 1, x1[0], x1[1], f.f(x1)));

      x0 = x1;
    }

    return x0;
  }
}
