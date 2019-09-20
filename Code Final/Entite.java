public class Entite {
	
	protected Case caze;
	protected String nom;
	
	public Entite(String nom,Case caze) {
		this.nom = nom;
		this.caze = caze;
	}
	
	public Entite(String nom) {
		this.nom = nom;
	}
	
	public Entite(Case caze) {
		this.caze = caze;
	}

	public Case getCase() {
		return caze;
	}
	public void setCase(Case caze) {
		this.caze = caze;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
