package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.models.Categoria;
import src.models.comun.DbObject;

public class menuCategorias implements crud {

    List<DbObject> categoriasLista = new ArrayList();
    Categoria cat = new Categoria();
    public static Scanner keyboard = new Scanner(System.in);

    public menuCategorias() {

    }

    public static menuCategorias menu = new menuCategorias();

    public static void mostrarCategorias() {

        boolean salida = true;

        int opcion;

        System.out.print("\n****Menu Categorias****\n\n");

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

        categoriasLista = cat.list();

        for (int i = 0; i < categoriasLista.size(); i++) {

            System.out.println(i + " = " + categoriasLista.get(i));

        }
        menuCategorias.mostrarCategorias();
    }

    @Override
    public void modificar() {

        System.out.println("\n Dime la posicion de la Categoria que quieres Modificar");
        keyboard.reset();

        String eleccion;
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);
        categoriasLista.get(opcion);
        int id = categoriasLista.get(opcion).getId();

        System.out.println("Dime El nuevo nombre de la Categoria");
        keyboard.reset();
        String nuevoNombre = keyboard.nextLine();

        cat = (Categoria) cat.getByid(id);
        cat.setNombre(nuevoNombre);
        cat.save();

        menuCategorias.mostrarCategorias();

    }

    @Override
    public void borrar() {
        keyboard.reset();

        String eleccion;
        System.out.println("Dime la posicion de la Categoria que quieres Borrar");
        eleccion = keyboard.nextLine();
        int opcion = Integer.parseInt(eleccion);

        categoriasLista.get(opcion).delete();

        menuCategorias.mostrarCategorias();

    }

    @Override
    public void crear() {

        System.out.println("Dime el nombre del la nueva categoria");

        keyboard.reset();

        String nuevaCat = keyboard.nextLine();

        cat.setNombre(nuevaCat);
        cat.save();

        System.out.println("Se ha insertado la nueva Categoria");

        menuCategorias.mostrarCategorias();

    }
}
