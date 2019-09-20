public class Ruine extends Batiment {

	public Ruine(String nom) {
		super(nom);
	}
	
	public Ruine(String nom, Case caze) {
		super(nom, caze);
	}
	
	private void ruineEquipable(Hero personnage) {
		Equipable objet = null;
		switch(De.Lancer(0, 2)) {
			case 0: ; objet = new Arme("hache antique",3,25);
				break;
			case 1: objet = new Armure("armure antique",3,30);
				break;
			case 2: objet = new Bottes("paire de bottes simples",1,15);
				break;
		}
		
		System.out.println("Vous trouvez un objet equipable : " + objet );
		personnage.gainObjet(objet);
	}
	
	private void ruineUtilisable(Hero personnage) {
		Utilisable objet = null;
		objet = Utilisable.utilisableAleatoire();
		
		System.out.println("Vous trouvez un objet utilisable : " + objet );
		personnage.gainObjet(objet);
	}

	private void ruineOr(Hero personnage) {
		int or = De.Lancer(2, 5)*5;
		System.out.println("Vous trouvez un grand tresor : " + or + " pieces d'or !");
		personnage.modifOr(or);
	}

	private void ruineCompetence(Hero personnage) {
		System.out.println("Vous trouvez un grand savoir dans ces ruines (+1 pt de competence)" );
		personnage.ajoutCompetence(1);
	}
	
	private void ruinePertObjet(Hero personnage) {
		System.out.println("Au bout de longues heures d'exploration vous ne trouvez rien.");
		if (personnage.getInventaire().isEmpty())
			return;
		else {
			int obj = De.Lancer(0,personnage.getInventaire().size());
			System.out.println("Vous avez en plus perdu cette objet de votre inventaire : " + personnage.getInventaire().get(obj));
			personnage.getInventaire().remove(obj);
		}
			
	}
	
	private void ruinePertPv(Hero personnage) {
		int vie_perdu = De.Lancer(5, 12);
		System.out.println("Vous vous etes coupe sur des pierres et vous perdez de la vie.("+ -vie_perdu +" pv)");
		personnage.modifPv(-vie_perdu);
	}
	
	private void ruinePertPa(Hero personnage) {
		System.out.println("Au bout de longues heures d'exploration vous ne trouvez rien.\nVous etes maintenant extenue (perte de vos PA restant).");
		personnage.setPa(0);
	}

	public void faireActionBatiment(Hero personnage) {
		System.out.println("Vous rentrez dans une ruine.");
		switch(De.Lancer(0,6)) {
			case 0: ruineEquipable(personnage);
				break;
			case 1: ruineUtilisable(personnage);
				break;
			case 2: ruineOr(personnage);
				break;
			case 3: ruineCompetence(personnage);
				break;
			case 4: ruinePertPv(personnage);
				break;
			case 5: ruinePertPa(personnage);
				break;
			case 6: ruinePertObjet(personnage);
				break;
		}
		System.out.print("\n\n");
	}

}
