import java.util.ArrayList;
import java.util.Scanner;

public abstract class  Personnage extends Humanoide {

	protected int pv;
	protected int maxpv;
	protected int force;
	protected int adresse;
	protected int resistance;
	protected int niveau;
	protected int experience;
	protected Arme arme_equipee;
	protected Armure armure_equipee;
	protected Bottes bottes_equipees;
	
	public Personnage(String nom) {
		super(nom);
	}
	
	public Personnage(Case caze) {
		super(caze);
	}
	
	public Personnage(String nom, Case caze) {
		super(nom, caze);
		caze.setPersonnage(this);
	}
	
	public Personnage(String nom,Case caze, Objet[] inventaire) {
		super(nom, caze,inventaire);
		caze.setPersonnage(this);
	}
	
	public Personnage(String nom,Objet[] inventaire) {
		super(nom,inventaire);
	}
	
	public void toutDesequiper() {
		if (arme_equipee != null) 
			arme_equipee.desequiper(this);
		if (armure_equipee != null) 
			armure_equipee.desequiper(this);
		if (bottes_equipees != null) 
			bottes_equipees.desequiper(this);
	}
	
	public void riposte(Hero hero) {
		System.out.println(getNom() + " tentes une ripostes.");
		int attaque = getAttaque() + De.Lancer(0,6);
		int esquive = hero.getEsquive()+De.Lancer(0,6);
		int degat = getDegat()+De.Lancer(0,6);
		int defense = hero.getDefense()+De.Lancer(0,6);
		if(attaque >= esquive) {
			System.out.println(this.getNom()+" attaque " + hero.getNom() + " avec " + attaque + " de chance d'attaquer contre " +
		esquive + " de chance d'esquiver\n");
			if(degat>defense) {
				System.out.println(this.getNom()+" blesse " + hero.getNom() + " avec " + degat + " de degats contre " + defense+ 
						" de defense\n");
				hero.modifPv( defense-degat);
			} 
			else {
				System.out.println(hero.getNom() + " s'en sort indemne grace a " + defense + " de defense contre " + degat + " de degat\n");
			}
		}
		
		else {
			System.out.println(hero.getNom()+" esquive "+ this.getNom()+" avec " + esquive+" de chance d'esquiver contre " +  getAttaque()+ 
					" de chance d'attaque\n");
		}
	}
	
	// --------------------------- METHODES SUR LES CARACTERISTIQUES -------------------------------//
	
	public void mort() {
		System.out.println(this.getNom() + " viens de mourir.");
		this.toutDesequiper();
		setPv(0);
		getCase().setPersonnage(null);
		setCase(null);
		
	}
	
	public void modifPv(int modif) {
		if (this.pv + modif > this.maxpv)
			this.pv = maxpv;
		else if (this.pv + modif <= 0)
			this.mort();
		else 
			this.pv += modif;
	}
	
	public void modifMaxPv(int modif) {
		maxpv += modif;
	}
	
	// --------------------------- METHODES SUR LES STATS ------------------------------------------//
	
	public int getAttaque() {
		if (arme_equipee != null)
			return force + getAdresse();
		return force;
	}
	
	public int getDegat() {
		if(arme_equipee != null)
			return force + arme_equipee.getBonus();
		return force;
	}
	
	public int getDefense() {
		if (armure_equipee != null)
			return resistance + armure_equipee.getBonus();
		return resistance;
	}
	
	public int getEsquive() {
		if(armure_equipee != null)
			return getAdresse() - armure_equipee.getBonus();
		return getAdresse();
	}
	
	// --------------------------- GETTER ET SETTER ------------------------------------------//
	
	public int getAdresse() {
		if (bottes_equipees != null)
			return adresse + bottes_equipees.getBonus();
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	
	public void modifAdresse(int bonus) {
		adresse += bonus;
	}
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}
	

	public void modifForce(int force) {
		this.force += force;
	}
	
	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	
	public void modifResistance(int bonus) {
		resistance += bonus;
		
	}
	
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public int getMaxPv() {
		return maxpv;
	}

	public void setMaxPv(int maxpv) {
		this.maxpv = maxpv;
	}
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	public Arme getArme_equipee() {
		return arme_equipee;
	}

	public void setArme_equipee(Arme arme_equipee) {
		this.arme_equipee = arme_equipee;
	}

	public Armure getArmure_equipee() {
		return armure_equipee;
	}

	public void setArmure_equipee(Armure armure_equipee) {
		this.armure_equipee = armure_equipee;
	}

	public Bottes getBottes_equipees() {
		return bottes_equipees;
	}

	public void setBottes_equipees(Bottes bottes_equipees) {
		this.bottes_equipees = bottes_equipees;
	}

}
