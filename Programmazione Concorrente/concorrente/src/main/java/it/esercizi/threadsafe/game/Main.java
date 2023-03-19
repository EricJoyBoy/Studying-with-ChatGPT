package it.esercizi.threadsafe.game;

public class Main {
    public static void main(String[] args) {
        String[] playerNames = {"Alice", "Bob", "Charlie", "Dave"};
        Game game = new Game(20, playerNames);
        game.play();
    }
}
