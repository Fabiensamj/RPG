public abstract class  EffetTemporaire {
	protected int temps_restant;
	protected int bonus;
	
	public EffetTemporaire(int bonus,int temps_restant) {
		this.bonus = bonus;
		this.temps_restant = temps_restant;
	}
	
	public abstract void ajoutEffet(Hero hero);

	public abstract void retirerEffet(Hero hero);
	
	public void perteTemps(Hero hero) {
		this.temps_restant--;
		if (temps_restant == 0) {
			hero.perdreEffet(this);
		}
	}

	public int getTemps_restant() {
		return temps_restant;
	}

	public void setTemps_restant(int temps_restant) {
		this.temps_restant = temps_restant;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
