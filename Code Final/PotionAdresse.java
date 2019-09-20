public class PotionAdresse extends UtilisableTemporaire {
		
	public PotionAdresse(String nom, int bonus, int prix, int temps) {
		super(nom,prix);
		effet = new EffetAdresse(bonus,temps);
		
	}
	
	public String toString() {
		return (nom +  " qui augmente votre adresse de + " + effet.getBonus() + " pour " + effet.getTemps_restant()+ " tours.");
	}
}
