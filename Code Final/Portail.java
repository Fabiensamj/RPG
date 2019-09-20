public class Portail extends Batiment {
	private Case case_arrive;
	
	public Portail(String nom, Case caze,Case case_arrive) {
		super(nom, caze);
		this.case_arrive = case_arrive;
	}

	public void faireActionBatiment(Hero personnage) {
		if(case_arrive.caseLibrePersonnage()) {
			System.out.println("Vous entrez dans un portail qui vous teleporte dans un endroit inconnu.");
			personnage.changerCase(case_arrive);
		}
		else
			System.out.println("Le portail est bouche de l'autre cote.");
		System.out.print("\n\n");
	}

}
