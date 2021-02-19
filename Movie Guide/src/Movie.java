
public class Movie {

	
	private String name;
	private double rating;
	private String[]genre;
	
	private double[]ratingVector = new double[10];
	
	public Movie(String name,double rating,String[]genre) {
		this.name=name;
		this.genre=genre;
		this.setRating(rating);
		
	}

	
	
	
	
	public double[] getRatingVector() {
		
		
		return ratingVector;
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
		setRatingVector();
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}





	public void setRatingVector() {
        
		
		for(int i=0;i<genre.length;i++) {
			if(genre[i].equals(Genre.Action.toString()))
				ratingVector[0]=this.rating;
			if(genre[i].equals(Genre.Adventure.toString()))
				ratingVector[1]=this.rating;
			if(genre[i].equals(Genre.Comedy.toString()))
				ratingVector[2]=this.rating;
			if(genre[i].equals(Genre.Crime.toString()))
				ratingVector[3]=this.rating;
			if(genre[i].equals(Genre.Drama.toString()))
				ratingVector[4]=this.rating;
			if(genre[i].equals(Genre.Fantasy.toString()))
				ratingVector[5]=this.rating;
			if(genre[i].equals(Genre.Historical.toString()))
				ratingVector[6]=this.rating;
			if(genre[i].equals(Genre.Horror.toString()))
				ratingVector[7]=this.rating;
			if(genre[i].equals(Genre.Mystery.toString()))
				ratingVector[8]=this.rating;
			if(genre[i].equals(Genre.Thriller.toString()))
				ratingVector[9]=this.rating;
			
		}
	}
	
	
}
