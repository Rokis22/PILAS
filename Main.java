import java.util.ArrayList;
import java.util.Scanner;

class Pila {
    private final ArrayList<Integer> pila;
    private final int maxSize;

    public Pila(int size) {
        pila = new ArrayList<>(size);
        this.maxSize = size;
    }

    public void apilar(int elemento) {
        if (estaLlena()) {
            System.out.println("La pila está llena, no se puede insertar más elementos.");
        } else {
            pila.add(elemento);
            System.out.println("Elemento " + elemento + " apilado.");
        }
    }

    public void desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede desapilar ningún elemento.");
        } else {
            int elemento = pila.remove(pila.size() - 1);
            System.out.println("Elemento " + elemento + " desapilado.");
        }
    }

    public void obtenerTope() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("El tope de la pila es: " + pila.get(pila.size() - 1));
        }
    }

    public void mostrarElementos() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos en la pila: " + pila);
        }
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }

    public boolean estaLlena() {
        return pila.size() == maxSize;
    }

    public int obtenerTamaño() {
        return pila.size();
    }

    public void vaciarPila() {
        pila.clear();
        System.out.println("La pila ha sido vaciada.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la pila: ");
        int size = scanner.nextInt();

        Pila pila = new Pila(size);
        int opcion;

        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Apilar (Insertar)");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener el Tope");
            System.out.println("4. Mostrar Elementos");
            System.out.println("5. Verificar si la Pila está Vacía");
            System.out.println("6. Verificar si la Pila está Llena");
            System.out.println("7. Obtener el Tamaño de la Pila");
            System.out.println("8. Vaciar la Pila");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a apilar: ");
                    int elemento = scanner.nextInt();
                    pila.apilar(elemento);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    pila.obtenerTope();
                    break;
                case 4:
                    pila.mostrarElementos();
                    break;
                case 5:
                    System.out.println(pila.estaVacia() ? "La pila está vacía." : "La pila no está vacía.");
                    break;
                case 6:
                    System.out.println(pila.estaLlena() ? "La pila está llena." : "La pila no está llena.");
                    break;
                case 7:
                    System.out.println("El tamaño actual de la pila es: " + pila.obtenerTamaño());
                    break;
                case 8:
                    pila.vaciarPila();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }
}
