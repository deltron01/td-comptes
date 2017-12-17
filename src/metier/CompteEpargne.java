package metier;

import java.util.Date;

public class CompteEpargne extends Compte {

	private double taux;
	
	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int code, double solde, double taux) {
		super(code, solde);
		this.taux = taux;
	}

	@Override
	public void retirer(double mt) throws RuntimeException{
		if(mt > solde) throw new RuntimeException("Op�ration impossible..Solde insuffisant!");	
		this.solde -= mt;
    	Retrait versement = new Retrait(operations.size() +1, new Date(), mt); // ou bie d�clarer une variable static dans Operation.class 
    	                                                                           //et l'incr�menter � chaque fois
    	operations.add(versement);
		
	}

	@Override
	public void updateSolde() {
		solde = solde + (solde * taux /100);
		
	}

}
