package unal.functions;

public class Griewank implements OptimizableFunction {
  public double f(double[] x) {
    return 0.0;
  }

  public double[] gradient(double[] x) {
    return new double[] {0.0};
  }

  public double[] getInitialPoint() {
    return new double[]{0.0};
  }
}
