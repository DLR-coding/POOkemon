package Game.Joueur;

import Game.Elements.Element;
import Game.EnsemblePokemon.*;
import Game.Pokemon;

import java.util.Scanner;

/**
 * La classe JoueurHumain représente un joueur humain dans le jeu.
 * * Implémente l'interface {@link Player}.
 */
public class JoueurHumain implements Player
{
    private String m_nom;
    private MainDuJoueur m_main;
    private Pioche m_pioche;
    private Terrain m_terrain;
    private Defausse m_defausse;
    private boolean m_joueur1;

    /**
     * Constructeur pour créer un joueur humain avec un nom spécifié.
     *
     * @param nom le nom du joueur
     */
    public JoueurHumain(String nom)
    {
        m_nom = nom;
        m_main = new MainDuJoueur();
        m_pioche = new Pioche();
        m_terrain = new Terrain();
        m_defausse = new Defausse();
        m_joueur1 = false;
    }

    /**
     * @return la défausse du joueur
     */
    public Defausse getM_defausse() {
        return m_defausse;
    }

    /**
     * @return la main du joueur
     */
    public MainDuJoueur getM_main() {
        return m_main;
    }

    /**
     * @param i l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la main
     */
    public Pokemon getPokemonFromMain(int i) {
        return m_main.getPokemon(i);
    }

    /**
     * @return le nom du joueur
     */
    public String getM_nom() {
        return m_nom;
    }

    /**
     * @param index l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la pioche
     */
    public Pokemon getPokemonFromPioche(int index) {
        return m_pioche.getPokemon(index);
    }

    /**
     * Place un Pokémon sur le terrain et pioche un nouveau Pokémon pour la main.
     *
     * @param pokemon le Pokémon à placer sur le terrain
     */
    @Override
    public void placeSurTerrain(Pokemon pokemon)
    {
        this.m_main.transferPokemon(pokemon,m_terrain);
        System.out.println("Joueur repioche pour automatiquement remplir sa main...");
        piocherPokemon(getPokemonFromPioche(m_pioche.getNbPokemon() - 1));

    }

    /**
     * @return le terrain du joueur
     */
    public Terrain getM_terrain() {
        return m_terrain;
    }

    /**
     * @return vrai si le joueur est le joueur 1, sinon faux
     */
    @Override
    public boolean isJoueur1() {
        if (m_joueur1 == true)
        {
            return true;
        }
        else
        {
            return false;
        }
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
     * Définit si le joueur est le joueur 1.
     *
     * @param bool vrai si le joueur est le joueur 1, sinon faux
     */
    @Override
    public void setJoueur1(Boolean bool) {
        m_joueur1 = bool;
    }

    /**
     * Pioche un Pokémon et l'ajoute à la main du joueur.
     *
     * @param pokemon le Pokémon à piocher
     */
    @Override
    public void piocherPokemon(Pokemon pokemon)
    {
        this.m_pioche.transferPokemon(pokemon, m_main);
    }

    /**
     * Permet au joueur humain de jouer un tour en attaquant un Pokémon de l'adversaire.
     *
     * @param adversaire le joueur adversaire
     * @return vrai si le tour est réussi, sinon faux
     */
    public Boolean joue(Player adversaire)
    {
        Scanner scanner = new Scanner(System.in);


            System.out.println("Quel Pokémon souhaites-tu jouer depuis ta main ? (Donne le nom du Pokémon)");
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = m_terrain.getPokemonByName(nomPokemonJoueur);

            if (pokemonJoueur == null) {
                System.out.println("Pokémon introuvable dans ta main. Réessaye.");
                return false; // Pour redemander le choix pour le même tour
               // continue;
            }

            System.out.println("Quel Pokémon de l'adversaire souhaites-tu attaquer ? (Donne le nom du Pokémon)");
            String nomPokemonAdversaire = scanner.nextLine();
            Pokemon pokemonAdversaire = adversaire.getM_terrain().getPokemonByName(nomPokemonAdversaire);

            if (pokemonAdversaire == null) {
                System.out.println("Pokémon introuvable sur le terrain de l'adversaire. Réessaye.");
                return false; // Pour redemander le choix pour le même tour
                //continue;
            }
            System.out.println(pokemonJoueur.getM_nom() + " attaque " + pokemonAdversaire.getM_nom() + " !");
            pokemonJoueur.attaquer(pokemonAdversaire);

            return true;
    }

    /**
     * Permet au joueur humain d'utiliser le pouvoir d'un Pokémon.
     *
     * @param index l'index du Pokémon dans le terrain
     * @return vrai si le pouvoir est utilisé, sinon faux
     */
    @Override
    public Boolean UtilisePouvoir(int index) {
        if (m_terrain.getPokemon(index).getM_pouvoir() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veut tu utiliser le pouvoir : " + getM_terrain().getPokemon(index).getM_pouvoir().getNomPouvoir() + " \"i\" pour info sur le pouvoir y/n");
            String confirmInfo = scanner.nextLine();
            if (confirmInfo.equals("y") || confirmInfo.equals("i")) {// Utilisation de equals pour comparer le contenu des chaînes

                if(confirmInfo.equals("i")){
                    System.out.println(getM_terrain().getPokemon(index).getM_pouvoir().description());
                     System.out.println("Veut tu utiliser le pouvoir : " + getM_terrain().getPokemon(index).getM_pouvoir().getNomPouvoir() + " y/n");
                     String confirm = scanner.nextLine();
                     if (confirm.equals("y")) {// Utilisation de equals pour comparer le contenu des chaînes
                         return true;
                     }
                }
                else {
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * @return la pioche du joueur
     */
    public Pioche getM_pioche() {
        return m_pioche;
    }

}


