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
    double result = this.A * this.d;

    for (int i = 0; i < this.d; i++) {
      result += Math.pow(x[i], 2) - A * Math.cos(2 * Math.PI * x[i]);
    }

    return result;
  }

  public double[] gradient(double[] x) {
    double[] res = new double[this.d];

    for (int i = 0; i < this.d; i++) {
      res[i] = 2 * x[i] + (this.A * 2 * Math.PI * Math.sin(2 * Math.PI * x[i]));
    }

    return res;
  }

  public int getDimensions() {
    return this.d;
  }

  public double[] getInitialPoint() {
    double[] intialPoint = new double[this.d];
    for (int i = 0; i < this.d; i++) {
      intialPoint[i] = -this.limit + (Math.random() * this.limit * 2);
    }

    // return new double[]{0.5, 0.5};
    return intialPoint;
  }
}
