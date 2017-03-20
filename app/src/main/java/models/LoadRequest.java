package models;

public class LoadRequest {
	public User[] users;
	public Person[] persons;
	public Event[] events;
	public String message;
	
	public LoadRequest(User[] users, Person[] people, Event[] events) {
		this.users = users;
		this.persons = people;
		this.events = events;
	}
}
