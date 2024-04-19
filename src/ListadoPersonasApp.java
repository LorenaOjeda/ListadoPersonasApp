
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //Menu
        var salir = false;
        while (!salir){
            mostrarMenu();
            try{
                salir = ejecutarOperacion(consola, personas);
            }
            catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                **** Listado Personas App****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("¿Que deseas hacer?:");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> {//Agregar persona
                System.out.print(" Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print(" Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.print(" Proporciona el email: ");
                var email = consola.nextLine();
                //Crear el objeto Persona
                var persona = new Persona(nombre, tel, email);
                //Agregar objeto a lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + "elementos");
            } case 2 -> {//Listar personas
                System.out.println("Listado de personas: ");
                //Metodo de referencia
                personas.forEach(System.out::println);
            } case 3 -> {//Salida de ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);

        }//fin switch
        return salir;

    }
}