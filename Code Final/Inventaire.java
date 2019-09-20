import java.util.ArrayList;

public class Inventaire extends ArrayList<Objet> {
	
	public Objet get(String nom) {
		for (int a = 0 ; a < this.size() ; a++) {
			if ( this.get(a).getNom().equals(nom))
				return this.get(a);
		}
		return null;
	}
	
	public void remove(String nom) {
		for (int a = 0 ; a < this.size() ; a++) {
			if ( this.get(a).getNom().equals(nom))
				this.remove(a);
		}
	}
	
	public void gainInventaire(Inventaire inventairegain) {
		for(int a = 0 ; a < inventairegain.size() ; a++) {
			this.add(inventairegain.get(a));
		}
	}
	
	public ArrayList<Utilisable> getUtilisable() {
		ArrayList<Utilisable> retour = new ArrayList<Utilisable>();
		for(int a = 0 ; a < this.size() ; a++) {
			if(this.get(a).getClass().getSuperclass().getSimpleName().equals("Utilisable") || this.get(a).getClass().getSuperclass().getSimpleName().equals("UtilisableTemporaire"))
				retour.add((Utilisable)this.get(a));
		}
		return retour;
	}
	
	public ArrayList<Equipable> getEquipable() {
		ArrayList<Equipable> retour = new ArrayList<Equipable>();
		for(int a = 0 ; a < this.size() ; a++) {
			if(this.get(a).getClass().getSuperclass().getSimpleName().equals("Equipable"))
				retour.add((Equipable)this.get(a));
		}
		return retour;
		
	}
}
