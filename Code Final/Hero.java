import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Personnage{
	
	protected int or;
	protected int pa;
	protected int maxpa;
	protected Quete quete_en_cours;
	protected ArrayList<EffetTemporaire> liste_effet = new ArrayList<EffetTemporaire>() ;
	
	//-------------------------------------------------------------------CONSTRUCTEUR ----------------------------------------------------------------------------------------------------//
	
	public Hero(String nom) {
		super(nom);
		init();
	}
	
	public Hero(String nom, Case caze) {
		super(nom, caze);
		init();
	}
	
	public Hero(String nom,Case caze, Objet[] inventaire) {
		super(nom, caze,inventaire);
		init();
	}
	
	public Hero(String nom,Objet[] inventaire) {
		super(nom,inventaire);
		init();
	}
	
	public void init() {
		setMaxPa(5);
		setPv(20);
		setMaxPv(20);
		setNiveau(1);
		setPa(0);
	}
	
	//------------------------------------------------------ ACTIONS --------------------------------------//
	public void resume() {
		System.out.println("\n" + getCase().getPos());
		this.afficherEquipee();
		this.afficherEffet();
		System.out.println("Vous etes niveau " + this.getNiveau()+".");
		System.out.println("Force: "+ this.getForce()+"\n"+
							"Adresse: " + this.getAdresse() +"\n"+
							"Resistance: "+this.getResistance() +"");
		System.out.println("Il vous reste " + pv + "/" + maxpv+" points de vies.");
		if(quete_en_cours != null)
			quete_en_cours.resumeQuete();
		else
			System.out.println("Vous n'avez aucune quete en cours.");
		System.out.println("Vous avez " + or + " piece(s) d'or" + "\n");
	}
	
	public void gestionInventaire() {
		Scanner sc = new Scanner(System.in);
		String choix = "";
		do {
			
			System.out.println("Dans ce menu vous pouvez gerer votre inventaire.(equiper/utiliser/sortir)");
			choix = sc.nextLine();
			
		}while(choix.length() < 1);
		
		if(choix.charAt(0) == 'e' || choix.charAt(0) == 'e' || choix.charAt(0) == 'E')
			this.equiperObjet();
		else if(choix.charAt(0) == 'u' || choix.charAt(0) == 'U')
			if(pa >= 1)
			this.utiliserObjet();
			else
				System.out.println("Vous n'avez pas assez de pa pour cette action.");
		else if(choix.charAt(0) == 's')
			return ;
			
	}
	
	public void utiliserObjet() {
		Scanner sc =new Scanner(System.in);
		ArrayList <Utilisable> liste_utilisable = inventaire.getUtilisable();
		for(int a = 0 ; a < liste_utilisable.size() ; a++) {
			System.out.println( (a+1) + "." + liste_utilisable.get(a) );
		}
		
		int choix = 0;
		do {
			System.out.println("Choisissez l'objet a utiliser. (mettez le numero, si 0 alors rien.)");
			try {
				choix = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Il faut uniquement entrer un nombre.");
				choix = -1;
			}
			
		}while(choix < 0 || choix > liste_utilisable.size());
		
		if (choix == 0)
			return;
		
		liste_utilisable.get(choix-1).utilise(this);
		modifPa(-1);
	}
	
	public void equiperObjet() {
		Scanner sc =new Scanner(System.in);
		ArrayList <Equipable> liste_equipable = inventaire.getEquipable();
		
		if(liste_equipable.size() == 0) {
			System.out.println("Vous n'avez pas d'objet a equiper.");
			return;
		}
			
		for(int a = 0 ; a < liste_equipable.size() ; a++) {
			System.out.println( (a+1) + "." + liste_equipable.get(a) );
		}
		int choix = 0;
		do {
			System.out.println("Choisissez l'arme a equiper. (mettez le numero, si 0 alors rien.)");
			try {
				choix = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Il faut uniquement entrer un nombre.");
				choix = -1;
			}
			
		}while(choix < 0 || choix > liste_equipable.size());
		
		if (choix == 0)
			return;
		
		liste_equipable.get(choix-1).equiper(this);
	}
	
	public void afficherEquipee() {
		System.out.println("Liste des objets equipes:");
		int nb = 0;
		if (arme_equipee != null) {
			System.out.println(arme_equipee);
			nb++;
		}
		if (armure_equipee != null) {
			System.out.println(armure_equipee);
			nb++;
		}
		if (bottes_equipees != null) {
			System.out.println(bottes_equipees);
			nb++;
		}
		if (nb == 0)
			System.out.println("Vous n'avez aucun objet equipe.\n");
	}
	
	public void afficherEffet() {
		System.out.println("Liste des objets effets:");
		if (liste_effet.size() == 0 )
			System.out.println("Vous n'avez aucun effet actif.\n");
		else {
			for(int a = 0 ; a < liste_effet.size() ; a++ ) {
				System.out.println(liste_effet.get(a));
			}
		}
	}
	
	public void ajoutCompetence(int pt) {
		System.out.print("Vous avez " + pt +" points de competences a ajouter. ");
		Scanner sc =new Scanner(System.in);
		String choix;
		int f_agm = 0 ;
		int a_agm = 0 ;
		int r_agm = 0 ;
		while(pt > 0) {
			
			System.out.println("Ou voulez vous ajouter un point de competences ? (force/adresse/resistance)");
			choix = sc.nextLine();
			while (choix.equals("force") != true && choix.equals("adresse") != true  && choix.equals("resistance") != true ) {
				System.out.print("Choisissez bien soit force soit adresse soit resistance : ");
				choix = sc.nextLine();
			}
			
			if(choix.equals("force")) {
				this.force ++;
				f_agm ++;
			}
			
			else if(choix.equals("resistance")) {
				this.resistance ++;
				r_agm++;
			}
			
			else {
				this.setAdresse(this.getAdresse() + 1);
				a_agm++;
			}
			pt--;
		}
		System.out.println("Recap : Vous avez ajoute " + f_agm + " points en force, " + a_agm + " en adresse et " + r_agm + " en resistance.");
		
	}
	
	public void gainExperience(int exp) {
		int niveau_gagne = 0;
		while(isNiveauGagnee(exp)) {
			this.experience = 0;
			exp += this.experience - niveau*5;
			niveau++;
			niveau_gagne++;
		}
		
		this.experience += exp;
		if (niveau_gagne != 0) {
			System.out.println("Vous avez gagne " + niveau_gagne + " niveau(x).");
			this.ajoutCompetence(niveau_gagne);
		}
	}
	
	public boolean isNiveauGagnee(int exp) {
		return this.experience + exp > niveau*5;
	}
	
	public abstract void combattre (Personnage personnage);
	
	public void mort() {
		super.mort();
		setPa(0);
	}
	// ------------------------------------------ METHODE DEPLACEMENT ---------------------------------------//
	public void changerCase(Case caze) {
		this.caze.setPersonnage(null);
		this.setCase(caze);
		caze.setPersonnage(this);
		if(caze.getBatiment() != null) {
			caze.getBatiment().faireActionBatiment(this);
		}
	}
	
	public int coutPa(String action) {
		if (action.equals("deplacement")) {

			if (bottes_equipees != null)
				return  -1;
			
			else return -2;
		}
		
		else if (action.equals("combat")) {
			return -3;
		}
			
		else return 0;
	}
	
	public void reinitialiserPa() {
		pa = maxpa;
	}
	
	// --------------------------------------------------------------------- GETTER ET SETTER ---------------------------------------------------------------------------------------- //
	
	public int getPa() {
		return pa;
	}
	
	public void setPa(int pa) {
		this.pa =  pa;
	}
	
	public void modifPa(int pa) {
		this.pa +=  pa;
	}
	
	public int getMaxPa() {
		return maxpa;
	}
	
	public void setMaxPa(int maxpa) {
		this.maxpa =  maxpa;
	}
	
	public int getOr() {
		return or;
	}
	
	public void setOr(int or) {
		this.or =  or;
	}
	
	public Quete getQuete_en_cours() {
		return quete_en_cours;
	}

	public void setQuete_en_cours(Quete quete_en_cours) {
		this.quete_en_cours = quete_en_cours;
	}

	public void modifOr(int or) {
		this.or +=  or;
	}
	
	public void gainObjet(Objet obj) {
		if(obj.getClass().getSuperclass().getSimpleName().equals("Equipable")) {
			((Equipable) obj).equiper(this);
		}
		else
			super.gainObjet(obj);
	}
	
	public ArrayList<EffetTemporaire> getListeEffet() {
		return liste_effet;
	}

	public void setListeEffet( ArrayList<EffetTemporaire> liste_effet) {
		this.liste_effet = liste_effet;
	}
	
	public void perdreEffet(EffetTemporaire effet) {
		effet.retirerEffet(this);
		liste_effet.remove(effet);
		
	}
	
	
	public void gainEffet(EffetTemporaire effet) {
		effet.ajoutEffet(this);
		liste_effet.add(effet);
	}
	
}
