package Game.Jeu;


import Game.Joueur.JoueurHumain;
import Game.Joueur.Player;
import Game.Joueur.RobotPlayer;

/**
 * Classe représentant une partie de jeu entre un joueur humain et un robot.
 */
public class Partie
{
    private JoueurHumain m_jHumain;
    private RobotPlayer m_jRobot;
    private int m_numTour;
    private Boolean m_arret = false;

    /**
     * Constructeur de la classe Partie.
     *
     * @param humain Le joueur humain participant à la partie.
     * @param robot Le joueur robot participant à la partie.
     */
    public Partie(JoueurHumain humain, RobotPlayer robot )
    {
        m_jHumain = humain;
        m_jRobot = robot;
        m_numTour = 1;
    }

    /**
     * Lance la partie et gère les différentes phases de jeu.
     */
    public void Lunch()
    {
        Tour tour = new Tour(m_jHumain,m_jRobot);
        tour.choix1erJoueur();
        System.out.println("Création des pioches...");
        tour.piochesJoueurs();
        System.out.println("Création des Mains...");
        tour.MainJoueurs(5);
        tour.placementPokemon(3,3);
        tour.Affichage();

        System.out.println("le 1er joueur attaque...");
        tour.phaseAttaquer(m_numTour);
        //Affichage.afficherJeu(this);
        tour.Affichage();

        while (!m_arret) {
            tour.Affichage();
            m_numTour++;
            tour.phaseAttaquer(m_numTour);
            verifierFinJeu();
        }

    }

    /**
     * Vérifie si le jeu doit se terminer en fonction des pokemon du joueur.
     */
    private void verifierFinJeu() {
        if (tousPokemonsElimines(m_jHumain)) {
            m_arret = true;
            System.out.println("Le robot a gagné ! Il lui reste " + nbPokemonsRestants(m_jRobot) + " Pokémons.");
        } else if (tousPokemonsElimines(m_jRobot)) {
            m_arret = true;
            System.out.println("Tu as gagné ! Il te reste " + nbPokemonsRestants(m_jHumain) + " Pokémons.");
        }
    }

    /**
     * Calcule le nombre de Pokémons restants pour un joueur donné.
     *
     * @param joueur Le joueur dont on veut connaître le nombre de Pokémons restants.
     * @return Le nombre de Pokémons restants pour le joueur.
     */
    private int nbPokemonsRestants(Player joueur)
    {
        int nbPokemonInitial = (joueur.isJoueur1()) ? 20 : 21;
        int count = nbPokemonInitial - joueur.getM_defausse().getNbPokemon() ;
        return count;
    }

    /**
     * Vérifie si tous les Pokémons d'un joueur sont éliminés.
     *
     * @param joueur Le joueur dont on veut vérifier si tous les Pokémons sont éliminés.
     * @return true si tous les Pokémons du joueur sont éliminés, false sinon.
     */
    public boolean tousPokemonsElimines(Player joueur) {
        int nbPokemonInitial = (joueur.isJoueur1()) ? 20 : 21;
        return joueur.getM_defausse().getNbPokemon() == nbPokemonInitial;
    }

}
