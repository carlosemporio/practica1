package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.models.Producto;
import src.models.comun.DbObject;

public class menuProducto implements crud {

    List<DbObject> productosLista = new ArrayList();
    Producto pro = new Producto();
    public static Scanner keyboard = new Scanner(System.in);

    public menuProducto() {

    }

    public static menuProducto menu = new menuProducto();

    public static void mostrarProducto() {

        boolean salida = true;

        int opcion;
        System.out.print("\n **** Productos ****\n");

        System.out.print("1.- Ver\n");
        System.out.print("2.- Crear\n");
        System.out.print("3.- Borrar\n");
        System.out.print("4.- Modificar\n");
        System.out.print("5.- Volver al menu Principal\n");

        System.out.print("\nElige una opcion: ");

        do {

            opcion = Integer.parseInt(keyboard.nextLine());

            switch (opcion) {
                case 1:
                    menu.ver();
                    break;
                case 2:
                    menu.crear();
                    break;
                case 3:
                    menu.borrar();
                    break;
                case 4:
                    menu.modificar();
                    break;
                case 5:
                    menuPrincipal.iniciaMenu();
                    break;
                default:
                    break;
            }

        } while (salida);

        System.out.print("Gracias por usar la apliacion");

    }

    @Override
    public void ver() {

        productosLista = pro.list();

        for (int i = 0; i < productosLista.size(); i++) {

            System.out.println(i + " = " + productosLista.get(i));

        }
        menuProducto.mostrarProducto();
    }

    @Override
    public void modificar() {

        System.out.println("Dime la posicion del Producto que quieres Modificar");
        keyboard.reset();

        String eleccion;
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);
        productosLista.get(opcion);
        int id = productosLista.get(opcion).getId();

        System.out.println("Dime El nuevo nombre de Producto");
        keyboard.reset();
        String nuevoNombre = keyboard.nextLine();

        pro = (Producto) pro.getByid(id);
        pro.setNombre(nuevoNombre);

        System.out.println("Dime el Precio del nuevo Producto");

        int precioProducto = Integer.parseInt(keyboard.nextLine());
        pro.setPrecio(precioProducto);

        System.out.println("Dime el Stock del nuevo Producto");

        int stockProducto = Integer.parseInt(keyboard.nextLine());
        pro.setId_categoria(stockProducto);

        pro.save();

        menuProducto.mostrarProducto();
    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la posicion del Producto que quieres Borrar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);

        productosLista.get(opcion).delete();

        menuProducto.mostrarProducto();
    }

    @Override
    public void crear() {

        keyboard.reset();
        System.out.println("Dime el nombre del la nueva categoria");

        String nuevoPro = keyboard.nextLine();
        pro.setNombre(nuevoPro);

        System.out.println("Dime el ID del nuevo Producto");

        int idProducto = Integer.parseInt(keyboard.nextLine());
        pro.setId_categoria(idProducto);

        pro.setNombre(nuevoPro);

        System.out.println("Dime el Precio del nuevo Producto");

        int precioProducto = Integer.parseInt(keyboard.nextLine());
        pro.setPrecio(precioProducto);

        System.out.println("Dime el Stock del nuevo Producto");

        int stockProducto = Integer.parseInt(keyboard.nextLine());
        pro.setId_categoria(stockProducto);

        System.out.println("Se ha insertado el nuevo Producto");

        pro.save();

        menuProducto.mostrarProducto();
        //Producto pro = new Producto();
        //pro.setId_categoria(01);
        //pro.setNombre("Queso");
        //pro.setPrecio(200);
        //pro.setStock(16);
        //pro.save();

    }

}
