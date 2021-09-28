package core.view;

import java.util.Scanner;

import core.controller.SearchMethod;
import core.controller.SortMethod;
import core.model.Order;
import core.model.TableInteger;

public class TableIntegerRead {
	
	private Scanner scan;
	
	
	public TableIntegerRead() {
		this.scan = new Scanner(System.in);
	}
	
	public void readTable(TableInteger tab) {
		for(int i = 0;i<tab.getSize();i++) {
			TableIntegerShow.display("Veullez entrer la valeur " + (i+1)  + " du tableau");
			tab.setValue(i, this.scan.nextInt());
		}
	}
	
	public int readPositifInt() { 
		TableIntegerShow.display("Veuillez entrer la taille du tableau");
		
		int integer = this.scan.nextInt();
		
		while(integer<=0) {
			TableIntegerShow.display("La taille du tableau doit etre strictement superieur a 0");
			integer = this.scan.nextInt();
		}
		
		return integer;
	}
	
	public int readIntToSearch() {
		TableIntegerShow.display("Veuillez entrer l'entier a rechercher");
		return this.scan.nextInt();
	}
	
	public Order readOrder() {
		Order order;
		TableIntegerShow.display("Veuillez entrer l'entier correspondant a l'ordre dans lequel vous voulez trier le tableau");
		TableIntegerShow.display("1. ordre croissant\n2. ordre decroissant");
		int userData = this.scan.nextInt();
		while(userData!=1 && userData!=2) {
			TableIntegerShow.display("1. Ordre croissant\n2. Ordre decroissant");
			userData = this.scan.nextInt();
		}
		
		if(userData==1) {
			order = Order.ASC;
		}
		else {
			order = Order.DESC;
		}
		return order;
	}
	
	public SearchMethod readSearchMethod() {
		SearchMethod method=SearchMethod.Dicho;
		int n;
		do {
		TableIntegerShow.display("Veuillez saisir la methode de recherche");
		TableIntegerShow.display("1. Recherche dichotomique");
		TableIntegerShow.display("2. Recherche lineaire");
		TableIntegerShow.display("3. Recherche exponentielle");
		TableIntegerShow.display("4. Recherche par saut");
		n = this.scan.nextInt();
		switch(n) {
		case 1:{
			method = SearchMethod.Dicho;
		}break;
		
		case 2:{
			method = SearchMethod.Linear;
		}break;
		
		case 3:{
			method = SearchMethod.Exp;
		}break;
		
		case 4:{
			method = SearchMethod.Jump;
		}break;
		
		default:{
			TableIntegerShow.display("valeur invalide");
		}
		
		}
		
		}while(n<1 || n>4);
		
		return method;
	}
	
	public SortMethod readSortMethod() {
		SortMethod method=SortMethod.Fast;
		int n;
		do {
		TableIntegerShow.display("Veuillez saisir la methode de tri");
		TableIntegerShow.display("1. tri rapide");
		TableIntegerShow.display("2. tri a bulle");
		TableIntegerShow.display("3. tri par insertion");
		TableIntegerShow.display("4. tri par selection");
		n = this.scan.nextInt();
		switch(n) {
		case 1:{
			method = SortMethod.Fast;
		}break;
		
		case 2:{
			method = SortMethod.Bubble;
		}break;
		
		case 3:{
			method = SortMethod.Insert;
		}break;
		
		case 4:{
			method = SortMethod.Select;
		}break;
		
		default:{
			TableIntegerShow.display("valeur invalide");
		}
		
		}
		
		}while(n<1 || n>4);
		
		return method;
	}
}
