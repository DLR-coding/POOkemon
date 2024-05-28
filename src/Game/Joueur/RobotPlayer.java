package Game.Joueur;

import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.EnsemblePokemon.Terrain;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        this.m_pioche.transferPokemon(pokemon,m_main);
    }

    @Override
    public Pokemon getPokemonFromPioche(int index) {
        return m_pioche.getPokemon(index);
    }

    @Override
    public void placeSurTerrain(Pokemon pokemon) {
        m_main.transferPokemon(pokemon,m_terrain);
        System.out.println("Robot repioche pour automatiquement remplir sa main...");
        piocherPokemon(getPokemonFromPioche(m_pioche.getNbPokemon() - 1));


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
    public void joue(Player adversaire) {

        Random rand = new Random();
        int index = rand.nextInt(m_terrain.getNbPokemon());
        Pokemon attaquant = m_terrain.getPokemon(index);


        for (int i = 0 ; i < adversaire.getM_terrain().getNbPokemon(); i++)
        {
            Pokemon cible = choisirCible(adversaire.getM_terrain(), attaquant);
            if (cible != null) {
                attaquant.Attaquer(cible);
                System.out.println(attaquant.getM_nom() + " attaque " + cible.getM_nom() + " !");
            }
        }
    }

    private Pokemon choisirCible(Terrain adversairePokemons, Pokemon attaquant) {
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

    public void setPioche(Pioche pioche) {
        this.m_pioche = pioche;
    }


    public Pokemon getPokemonFromMain(int i) {
        return m_main.getPokemon(i);
    }

    public Pioche getM_pioche() {
        return m_pioche;
    }


}
