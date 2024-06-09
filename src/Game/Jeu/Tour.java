package Game.Jeu;

import Game.EnsemblePokemon.Pioche;
import Game.Joueur.JoueurHumain;
import Game.Joueur.Player;
import Game.Joueur.RobotPlayer;
import Game.Pokemon;
import Game.Jeu.Affichage;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant un tour de jeu.
 */
public class Tour {
    private JoueurHumain m_jHumain;
    private RobotPlayer m_jRobot;
    private int m_numTour;
    private Boolean m_arret = false;

    /**
     * Constructeur de la classe Tour.
     *
     * @param humain Le joueur humain participant au tour.
     * @param robot Le joueur robot participant au tour.
     */
    public Tour(JoueurHumain humain, RobotPlayer robot )
    {
        m_jHumain = humain;
        m_jRobot = robot;
        m_numTour = 1;
    }

    /**
     * Initialise les mains des joueurs avec un certain nombre de Pokémons.
     *
     * @param tailleMain La taille de la main pour chaque joueur.
     */

    public void MainJoueurs(int tailleMain)
    {
        // Main pour chaque joueur
        for (int i = 0; i < tailleMain; i++)
        {
            m_jHumain.piocherPokemon(m_jHumain.getPokemonFromPioche(i));
            m_jRobot.piocherPokemon(m_jRobot.getPokemonFromPioche(i));
        }

    }

    /**
     * Gère la phase d'attaque,ainsi que les pouvoir pour un tour donné.
     *
     * @param tour Le numéro du tour.
     */
    public void phaseAttaquer(int tour) {
        int nb = tour % 2;
        System.out.println("le tour est : " + nb);
        if (tour % 2 != 0) { // Si le tour est impair, c'est le joueur 1 qui joue
            if (m_jHumain.isJoueur1()) {

                Pouvoir(m_jHumain);
                for (int i = 0; i < 3; i++) {
                  if(m_jHumain.joue(m_jRobot) == false){
                    i--;
                  }
                  verifMort();
                }
                Pouvoir(m_jRobot);
                for (int i = 0 ; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
                    m_jRobot.joue(m_jHumain);
                    verifMort();
                }

            } else if (m_jRobot.isJoueur1()) {
                Pouvoir(m_jRobot);
                for (int i = 0 ; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
                    m_jRobot.joue(m_jHumain);
                    verifMort();
                }
                Pouvoir(m_jHumain);
                for (int i = 0; i < 3; i++) {
                    if(m_jHumain.joue(m_jRobot) == false){
                        i--;
                    }
                    verifMort();
                }
            }
        } else { // Si le tour est pair, c'est le joueur 2 qui joue
            if (m_jHumain.isJoueur1()) {

                Pouvoir(m_jRobot);
                for (int i = 0 ; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
                    m_jRobot.joue(m_jHumain);
                    verifMort();
                }
                Pouvoir(m_jHumain);
                for (int i = 0; i < 3; i++) {
                    if(m_jHumain.joue(m_jRobot) == false){
                        i--;
                    }
                    verifMort();
                }

            } else if (m_jRobot.isJoueur1()) {
                Pouvoir(m_jHumain);
                for (int i = 0; i <m_jHumain.getM_terrain().getNbPokemon(); i++) {
                    if(m_jHumain.joue(m_jRobot) == false){
                        i--;
                    }
                    verifMort();
                }
                Pouvoir(m_jRobot);
                for (int i = 0 ; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
                    m_jRobot.joue(m_jHumain);
                    verifMort();
                }
            }
        }
        for (int i = 0; i < m_jHumain.getM_terrain().getNbPokemon(); i++) {
            if (m_jHumain.getM_terrain().getPokemon(i).getM_pouvoir() != null) {
                m_jHumain.getM_terrain().getPokemon(i).getM_pouvoir().RetourALanormal(m_jHumain.getM_terrain().getPokemon(i), m_jHumain);

            }
        }
            for (int i = 0; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
            if (m_jRobot.getM_terrain().getPokemon(i).getM_pouvoir() != null) {
                m_jRobot.getM_terrain().getPokemon(i).getM_pouvoir().RetourALanormal(m_jRobot.getM_terrain().getPokemon(i), m_jRobot);
            }
        }

    }

    /**
     * Place les Pokémons des joueurs sur le terrain.
     *
     * @param nbJ1 Le nombre de Pokémons à placer pour le joueur humain.
     * @param nbRobot Le nombre de Pokémons à placer pour le robot.
     */
    public void placementPokemon(int nbJ1,int nbRobot)
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

    /**
     * Initialise les pioches des joueurs.
     */
    public void piochesJoueurs()
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

    /**
     * Choisit aléatoirement quel joueur commence en premier.
     */
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

    /**
     * Vérifie si un Pokémon est mort.
     *
     * @param pokemon Le Pokémon à vérifier.
     * @return true si le Pokémon est mort, false sinon.
     */
    public boolean PokemonMort(Pokemon pokemon){
        if (pokemon.getVie() <= 0){
            return true;
        }
        return false;
    }


    /**
     * Vérifie et gère la mort des Pokémons sur le terrain.
     */
    public void verifMort(){
        int nbMortJ1 = 0;
        int nbMortRobot = 0;
        int index = 0;
        boolean Mort;
        for(int i = 0; i < m_jHumain.getM_terrain().getNbPokemon() ;i++) {
            Mort = PokemonMort(m_jHumain.getM_terrain().getPokemon(i));
            if (Mort == true) {
                nbMortJ1 = 1;
                index = i;
            }
        }
        for(int i = 0; i < m_jRobot.getM_terrain().getNbPokemon() ;i++) {
            Mort = PokemonMort(m_jRobot.getM_terrain().getPokemon(i));
            if (Mort == true) {
                nbMortRobot = 1;
                index = i;
            }
        }


        if(nbMortJ1 !=0 ) {
            m_jHumain.getM_terrain().transferPokemon(m_jHumain.getM_terrain().getPokemon(index) ,m_jHumain.getM_defausse());
        } else if (nbMortRobot != 0 ) {
            m_jRobot.getM_terrain().transferPokemon(m_jRobot.getM_terrain().getPokemon(index) ,m_jRobot.getM_defausse());
        }
        if(m_jHumain.getM_terrain().getNbPokemon() == 4 ){
            nbMortJ1 = 0;
        }
        if(m_jRobot.getM_terrain().getNbPokemon() == 4){
            nbMortRobot = 0;
        }
        if(nbMortJ1 !=0 || nbMortRobot != 0) {
            placementPokemon(nbMortJ1, nbMortRobot);
        }else{
            Affichage.afficherJeu(this);
        }


    }

    /**
     * Active les pouvoirs des Pokémons sur le terrain pour un joueur donné.
     *
     * @param joueur Le joueur dont les pouvoirs des Pokémons doivent être activés.
     */
    public void Pouvoir(Player joueur) {
        if (joueur == m_jHumain) {

            for (int i = 0; i < m_jHumain.getM_terrain().getNbPokemon(); i++) {
                if (joueur.UtilisePouvoir(i) == true) {

                    joueur.getM_terrain().getPokemon(i).getM_pouvoir().activatePouvoir(joueur.getM_terrain().getPokemon(i), m_jHumain, m_jRobot, m_jHumain);
                }
                Affichage.afficherJeu(this);

            }
        }else{
            for (int i = 0; i < m_jRobot.getM_terrain().getNbPokemon(); i++) {
                if (joueur.UtilisePouvoir(i) == true) {

                        joueur.getM_terrain().getPokemon(i).getM_pouvoir().activatePouvoir(joueur.getM_terrain().getPokemon(i), m_jHumain, m_jRobot, m_jRobot);
                }
                Affichage.afficherJeu(this);

            }
        }
    }

    /**
     * Affiche l'état actuel du jeu.
     */
    public void Affichage() {Affichage.afficherJeu(this); }

    /**
     * Obtient le joueur humain.
     *
     * @return Le joueur humain.
     */
    public JoueurHumain getM_jHumain()
    {
        return m_jHumain;
    }

    /**
     * Obtient le joueur robot.
     *
     * @return Le joueur robot.
     */
    public RobotPlayer getM_jRobot()
    {
        return m_jRobot;
    }

    /**
     * Obtient le numéro actuel du tour.
     *
     * @return Le numéro actuel du tour.
     */
    public int getM_numTour()
    {
        return m_numTour;
    }

    }
