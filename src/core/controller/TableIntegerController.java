package core.controller;

import core.model.Order;
import core.model.TableInteger;
import core.view.TableIntegerRead;
import core.view.TableIntegerShow;

public class TableIntegerController {
	
	private TableInteger tab;
	private TableIntegerShow featuresShow;
	private TableIntegerRead featuresRead;	
	
	public TableIntegerController() {
		this.featuresShow = new TableIntegerShow();
		this.featuresRead = new TableIntegerRead();
		this.tab = new TableInteger(featuresRead.readPositifInt());
	}

	public void run() {
		featuresRead.readTable(tab);
		
		featuresShow.showTable(tab);
		
		Order order = featuresRead.readOrder();
		
		SortMethod sortMethod = featuresRead.readSortMethod();
		
		sort(order,sortMethod);
		
		featuresShow.showTable(tab);
		
		int intToSearch = featuresRead.readIntToSearch();
		SearchMethod searcMethod = featuresRead.readSearchMethod();
		
		if(search(intToSearch,searcMethod,order)) {
			TableIntegerShow.display("L'entier se trouve dans le tableau");
		}	
		else {
			TableIntegerShow.display("L'entier ne se trouve pas dans le tableau");
		}
	}
	
	public boolean search(int value,SearchMethod method,Order order) {
		switch(method) {
		case Exp:{
			return tab.exponentialSearch(value,order);
		}
		
		case Dicho:{
			return tab.dichoSearch(value,order);
		}
		
		case Linear:{
			return tab.linearSearch(value);
		}
		
		case Jump:{
			return tab.jumpSearch(value,order);
		}
		
		default:{
			return false;
		}
		
		}
	}	
	
	public void sort(Order order,SortMethod method) {
		switch(method) {
		case Fast:{
			tab.fastSort(order);
		}break;
		
		case Bubble:{
			tab.bubbleSort(order);
		}break;
		
		case Insert:{
			tab.insertSort(order);
		}break;
		
		case Select:{
			tab.selectionSort(order);
		}break;
		
		}
	}
}
