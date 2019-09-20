public class Case {
	
	private String type;
	private Position pos;
	private boolean franchissable;
	private Personnage personnage;
	private Batiment batiment;
	
	public Case(int x, int y) {
		this.setType("terre");
		this.setFranchissable(true);
		this.setPos(new Position(x,y));
		this.setPersonnage(null);
		this.setBatiment(null);
	}
	
	public Case(int x, int y,String type) {
		this.setType(type);
		
		if (type.equals("mur") || type.equals("eau") || type.equals("foret"))
			this.setFranchissable(false);
		else
			this.setFranchissable(true);
		
		this.setPos(new Position(x,y));
		this.setPersonnage(null);
		this.setBatiment(null);
	}
	
	public boolean caseLibrePersonnage() {
		return (personnage == null && franchissable);
	}
	
	public boolean caseLibreBatiment() {
		return (batiment == null && franchissable);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public boolean isFranchissable() {
		return franchissable;
	}

	public void setFranchissable(boolean franchissable) {
		this.franchissable = franchissable;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}
	
	
	
}
