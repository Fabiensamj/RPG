public class QueteObjet extends Quete {
	
	public String type_objet;
	public String nom_classe_objet;
	
	public QueteObjet() {
		switch (De.Lancer(0,1)) {
			case 0: 
				type_objet = " une potion de force";
				nom_classe_objet = "PotionForce";
			case 1: 
				type_objet = " une potion d'adresse";
				nom_classe_objet = "PotionAdresse";
			case 2: 
				type_objet = " une potion de resistance";
				nom_classe_objet = "PotionResistance";
		}
	}
	
	public boolean verifQuete(Hero hero) {
		
		for(int a = 0 ; a < hero.getInventaire().size(); a++) {
			if(hero.getInventaire().get(a).getClass().getSimpleName().equals(nom_classe_objet))
				return true;
		}
		
		return false;
	}

	public void resumeQuete() {
		System.out.println("Vous devez ramener " + type_objet + " à l'auberge.");
	}

	public void rendreQuete(Hero hero) {
		System.out.println("Merci pour cet objet. Voila 25 pieces d'or et 30 points d'experiences.");
		hero.getInventaire().remove(type_objet);
	}

}
