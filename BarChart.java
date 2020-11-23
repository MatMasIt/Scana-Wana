import java.io.FileNotFoundException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart extends JFrame {
   
   public BarChart( String applicationTitle , String chartTitle,DefaultCategoryDataset d ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         d,          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   
   
   public static void main( String[ ] args ) throws FileNotFoundException {
	   CategoryDatasetFactory cdf = new CategoryDatasetFactory();
	   DefaultCategoryDataset dcd= cdf.loadFile("faccim.txt");
      BarChart chart = new BarChart("Canzoni di Domenico Bini", 
         "Il cantautore famoso sul web e nel Mondo",dcd);
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}