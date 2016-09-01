package maf.thescout.thescoutview;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Juliette {
	private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

	public Juliette() {
	super();
	}
	 
	private String firstName;
	private String lastName;
	private int grade;
	private String gsLevel;
	private int troopNumber;
	 
	public void setFirstName(String firstName) {
	String oldName = this.firstName;
	this.firstName = firstName;
	propertyChangeSupport.firePropertyChange("name", oldName, firstName);
	}
	 
	public void addPropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.addPropertyChangeListener(l);
	}
	 
	public void removePropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.removePropertyChangeListener(l);
	}
	 
	public String getFirstName() {
	return firstName;
	}
	 
	public void setLastName(String lastName) {
	String oldLastName = this.lastName;
	this.lastName = lastName;
	propertyChangeSupport.firePropertyChange("lastName", oldLastName, lastName);
	}
	 
	public String getLastName() {
	return lastName;
	}
	
	public void setGrade(int grade){
	int oldGrade = this.grade;
	this.grade = grade;
	propertyChangeSupport.firePropertyChange("Grade", oldGrade, grade);
	}
	
	public int getGrade() {
	return grade;
	}
	
	public void setGsLevel(String gsLevel) {
	String oldGsLevel = this.gsLevel;
	this.gsLevel = gsLevel;
	propertyChangeSupport.firePropertyChange("Level", oldGsLevel, gsLevel);
	}
	 
	public String getGsLevel() {
	return gsLevel;
	}
	 
	public void setTroopNumber(int troopNumber) {
	int oldTroopNumber = this.troopNumber;
	this.troopNumber = troopNumber;
	propertyChangeSupport.firePropertyChange("Troop Number", oldTroopNumber, troopNumber);
	}
	 
	public int getTroopNumber() {
	return troopNumber;
	}
	 
	public Juliette(String firstName, String lastName, int grade, String gsLevel, int troopNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.gsLevel = gsLevel;
		this.troopNumber = troopNumber;
	}
}
