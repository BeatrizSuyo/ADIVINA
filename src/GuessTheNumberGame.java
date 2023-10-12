import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Clase abstracta para representar a un jugador genérico
 abstract class Player {
    //private. solo los metodos dentro de Player pueden modificar
    private String name;
    //protected solo las sub-clases pueden acceder
    protected List<Integer> guesses;
//constructor: iniciliza NAME y crea lista GUESSES
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }
    //metodo abs se implementa en las sub-clases
    public abstract int makeGuess();
     //metodo obtener nombre
    public String getName() {
        return name;
    }
    //metodo para obtener suposiciones
    public List<Integer> getGuesses() {
        return guesses;
    }

    public Object getTargetNumber() {
        return null;
    }
}

// Clase para representar al jugador humano
class HumanPlayer extends Player {
    Scanner scanner;//lee entrada del usuario

    public HumanPlayer(String name) {
        //trae de Player atributos y metodos
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public int makeGuess() {
        System.out.print(getName() + ", ingresa tu suposición (entre 1 y 100): ");
        int guess = scanner.nextInt();
        scanner.nextLine(); // la nueva línea después del número
        return guess;
    }
/* 
    public void setScanner(Scanner scanner2) {
        scanner = scanner2;
    }
    */
}

// Clase para representar al jugador computadora
class ComputerPlayer extends Player {
    private Random random;
    private int targetNumber;
    
    public ComputerPlayer(String name, int targetNumber) {
        super(name);
        this.targetNumber = targetNumber;
    
        random = new Random();
    }
    
   // suposiciones estratégicas 
    @Override
    public int makeGuess() {
        int guess;

        if (guesses.isEmpty()) {
            guess = random.nextInt(100) + 1;
        } else {
            int lastGuess = guesses.get(guesses.size() - 1);

            // Calcula la diferencia entre la suposición anterior y el valor objetivo
            int difference = targetNumber - lastGuess;
            
            // Ajusta la suposición en función de la diferencia
            if (Math.abs(difference) <= 7) {
                // Si la diferencia es pequeña, intenta adivinar el valor objetivo
                guess = targetNumber;
            } else {
                // Si la diferencia es grande, realiza una suposición más cercana al objetivo
                guess = lastGuess + (difference > 0 ? 7 : -7);
            }
            
            // Asegúrate de que la suposición esté dentro del rango válido
            guess = Math.min(100, Math.max(1, guess));
        }
        guesses.add(guess);
        return guess;
    }

    public Object getTargetNumber() {
        return null;
    }

    public void setRandom(Random random2) {
    }

    public void setTargetNumber(int targetNumber2) {
    }
        
}

// Clase principal que maneja la lógica del juego
public class GuessTheNumberGame {
    private static Random random;
    private static int targetNumber;
    //public static Object currentPlayer;

    public static void main(String[] args) {
        random = new Random();
        targetNumber = random.nextInt(100) + 1;

        Player humanPlayer = new HumanPlayer("Jugador Humano");
        Player computerPlayer = new ComputerPlayer("Jugador Computadora", targetNumber);
    
        Player currentPlayer = humanPlayer;

        while (true) {

            int guess = currentPlayer.makeGuess();
            currentPlayer.guesses.add(guess);

            if (guess == targetNumber) {
                System.out.println(" ¡Felicidades! " );
                System.out.println("¡" + currentPlayer.getName() + " ha adivinado el número  " + targetNumber + "!");
                System.out.println("Historial de suposiciones de " + currentPlayer.getName() + ": " + currentPlayer.getGuesses());
                break; 
                
            } else if (guess < targetNumber) {
                System.out.println(currentPlayer.getName() + " supuso " + guess + " (Demasiado bajo)");
            } else {
                System.out.println(currentPlayer.getName() + " supuso " + guess + " (Demasiado alto)");
            }
    
           // Cambiar al siguiente jugador
            currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
        }
            
     }
}
