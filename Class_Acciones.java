package P1_Listas_Nodos;

import java.util.Scanner;
import java.util.Random;
import P1_Listas_Nodos.P1_Lista_NumerosA.Nodo;

public class Class_Acciones {

    public int IngresoNumero(char etiqueta) {
        int valor;
        do {
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese " + etiqueta + " elementos: ");
            valor = leer.nextInt();
            if (valor <= 0) {
                System.out.println("Tiene que ser > 0 !");
            }
        } while (valor <= 0);

        return valor;
    }

    public Nodo InsercionFinal(Nodo top, int n, int m) {

        Nodo ultimo = top;
        for (int i = 1; i <= n; i++) {
            Nodo temp = new Nodo();
            if (m == 0) {
                temp.num = new Random().nextInt(100);
            } else {
                temp.num = i * m;
            }
            temp.sig = null;
            if (top == null) //1er nodo
            {
                top = temp;
            } else //n-1 casos
            {
                ultimo.sig = temp;
            }
            ultimo = temp;
        }
        return top;
    }

    public Nodo InsercionInicio(Nodo top, int n, int m) {

        for (int i = 1; i <= n; i++) {
            Nodo temp = new Nodo();
            if (m == 0) {
                temp.num = new Random().nextInt(100);
            } else {
                temp.num = i * m;
            }
            if (top == null) //1er nodo
            {
                temp.sig = null;
            } else //n-1 casos
            {
                temp.sig = top;
            }
            top = temp;
        }
        return top;
    }

    Nodo ultimo;

    public Nodo BuscarNodo(Nodo temp1) {
        int buscar;

        ultimo = temp1;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese número a buscar #: ");
        buscar = leer.nextInt();

        while (temp1 != null) {
            if (temp1.num != buscar) {
                ultimo = temp1;
                temp1 = temp1.sig;
            } else {
                break;
            }
        }
        if (temp1 == null) {
            System.out.println(" ->" + buscar + " no existe");
        }

        return temp1;
    }

    public void InsercionDespues(Nodo temp1) {
        if (temp1 != null) //encontrado e inserción
        {
            Nodo temp = new Nodo();
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese el número en el nodo #: ");
            temp.num = leer.nextInt();
            temp.sig = temp1.sig;   //paso 1
            temp1.sig = temp;       //paso 2
        }
    }

    public Nodo InsercionAntes(Nodo temp1, Nodo top) {

        if (temp1 != null) //encontrado e inserción
        {
            Nodo temp = new Nodo();
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese número en el nodo #: ");
            temp.num = leer.nextInt();
            if (temp1 == top) // 1er nodo
            {
                temp.sig = top;
                top = temp;
            } else // n-1 casos
            {
                temp.sig = temp1;
                ultimo.sig = temp;
            }
        }
        return top;
    }

    public Nodo Eliminar(Nodo temp1, Nodo top) {

        if (temp1 != null) //encontrado y eliminar
        {
            if (temp1 == top) // 1er nodo
            {
                top = top.sig;
            } else // n-1 casos
            {
                ultimo.sig = temp1.sig;
            }
        }
        return top;
    }

    public void Modificar(Nodo temp1) {

        if (temp1 != null) //encontrado y modificar
        {
            Scanner leer = new Scanner(System.in);
            System.out.print("Ingrese el nuevo número #: ");
            temp1.num = leer.nextInt();
        }
    }

    public void NumeroMayorMenor(Nodo top) {
        int mayor = top.num;
        int menor = top.num;
        Nodo temp1 = top.sig;
        while (temp1 != null) {
            if (temp1.num > mayor) {
                mayor = temp1.num;
            }
            if (temp1.num < menor) {
                menor = temp1.num;
            }
            temp1 = temp1.sig;
        }
        System.out.println("\nEl número mayor en la lista enlazada es: " + mayor);
        System.out.println("El número menor en la lista enlazada es: " + menor);
    }

    public void SalidaPantalla(Nodo temp1) {
        while (temp1 != null) {
            System.out.print(temp1.num + ", ");
            temp1 = temp1.sig;
        }
    }

}
