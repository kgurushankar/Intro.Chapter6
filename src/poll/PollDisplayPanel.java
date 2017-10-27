package poll;

// A PollDisplayPanel holds the vote counts and
// displays the numbers and the pie chart for
// the current vote counts.


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PollDisplayPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	
private String[] name = new String[4];
  // Declare the int fields count1, count2, count3:
  private int[] count = new int[4];
  

  // Constructor
  public PollDisplayPanel(String nm1, String nm2, String nm3)
  {
    setBackground(Color.WHITE);
    name[1] = nm1;
    name[2] = nm2;
    name[3] = nm3;
    count[1] = 0;   // optional
    count[2] = 0;   // optional
    count[3] = 0;   // optional
  }

  // Increments count1
  public void vote1()
  {
	  count[1]++;
  }

  // Increments count2
  public void vote2()
  {
	  count[2]++;
  }

  // Increments count3
  public void vote3()
  {
	  count[3]++;
  }
  
  public void reset(){
	  count[1] =0;
	  count[2] =0;
	  count[3] =0;
  }

  // Returns a string representation of this object
  public String toString()
  {
    return   	name[1] + ": " + count[1] + " " +

    			name[2] + ": " + count[2] + " " +

    			name[3] + ": " + count[3] 		;
  }

  // Redefines JPanel's paintComponent to draw this pie chart
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int w = getWidth();
    int h = getHeight();
    int x = w/2;
    int y = h/2;
    int r = Math.min(w, h) / 4;
    drawPieChart(g, x, y, r);
    drawLegend(g, x, y, r);
  }

  // Draws the pie chart.
  // To avoid gaps in the picture, the following algorithm is used:
  // 1. set fromDegree to 0;
  // 2. draw the red sector and increment fromDegree by its size
  // 3. draw the green sector and increment fromDegree by its size
  // 4. set the size of the blue sector to the remaining
  //    area, 360 - fromDegree, but not less than 0:
  //      degrees = Math.max(360 - fromDegree, 0);
  //    (Occasionally, due to rounding errors, fromDegree may become 361,
  //    for example, count1 = 5, count2 = 11, count3 = 0.)
  private void drawPieChart(Graphics g, int x, int y, int r)
  {
    int total = count[1] + count[2] + count[3];
    int fromDegree = 0;

    if (total > 0)
    {
      int degrees;
      g.setColor(Color.RED);
      degrees = countToDegrees(count[1], total);
      drawSector(g, x, y, r, fromDegree, degrees);
      fromDegree+=degrees;
      
      g.setColor(Color.GREEN);
      degrees = countToDegrees(count[2], total);
      drawSector(g, x, y, r, fromDegree, degrees);
      fromDegree+=degrees;
      
      g.setColor(Color.YELLOW);
      degrees = (360-fromDegree<=0) ? 0 : 360-fromDegree;
      drawSector(g, x, y, r, fromDegree, degrees);
      
    }
    else
    {
      g.setColor(Color.LIGHT_GRAY);
      drawSector(g, x, y, r, fromDegree, 360);
    }
  }

  // Draws the vote counts and the corresponding color squares.
  private void drawLegend(Graphics g, int x, int y, int r)
  {
    // Display the counts:
    y += (r + 20);
    g.setColor(Color.BLACK);

    g.drawString( name[1] + ": " + count[1] , x - r, y);

    g.drawString( name[2] + ": " + count[2] , x, y);

    g.drawString( name[3] + ": " + count[3] , x + r, y);


    // Display the color squares:
    y += 5;
    x -= 2;
    g.setColor(Color.RED);
    g.fillRect(x - r, y, 10, 10);
    g.setColor(Color.GREEN);
    g.fillRect(x, y, 10, 10);
    g.setColor(Color.YELLOW);
    g.fillRect(x + r, y, 10, 10);
  }

  // Returns the number of degrees in a pie slice that
  // corresponds to count / total, rounded to the nearest integer.
  private int countToDegrees(int count, int total)
  {

    return  360 * count / total;
  }


  // Draws a sector, centered at x, y, of radius r,
  // of angle measure degrees, starting at fromDegree.
  private void drawSector(Graphics g, int x, int y, int r, int fromDegree, int degrees)
  {
    if (degrees > 359)
      g.fillOval(x - r, y - r, 2 * r, 2 * r);
    else
      g.fillArc(x - r, y - r, 2 * r, 2 * r, fromDegree, degrees);
  }
}
