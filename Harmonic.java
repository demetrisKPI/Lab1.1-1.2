import java.util.Random;

public class Harmonic {
  private int countOfHarmonics;
  private int limitFrequency;
  private int countOfDescreteCalls;
  private double[][] signalsForAllHarmonics;
  private double[] signalsForResultingHarmonic;

  public Harmonic(int countOfHarmonics, int limitFrequency, int countOfDescreteCalls) {
    this.countOfHarmonics = countOfHarmonics;
    this.limitFrequency = limitFrequency;
    this.countOfDescreteCalls = countOfDescreteCalls;
    this.signalsForAllHarmonics = new double[countOfHarmonics][countOfDescreteCalls];
    this.signalsForResultingHarmonic = new double[countOfDescreteCalls];
  }

  public double[] calculateSignalsForResultingHarmonic() {
    Random r = new Random();
    double A = r.nextDouble();
    double fi = r.nextDouble() * Math.PI;
    for (int i = 0; i < countOfHarmonics; i++) {
      for (int j = 0; j < countOfDescreteCalls; j++) {
        signalsForResultingHarmonic[j] += A * Math.sin(1. * limitFrequency * (i + 1) / countOfHarmonics * j + fi);
      }
    }
    return signalsForResultingHarmonic;
  }

  public double[] calculateSignalsForResultingHarmonic(int n) {
    Random r = new Random();
    double A = r.nextDouble();
    double fi = r.nextDouble() * Math.PI;
    double[] res;
    res = new double[n];
    for (int i = 0; i < countOfHarmonics; i++) {
      for (int j = 0; j < n; j++) {
        res[j] += A * Math.sin(1. * limitFrequency * (i + 1) / countOfHarmonics * j + fi);
      }
    }
    return res;
  }

    public double[] task_Rxx() {
        double[] array = calcSignalsForResultingHarmonic();
        double Mx = calcMathExpectation();
        for (int tau = 0; tau < array.length / 2; tau++) {
            double R = 0;
            for (int t = 0; t < countOfCalls - tau; t++) {
                R += ((array[t] - Mx) * (array[t + tau] - Mx)) / (countOfCalls - 1);
            }
            mass[tau] = R;
        }
        return mass;
    }

    public double[] graphTask() {
        for (int i = 0; i < countOfCalls; i++) {
            arr2[i] = calcDispersion(calcSignalsForResultingHarmonic(i)) - 
                calcMathExpectation(calcSignalsForResultingHarmonic(i));
        }
        return arr2;
    }

  public double calculateMathExpectation(double[] tmp) {
    double sum = 0;
    for (double signal : tmp) {
      sum += signal;
    }
    return sum / tmp.length;
  }

  public double calculateMathExpectation() {
    double sum = 0;
    for (double signal : getSignalsForResultingHarmonic()) {
      sum += signal;
    }
    return sum / getSignalsForResultingHarmonic().length;
  }

  public double calculateDispersion() {
    double sum = 0;
    double mathExpectation = calculateMathExpectation();
    for (double signal : getSignalsForResultingHarmonic()) {
      sum += Math.pow(signal - mathExpectation, 2);
    }
    return sum / (getSignalsForResultingHarmonic().length - 1);
  }

  public double calculateDispersion(double[] tmp) {
    double sum = 0;
    double mathExpectation = calculateMathExpectation(tmp);
    for (double signal : tmp) {
      sum += Math.pow(signal - mathExpectation, 2);
    }
    return sum / (tmp.length - 1);
  }

  public double[] calculateCorrelation() {
    return calculateCorrelationWithOtherFunc(this);
  }

  public double[] calculateCorrelationWithOtherFunc(Harmonic otherHarmonic) {
    double[] correlation_arr = new double[getCountOfDescreteCalls() / 2];
    double mathExp = calculateMathExpectation();
    double mathExp2 = otherHarmonic.calculateMathExpectation();

    for (int tau = 0; tau < getCountOfDescreteCalls() / 2; tau++) {
      double correlation = 0;
      for (int t = 0; t < getCountOfDescreteCalls() / 2; t++) {
        correlation += (getSignalsForResultingHarmonic()[t] - mathExp)
            * (otherHarmonic.getSignalsForResultingHarmonic()[t + tau] - mathExp2);
      }
      correlation_arr[tau] = correlation / (getCountOfDescreteCalls() - 1);
    }
    return correlation_arr;
  }

  public int getCountOfHarmonics() {
    return countOfHarmonics;
  }

  public void setCountOfHarmonics(int countOfHarmonics) {
    this.countOfHarmonics = countOfHarmonics;
  }

  public int getLimitFrequency() {
    return limitFrequency;
  }

  public void setLimitFrequency(int limitFrequency) {
    this.limitFrequency = limitFrequency;
  }

  public int getCountOfDescreteCalls() {
    return countOfDescreteCalls;
  }

  public void setCountOfDescreteCalls(int countOfDescreteCalls) {
    this.countOfDescreteCalls = countOfDescreteCalls;
  }

  public double[][] getSignalsForAllHarmonics() {
    return signalsForAllHarmonics;
  }

  public void setSignalsForAllHarmonics(double[][] signalsForAllHarmonics) {
    this.signalsForAllHarmonics = signalsForAllHarmonics;
  }

  public double[] getSignalsForResultingHarmonic() {
    return signalsForResultingHarmonic;
  }

  public void setSignalsForResultingHarmonic(double[] signalsForResultingHarmonic) {
    this.signalsForResultingHarmonic = signalsForResultingHarmonic;
  }
}