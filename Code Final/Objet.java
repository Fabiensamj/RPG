public abstract class Objet {
	
	protected String nom;
	protected int bonus;
	protected int prix;
	
	public static Objet objetAleatoire() {
		switch(De.Lancer(0,1)) {
			case 0: return Utilisable.utilisableAleatoire();
			case 1: return Equipable.equipableAleatoire();
		}
		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}

}
