import Game.Jeu.Partie;
import Game.Joueur.*;

public class Main {
    public static void main(String[] args)
    {
        // Create a human player named "j1"
        JoueurHumain joueur = new JoueurHumain("j1");

        // Create a robot player named "Robot1"
        RobotPlayer robot = new RobotPlayer("Robot1");

        // Create a new game with the human and robot players
        Partie game = new Partie(joueur,robot);

        // Start the game
        game.Lunch();

    }

}