import java.util.Scanner;

public class Actividades {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menuOpciones();
    }

    public static void menuOpciones() {
        int opcion = 0;
        do {
            menuTexto();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> System.out.println("Hasta otra");
            }
        } while(opcion != 6);
    }

    public static void menuTexto() {
        int i;
        System.out.println("\nQue ejercicio quieres ejecutar?");
        for (i = 1; i <= 5; i++) {
            System.out.println("\t" + i + ". Ejercicio "+ i);
        }
        int salida = i + 1;
        System.out.println("\t" + i + ". Salir");
    }

    public static void ejercicio1() {
        int numeros = 0;

        int matriz[][] = new int[5][5];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println();
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j] = numeros;
                numeros++;
                System.out.print(matriz[i][j] + " ");
            }
        }
    }

    public static void ejercicio2() {
        int t = 1;
        int f[][] = new int[10][10];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                f[i][j] = t * (j + 1);
                System.out.print(f[i][j] + " ");
            }
            t++;
            System.out.println("");
        }
    }

    public static void ejercicio3() {
        int fusuario, cusuario, nmayores = 0, nmenores = 0, ncero = 0;

        System.out.println("Introduce el numero de filas que quieres introducir");

        fusuario = validaInt();

        System.out.println("Introduce el numero de columnas que quieres introducir");

        cusuario = validaInt();

        int matriz[][] = new int[fusuario][cusuario];

        for (int i = 0; i < matriz.length; i++) {

            for (int x = 0; x < matriz[0].length; x++) {

                System.out.println("Introduce el valor de la fila : " + (i + 1) + " de la columna: " + (x + 1));

                matriz[i][x] = validaInt();

                if (matriz[i][x] < 0) {
                    nmenores++;
                } else if (matriz[i][x] > 0) {
                    nmayores++;
                } else {
                    ncero++;
                }

            }

        }
        System.out.println("Has introducido " + nmenores + " numeros menores de 0");
        System.out.println("Has introducido " + nmayores + " numeros mayores de 0");
        System.out.println("Has introducido " + ncero + " numeros iguales a 0");
    }

    public static void ejercicio4() {
        float notas[][]= new float[4][5];
        float minima=0,maxima=0,sumanotas=0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[0].length; j++) {
                System.out.print("La nota del alumno "+(i+1)+" es "+(j+1)+": ");
                notas[i][j]=sc.nextFloat();
                sumanotas+= notas[i][j];
                if (j==0) {
                    minima=notas[i][j];
                    maxima=notas[i][j];
                }
                if(minima>notas[i][j]){
                    minima=notas[i][j];
                }
                if(maxima<notas[i][j]){
                    maxima=notas[i][j];
                }
            }
            System.out.println("La nota mínima del alumno "+(i+1)+" es: "+minima);
            System.out.println("La nota máxima del alumno "+(i+1)+" es: "+maxima);
            System.out.println("La nota media del alumno "+(i+1)+" es: "+ (sumanotas/5));
            sumanotas=0;
            System.out.println("");
        }
    }

    public static void ejercicio5() {
        System.out.print("Introduce el numero de personas ");
        int n = sc.nextInt();
        int nvarones = 0, nmujeres = 0, sumavarones = 0, sumamujeres = 0;

        float sueldos[][] = new float[n][2];

        for (int i = 0; i < sueldos.length; i++) {
            for (int j = 0; j < sueldos[0].length; j++) {
                if (j == 0) {
                    System.out.print("Introduce el género (0 para varón y 1 para mujer) de la persona " + (i + 1) + ": ");
                    sueldos[i][j] = sc.nextFloat();
                }
                if (j == 1) {
                    System.out.print("Introduce el sueldo: ");
                    sueldos[i][j] = sc.nextFloat();
                }
            }
        }

        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i][0] == 0.0) {
                nvarones++;
                sumavarones += sueldos[i][1];
            }
            if (sueldos[i][0] == 1.0) {
                nmujeres++;
                sumamujeres += sueldos[i][1];
            }
        }
        System.out.println("El sueldo medio de los varones es: " + (sumavarones / nvarones));
        System.out.println("El sueldo medio de las mujeres es: " + (sumamujeres / nmujeres));
    }

    public static int validaInt() {
        int numero = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Esto no es un numero, introduzca un numero valido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
