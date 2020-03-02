package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.comun.DbObject;

public class menuClientes implements crud {

    List<DbObject> clientesLista = new ArrayList();
    Clientes cli = new Clientes();
    public static Scanner keyboard = new Scanner(System.in);

    public menuClientes() {

    }

    public static menuClientes menu = new menuClientes();

    public static void mostrarClientes() {

        boolean salida = true;

        int opcion;

        System.out.print("1.- Ver\n");
        System.out.print("2.- Crear\n");
        System.out.print("3.- Borrar\n");
        System.out.print("4.- Modificar\n");
        System.out.print("5.- Volver menu Principal\n");

        System.out.print("\n Elige una opcion: ");

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

        clientesLista = cli.list();

        for (int i = 0; i < clientesLista.size(); i++) {

            System.out.println(i + " = " + clientesLista.get(i));

        }
        menuClientes.mostrarClientes();
    }

    @Override
    public void modificar() {

        String eleccion;

        System.out.println("Dime la posicion del Cliente que quieres Modificar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);
        clientesLista.get(opcion);
        int id = clientesLista.get(opcion).getId();

        cli = (Clientes) cli.getByid(id);
        System.out.println("Dime el nombre del nuevo Cliente");

        String nuevoCliNombre = keyboard.nextLine();
        cli.setNombre(nuevoCliNombre);
        System.out.println("Dime el DNI del nuevo Cliente");
        String nuevoCliDNi = keyboard.nextLine();
        cli.setDni(nuevoCliDNi);
        System.out.println("Dime la direccion del nuevo Cliente");
        String nuevoCliDireccion = keyboard.nextLine();
        cli.setDireccion(nuevoCliDireccion);
        System.out.println("Dime el Telefono del nuevo Cliente");
        String nuevoCliTelefonoString = keyboard.nextLine();
        cli.setTelefono(nuevoCliTelefonoString);
        System.out.println("Dime el correo del nuevo Cliente");
        String nuevoCorreo = keyboard.nextLine();
        cli.setEmail(nuevoCorreo);
        cli.save();

        menuClientes.mostrarClientes();

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la posicion de la Categoria que quieres Borrar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);

        clientesLista.get(opcion).delete();

        menuClientes.mostrarClientes();

    }

    @Override
    public void crear() {

        System.out.println("Dime el nombre del nuevo Cliente");

        keyboard.reset();

        String nuevoCliNombre = keyboard.nextLine();
        cli.setNombre(nuevoCliNombre);
        System.out.println("Dime el DNI del nuevo Cliente");
        String nuevoCliDNi = keyboard.nextLine();
        cli.setDni(nuevoCliDNi);
        System.out.println("Dime la direccion del nuevo Cliente");
        String nuevoCliDireccion = keyboard.nextLine();
        cli.setDireccion(nuevoCliDireccion);
        System.out.println("Dime el Telefono del nuevo Cliente");
        String nuevoCliTelefonoString = keyboard.nextLine();
        cli.setTelefono(nuevoCliTelefonoString);
        System.out.println("Dime el correo del nuevo Cliente");
        String nuevoCorreo = keyboard.nextLine();
        cli.setEmail(nuevoCorreo);
        cli.save();

        System.out.println("Se ha insertado el nuevo cliente");

        menuClientes.mostrarClientes();

    }
}
