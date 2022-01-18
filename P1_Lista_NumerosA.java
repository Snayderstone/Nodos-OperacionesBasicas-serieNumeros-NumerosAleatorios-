/*

P1_Listas_Insercion_desde_Final_desde_Inicio_Comparacion_IncercionAntes_InsercionDespues
_Eliminar_Editar_NumMayot_NumMenor
 */
package P1_Listas_Nodos;

import java.util.Scanner;

public class P1_Lista_NumerosA {

    public static class Nodo {

        int num;
        Nodo sig;
    }

    public static void main(String[] args) {
        int n, opcion1, opcion2, opcion3;
        int m = 0;

        System.out.println("<< NÚMEROS ALEATORIOS Y SERIE DE NÚMEROS >>");
        Class_Acciones ac = new Class_Acciones();
        n = ac.IngresoNumero('n');
        System.out.println("---------MENU-------");
        System.out.println("1. Números aleatorios");
        System.out.println("2. Serie de números");
        System.out.println("0. Salir");
        System.out.println("Seleccionar la opción: ");
        Scanner leer2 = new Scanner(System.in);
        opcion1 = leer2.nextInt();
        if (opcion1 == 2) {
            m = ac.IngresoNumero('m');
        }
        System.out.println("---------SUBMENU-------");
        System.out.println("1. Inserción al final");
        System.out.println("2. Inserción al inicio");
        System.out.println("3. Comparativo 1 y 2");
        System.out.println("0. Salir");
        System.out.println("Seleccionar la opción: ");
        opcion2 = leer2.nextInt();

        Nodo top = null; //incializar la lista enlazada en null
        switch (opcion2) {
            case 1 -> {
                top = ac.InsercionFinal(top, n, m);
                ac.SalidaPantalla(top);
                ac.NumeroMayorMenor(top);
                break;
            }
            case 2 -> {
                top = ac.InsercionInicio(top, n, m);
                ac.SalidaPantalla(top);
                ac.NumeroMayorMenor(top);
                break;
            }
            case 3 -> {
                Nodo lista1 = null;
                Nodo lista2 = null;
                lista1 = ac.InsercionFinal(lista1, n, m);
                lista2 = ac.InsercionInicio(lista2, n, m);
                System.out.println("Con Inserción al final -> ");
                ac.SalidaPantalla(lista1);
                System.out.println("\nCon Inserción al inicio -> ");
                ac.SalidaPantalla(lista2);
                break;
            }
        }

        if ((opcion2 == 1) || (opcion2 == 2)) {
            System.out.println("\n ---------SUBMENU 2-------");
            System.out.println("1. Inserción, despúes del nodo encontrado");
            System.out.println("2. Inserción, antes del nodo encontrado");
            System.out.println("3. Eliminar");
            System.out.println("4. Modificar");
            System.out.println("0. Salir");
            System.out.println("Seleccionar la opción: ");
            opcion3 = leer2.nextInt();

            switch (opcion3) {
                case 1 -> {
                    Nodo temp1 = top;
                    temp1 = ac.BuscarNodo(temp1);
                    //System.out.println("temp1--> "+temp1.num);
                    ac.InsercionDespues(temp1);
                    ac.SalidaPantalla(top);
                    break;
                }
                case 2 -> {
                    Nodo temp1 = top;
                    temp1 = ac.BuscarNodo(temp1);
                    top = ac.InsercionAntes(temp1, top);
                    ac.SalidaPantalla(top);
                    break;
                }
                case 3 -> {
                    Nodo temp1 = top;
                    temp1 = ac.BuscarNodo(temp1);
                    top = ac.Eliminar(temp1, top);
                    ac.SalidaPantalla(top);
                    break;
                }
                case 4 -> {
                    Nodo temp1 = top;
                    temp1 = ac.BuscarNodo(temp1);
                    ac.Modificar(temp1);
                    ac.SalidaPantalla(top);
                    break;
                }
            }
        }

    }

}
