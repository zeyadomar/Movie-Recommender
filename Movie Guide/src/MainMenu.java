import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{
	
	private static final int WIDTH=1000;
	private static final int HEIGHT=1000;
	
	
	private static final int BUTTON_WIDTH=200;
	private static final int BUTTON_HEIGHT=250;
	
	private static  LinkedList<Movie> movies;
	private static Button[] testMovies;
	
	private static int count=0;
	private double[] movieIndex= new double[3];
	
	
	public MainMenu() {
	super("Movie-Guide");
	
	this.setSize(WIDTH, HEIGHT);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	movies=new LinkedList<Movie>();
	fillMovies();
	
	this.setLayout(null);
	this.getContentPane().setBackground(new Color(50, 120, 100));
	this.repaint();
	
	
	
	testMovies=new Button[6];
	for(int j=0;j<2;j++) {
	for(int i=0;i<3;i++) {
	Movie m=movies.get(count);
	m.setRating(-1);
	Button b1=new Button();
	testMovies[count]=b1;
	count++;
	
	b1.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
	b1.setMovie(m);
	b1.setText(m.getName());
	b1.setIcon(new ImageIcon("res/"+m.getName()+".jpg"));
	b1.setLocation(120+i*(60+BUTTON_WIDTH),120+ j*(60+BUTTON_HEIGHT));
	b1.addActionListener(this);
	this.add(b1);
	}}
	
	
	
	JLabel l=new JLabel();
	l.setFont(new Font("Serif", Font.BOLD, 30));
	l.setText("Please rate the above movies out of 5 :) ");
	l.setSize(500, 200);
	this.add(l);
	l.setLocation(220,700);
	this.repaint();
	
	
	
	}
	
	
	
	
	
	private void fillMovies() {
		Movie m1=new Movie("lordoftherings", 4.7, new String[]{"Action","Thriller","Adventure","Fantasy"});
		movies.add(m1);
		
		m1=new Movie("notimetodie", 5, new String[]{"Thriller","Adventure"});
		movies.add(m1);
		
		m1=new Movie("rampage", 5, new String[]{"Action","Adventure"});
		movies.add(m1);
		
		m1=new Movie("backtrack", 5, new String[]{"Horror","Thriller"});
		movies.add(m1);
		
		m1=new Movie("dunkirk", 5, new String[]{"Historical"});
		movies.add(m1);
		
		m1=new Movie("sicario", 5, new String[]{"Action","Thriller","Crime"});
		movies.add(m1);
		
		m1=new Movie("shazam", 5, new String[]{"Comedy","Adventure","Fantasy"});
		movies.add(m1);
		
		m1=new Movie("sherlock", 5, new String[]{"Mystery","Thriller","Crime"});
		movies.add(m1);
		
		m1=new Movie("thepredator", 5, new String[]{"Horror","Adventure"});
		movies.add(m1);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Button b=(Button)e.getSource();
		
		double x=Double.parseDouble(JOptionPane.showInputDialog(this," Enter rating for this movie : "));
	
		while (!(x<=5 && x>=0)) {
			x=Double.parseDouble(JOptionPane.showInputDialog(this,"please Enter  a valid rating : "));
				
		}

		b.getMovie().setRating(x);
		
		
		
		if(areAllRated()) {
			showRecMovies();
		}
	}
	
	
	
	
	private void showRecMovies() {
		
		double [] AvgGenre=new double[10];
		for(int i=0;i<count;i++)	
		{
			Movie m=movies.get(i);
			double[]ratingVec=m.getRatingVector();
			
			for(int j=0;j<ratingVec.length;j++)
			{
				AvgGenre[j]+=ratingVec[j];
				
			}
			
		}
		
		for(int j=0;j<AvgGenre.length;j++)
		{
			AvgGenre[j]/=count;
		
		}
		
		for(int i=count;i<movies.size();i++) {
			Movie m=movies.get(i);
			double[]ratingVec=m.getRatingVector();
			
			double prop=dotProduct(AvgGenre,ratingVec);
			
			movieIndex[i-count]=prop;
			
		}
		
		double max=-1;
		String movieName="";
	    for(int i=0;i<movieIndex.length;i++) {
	    	Movie m=movies.get(i+count);
	    	if(movieIndex[i]>max) {
	    		max=movieIndex[i];
	    	    movieName=m.getName();	    	}
	    	
	    }
	    
		JOptionPane.showMessageDialog(this, "recommended movies based on your recent activity");
		
		this.setEnabled(false);
		this.setVisible(false);
		new RecommendedMovies(movieName);
	}
	
	
	
	
	private double dotProduct(double[] avgGenre, double[] ratingVec) {
		
		double sum=0;
		for(int i=0;i<10;i++) {
			sum+=avgGenre[i]*ratingVec[i];
		}
		return sum;
	}





	private Boolean areAllRated() {
		for(int i=0;i<6;i++) {
			if(testMovies[i].getMovie().getRating()<0)
				return false;
		}
		
		return true;
		
	}

}
