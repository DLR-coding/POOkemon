package Game.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Berserk implémente le pouvoir Berserk pour un Pokémon.
 * Berserk double l'attaque d'un Pokémon choisi pour le tour en cours.
 *
 * Implémente l'interface {@link Pouvoir}.
 */
public class Berserk implements Pouvoir{

    private Pokemon m_pj1;
    private Pokemon m_pRobot;

    /**
     * Active le pouvoir Berserk sur un Pokémon.
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param j1 le joueur humain
     * @param Robot le joueur robot
     * @param joueur le joueur actuel
     */
    @Override
    public void activatePouvoir(Pokemon p, Player j1, Player Robot,Player joueur) {
        if(joueur == j1) {
            System.out.println("Selectionner le Pokemon a donner le pouvoir : ");
            Scanner scanner = new Scanner(System.in);
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = j1.getM_terrain().getPokemonByName(nomPokemonJoueur);

            if(j1.getM_terrain().getPokemonByName(nomPokemonJoueur) != null) {
                GetPokemonJ1(pokemonJoueur);
                pokemonJoueur.setM_attaque(pokemonJoueur.getM_attaque() * 2);
            }
        }
        else{

            List<Pokemon> ciblesPotentielles = new ArrayList<>();

            for (int i = 0 ; i < Robot.getM_terrain().getNbPokemon(); i++) {
                ciblesPotentielles.add(Robot.getM_terrain().getPokemon(i));
            }

            Pokemon cibleChoisie = ciblesPotentielles.get(0);
            for (Pokemon po : ciblesPotentielles) {
                Random randomBool = new Random();
                if (p.getVie() < cibleChoisie.getVie()) {
                    cibleChoisie = p;
                } else if (p.getVie() == cibleChoisie.getVie() && randomBool.nextBoolean()) {
                    cibleChoisie = po;
                }
            }
            GetPokemonRobot(cibleChoisie);
            cibleChoisie.setM_attaque(cibleChoisie.getM_attaque() * 2);
        }
    }

    /**
     * Retourne le Pokémon affecté à son état normal après l'utilisation du pouvoir.
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param joueur le joueur actuel
     */
    @Override
    public void RetourALanormal(Pokemon p,Player joueur) {
        if (m_pj1 != null) {

        if(joueur.getM_nom().equals("j1")) {
            m_pj1.setM_attaque(m_pj1.getM_attaque() / 2);
            p.setPouvoir(null);
        }
            m_pj1 = null;
    }
        if (m_pRobot != null) {
            if (joueur.getM_nom().equals("Robot1")) {
                m_pRobot.setM_attaque(m_pRobot.getM_attaque() / 2);
                p.setPouvoir(null);
            }
            m_pRobot = null;
        }
    }

    /**
     * Obtient le nom du pouvoir.
     *
     * @return le nom du pouvoir
     */
    @Override
    public String getNomPouvoir() {
        return "Berserk";
    }

    /**
     * Enregistre le Pokémon joueur humain affecté par le pouvoir.
     *
     * @param p le Pokémon affecté
     */
    public void GetPokemonJ1(Pokemon p){this.m_pj1 = p ; }

    /**
     * Enregistre le Pokémon robot affecté par le pouvoir.
     *
     * @param p le Pokémon affecté
     */
    public void GetPokemonRobot(Pokemon p){this.m_pRobot = p ; }

    /**
     * Fournit une description du pouvoir Berserk.
     *
     * @return la description du pouvoir
     */
    @Override
    public String description(){
    return "Berserk, à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même).\n Pour le tour en cours, l'attaque de ce Pokémon est doublée.";}
}
