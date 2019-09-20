public class PotionResistance extends UtilisableTemporaire {
	
	public PotionResistance(String nom, int bonus, int prix, int temps) {
		super(nom, prix);
		effet = new EffetResistance(bonus,temps);
	}
	
	public String toString() {
		return (nom +  " qui augmente votre resistance de + " + effet.getBonus() + " pour " + effet.getTemps_restant()+ " tours.");
	}
}
