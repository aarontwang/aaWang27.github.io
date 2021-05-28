
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineComponent extends JComponent {
	
	private Line2D.Double l1;
	private Line2D.Double l2;
	private Line2D.Double l3;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(l1);
		g2.draw(l2);
		g2.draw(l3);
	}
	
	
	public void drawLine(int x1, int y1, int x2, int y2, int x3, int y3) {
		l1 = new Line2D.Double(new Point2D.Double((double) x1, (double) y1), new Point2D.Double((double) x2, (double) y2));
		l2 = new Line2D.Double(new Point2D.Double((double) x2, (double) y2), new Point2D.Double((double) x3, (double) y3));
		l3 = new Line2D.Double(new Point2D.Double((double) x3, (double) y3), new Point2D.Double((double) x1, (double) y1));
	}
	
	public void clearLine() {
		l1 = new Line2D.Double();
		l2 = new Line2D.Double();
		l3 = new Line2D.Double();
	}
	
	public LineComponent() {
		// TODO Auto-generated constructor stub
		l1 = new Line2D.Double(new Point2D.Double(0, 0), new Point2D.Double(0, 0));
		l2 = new Line2D.Double(new Point2D.Double(0, 0), new Point2D.Double(0, 0));
		l3 = new Line2D.Double(new Point2D.Double(0, 0), new Point2D.Double(0, 0));
	}
}
