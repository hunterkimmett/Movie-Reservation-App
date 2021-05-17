package model;
import java.util.ArrayList;
import java.util.LinkedList;

public class UserController {
	
	private UserDBManager udbm;
	private News news;
	
	private ArrayList<RegisteredUser> userList;
	
	public UserController() {
		udbm = new UserDBManager();
		this.userList = udbm.run();
		setNews(new News("The Room is will be on pre-sale for registered users on December 25."));
	}

	public ArrayList<RegisteredUser> getUserList() {
		return userList;
	}
	
	public void addToUserList(RegisteredUser temp) {
		userList.add(temp);
	}

	public void setUserList(ArrayList<RegisteredUser> userList) {
		this.userList = userList;
	}
	
	public static void main (String args []) {
		
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
