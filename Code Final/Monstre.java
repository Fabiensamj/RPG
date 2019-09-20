public class Monstre extends Personnage {

	public static Monstre monstreAleatoire(Case caze) {
		Monstre monstre = new Monstre(caze);
		monstre.setInventaire(new Inventaire());
		caze.setPersonnage(monstre);
		switch (De.Lancer(0, 3)){
		case 0: monstre.setNom("Bandit");
			break;
		case 1: monstre.setNom("Ours");
			break;
		case 2: monstre.setNom("Squelette");
			break;
		case 3: monstre.setNom("Troll");
			break;
		}
		
		switch (De.Lancer(0,3)){
		case 0: monstre.setNiveau(1);
			monstre.setForce(3);
			monstre.setAdresse(3);
			monstre.setResistance(3);
			monstre.setPv(15);
			monstre.setMaxPv(15);
			break;
		case 1: monstre.setNiveau(3);
			monstre.setForce(5);
			monstre.setAdresse(5);
			monstre.setResistance(5);
			monstre.setPv(20);
			monstre.setMaxPv(20);
			break;
		case 2: monstre.setNiveau(4);
			monstre.setForce(6);
			monstre.setAdresse(6);
			monstre.setResistance(6);
			monstre.setPv(30);
			monstre.setMaxPv(30);
			break;
		case 3: monstre.setNiveau(5);
			monstre.setForce(8);
			monstre.setAdresse(8);
			monstre.setResistance(8);
			monstre.setPv(35);
			monstre.setMaxPv(35);
			break;
		}
		
		monstre.gainObjet(Equipable.equipableAleatoire());
		((Equipable) monstre.getInventaire().get(0)).equiper(monstre);
		return monstre;
		
	}
	
	public Monstre(Case caze) {
		super(caze);
	}
	
	public Monstre(String nom, Case caze, Objet[] inventaire) {
		super(nom, caze, inventaire);
	}
	
	public Monstre(String nom, Case caze) {
		super(nom, caze);
	}
	
}
