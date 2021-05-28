import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class TriangleFrame extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 600;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int count = 0;
	private LineComponent scene1;
	
	class MousePressListener implements MouseListener {
		
		public void mousePressed (MouseEvent event) {
			count ++;
			if (count%4 == 1) {
				x1 = event.getX();
				y1 = event.getY();
				scene1.drawLine(x1, y1, x1, y1, x1, y1);
				repaint();
			} else if (count%4 == 2) {
				x2 = event.getX();
				y2 = event.getY();
				scene1.drawLine(x1, y1, x2, y2, x2, y2);
				repaint();
			} else if (count%4 == 3) {
				x3 = event.getX();
				y3 = event.getY();
				scene1.drawLine(x1, y1, x2, y2, x3, y3);
				repaint();
			} else {
				x1 = 0;
				y1 = 0;
				x2 = 0;
				y2 = 0;
				x3 = 0;
				y3 = 0;
				count = 0;
				scene1.clearLine();
				repaint();
			}
			
		}
		
		public void mouseReleased (MouseEvent event) {}
		public void mouseClicked (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
		
	}
	
	public TriangleFrame() {

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		scene1 = new LineComponent();
		add(scene1);

		MouseListener listener = new MousePressListener();
		scene1.addMouseListener(listener);
	}

}
