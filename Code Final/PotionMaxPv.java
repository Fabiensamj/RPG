public class PotionMaxPv extends UtilisableTemporaire {

	public PotionMaxPv(String nom,int bonus ,int prix, int temps) {
		super(nom, prix);
		effet = new EffetMaxVie(bonus,temps);
	}
	
	public String toString() {
		return (nom +  " qui augmente vos points de vies de + " + effet.getBonus() + " pour " + effet.getTemps_restant()+ " tours.");
	}

}
