import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {
        ArbolBinario ab = new ArbolBinario();

        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("Nombre: Jamileth Kumpanam");

        System.out.println("--------------------Árbol InOrder--------------------");
        ab.printInOrderSimple();

        System.out.println("--------------------Árbol InOrder con alturas--------------------");
        ab.printInOrderWithHeights();

        System.out.println("--------------------Árbol InOrder con factor de equilibrio--------------------");
        ab.printInOrderWithBalance();

        System.out.println("Árbol está equilibrado: " + ab.estaEquilibrado());

        int nuevo = 15;
        System.out.println("* Agregar valor: " + nuevo);
        ab.insert(nuevo);

        System.out.println("--------------------Árbol InOrder con factor de equilibrio--------------------");
        ab.printInOrderWithBalance();

        System.out.println("Nodos desequilibrados: ");
        ab.printNodosDesequilibrados();
    }
}
