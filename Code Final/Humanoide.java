public class Humanoide extends Entite {
	
	protected Inventaire inventaire;
	
	public Humanoide(String nom) {
		super(nom);
		this.inventaire = new Inventaire();
		
	}
	
	public Humanoide(String nom,Case caze) {
		super(nom,caze);
		this.inventaire = new Inventaire();
		
	}
	
	public Humanoide(String nom,Case caze,Objet[] inventaire) {
		super(nom, caze);
		this.inventaire = new Inventaire();
		for (int a = 0 ; a < inventaire.length ; a++) {
			this.inventaire.add(inventaire[a]);
		}
	}
	
	public Humanoide(String nom,Objet[] inventaire) {
		super(nom);
		this.inventaire = new Inventaire();
		for (int a = 0 ; a < inventaire.length ; a++) {
			this.inventaire.add(inventaire[a]);
		}
	}

	public Humanoide(Case caze) {
		super(caze);
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	public void perdreObjet(Objet objet) {
		inventaire.remove(objet);
	}
	
	public void perdreObjet(String nom) {
		inventaire.remove(nom);
	}
	
	public void gainObjet(Objet obj) {
		inventaire.add(obj);
	}
}
