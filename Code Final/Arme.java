public class Arme extends Equipable {

	public Arme(String nom, int bonus,int prix) {
		this.setNom(nom);
		this.setBonus(bonus);
		this.setPrix(prix);
	}
	
	public static Arme armeAleatoire() {
		switch(De.Lancer(0,5)){
			case 0 : return new Arme("hache de fer",2,15);
				
			case 1 : return new Arme("epee de fer",1,10);
			
			case 2 : return new Arme("hache d'acier",3,20);
			
			case 3 : return new Arme("epee d'acier",2,15);
			
			case 4 : return new Arme("longue epee d'acier",3,25);
			
			case 5 : return new Arme("marteau d'acier",4,30);
		
		}
		return null;
		
	}
	
	public void equiper(Personnage perso) {
		if(perso.getArme_equipee() != null) {
			perso.getArme_equipee().desequiper(perso);
		}
		perso.setArme_equipee(this);
		perso.inventaire.remove(this);
	}
	
	public void desequiper(Personnage perso) {
		perso.setArme_equipee(null);
		perso.getInventaire().add(this);
	}
	
	public String toString() {
		return "Une arme nommee " + nom + " qui augmente votre attaque de " + getBonus() + ".";
	}
	
}
