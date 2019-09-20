public class EffetResistance extends EffetTemporaire {
	
	public EffetResistance(int bonus, int temps_restant) {
		super(bonus, temps_restant);
	}

	public void ajoutEffet(Hero hero) {
		hero.modifResistance(bonus);
	}
	
	public void retirerEffet(Hero hero) {
		hero.modifResistance(-bonus);
	}

	public String toString() {
		return (" + "  + bonus + " points de resistance pour " + temps_restant + " tours.");
	}
	
}
