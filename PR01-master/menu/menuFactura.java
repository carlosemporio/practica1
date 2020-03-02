package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import src.models.Clientes;
import src.models.Factura;
import src.models.comun.DbObject;

public class menuFactura implements crud {

    List<DbObject> facturaLista = new ArrayList();
    Factura fac = new Factura();
    public static Scanner keyboard = new Scanner(System.in);

    public menuFactura() {

    }

    public static menuFactura menu = new menuFactura();

    public static void mostrarFactura() {

        boolean salida = true;

        int opcion;

        System.out.print("\n **** Facturas **** \n");

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

    }

    @Override
    public void ver() {

        facturaLista = fac.list();

        for (int i = 0; i < facturaLista.size(); i++) {

            System.out.println(i + " ==== " +facturaLista.get(i));

        }
        menuFactura.mostrarFactura();
    }

    @Override
    public void modificar() {

        keyboard.reset();

        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String eleccion;
        sdf.setLenient(false);

        System.out.println("Codigo Articulo a Modificar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);
        facturaLista.get(opcion);
        int id = facturaLista.get(opcion).getId();
        fac = (Factura) fac.getByid(id);

        System.out.println("Dime la nueva fecha de Factura yyyy-MM-dd ");
        String nuevaFechaFactura = keyboard.nextLine();
        try {
            fecha = sdf.parse(nuevaFechaFactura);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fac.setFecha(fecha);
        System.out.println("ID Cliente");
        int nuevoIdCliente = Integer.parseInt(keyboard.nextLine());
        fac.setId_cliente(nuevoIdCliente);
        System.out.println("Serie Factura");
        int nuevaSerieCliente = Integer.parseInt(keyboard.nextLine());
        fac.setSerie(nuevaSerieCliente);

        fac.save();

        menuFactura.mostrarFactura();

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la posicion de la Categoria que quieres Borrar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);        
        facturaLista.get(opcion).delete();
        menuFactura.mostrarFactura();

    }

    @Override
    public void crear() {

        keyboard.reset();
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        System.out.println("Fecha de Factura en formato yyyy-MM-dd");
        String nuevaFechaFactura = keyboard.nextLine();

        try {
            fecha = sdf.parse(nuevaFechaFactura);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        System.out.println("Fecha correcta: "+fac.getFecha());
        System.out.println("Dime el ID del cliente de la Factura");
        int nuevoIdCliente = Integer.parseInt(keyboard.nextLine());
        fac.setId_cliente(nuevoIdCliente);
        System.out.println("Dime la Serie de la Factura");
        int nuevaSerieCliente = Integer.parseInt(keyboard.nextLine());
        fac.setSerie(nuevaSerieCliente);

        fac.save();

        System.out.println("Se ha insertado el nuevo cliente");

        menuFactura.mostrarFactura();

    }

}
