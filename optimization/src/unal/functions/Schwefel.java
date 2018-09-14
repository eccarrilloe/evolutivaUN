package unal.functions;

public class Schwefel implements OptimizableFunction {
  private int d;
  private double limit;

  public Schwefel(int d) {
    this.d = d;
    this.limit = 500;
  }

  public double f(double[] x) {
    double result = 418.9829 * this.d;

    for (int i = 0; i < x.length; i++) {
      result -= x[i] * Math.sin(Math.sqrt(Math.abs(x[i])));
    }

    return result;
  }

  public double[] gradient(double[] x) {
    double result[] = new double[this.d];

    for (int i = 0; i < x.length; i++) {
      result[i] = - (Math.sin(Math.sqrt(Math.abs(x[i]))) +
                    (x[i] * Math.cos(Math.sqrt(Math.abs(x[i]))) * (1 / (2 * Math.sqrt(Math.abs(x[i])))) * (x[i] / Math.abs(x[i]))));
    }

    return result;
  }

  public boolean factible(double[] x) {
    boolean factible = true;

    for (int i = 0; i < x.length; i++) {
      factible = factible && x[i] >= -limit && x[i] <= limit;
    }

    return factible;
  }

  public int getDimensions() {
    return this.d;
  }

  public double[] getInitialPoint() {
    double[] initialPoint = new double[this.d];

    for (int i = 0; i < this.d; i++) {
      initialPoint[i] = -this.limit + (Math.random() * this.limit * 2);
    }

    return initialPoint;
  }
}
