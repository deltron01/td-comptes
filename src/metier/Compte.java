package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
	
	private int code;
	protected double solde;
	protected List<Operation> operations = new ArrayList<>();
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
    public void verser(double mt){
    	this.solde += mt;
    	Versement versement = new Versement(operations.size() +1, new Date(), mt); // ou bie déclarer une variable static dans Operation.class 
    	                                                                           //et l'incrémenter à chaque fois
    	operations.add(versement);
    }
    public abstract void retirer(double mt);
    public void virement(double mt, Compte cp2){
    	retirer(mt);
    	cp2.verser(mt);
    }
    public double consulterSolde(){
    	return this.solde;
    }
    public abstract void updateSolde();
    
    public List<Operation> getOperations(){
    	return this.operations;
    }
    public double totalVersements(){
    	double somme = 0;
    	for(Operation op : this.operations){
    		if(op instanceof Versement){
    			somme += op.getMontant();
    		}
    	}
    	return somme;
    }
    public double totalRetraits(){
    	double somme = 0;
    	for(Operation op : this.operations){
    		if(op instanceof Retrait){
    			somme += op.getMontant();
    		}
    	}
    	return somme;
    }
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
    
}
