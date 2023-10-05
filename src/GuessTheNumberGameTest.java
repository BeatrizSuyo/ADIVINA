import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

//import static org.mockito.Mockito.when;

public class GuessTheNumberGameTest {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() {

       // Crea el objeto HumanPlayer con el SimulatedUserInput
        humanPlayer = new HumanPlayer("Jugador Humano");

        // Configura el objeto ComputerPlayer con un número objetivo fijo
        computerPlayer = new ComputerPlayer("Jugador Computadora", 44);
    }

    @Test
    public void testHumanPlayerMakeGuess() {
        // Verificar que el jugador humano ingrese la suposición correcta
        int guess = humanPlayer.makeGuess();
        assertEquals(44, guess);
    }

    @Test
    public void testComputerPlayerMakeGuess() {
        // Verificar que el jugador de computadora haga una suposición válida
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
    }
    //mockeo

   
@Test
    public void testPlayerGuessesAfterWinning() {
        // Crear un objeto mock de la clase Player
        Player player = Mockito.mock(Player.class);

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
}


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
}
*/


