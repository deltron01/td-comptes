package manip;

import java.util.List;

import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Operation;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Compte cp1 = new CompteCourant(1, 8000, 5000);
		Compte cp2 = new CompteEpargne(2, 30000, 5.5);
		try{
		cp1.verser(50000);
		cp1.retirer(3000);
		cp1.verser(4000);
		cp1.retirer(7000);
		cp1.virement(400, cp2);
		System.out.println(">> Solde du compte cp1 : " + cp1.consulterSolde() + " DH");
		System.out.println(">> Solde du compte cp2 : " + cp2.consulterSolde() + " DH");	
		
		List<Operation> listOperations = cp1.getOperations();
		System.out.println(">> Historique des opérations : ");
		System.out.println("---------------------------------");
		for(Operation op : listOperations){
			System.out.println(">> " + op.getClass().getSimpleName() + " -- N° : " + op.getNumero() 
					+ " -- Date : " + op.getDateOperation() + " -- Montant : "
					+ op.getMontant() + " DH");
		}
		System.out.println("=============================================");
		System.out.println(">> Total des versements du compte cp1 : " + cp1.totalVersements() + "DH");
		System.out.println(">> Total des retraits du compte cp1 : " + cp1.totalRetraits() + "DH");
		
		System.out.println(">> Mettre à jour le solde");
		cp1.updateSolde(); cp2.updateSolde();
		System.out.println(">> Solde du compte cp1 : " + cp1.consulterSolde() + " DH");
		System.out.println(">> Solde du compte cp2 : " + cp2.consulterSolde() + " DH");	
		cp1.retirer(960024000);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
