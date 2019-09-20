public class Potion extends Utilisable {
	
	public Potion(String nom, int bonus,int prix) {
		this.setNom(nom);
		this.setBonus(bonus);
		this.setPrix(prix);
	}
	
	public void utilise(Hero hero) {
		super.utilise(hero);
		System.out.print("Vous vous restaurez de " + getBonus() + " pv.");
		hero.modifPv(bonus);
	}
	
	public String toString() {
		return "Une "+ getNom();
	}

}
