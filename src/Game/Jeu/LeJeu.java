package Game.Jeu;

import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.Joueur.JoueurHumain;
import Game.Joueur.RobotPlayer;

import java.util.Random;
import java.util.Scanner;

public class LeJeu
{
    private JoueurHumain m_jHumain;
    private RobotPlayer m_jRobot;
    private int m_numTour;

    public LeJeu(JoueurHumain humain, RobotPlayer robot )
    {
        m_jHumain = humain;
        m_jRobot = robot;
        m_numTour = 0;
    }
    public void MainJoueurs(int tailleMain)
    {
        // Main pour chaque joueur
        for (int i = 0; i < tailleMain; i++)
        {
            m_jHumain.piocherPokemon(m_jHumain.getPokemonFromPioche(i));
            m_jRobot.piocherPokemon(m_jRobot.getPokemonFromPioche(i));
        }

    }

    public void Lunch()
    {
        choix1erJoueur();
        piochesJoueurs();
        MainJoueurs(5);
        placementPokemon();


        System.out.println("le 1er joueur attaque...");
        phaseAttaquer();

    }

    public void phaseAttaquer()
    {
        //Attaque
        if (m_jHumain.isJoueur1()) {
            m_jHumain.joue(m_jRobot);
        } else {
            m_jRobot.joue(m_jHumain);
        }
    }
    private void placementPokemon()
    {
        //Terrain
        if (m_jHumain.isJoueur1())
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");

            for (int i = 0; i < 3; i++) {
                System.out.println("Quel Pokémon souhaites-tu jouer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner.nextInt();

                if (index >= 1 && index <= 5) {
                    m_jHumain.placeSurTerrain(m_jHumain.getPokemonFromMain(index));
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
            }
            scanner.close();
            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < 3; i++) {
                m_jRobot.placeSurTerrain(m_jRobot.getPokemonFromMain(i));
            }
        }
        else
        {

            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < 3; i++) {
                m_jRobot.placeSurTerrain(m_jRobot.getPokemonFromMain(i));
            }

            Scanner scanner2 = new Scanner(System.in);

            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");

            for (int i = 0; i < 3; i++) {
                System.out.println("Quel Pokémon souhaites-tu jouer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner2.nextInt();

                if (index >= 1 && index <= 5) {
                    m_jHumain.placeSurTerrain(m_jHumain.getPokemonFromMain(index));
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
            }
            scanner2.close();
        }
    }

    private void piochesJoueurs()
    {
        // Initialisation des pioches
        Pioche piocheJoueur1;
        Pioche piocheJoueur2;
        piocheJoueur1 = new Pioche(20);
        piocheJoueur2 = new Pioche(21);
        if (m_jHumain.isJoueur1()) {
            m_jHumain.setPioche(piocheJoueur1);
            m_jRobot.setPioche(piocheJoueur2);
        } else {
            m_jHumain.setPioche(piocheJoueur2);
            m_jRobot.setPioche(piocheJoueur1);
        }
    }

    // Choix random de qui joue en premier
    public void choix1erJoueur()
    {
        Random random = new Random();
        int joueur1Random = random.nextInt(2) + 1;
        if (joueur1Random == 1) {
            System.out.println("Tu joue en 1er");
            m_jHumain.setJoueur1(true); //le joueur 1 est le joueur humain
            m_jRobot.setJoueur1(false);
        } else {
            System.out.println("Le robot joue en 1er");
            m_jHumain.setJoueur1(false); // le joueur 1 est l'ordinateur
            m_jRobot.setJoueur1(true);
        }
    }



}
