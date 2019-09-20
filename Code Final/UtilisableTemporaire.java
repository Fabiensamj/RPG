public class UtilisableTemporaire extends Utilisable {
	
	protected EffetTemporaire effet ;
	
	public UtilisableTemporaire(String nom, int prix){
		this.nom = nom;
		this.prix = prix;
	}
	
	

	
	public EffetTemporaire getEffet() {
		return effet;
	}

	public void setEffet( EffetTemporaire effet) {
		this.effet = effet;
	}
	
	public void utilise(Hero hero) {
		super.utilise(hero);
		hero.gainEffet(effet);
		System.out.println(effet);
	}
	
}
