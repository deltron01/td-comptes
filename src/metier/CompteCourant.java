package metier;

import java.util.Date;

public class CompteCourant extends Compte {

	private double decouvert;
	
	
	public CompteCourant() {
		super();
	}

	public CompteCourant(int code, double solde, double decouvert) {
		super(code, solde);
		this.decouvert = decouvert;
	}

	@Override
	public void retirer(double mt) throws RuntimeException {
		if(mt > solde + decouvert) throw new RuntimeException("Opération impossible..Solde insuffisant!");	
		this.solde -= mt;
    	Retrait versement = new Retrait(operations.size() +1, new Date(), mt); // ou bie déclarer une variable static dans Operation.class 
    	                                                                           //et l'incrémenter à chaque fois
    	operations.add(versement);
	}

	@Override
	public void updateSolde() {
		// Ne rien faire, car c'est un compte courant.
		
	}

}
