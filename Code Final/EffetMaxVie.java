public class EffetMaxVie extends EffetTemporaire {

	public EffetMaxVie(int bonus, int temps_restant) {
		super(bonus, temps_restant);
	}

	public void ajoutEffet(Hero hero) {
		
		hero.modifMaxPv(bonus);
		hero.modifPv(bonus);
		
	}

	public void retirerEffet(Hero hero) {
		hero.modifMaxPv(-bonus);
		hero.modifPv(0);
	}
	
	public String toString() {
		return (" + "  + bonus + " points de vies pour " + temps_restant + " tours.");
	}

}
