package core.view;

import core.model.TableInteger;

public class TableIntegerShow {

	public TableIntegerShow() {
		
	}

	public void showTable(TableInteger tab) {
		display(tab.toString());
	}
	
	public static void display(String a) {
		System.out.println(a);
	}
	
	
}
