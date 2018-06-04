package users;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aliu
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String email;
	private String name;
	private Date birthday;
	private Long rating;
	
	public User() {
		this(null,null,null,null,null);
	}
	
	public User(String username, String email, String name) {
		this(null,username,email,name,null);
	}
	
	public User(Long id, String username, String email, String name, Date birthday) {
		this.setEmail(email);
		this.setUsername(username);
		this.setName(name);
		this.setBirthday(birthday);
		this.id = id;
		setup();
	}	
	
	public User(String username, String email, String name, Date birthday) {
		this(null, username, email, name, birthday);
	}	
	
	public User(User other) {
		this(null, other);
	}
	
	public User(Long id, User other) {
		if (other != null) {
			username = other.getUsername();
			email = other.getEmail();
			name = other.getName();
			birthday = other.getBirthday();
		} else {
			this.setEmail(null);
			this.setUsername(null);
			this.setName(null);
			this.setBirthday(null);
		}
		this.id = id;
		setup();
	}
	
	private void setup() {
		if (username != null && !checkValidUsername(username))
			throw new IllegalArgumentException("Username was wonky as heck.");
		if (name != null && !checkValidName(name))
			throw new IllegalArgumentException("Name contains illegal special characters.");
		if (email != null && !checkValidEmail(email))
			throw new IllegalArgumentException("Email isn't formatted correctly.");
		
	}

	public final static boolean checkValidUsername(String username) {
		return username.split("[^_A-Za-z0-9]|.(?=[^_A-Za-z0-9])").length == 1 && username.trim().length() != 0;
	}
	public final static boolean checkValidEmail(String email) {
		return email.contains("@") && !email.contains(" ");
	}
	
	public final static boolean checkValidName(String name) {
		return !(!name.split("[^\\-A-Za-z ]|(?<![a-zA-Z])[-]|[-](?![A-Za-z])")[0].equals(name)|| name.endsWith("-") || name.trim().length() == 0);
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		if (username != null && !checkValidUsername(username))
			throw new IllegalArgumentException("'" + username + "' is a wonky username. Too wonky. Try again.");
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if (email != null && !checkValidEmail(email))
			throw new IllegalArgumentException("'" + email + "' isn't a correctly formatted email.");
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name != null && !checkValidName(name))
			throw new IllegalArgumentException("'" + name + "' contains illegal special characters.");
		this.name = name;
	}

	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	 
	 public Long getID() {
		 return id;
	 }
	 
	 public void setID(Long id) {
		 this.id = id;
	 }

	
	  /**
     * The user ID is unique for each User. So this should compare User by ID only.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof User) && (getID() != null)
             ? getID().equals( ( (User) other).getID() )
             : (other == this);
    }
    
    public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

    /**
     * The user ID is unique for each User. So User with same ID should return same hashcode.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return (getID() != null)
             ? (this.getClass().hashCode() + getID().hashCode()) 
             : super.hashCode();
    }

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("User[id=%d,username=%s,email=%s,name=%s,birthdate=%s]", 
        					getID(), username, email, name, birthday);
    }

	
	
	
	
	
}
