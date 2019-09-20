public class EffetAdresse extends EffetTemporaire {

	public EffetAdresse(int bonus, int temps_restant) {
		super(bonus, temps_restant);
	}

	public void ajoutEffet(Hero hero) {
		hero.gainEffet(this);
		hero.modifAdresse(bonus);
	}

	public void retirerEffet(Hero hero) {
		hero.perdreEffet(this);
		hero.modifAdresse(bonus);
	}

	public String toString() {
		return (" + "  + bonus + " points d'adresse pour " + temps_restant + " tours.");
	}
	
}
