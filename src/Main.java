import Game.EnsemblePokemon.*;
import Game.Jeu.LeJeu;
import Game.Joueur.*;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        JoueurHumain joueur = new JoueurHumain("j1");
        RobotPlayer robot = new RobotPlayer("Robot1");

        LeJeu game = new LeJeu(joueur,robot);

        game.Lunch();

    }
}