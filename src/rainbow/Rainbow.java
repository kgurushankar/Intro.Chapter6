package rainbow;

/**
 * @author Keshav Gurushankar
 */

import java.awt.*;
import javax.swing.*;

public class Rainbow extends JPanel
{

	private static final long serialVersionUID = 1L;
// Declare skyColor:
  private final Color skyColor = Color.CYAN;
  

  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    // ________________________________________________
    int xCenter = getWidth()/2;
    int yCenter = getHeight()*3/4;
 
    // Declare and initialize the radius of the large semicircle:
    // ________________________________________________
    int radius = getWidth()/2;

    //g.setColor(Color.RED);

    // Draw the large semicircle:
    //g.fillArc(xCenter-(radius/2), yCenter, radius, radius, 0, 180);
    
    
    
    
    Color[] rings = {Color.CYAN, (Color.getColor(("violet"), (int)(7274751))),
    		(Color.getColor(("indigo"), (int)(9699539))), Color.BLUE, Color.GREEN,
    		Color.YELLOW,Color.ORANGE, Color.RED,};
    int n = rings.length;
    for (int i=n; i>0; i-- ){
    	int newRadius = (int) (radius*i
    			/n);
    	g.setColor(rings[i-1]);
    	g.fillArc(xCenter-(newRadius/2), yCenter-(newRadius/2), newRadius, newRadius, 180, -180);
    }

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    
    // ________________________________________________

    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________

    // Draw the sky-color semicircle:
    // ________________________________________________
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
  
  public static Color randomcolor(){
	  Color val = Color.getColor(("jetblack"), (int)((Math.random()*(255*255*255))));
	  return val;
  }
}
