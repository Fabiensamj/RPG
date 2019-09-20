public class Armure extends Equipable {
	
	public Armure(String nom, int bonus,int prix) {
		this.setNom(nom);
		this.setBonus(bonus);
		this.setPrix(prix);
	}
	
	public static Armure armureAleatoire() {
		switch(De.Lancer(0,3)){
			case 0 : return new Armure("armure de cuir",1,10);
				
			case 1 : return new Armure("armure de fer",2,15);
			
			case 2 : return new Armure("armure d'acier",3,20);
			
			case 3 : return new Armure("armure de qualite",4,25);
		
		}
		return null;
		
		
	}
	
	public void equiper(Personnage perso) {
		if(perso.getArmure_equipee() != null) {
			perso.getArmure_equipee().desequiper(perso);
		}
		perso.setArmure_equipee(this);
		perso.inventaire.remove(this);
	}
	
	public void desequiper(Personnage perso) {
		perso.setArmure_equipee(null);
		perso.getInventaire().add(this);
	}
	
	public String toString() {
		return "Une armure nommee " + nom + " qui augmente votre armure de " + getBonus() + ".";
	}
}
