
public class Archer extends Hero {
	public Archer(String nom) {
		super(nom);
		init();
		init2();

	}
	
	public Archer(String nom, Case caze) {
		super(nom, caze);
		init();
		init2();

	}
	
	public Archer(String nom,Case caze, Objet[] inventaire) {
		super(nom, caze,inventaire);
		init();
		
		init2();
	}

	public void init2() {
		
		setForce(5);
		setAdresse(5);
		setResistance(5);
		
	}
	public String toString(){
		return "Archer";
	}
	public void combattre(Personnage personnage) {
		int attaque = getAttaque() + De.Lancer(0,6);
		int esquive =personnage.getEsquive()+De.Lancer(0,6);
		int degat = getDegat()*2+De.Lancer(0,6) + De.Lancer(0,6);
		int defense =personnage.getDefense()+De.Lancer(0,6);
		if(attaque >= esquive) {
			System.out.println(this.getNom()+" tire une fleche " + personnage.getNom() + " avec " + attaque + " de chance de le toucher contre " +
		getEsquive() + " de chance d'esquiver\n");
			if(degat>defense) {
				System.out.println(this.getNom()+" blesse " + personnage.getNom() + " avec " + degat + " de degats contre " + defense+ 
						" de defense\n");
				personnage.modifPv( defense - degat);
				if(personnage.getCase() == null) {
					System.out.println("Vous gagnez " + personnage.getNiveau()*3 + " points d'experiences et tout l'inventaire de " + personnage.getNom() +".");
					getInventaire().gainInventaire(personnage.getInventaire());
					gainExperience(personnage.getNiveau()*3);
					if(personnage.getClass().getSuperclass().getSimpleName().equals("Hero")) {
						this.modifOr( ((Hero) personnage).getOr());
						System.out.println(" Vous avez egalement gagner l'or de votre adversaire, soit " + ((Hero) personnage).getOr() + " pieces d'or.");
					}
					return;
					
				}
			} 
			else {
				System.out.println(personnage.getNom() + " s'en sort indemne grace a " + defense + " de defense contre " + degat + " de degat\n");
			}
		}
		
		else {
			System.out.println(personnage.getNom()+" esquive "+ this.getNom()+" avec " + esquive+" de chance d'esquiver contre " +  attaque+ 
					" de chance d'attaque\n");
		}
	}
}
