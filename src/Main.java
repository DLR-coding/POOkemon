import Game.Jeu.Partie;
import Game.Joueur.*;

public class Main {
    public static void main(String[] args)
    {
        JoueurHumain joueur = new JoueurHumain("j1");

        RobotPlayer robot = new RobotPlayer("Robot1");

        Partie game = new Partie(joueur,robot);

        game.Lunch();

    }
}