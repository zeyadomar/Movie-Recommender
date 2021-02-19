import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RecommendedMovies extends JFrame{
	
	public RecommendedMovies(String movieName) {
		
		super("recomended movies");
		
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Button b1=new Button();
		
		b1.setSize(250, 250);
		b1.setLocation(300,300);
		b1.setIcon(new ImageIcon("res/"+movieName+".jpg"));
		
		this.add(b1);
	
		this.repaint();
		
	}

}
