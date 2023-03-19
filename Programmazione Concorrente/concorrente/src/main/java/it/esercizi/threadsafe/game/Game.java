package it.esercizi.threadsafe.game;

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
