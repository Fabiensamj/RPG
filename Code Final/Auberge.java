public class Auberge extends Batiment {
	
	private Carte carte_autour;
	private Quete quete_donnee;
	
	public Auberge(String nom, Case caze,Case[][] carte) {
		super(nom, caze);
		carte_autour = new Carte(carte);
	}

	
	
	public void faireActionBatiment(Hero hero) {
		if(hero.getQuete_en_cours() == null) {
			
			if(quete_donnee == null) {
				System.out.print("L'aubergiste vous donne une quete.");
				quete_donnee = Quete.queteAleatoire(carte_autour.caseLibre());
				quete_donnee.resumeQuete();
				hero.setQuete_en_cours(quete_donnee);
				System.out.print("\n\n");
			}
			
			else
				System.out.println("Quelqu'un d'autre se charge de la quete pour l'aubergiste.");
		}
		
		else if(hero.getQuete_en_cours() == quete_donnee) {
			if(quete_donnee.verifQuete(hero)) {
				quete_donnee.rendreQuete(hero);
				quete_donnee = null;
				hero.setQuete_en_cours(null);
				System.out.print("\n\n");
			}
			else {
				System.out.println("Vous n'avez pas encore finis la quete que l'aubergiste vous a donne.\n\n");
			}
		}
		
		
		else {
			System.out.println("Vous travaillez sur une quete d'un autre aubergiste.\n\n");
		}
		
		

	}

}
