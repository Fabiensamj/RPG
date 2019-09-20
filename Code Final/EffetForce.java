public class EffetForce extends EffetTemporaire {

	public EffetForce(int bonus,int nb_tour) {
		super(bonus,nb_tour);
	}

	public void ajoutEffet(Hero hero) {
		hero.modifForce(bonus);
	}
	
	public void retirerEffet(Hero hero) {
		hero.modifForce(-bonus);
	}
	
	public String toString() {
		return (" + "  + bonus + " force pour " + temps_restant + " tours.");
	}

}
