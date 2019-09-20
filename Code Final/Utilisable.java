public abstract class Utilisable extends Objet {
	
	public static Utilisable utilisableAleatoire() {
		switch(De.Lancer(0,5)) {
			case 0: return new Potion("potion de soin",15,10);
			case 1: return new PotionExp("potion d'experience",25,10);
			case 2: return new PotionForce("potion de force",3,25,3);
			case 3: return new PotionAdresse("potion d'adresse",3,25,3);
			case 4: return new PotionResistance("potion de resistance",3,25,3);
			case 5: return new PotionMaxPv("potion qui augmente votre sante",10,25,3);
		}
		return null;
	}
	
	public void utilise(Hero hero) {
		hero.perdreObjet(this);
	}
	
}
