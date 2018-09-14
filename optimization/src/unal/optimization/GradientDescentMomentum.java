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
    double[] results = new double[this.iterations + 1];

    for (int i = 0; i < delta.length; i++) {
      delta[i] = 0;
    }

    results[0] = f.f(x0);

    for (int i = 0; i < this.iterations; i++) {
      double[] x1 = x0.clone();
      double[] gradient = f.gradient(x1);

      for (int j = 0; j < x1.length; j++) {
        delta[j] = miu * delta[j] - gradient[j] * alpha;
        x1[j] += delta[j];
      }

      results[i + 1] = f.f(x1);

      x0 = x1;
    }

    return results;
  }
}
