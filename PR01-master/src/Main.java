package src; 
import java.util.ArrayList;
import java.util.Date;

import menu.menuPrincipal;
import java.util.List;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.FacturaLinea;
import src.models.Producto;
import src.models.comun.DbObject;
import src.models.comun.Tools; 

public class Main extends menuPrincipal {
	
	/**
	 * <strong>EJERCICIOS</strong>
	 * <strong>Entrega: 6 de Noviembre (Github)</strong>
	 * 
	 * 1.- Actualizar vuestros repositorio con este
	 * 2.- Interface Comandos:
	 * 	-> Categoria: CRUD
	 *  -> Producto: CRUD // NOTA: Un producto tiene un id_Categoria obligatorio, y tiene existir la categoria
	 *  -> Cliente: CRUD
	 * 
	 * 2.- Listar:
	 *  -> Productos de una Categoria // Dado un ID de categoria; tener todos los productos
	 * 
	 * 3*.- Validaciones:
	 *  -> Los datos del C/U (Create/Update) tienen que cumplir condiciones coherentes. 
	 *  => PISTA: regex
	 * 
	 * *-> Para nota ;)
	 * 
	 */

	public static void main(String[] args) {
		 
		
		 //Categoria cat = new Categoria();
		 //cat.setNombre("Cat 01");
		 //cat.setNombre("Cat 02");
		 //

			//Clientes cli =new Clientes();
			//cli.setDireccion("Calle rapaciones");
			//cli.setDni("71665576z");
			//cli.setEmail("Prueba@prueba.com");
			//cli.setNombre("Juanjose");
			//cli.setTelefono("985115858");
			//cli.save();
		
		//Factura fac = new Factura();
		//Date fecha = null;
		
		//fac.setFecha(fecha);
		//fac.setSerie(02);
		//fac.setId_cliente(03);
		//fac.save();
		
		//Producto pro = new Producto();
		//pro.setId_categoria(01);
		//pro.setNombre("Queso");
		//pro.setPrecio(200);
		//pro.setStock(16);
		//pro.save();
		
		
//		FacturaLinea faclin = new FacturaLinea();
//		faclin.setId_factura(15);
//		faclin.setNombre("compra plantas");
//		faclin.setPrecio(500);
		
		
		
		menuPrincipal.iniciaMenu();
		 
		 
	}
}