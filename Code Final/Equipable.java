public abstract class Equipable extends Objet {
	
	private int ameliore;
	
	public static Equipable equipableAleatoire(){
		switch(De.Lancer(0, 2)) {
			case 0: return Arme.armeAleatoire();
			
			case 1: return Armure.armureAleatoire();
			
			case 2: return Bottes.bottesAleatoire();
		}
		return null;
	}
	
	public abstract void equiper(Personnage personnage);
	public abstract void desequiper(Personnage personnage);

	public int getBonus() {
		return bonus + ameliore;
	}
	
	public int getAmeliore() {
		return ameliore;
	}

	public void setAmeliore(int ameliore) {
		this.ameliore = ameliore;
	}
	
}
