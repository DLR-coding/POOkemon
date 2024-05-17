package Game.Joueur;

import Game.EnsemblePokemon.*;
import Game.Pokemon;

public class JoueurHumain implements Player
{
    private String m_nom;
    private MainDuJoueur m_main;
    private Pioche m_pioche;
    private Terrain m_terrain;
    private Defausse m_defausse;
    private boolean m_joueur1;

    public JoueurHumain(String nom)
    {
        m_nom = nom;
        m_main = new MainDuJoueur();
        m_pioche = new Pioche();
        m_terrain = new Terrain();
        m_defausse = new Defausse();
        m_joueur1 = false;
    }

    /*
    public void RemplireTerrain(){
        for(int i = 0;i< 3 ;i++)
            m_terrain.ajouterPokemon(getPokemonFromMain(i));
    }

     */



    public boolean aDesPokemons() {
        for (int i = 0; i < 4; i++) {
            if (m_main.getPokemon(i) == null) {
                return false;
            }
        }
        return true;
    }

    public Defausse getM_defausse() {
        return m_defausse;
    }

    public MainDuJoueur getM_main() {
        return m_main;
    }

    public Pokemon getPokemonFromMain(int i) {
        return m_main.getPokemon(i);
    }

    public String getM_nom() {
        return m_nom;
    }

    public Pokemon getPokemonFromPioche(int index) {
        return m_pioche.getPokemon(index);
    }

    @Override
    public void placeSurTerrain(Pokemon pokemon)
    {
        this.m_main.retirerPokemon(pokemon);
        this.m_terrain.ajouterPokemon(pokemon);
    }


    public Terrain getM_terrain() {
        return m_terrain;
    }

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

    public void setPioche(Pioche pioche) {
        this.m_pioche = pioche;
    }

    @Override
    public void setJoueur1(Boolean bool) {
        m_joueur1 = bool;
    }

    @Override
    public void piocherPokemon(Pokemon pokemon)
    {
             this.m_pioche.retirerPokemon(pokemon);
             this.m_main.ajouterPokemon(pokemon);
    }

    public void afficherPioche()
    {
        m_pioche.afficher();
    }
    public void afficherMain()
    {
        m_main.afficher();
    }

    public void afficherTerrain() {
        m_terrain.afficher();
    }
}


