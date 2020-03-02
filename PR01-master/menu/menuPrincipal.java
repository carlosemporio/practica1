package menu;

import java.util.Scanner;

public abstract class menuPrincipal {

		
                public static void iniciaMenu() {
		
		boolean salida = true;
		
		int opcion;
		Scanner keyboard = new Scanner(System.in);
		
		
                System.out.print(" **** Menu Principal ****\n\n");
                
		System.out.print("1.- Categorias\n");
		System.out.print("2.- Clientes\n");
		System.out.print("3.- Facturas\n");
		System.out.print("4.- Factura Linea\n");
		System.out.print("5.- Producto\n");
		System.out.print("6.- Salir\n");
		
                System.out.print("\n Elige una opcion: ");
                
                
                
		do {
		
		opcion = Integer.parseInt(keyboard.nextLine());
		
		switch (opcion) {
		case 1:			
			menuCategorias.mostrarCategorias();
			break;
		case 2:			
			menuClientes.mostrarClientes();
			break;
		case 3:		
			menuFactura.mostrarFactura();
	
			break;
		case 4:			
			menuFacturaLinea.mostrarFacturaLinea();
			break;
		case 5:			
			menuProducto.mostrarProducto();
			break;
		case 6:			
			salida = false;
			break;
		default:
			break;
		}
		}while(salida);
		System.out.print("Ha salido de la Aplicacion Mi Tienda");
		}

}
