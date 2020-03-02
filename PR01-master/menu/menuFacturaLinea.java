package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.models.FacturaLinea;
import src.models.comun.DbObject;

public class menuFacturaLinea implements crud {

    List<DbObject> facturaLineaLista = new ArrayList();
    FacturaLinea facLin = new FacturaLinea();
    public static Scanner keyboard = new Scanner(System.in);

    public menuFacturaLinea() {

    }

    public static menuFacturaLinea menu = new menuFacturaLinea();

    public static void mostrarFacturaLinea() {

        boolean salida = true;

        int opcion;

        System.out.print("\n **** Lineas Factura **** \n");

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

        facturaLineaLista = facLin.list();

        for (int i = 0; i < facturaLineaLista.size(); i++) {

            System.out.println(i + " = " + facturaLineaLista.get(i));

            menuFacturaLinea.mostrarFacturaLinea();
        }

    }

    @Override
    public void modificar() {

        String eleccion;

        System.out.println("Articulo a Modificar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);
        facturaLineaLista.get(opcion);
        int id = facturaLineaLista.get(opcion).getId();
        facLin = (FacturaLinea) facLin.getByid(id);

        System.out.println("Dime el nuevo nombre de la factura en linea");
        String nuevoNombre = keyboard.nextLine();
        facLin.setNombre(nuevoNombre);
        System.out.println("Dime el nuevo ID de la factura en linea");
        int nuevoIdFactura = Integer.parseInt(keyboard.nextLine());
        facLin.setId_factura(nuevoIdFactura);
        System.out.println("Dime el nuevo Precio de la Factura en linea");
        int nuevoPrecio = Integer.parseInt(keyboard.nextLine());
        facLin.setPrecio(nuevoPrecio);
        facLin.save();

        menuFacturaLinea.mostrarFacturaLinea();

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la posicion de la Factura en linea que quieres Borrar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);

        facturaLineaLista.get(opcion).delete();
        menuFacturaLinea.mostrarFacturaLinea();

    }

    @Override
    public void crear() {

        keyboard.reset();

        System.out.println("Dime el Nombre de la Factura en linea");

        String nombreFacturaLinea = keyboard.nextLine();
        facLin.setNombre(nombreFacturaLinea);

        System.out.println("Dime el ID de la Factura en Linea");
        int idFacturaLinea = Integer.parseInt(keyboard.nextLine());
        facLin.setId_factura(idFacturaLinea);
        System.out.println("Dime  el precio para la Factua en Linea");
        int nuevoPrecio = Integer.parseInt(keyboard.nextLine());
        facLin.setPrecio(nuevoPrecio);

        facLin.save();

        System.out.println("Se ha insertado la nueva Factura en Linea");

        menuFacturaLinea.mostrarFacturaLinea();

    }

}
