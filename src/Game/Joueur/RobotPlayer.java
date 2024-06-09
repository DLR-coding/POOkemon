package Game.Joueur;

import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.EnsemblePokemon.Terrain;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe RobotPlayer représente un joueur robot dans le jeu.
 * Implémente l'interface {@link Player}.
 */
public class RobotPlayer implements Player
{
    private String m_nom;
    private MainDuJoueur m_main;
    private Pioche m_pioche;
    private Terrain m_terrain;
    private Defausse m_defausse;
    private boolean m_joueur1;

    /**
     * Constructeur pour créer un joueur robot avec un nom spécifié.
     *
     * @param nom le nom du joueur robot
     */
    public RobotPlayer(String nom)
    {
        m_nom = nom;
        m_main = new MainDuJoueur();
        m_pioche = new Pioche();
        m_terrain = new Terrain();
        m_defausse = new Defausse();
        m_joueur1 = false;
    }

    /**
     * @return vrai si le joueur est le joueur 1, sinon faux
     */
    @Override
    public boolean isJoueur1()
    {
        if (m_joueur1 == true) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Définit si le joueur est le joueur 1.
     *
     * @param bool vrai si le joueur est le joueur 1, sinon faux
     */
    @Override
    public void setJoueur1(Boolean bool)
    {
        m_joueur1 = bool;
    }

    /**
     * Pioche un Pokémon et l'ajoute à la main du joueur.
     *
     * @param pokemon le Pokémon à piocher
     */
    @Override
    public void piocherPokemon(Pokemon pokemon) {
        this.m_pioche.transferPokemon(pokemon,m_main);
    }

    /**
     * @param index l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la pioche
     */
    @Override
    public Pokemon getPokemonFromPioche(int index) {
        return m_pioche.getPokemon(index);
    }

    /**
     * Place un Pokémon sur le terrain et pioche un nouveau Pokémon pour la main.
     *
     * @param pokemon le Pokémon à placer sur le terrain
     */
    @Override
    public void placeSurTerrain(Pokemon pokemon) {
        m_main.transferPokemon(pokemon,m_terrain);
        System.out.println("Robot repioche pour automatiquement remplir sa main...");
        piocherPokemon(getPokemonFromPioche(m_pioche.getNbPokemon() - 1));

    }

    /**
     * @return la défausse du joueur
     */
    @Override
    public Defausse getM_defausse() {
        return this.m_defausse;
    }

    /**
     * @return la main du joueur
     */
    @Override
    public MainDuJoueur getM_main() {
        return m_main;
    }

    /**
     * @return le nom du joueur
     */
    @Override
    public String getM_nom() {
        return m_nom;
    }

    /**
     * @return le terrain du joueur
     */
    @Override
    public Terrain getM_terrain() {
        return m_terrain;
    }

    /**
     * Permet au joueur robot de jouer un tour en attaquant un Pokémon de l'adversaire.
     *
     * @param adversaire le joueur adversaire
     * @return vrai si le tour est réussi, sinon faux
     */
    @Override
    public Boolean joue(Player adversaire) {

        Random rand = new Random();
        int index = rand.nextInt(m_terrain.getNbPokemon());
        Pokemon attaquant = m_terrain.getPokemon(index);



            Pokemon cible = choisirCible(adversaire.getM_terrain(), attaquant);
            if (cible != null) {
                attaquant.attaquer(cible);
                System.out.println(attaquant.getM_nom() + " attaque " + cible.getM_nom() + " !");
            }

        return true;
    }

    /**
     * Choisit une cible par rapport a ca vie et son element fort contre pour l'attaque parmi les Pokémon de l'adversaire.
     *
     * @param adversairePokemons le terrain de l'adversaire contenant ses Pokémon
     * @param attaquant le Pokémon attaquant
     * @return le Pokémon cible choisi
     */
    public Pokemon choisirCible(Terrain adversairePokemons, Pokemon attaquant) {
        List<Pokemon> ciblesPotentielles = new ArrayList<>();

        // Pokemon avec désavantage d'élément
        for (int i = 0 ; i < adversairePokemons.getNbPokemon(); i++) {
            if (attaquant.getM_elements().getFortContre().equals((adversairePokemons.getPokemon(i).getM_elements().getFaibleContre())))
            {
                ciblesPotentielles.add(adversairePokemons.getPokemon(i));
            }
        }

        // Pokemon avec le moins de PV
        if (ciblesPotentielles.isEmpty()) {
            for (int i = 0 ; i < adversairePokemons.getNbPokemon(); i++) {
                ciblesPotentielles.add(adversairePokemons.getPokemon(i));
            }
        }
        Pokemon cibleChoisie = ciblesPotentielles.get(0);
        for (Pokemon p : ciblesPotentielles) {
            Random randomBool = new Random();
            if (p.getVie() < cibleChoisie.getVie()) {
                cibleChoisie = p;
            } else if (p.getVie() == cibleChoisie.getVie() && randomBool.nextBoolean()) {
                cibleChoisie = p;
            }
        }
        return cibleChoisie;
    }

    /**
     * Permet au joueur robot d'utiliser le pouvoir d'un Pokémon.
     *
     * @param index l'index du Pokémon dans le terrain
     * @return vrai si le pouvoir est utilisé, sinon faux
     */
    @Override
    public Boolean UtilisePouvoir(int index) {
        if (m_terrain.getPokemon(index).getM_pouvoir() != null) {
            Random randomBool = new Random();
            Boolean confirm = randomBool.nextBoolean();
            if (confirm == true) {
                System.out.println("Robot utilise le pouvoir : " + getM_terrain().getPokemon(index).getM_pouvoir().getNomPouvoir());
                return true;
            }
        }
        return false;
    }

    /**
     * Définit la pioche du joueur.
     *
     * @param pioche la pioche à définir
     */
    public void setPioche(Pioche pioche) {
        this.m_pioche = pioche;
    }

    /**
     * @param i l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la main
     */
    public Pokemon getPokemonFromMain(int i) {
        return m_main.getPokemon(i);
    }

    /**
     * @return la pioche du joueur
     */
    public Pioche getM_pioche() {
        return m_pioche;
    }
}
