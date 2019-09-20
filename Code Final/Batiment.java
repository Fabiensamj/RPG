public abstract class Batiment extends Entite {

	public Batiment(String nom) {
		super(nom);
			
	}
		
	public Batiment(String nom,Case caze) {
		super(nom, caze);
		caze.setBatiment(this);
			
	}
	
	public abstract void faireActionBatiment(Hero hero); // Fonction devant effectuer l'evenement du batiment.
	
}
