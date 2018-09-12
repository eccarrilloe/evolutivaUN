package unal.functions;

public class Rastrigin implements OptimizableFunction {

  private double A;
  private int d;
  private double limit;

  public Rastrigin(double A, int d) {
    this.A = A;
    this.d = d;
    this.limit = 5.12;
  }

  public double f(double[] x) {
    double res = this.A * this.d;

    for (int i = 0; i < this.d; i++) {
            res += Math.pow(x[i], 2) - A * Math.cos(2 * Math.PI * x[i]);
    }

    return res;
  }

  public boolean factible(double[] x) {
    return false;
  }

  public int getDimensions() {
    return this.d;
  }

  public double getInitialPoint() {
    return - this.limit + (Math.random() * this.limit * 2);
  }
}
