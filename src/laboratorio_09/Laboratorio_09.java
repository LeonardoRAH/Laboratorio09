
package laboratorio_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Laboratorio_09 {
    public static void main(String[] args) {
        int ancho = 30;
        int alto = 10;
        int naveX = ancho / 2;
        int naveY = alto - 1;
        int enemigoX = 0;
        int enemigoY = 0;
        int balaX = -1;
        int balaY = -1;
        boolean gameOver = false;

        List<Integer> enemigoPath = new ArrayList<>();
        for (int i = 0; i < ancho; i++) {
            enemigoPath.add(i);
        }
        int enemigoIndex = 0;

        while (!gameOver) {
            
            // Dibujo del tablero
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (i == naveY && j == naveX) {
                        System.out.print("***");
                    } else if (i == enemigoY && j == enemigoX) {
                        System.out.print("PPP");
                    } else if (i == balaY && j == balaX) {
                        System.out.print("l");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            // Control de la nave
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("a") && naveX > 0) {
                naveX--;
            } else if (input.equals("d") && naveX < ancho - 1) {
                naveX++;
            } else if (input.equals(" ")) {
                if (balaY == -1) {
                    balaX = naveX;
                    balaY = naveY - 1;
                }
            }

            // Actualiza la posición del enemigo
            enemigoX = enemigoPath.get(enemigoIndex);
            enemigoY++;

            // Verifica colisiones
            if (enemigoY == alto) {
                enemigoY = 0;
                enemigoIndex = (enemigoIndex + 1) % ancho;
            }

            if (balaY >= 0) {
                balaY--;
                if (balaX == enemigoX && balaY == enemigoY) {
                    gameOver = true;
                    System.out.println("¡Ganaste!");
                }
            }
        }
    }
}
