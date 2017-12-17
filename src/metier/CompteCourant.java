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
		if(mt > solde + decouvert) throw new RuntimeException("Op�ration impossible..Solde insuffisant!");	
		this.solde -= mt;
    	Retrait versement = new Retrait(operations.size() +1, new Date(), mt); // ou bie d�clarer une variable static dans Operation.class 
    	                                                                           //et l'incr�menter � chaque fois
    	operations.add(versement);
	}

	@Override
	public void updateSolde() {
		// Ne rien faire, car c'est un compte courant.
		
	}

}
