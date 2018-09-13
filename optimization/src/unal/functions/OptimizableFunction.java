package unal.functions;

public interface OptimizableFunction {
  public double f(double[] x);
  public double[] gradient(double[] x);
  public double[] getInitialPoint();
}
