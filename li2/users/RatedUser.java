package users;

public class RatedUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rated;
	
	public RatedUser(Long id, int rating) {
		super(id, null);
		this.rated = rating;
	}
	
	public int getRated() {
		return rated;
	}
	public void setRated(int rated) {
		this.rated = rated;
	}
	
	public String toString() {
		return String.format("RatedUser[id=%d, ratedAs = %d]",this.getID(), this.getRated());
	}
	
}
