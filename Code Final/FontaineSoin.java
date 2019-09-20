public class FontaineSoin extends Batiment {
	
	public FontaineSoin(String nom,Case caze) {
		super(nom,caze);
	}
		
	public FontaineSoin(String nom) {
		super(nom);
	}
	
	
	public void faireActionBatiment(Hero hero) {
		System.out.println("Vous arrivez pres d'une fontaine de soin !");
		if(hero.getPv() == hero.getMaxPv()) {
			System.out.println("Comme vous avez deja toute votre vie vous remplissez une gourde de l'eau de la fontaine pour qu'elle serve plus tard. (gain d'une potion de soin) ");
			System.out.print("\n\n");
			hero.gainObjet(new Potion("Potion de la fontaine",15,10));
		}
		
		else {
			System.out.println("Vous buvez de l'eau de cette fontaine et vous vous santez revigore ! (gain 15 pv)");
			System.out.print("\n\n");
			hero.modifPv(15);
		}
		
	}

}
