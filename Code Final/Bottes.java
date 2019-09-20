public class Bottes extends Equipable {

	public Bottes(String nom, int bonus,int prix) {
		this.setNom(nom);
		this.setBonus(bonus);
		this.setPrix(prix);
	}
	
	public static Bottes bottesAleatoire() {
		switch(De.Lancer(0,3)){
			case 0 : return new Bottes("bottes de cuir",2,15);
				
			case 1 : return new Bottes("bottes en peaux",1,10);
			
			case 2 : return new Bottes("bottes tres confortable",3,20);
			
			case 3 : return new Bottes("bottes enchantes",4,25);
			

		}
		return null;
		
		
	}
	
	public void equiper(Personnage perso) {
		if(perso.getBottes_equipees() != null) {
			perso.getBottes_equipees().desequiper(perso);
		}
		
		perso.setBottes_equipees(this);
		perso.inventaire.remove(this);
	}
	
	public void desequiper(Personnage perso) {
		perso.setBottes_equipees(null);
		perso.getInventaire().add(this);
	}
	
	public String toString() {
		return "Une paire de " + nom + " qui reduit le couts de vos deplacement de " + 1 + " et augmente votre adresse de " + getBonus()+".";
	}
}
