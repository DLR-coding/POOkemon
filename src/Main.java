import Game.EnsemblePokemon.*;
import Game.Joueur.*;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        JoueurHumain joueur = new JoueurHumain("j1");
        RobotPlayer robot = new RobotPlayer("Robot1");

        // Choix random de qui joue en premier (il aura 21 pokemon dans sa pioche)
        Random random = new Random();
        int joueur1Random = random.nextInt(2) + 1;
        if (joueur1Random == 1) {
            System.out.println("Tu joue en 1er");
            joueur.setJoueur1(true); //le joueur 1 est le joueur humain
            robot.setJoueur1(false);
        } else {
            System.out.println("Le robot joue en 1er");
            joueur.setJoueur1(false); // le joueur 1 est l'ordinateur
            robot.setJoueur1(true);
        }

        // Initialisation des pioches
        Pioche piocheJoueur1;
        Pioche piocheJoueur2;
        piocheJoueur1 = new Pioche(21);
        piocheJoueur2 = new Pioche(20);
        if (joueur.isJoueur1()) {
            joueur.setPioche(piocheJoueur1);
            robot.setPioche(piocheJoueur2);
        } else {
            joueur.setPioche(piocheJoueur2);
            robot.setPioche(piocheJoueur1);
        }

        System.out.println(" ");
        System.out.println(" TA PIOCHE : ");
        joueur.afficherPioche();
        System.out.println(" PIOCHE DE l'ordinateur : ");
        robot.afficherPioche();
        System.out.println(" ");


        // Main pour chaque joueur
        for (int i = 0; i < 5; i++)
        {
            joueur.piocherPokemon(joueur.getPokemonFromPioche(i));
            robot.piocherPokemon(robot.getPokemonFromPioche(i));
        }

        System.out.println("AFFICHAGE DE TA MAIN");
        joueur.afficherMain();
        System.out.println("AFFICHAGE DE LA MAIN ORDINATEUR");
        robot.afficherMain();



        //Terrain
        if (joueur.isJoueur1())
        {
            System.out.println("tu place tes pokemon de ta main à ton terrain... ");
            for (int i = 0; i < 3; i++) {
                joueur.placeSurTerrain(joueur.getPokemonFromMain(i));
            }
            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < 3; i++) {
                robot.placeSurTerrain(robot.getPokemonFromMain(i));
            }
        }
        else
        {

            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < 3; i++) {
                robot.placeSurTerrain(robot.getPokemonFromMain(i));
            }
            System.out.println("tu place tes pokemon de ta main à ton terrain... ");
            for (int i = 0; i < 3; i++) {
                joueur.placeSurTerrain(joueur.getPokemonFromMain(i));
            }
        }

        System.out.println("AFFICHAGE DE Ton terrain");
        joueur.afficherTerrain();
        System.out.println("AFFICHAGE DU TERRAIN ORDI");
        robot.afficherTerrain();

        // Attaque
        System.out.println("le 1er joueur attaque ");







    }
}