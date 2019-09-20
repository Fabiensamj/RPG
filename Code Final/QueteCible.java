public class QueteCible extends Quete {
	
	Monstre cible;
	
	public QueteCible(Case caze) {
		cible = Monstre.monstreAleatoire(caze);
	}
	
	public boolean verifQuete(Hero hero) {
		if ( cible.getPv() == 0)
			return true;
		return false;
	}

	public void resumeQuete() {
		if( cible.getPv() != 0)
			System.out.println("Vous devez tuer le monstre : " + cible.getNom() + cible.getCase().getPos() );
		else
			System.out.println("Allez rendre votre quete.");
		
	}

	public void rendreQuete(Hero hero) {
		System.out.println("Vous avez finis la quete. Gain de 30 xp et 30 pieces d'or");
		hero.gainExperience(30);
		hero.modifOr(30);
	}
	
}
