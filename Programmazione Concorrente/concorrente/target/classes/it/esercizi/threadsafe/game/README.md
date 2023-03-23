Ecco un esempio di codice Java per simulare una partita di un gioco da tavolo con n giocatori. In questo esempio, viene utilizzata una classe "Player" per rappresentare ciascun giocatore e una classe "Game" per rappresentare la partita nel suo complesso.

```java
import java.util.Random;

public class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void play(Game game) {
        Random random = new Random();

        while (!game.isFinished()) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            System.out.println(name + " ha lanciato i dadi: " + dice1 + " e " + dice2);

            if (dice1 == dice2) {
                System.out.println("Hai fatto doppio! Lanci di nuovo.");
                continue;
            }

            int newPosition = position + dice1 + dice2;

            if (newPosition > game.getBoardSize()) {
                System.out.println(name + " non può muoversi di " + (dice1 + dice2) + " caselle, rimane fermo alla casella " + position);
                continue;
            }

            setPosition(newPosition);

            System.out.println(name + " si muove di " + (dice1 + dice2) + " caselle e arriva alla casella " + newPosition);

            if (newPosition == game.getBoardSize()) {
                System.out.println(name + " ha vinto la partita!");
                game.setFinished(true);
            }

            break;
        }
    }
}

public class Game {
    private int boardSize;
    private Player[] players;
    private boolean finished;

    public Game(int boardSize, String[] playerNames) {
        this.boardSize = boardSize;
        this.players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        this.finished = false;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Player[] getPlayers() {
        return players;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void play() {
        int currentPlayerIndex = 0;

        while (!isFinished()) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("\nÈ il turno di " + currentPlayer.getName());
            currentPlayer.play(this);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }

        System.out.println("\nLa partita è finita!");
    }
}

public class Main {
    public static void main(String[] args) {
        String[] playerNames = {"Alice", "Bob", "Charlie", "Dave"};
        Game game = new Game(20, playerNames);
        game.play();
    }
}

```

