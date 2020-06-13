import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

    static int A = 1;
    static double fp = Math.PI;
    static int n = 12;
    static double [] xArray = new double [20000];
    static double k = 0.0001;


    public LineChart_AWT( String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "t","x",
                createDataset(xArray),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(double [] xArray ) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        double t = k;

        for (double x: xArray) {
            t= t + k;
            dataset.addValue(x,"x",Double.toString(t));
            System.out.println(t);
            System.out.println(x);
        }
        return dataset;
    }

    public static void main( String[ ] args ) {

        for (int t = 0; t < xArray.length; t++) {
            double x = 0;
            for (int i = 0; i <= n; i++) {
                x += A * Math.sin(((n * t) * k + fp));
            }
            xArray[t] = x;
        }

        double M = 0;
        for (double xt : xArray) {
            M += xt;
        }
        M = M / xArray.length;
        System.out.println(M);
        double D = 0;
        for (double xt : xArray) {
            D += Math.pow((xt - M), 2);
        }
        D = D / (xArray.length - 1);
        System.out.println(D);


        LineChart_AWT chart = new LineChart_AWT(
                "x Vs t" ,
                "x vs t");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}