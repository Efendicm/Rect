import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.WindowConstants;


public class ShapeFrame extends JFrame {
    private ShapeComponent2 shapeDisplay;
    private JButton rectangle;
    private JRadioButtonMenuItem rectangleChoice;
    
    private class DoButtons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if( rectangleChoice.isSelected()  ){
                shapeDisplay.addSquare();
            }
        }
    }
    
    private class PutShape implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            double clickX = e.getX();
            double clickY = e.getY();
            if( rectangleChoice.isSelected() ){
                shapeDisplay.addRectangle(clickX, clickY);
            }
            
        }
        public void mousePressed(MouseEvent arg0) {
            
        }
        public void mouseReleased(MouseEvent arg0) {
            
        }
        public void mouseEntered(MouseEvent arg0) {
            shapeDisplay.clear();
        }
        public void mouseExited (MouseEvent arg0) {
            
            shapeDisplay.addSquare();
        }
    }
    
    public ShapeFrame() {
        super();
        Container ctPane = getContentPane();
        
        shapeDisplay = new ShapeComponent2();
        shapeDisplay.addMouseListener(new PutShape());
        ctPane.add(shapeDisplay, "Center");
        
        rectangle = new JButton("Rectangle");
        rectangle.addActionListener(new DoButtons());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rectangle);
        
        ctPane.add(buttonPanel,"South");
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu shapeMenu = new JMenu("Shapes");
        menubar.add(shapeMenu);
        
        rectangleChoice = new JRadioButtonMenuItem("Rectangle", true);
        shapeMenu.add(rectangleChoice);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rectangleChoice);
        
    }
    public ShapeFrame(String title) {
        this();
        setTitle(title);
        
    }
    public static void main(String[] args) {
        ShapeFrame frame = new ShapeFrame("The Shape of Things to Come");
        frame.setSize(400, 400);
        frame.setLocation(200, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
