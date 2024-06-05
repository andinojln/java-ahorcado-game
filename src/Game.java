import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {
        // Clase Scanner: escanea y captura los datos ingresados por el usuario
        Scanner scanner = new Scanner(System.in);
        String secretWord = "programacion";
        int maximumAttempts = 10;
        int attempts = 0;
        boolean guessedWord = false;
        // Array de chars: almacena cada char de (secretWord)
        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            // Reemplaza la letra recorrida de (guessedLetters) por un guion bajo
            guessedLetters[i] = '_';
        }

        System.out.println("===== Juego del Ahorcado =====");

        // Mientras no se adivine la palabra y todavia queden intentos, se seguira ejecutando el bucle
        while (!guessedWord && attempts < maximumAttempts) {
            // String.valueOf() -> convierte los chars de (guessedLetters) en una string
            System.out.println("Palabra a adivinar: " + String.valueOf(guessedLetters) + " (" + secretWord.length() + " letras)");
            System.out.println("Introduce una letra, por favor:");

            // En esta variable se almacenara la letra escaneada
            // Character.toLowerCase() -> convierte el caracter escaneado en minusculas
            // scanner.next() -> inicia el escaneo de datos
            // charAt(0) -> captura unicamente el primer caracter escaneado
            char userLetter = Character.toLowerCase(scanner.next().charAt(0));
            boolean correctLetter = false;

            for (int i = 0; i < secretWord.length(); i++) {
                // Si el primer char de (secretWord) es igual a (userLetter)...
                if (secretWord.charAt(i) == userLetter) {
                    guessedLetters[i] = userLetter;
                    correctLetter = true;
                }
            }

            // Si (correctLetter) es false, se incrementara el valor de (attempts) y se le restara a (maximumAttempts)
            if (!correctLetter) {
                attempts++;
                System.out.println("¡Incorrecto! Te quedan " + (maximumAttempts - attempts) + " intentos.");
            }

            // Si (guessedLetters) es igual a (secretWord)...
            if (String.valueOf(guessedLetters).equals(secretWord)) {
                guessedWord = true;
                System.out.println("¡Felicidades! Has adivinado la palabra: " + secretWord);
            }
        }

        // Si (guessedWord) es false...
        if (!guessedWord) {
            System.out.println("¡Te has quedado sin intentos! Game Over.");
        }

        // Finaliza el escaneo de datos
        scanner.close();
    }
}
