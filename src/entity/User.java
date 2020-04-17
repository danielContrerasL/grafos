package entity;

public class User {

	private static int cont_id = 0;
	private int id;
	private String name;

	public User(String name) {
		id = cont_id++;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
