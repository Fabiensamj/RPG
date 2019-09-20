public abstract class Quete {
	
	public static Quete queteAleatoire(Case caze) {
		if(De.Lancer(0, 1) == 0 )
			return new QueteCible(caze);
		else 
			return new QueteObjet();
	}
	
	public abstract boolean verifQuete(Hero hero);
	
	public abstract void resumeQuete();
	
	public abstract void rendreQuete(Hero hero);
	
}
