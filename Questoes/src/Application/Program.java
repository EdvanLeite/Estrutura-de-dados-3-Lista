package Application;

import Entities.ListaCircular02;

public class Program {

	public static void main(String[] args) {

		ListaCircular02 list = new ListaCircular02();

		list.addElemento(10);
		list.addElemento(50);
		list.addElemento(-20);
		list.addElemento(40);

		list.exibirLista();
		System.out.println();
		
		list.exibirDadosHead();
	

	
	}

}
