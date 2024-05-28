package Game.Jeu;


import Game.Jeu.Affichage;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.Joueur.JoueurHumain;
import Game.Joueur.Player;
import Game.Joueur.RobotPlayer;
import Game.Jeu.Affichage;
import Game.Pokemon;

import java.util.Random;
import java.util.Scanner;

public class LeJeu
{
    private JoueurHumain m_jHumain;
    private RobotPlayer m_jRobot;
    private int m_numTour;
    private Boolean m_arret = false;

    public LeJeu(JoueurHumain humain, RobotPlayer robot )
    {
        m_jHumain = humain;
        m_jRobot = robot;
        m_numTour = 1;
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
        System.out.println("Création des pioches...");
        piochesJoueurs();
        System.out.println("Création des Mains...");
        MainJoueurs(5);
        placementPokemon(3,3);

        System.out.println("le 1er joueur attaque...");
        phaseAttaquer(m_numTour);
        Affichage.afficherJeu(this);

        while (!m_arret) {
            Affichage.afficherJeu(this);
            m_numTour++;
            phaseAttaquer(m_numTour);
            verifierFinJeu();
        }

    }
    private void verifierFinJeu() {
        if (tousPokemonsElimines(m_jHumain)) {
            m_arret = true;
            System.out.println("Le robot a gagné ! Il lui reste " + nbPokemonsRestants(m_jRobot) + " Pokémons.");
        } else if (tousPokemonsElimines(m_jRobot)) {
            m_arret = true;
            System.out.println("Tu as gagné ! Il te reste " + nbPokemonsRestants(m_jHumain) + " Pokémons.");
        }
    }

    private int nbPokemonsRestants(Player joueur)
    {
        int nbPokemonInitial = (joueur.isJoueur1()) ? 20 : 21;
        int count = nbPokemonInitial - joueur.getM_defausse().getNbPokemon() ;
        return count;
    }

    public boolean tousPokemonsElimines(Player joueur) {
        int nbPokemonInitial = (joueur.isJoueur1()) ? 20 : 21;
        return joueur.getM_defausse().getNbPokemon() == nbPokemonInitial;
    }

    public void phaseAttaquer(int tour) {
        int nb = tour % 2 ;
        System.out.println("le tour est : " + nb);
        if (tour % 2 != 0)
        { // Si le tour est impair, c'est le joueur 1 qui joue
            if (m_jHumain.isJoueur1()) {
                m_jHumain.joue(m_jRobot);
                m_jRobot.joue(m_jHumain);
            }
            else if (m_jRobot.isJoueur1())
            {
                m_jRobot.joue(m_jHumain);
                m_jHumain.joue(m_jRobot);
            }
        }
        else
        { // Si le tour est pair, c'est le joueur 2 qui joue
            if (m_jHumain.isJoueur1()) {
                m_jRobot.joue(m_jHumain);
                m_jHumain.joue(m_jRobot);
            }
            else if (m_jRobot.isJoueur1())
            {
                m_jHumain.joue(m_jRobot);
                m_jRobot.joue(m_jHumain);
            }
        }
        for(int i = 0; i< 3 ; i++){
            verifMort();
        }


    }
    private void placementPokemon(int nbJ1,int nbRobot)
    {
        //Terrain
        if (m_jHumain.isJoueur1())
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");
            Affichage.afficherJeu(this);
            for (int i = 0; i < nbJ1; i++) {
                System.out.println("Quel Pokémon souhaites-tu placer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner.nextInt();

                if (index >= 1 && index <= 5) {
                    m_jHumain.placeSurTerrain(m_jHumain.getPokemonFromMain(index - 1)  );
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
                Affichage.afficherJeu(this);
            }
            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < nbRobot; i++) {
                m_jRobot.placeSurTerrain(m_jRobot.getPokemonFromMain(i));
                Affichage.afficherJeu(this);
            }
        }
        else
        {

            System.out.println("Robot place ses pokemon de sa main à son terrain... ");
            for (int i = 0; i < nbRobot; i++) {
                m_jRobot.placeSurTerrain(m_jRobot.getPokemonFromMain(i));
                Affichage.afficherJeu(this);
            }

            Scanner scanner2 = new Scanner(System.in);

            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");
            Affichage.afficherJeu(this);
            for (int i = 0; i < nbJ1; i++) {
                System.out.println("Quel Pokémon souhaites-tu jouer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner2.nextInt();

                if (index >= 1 && index <= 5) {
                    m_jHumain.placeSurTerrain(m_jHumain.getPokemonFromMain(index - 1));
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
                Affichage.afficherJeu(this);
            }
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

    public boolean PokemonMort(Pokemon pokemon){
         if (pokemon.getVie() <= 0){
             return true;
         }
         return false;
    }

    public void AjouterDefausse(Player joueur,Pokemon pokemon){
        joueur.getM_terrain().retirerPokemon(pokemon);
        joueur.getM_defausse().ajouterPokemon(pokemon);
    }

    public void verifMort(){
         int nbMortJ1 = 0;
        int nbMortRobot = 0;
        int index = 0;
        for(int i = 0; i < 3 ;i++){
            boolean Mort;
            Mort = PokemonMort(m_jHumain.getM_terrain().getPokemon(i));
            if(Mort == true){
               nbMortJ1 = 1;
                index = i ;
            }
            Mort = PokemonMort(m_jRobot.getM_terrain().getPokemon(i));
            if(Mort == true){
                nbMortRobot = 1;
                index = i;
            }
        }
        if(nbMortJ1 !=0) {
            AjouterDefausse(m_jHumain, m_jHumain.getM_terrain().getPokemon(index));
        } else if (nbMortRobot != 0) {
            AjouterDefausse(m_jRobot, m_jRobot.getM_terrain().getPokemon(index));
        }
        if(nbMortJ1 != 0) {
            placementPokemon(nbMortJ1, nbMortRobot);
        } else if (nbMortRobot != 0) {
            placementPokemon(nbMortJ1, nbMortRobot);
        }
    }

    public JoueurHumain getM_jHumain()
    {
        return m_jHumain;
    }

    public RobotPlayer getM_jRobot()
    {
        return m_jRobot;
    }

    public int getM_numTour()
    {
        return m_numTour;
    }





}
