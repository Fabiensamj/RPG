public class PotionExp extends Utilisable {

	public PotionExp(String nom, int bonus, int prix) {
		this.setNom(nom);
		this.setBonus(bonus);
		this.setPrix(prix);
	}

	public void utilise(Hero hero) {
		super.utilise(hero);
		System.out.println("Vous vous gagnez " + getBonus()+ " points d'experiences apres avoir bu cette potion.");
		hero.gainExperience(bonus);
	}

	public String toString() {
		return "Une "+ getNom();
	}
	
}
