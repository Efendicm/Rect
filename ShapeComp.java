import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;

public class ShapeComponent2 extends JComponent {
    private Shape theShape;
    private Random ranGen;
    Random rnd = new Random();
    
    public ShapeComponent2() {
        super();
        ranGen = new Random();
    }
    public void clear(){
        theShape = null;
        repaint();
    }
    
    public void addSquare() {
        double x = getWidth() * ranGen.nextDouble();
        double y = getHeight() * ranGen.nextDouble();
        double diameter = Math.min(getWidth(),getHeight()) * ranGen.nextDouble();
        theShape = new Rectangle2D.Double(x,y,diameter,diameter);
        repaint();
    }
    
    public void addRectangle(double x, double y) {
        double diameter = Math.min(getWidth(),getHeight()) * ranGen.nextDouble();
            x = x - diameter/2;
            y = y - diameter/2;
        theShape = new Rectangle2D.Double(x,y,diameter, diameter);
        repaint();
    
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.black);
        g2D.setColor(new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat()));
        g2D.clearRect(0, 0, getWidth(),getHeight());
        
        
        
        if(theShape !=null) {
            g2D.fill(theShape);
        }
    }
    

}
