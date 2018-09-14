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

  public static void main(String[] args) {
    Rastrigin rt = new Rastrigin(10, 2);
    double[] x = new double[]{5.12, 5.12};
    double res = rt.f(x);
    System.out.println(res);
  }
}
