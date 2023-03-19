package it.esercizi.threadsafe.game;

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
