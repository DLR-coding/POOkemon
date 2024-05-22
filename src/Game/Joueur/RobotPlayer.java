package Game.Joueur;

import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.EnsemblePokemon.Terrain;
import Game.Pokemon;

public class RobotPlayer implements Player
{
    private String m_nom;
    private MainDuJoueur m_main;
    private Pioche m_pioche;
    private Terrain m_terrain;
    private Defausse m_defausse;


    private boolean m_joueur1;

    public RobotPlayer(String nom)
    {
        m_nom = nom;
        m_main = new MainDuJoueur();
        m_pioche = new Pioche();
        m_terrain = new Terrain();
        m_defausse = new Defausse();
        m_joueur1 = false;
    }

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

    @Override
    public void setJoueur1(Boolean bool)
    {
        m_joueur1 = bool;
    }

    @Override
    public void piocherPokemon(Pokemon pokemon) {
        this.m_pioche.retirerPokemon(pokemon);
        this.m_main.ajouterPokemon(pokemon);
    }

    @Override
    public Pokemon getPokemonFromPioche(int index) {
        return m_pioche.getPokemon(index);
    }

    @Override
    public void placeSurTerrain(Pokemon pokemon) {
        m_main.retirerPokemon(pokemon);
        m_terrain.ajouterPokemon(pokemon);
    }

    @Override
    public Defausse getM_defausse() {
        return this.m_defausse;
    }

    @Override
    public MainDuJoueur getM_main() {
        return m_main;
    }

    @Override
    public String getM_nom() {
        return m_nom;
    }

    @Override
    public Terrain getM_terrain() {
        return m_terrain;
    }

    @Override
    public void joue(Player humain)
    {

        // Parcourir les pokemons du joueur
        for (int i= 0; i < humain.getM_terrain().getNbPokemon() ; i++) {
            Pokemon pokemonOrdi = m_terrain.getPokemon(i);

            for (int j= 0; j < humain.getM_terrain().getNbPokemon() ; j++) {
                Pokemon pokemonJoueur = humain.getM_terrain().getPokemon(i);
                // Vérifier l'avantage de l'affinité du pokemonOrdinateur sur l'affinité du pokemonJoueur
                if (pokemonOrdi.getM_elements().equals(pokemonJoueur.getM_elements().getFaibleContre()) )
                {
                    // Renvoie le pokemonJoueur avec un désavantage

                }
            }

        }
        // Renvoie null si aucun pokemonJoueur avec un désavantage n'est trouvé


    }

    public void setPioche(Pioche pioche) {
        this.m_pioche = pioche;
    }


    public Pokemon getPokemonFromMain(int i) {
        return m_main.getPokemon(i);
    }

}
