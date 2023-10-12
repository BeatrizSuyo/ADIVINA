import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
//import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;


public class GuessTheNumberGameTest {
    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() {
        new HumanPlayer("Jugador Humano");

        // Configura el objeto ComputerPlayer con un número objetivo fijo
        computerPlayer = new ComputerPlayer("Jugador Computadora", 44);

        // Esto es para que el jugador de la computadora no genere números aleatorios, sino que siga la estrategia.
        computerPlayer.setRandom(new Random(44));
    }

    @Test
    public void testComputerPlayerMakeGuess() {
        // Verificar que el jugador de computadora haga una suposición válida
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
        // se puede hacer más suposiciones y verificar si se acercan al objetivo.
    }

    @Test
    public void testPlayerUpdatesGuessesAfterGuess() {
        // Crea un objeto mock de la clase Player
        Player player = new ComputerPlayer("Mocked Computer Player", 50);

        // la lista de suposiciones esté vacía al principio
        assertTrue(player.getGuesses().isEmpty());

        // Hacer una suposición
        player.makeGuess();

        // Verificar que la lista de suposiciones no esté vacía después de hacer una suposición
        assertEquals(1, player.getGuesses().size());
    }

}







/**********************************************************************************************************************************
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.when;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
//import org.mockito.Mockito;

public class GuessTheNumberGameTest {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() {

       // Crea el objeto HumanPlayer con el SimulatedUserInput
        humanPlayer = new HumanPlayer("Jugador Humano");

        // Configura el objeto ComputerPlayer con un número objetivo fijo
        computerPlayer = new ComputerPlayer("Jugador Computadora", 44);
        //esto es para que el jugador computadora no genere aleatorios,sino siga la estrategia
        computerPlayer.setRandom(new Random(44));
    }
    
    
    @Test
    public void testComputerPlayerMakeGuess() {
        // Verificar que el jugador de computadora haga una suposición válida
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
        //para probar la logica de la soposicion de la computadora
        //se puede hacer mas suposiciones y verificar si se acercan al numero objetivo
    }
    @Test
    public void testPlayerUpdatesGuessesAfterGuess(){
         // Crear un objeto mock de la clase Player
         Player player = new ComputerPlayer("Mocked Computer Player", 50);

         // Asegúrate de que la lista de suposiciones esté vacía al principio
         assertTrue(player.getGuesses().isEmpty());
 
         // Hacer una suposición
         player.makeGuess();
 
         // Verificar que la lista de suposiciones no esté vacía después de hacer una suposición
         assertEquals(1, player.getGuesses().size());
     }
    
}



*/
//****************************************************************************************************************** */
    /*
    @Test
    public void testPlayerGuessesAfterWinning() {
        // Crear un objeto mock de la clase Player
        final Player player = Mockito.mock(Player.class);

        // Crear una lista de suposiciones simuladas
        List<Integer> simulatedGuesses = new ArrayList<>();
        simulatedGuesses.add(42);
        simulatedGuesses.add(64);
        simulatedGuesses.add(87);

        // Mockear el comportamiento del jugador para devolver las suposiciones simuladas
        when(player.getGuesses()).thenReturn(simulatedGuesses);

        // Verificar el comportamiento del jugador después de ganar
        assertEquals(simulatedGuesses, player.getGuesses());
    }

     */
     /* 
    @Test
    public void testCo

        ComputerPlayer computerPlayer = new ComputerPlayer("Jugador Computadora", targetNumber);

        // Realiza varias suposiciones y verificar que estén dentro del rango [1, 100]
        for (int i = 0; i < 100; i++) {
            int guess = computerPlayer.makeGuess();
            assertTrue(guess >= 1 && guess <= 100);
        }
    }

    */


