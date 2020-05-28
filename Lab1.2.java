import org.knowm.xchart.*;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.XYStyler;

import java.awt.*;

public class Lab1_2 {    
  public static void main(String[] args) {

    Harmonic harmonic = new Harmonic(10, 1500, 256);
    Harmonic harmonic2 = new Harmonic(10, 1500, 256);

    double[] count = new double[harmonic2.getCountOfDescreteCalls()];

    for (int k = 0; k < count.length; k++) {
        count[k] = k;
    }

    XYChart chart = new XYChartBuilder().width(900).height(600).title("X(T)").xAxisTitle("T").yAxisTitle("X").build();
    XYChart chart2 = new XYChartBuilder().width(900).height(600).title("RXX").xAxisTitle("T").yAxisTitle("RXX").build();
    
    XYSeries series = chart.addSeries("X(T)", i, harmonic2.calculateSignalsForResultingHarmonic());

    harmonic.calculateSignalsForResultingHarmonic();

    double[] correlation = harmonic.calculateCorrelationWithOtherFunc(harmonic2);
    double[] correlation2 = harmonic.calculateCorrelation();

    double[] i2 = new double[correlation.length];
    
    for (int k = 0; k < i2.length; k++) {
      i2[k] = k;
    }

    chart2.addSeries("Correlation", i2, correlation);
    chart2.addSeries("Correlation2", i2, correlation2);

    new SwingWrapper<>(chart).displayChart();
    new SwingWrapper<>(chart2).displayChart();
  }
}