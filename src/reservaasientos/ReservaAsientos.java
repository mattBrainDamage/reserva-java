package reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {

        public static void main(String[] args) {
            char asientos [][] = new char [10][10];
            boolean bandera = false;
            Scanner teclado = new Scanner(System.in);
            int fila=0, asiento=0;
            String respuesta;
            String verMapa;

            for(int f = 0;f < 10; f ++){
                for (int c = 0; c < 10; c++) {

                    asientos[f][c] = '-';
                }
            }

            System.out.println("----Bienvenidos al sistema de reservas----");

            // reserva de asientos

            while(bandera!=true){

                System.out.println("¿Desea ver los asientos disponibles? S: Sí. Cualquier otra letra:: No");
                verMapa = teclado.next();

                if(verMapa.equalsIgnoreCase("S")){
                    dibujarMapa(asientos);
                }


                //reserva
                boolean estaOk = false;

                while(estaOk!=true) {

                    System.out.println("\n Ingrese fila y asiento a reservar");
                    System.out.println("Fila (entre 0 y 9): ");
                    fila = teclado.nextInt();

                    System.out.println("Asiento (entre 0 y 9): ");
                    asiento = teclado.nextInt();

                    if (fila <= 9 && fila >= 0) {
                        if (asiento <= 9 && asiento >= 0) {
                            estaOk = true;
                        } else {
                            System.out.println("Número de asiento inválido");
                        }
                    } else {
                        System.out.println("Número de fila inválida");
                    }
                }

                if(asientos[fila][asiento]=='-'){
                        asientos[fila][asiento]='X';
                        System.out.println("El asiento fue reservado correctamente");

                } else {
                        System.out.println("El asiento esta ocupado. Elija otro");
                }

                System.out.println("¿Finaliza reserva? / S: Sí   N: No");
                respuesta = teclado.next();

                if(respuesta.equalsIgnoreCase("S")) {
                    bandera=true;
                }

            }
        }

     static void dibujarMapa(char asientos[][]){
        for(int f = 0;f < 10; f ++){
            System.out.print(f+" ");
            for (int c = 0; c < 10; c++) {
                System.out.print("["+asientos[f][c]+"]");

            }
            System.out.println(" ");
        }

    }


}
