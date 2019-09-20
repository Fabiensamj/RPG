public class PotionForce extends UtilisableTemporaire {

	public PotionForce(String nom, int bonus, int prix, int temps) {
		super(nom, prix);
		effet = new EffetForce(bonus,temps);
	}
	
	public String toString() {
		return (nom +  " qui augmente votre force de + " + effet.getBonus() + " pour " + effet.getTemps_restant()+ " tours.");
	}

}
