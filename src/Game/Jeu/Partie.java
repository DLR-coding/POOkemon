package Game.Jeu;


import Game.Joueur.JoueurHumain;
import Game.Joueur.Player;
import Game.Joueur.RobotPlayer;

public class Partie
{
    private JoueurHumain m_jHumain;
    private RobotPlayer m_jRobot;
    private int m_numTour;
    private Boolean m_arret = false;

    public Partie(JoueurHumain humain, RobotPlayer robot )
    {
        m_jHumain = humain;
        m_jRobot = robot;
        m_numTour = 1;
    }

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

}
