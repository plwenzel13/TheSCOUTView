package maf.thescout.thescoutview;

import java.util.List;
import maf.thescout.data.Data;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Juliettes {
	private List<Juliette> s_juliettes = null;
	private Juliette[] juliettes = null;
	 
	public void setJuliettes(Juliette[] juliettes) {
	Juliette[] oldJuliettes = this.juliettes;
	this.juliettes = juliettes;
	propertyChangeSupport.firePropertyChange("Juliettes", oldJuliettes, juliettes);
	}
	 
	public Juliette[] getJuliettes() {
	return juliettes;
	}
	 
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	 
	public Juliettes() {
		super();
	
		// pull from data.java
		this.s_juliettes = Data.getJuliettesDatabase();
		//this.s_juliettes = Data.main(null);

		this.setJuliettes((Juliette[]) s_juliettes.toArray(new Juliette[s_juliettes.size()]));
		}
	 
	public boolean addJuliette(String firstName, String lastName, int grade, String gsLevel, int troopNumber) {
	// add juliettes
	s_juliettes.add(new Juliette(firstName, lastName, grade, gsLevel, troopNumber));
	this.setJuliettes((Juliette[]) s_juliettes.toArray(new Juliette[s_juliettes.size()]));
	return true;
	}
	 
	public void addPropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.addPropertyChangeListener(l);
	}
	 
	public void removePropertyChangeListener(PropertyChangeListener l) {
	propertyChangeSupport.removePropertyChangeListener(l);
	}
}
