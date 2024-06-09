package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Soin_total implémente le pouvoir Soin total pour un Pokémon.
 * Soin total permet à un Pokémon du camp du lanceur de regagner toute sa vie.
 *
 * Implémente l'interface {@link Pouvoir}.
 */
public class Soin_total implements Pouvoir {

    /**
     * Active le pouvoir Soin total, permettant à un Pokémon du camp du lanceur de regagner toute sa vie.
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param j1 le joueur humain
     * @param Robot le joueur robot
     * @param joueur le joueur actuel
     */
    @Override
    public void activatePouvoir(Pokemon p, Player j1, Player Robot,Player joueur) {

        int nb = 0;
        if(joueur == j1) {
            System.out.println("Selectionner le Pokemon a donner le pouvoir : ");
            Scanner scanner = new Scanner(System.in);
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = j1.getM_terrain().getPokemonByName(nomPokemonJoueur);
            if(j1.getM_terrain().getPokemonByName(nomPokemonJoueur) != null) {
                nb = 1;
                pokemonJoueur.setVie(pokemonJoueur.getM_vieMax());
            }
        }else{

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
            cibleChoisie.setVie(cibleChoisie.getM_vieMax());
        }
        if(nb != 0) {
            nb = 0;
            p.setPouvoir(null);
        }
    }

    /**
     * Retourne rien pour se pouvoir
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param joueur le joueur actuel
     */
    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
        System.out.print("");
    }

    /**
     * Obtient le nom du pouvoir.
     *
     * @return le nom du pouvoir
     */
    @Override
    public String getNomPouvoir() {
        return "Soin total";
    }

    /**
     * Fournit une description du pouvoir Soin total.
     *
     * @return la description du pouvoir
     */
    @Override
    public String description(){
        return "Soin total, à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Celui-ci regagne toute sa vie.";}
}
