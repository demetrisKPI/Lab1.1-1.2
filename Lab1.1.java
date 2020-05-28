
import org.knowm.xchart.*;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.XYStyler;

import java.awt.*;

public class Lab1_1 {
    public static void main(String[] args) {

        Harmonic harmonic = new Harmonic(10,1500,256);

        double[] i = new double[harmonic.getCountOfCalls()];
        for (int k = 0; k < i.length; k++) {
            i[k] = k;
        }

        XYChart chart = new XYChartBuilder()
            .width(600)
            .height(400)
            .title("(D-Mx)(N)")
            .xAxisTitle("N")
            .yAxisTitle("t")
            .build();
        //XYSeries series = chart.addSeries("t(N)", i, harmonic.calcSignalsForResultingHarmonic());
        //XYSeries series1 = chart.addSeries("Rxx", i, harmonic.Rxx());
        XYSeries series1dop = chart.addSeries("d-mx", i, harmonic.graphTask());
        SwingWrapper<XYChart> o = new SwingWrapper<XYChart>(chart);
        o.displayChart();
        // System.out.println(harmonic.calcMathExpectation(harmonic.getCountOfCalls));
        // System.out.println(harmonic.calcDispersion(harmonic.getCountOfCalls));
    }
}
