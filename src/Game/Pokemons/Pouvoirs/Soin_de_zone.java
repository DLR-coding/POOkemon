package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

/**
 * La classe Soin_de_zone implémente le pouvoir Soin de zone pour un Pokémon.
 * Soin de zone permet à chaque Pokémon du camp du Pokémon utilisateur de regagner 10 points de vie.
 *
 * Implémente l'interface {@link Pouvoir}.
 */
public class Soin_de_zone implements Pouvoir{

    /**
     * Active le pouvoir Soin de zone, permettant à chaque Pokémon du camp du Pokémon utilisateur de regagner 10 points de vie.
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param j1 le joueur humain
     * @param Robot le joueur robot
     * @param joueur le joueur actuel
     */
    @Override
    public void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur) {


        if(joueur == j1) {
            for (int i = 0; i < 3; i++) {
                if (j1.getM_terrain().getPokemon(i).getVie() + 10 < j1.getM_terrain().getPokemon(i).getM_vieMax()) {
                    j1.getM_terrain().getPokemon(i).setVie(j1.getM_terrain().getPokemon(i).getVie() + 10);
                }

            }
        }
        else{
            for (int i = 0; i < 3; i++) {
                if (Robot.getM_terrain().getPokemon(i).getVie() + 10 < Robot.getM_terrain().getPokemon(i).getM_vieMax()) {
                    Robot.getM_terrain().getPokemon(i).setVie(Robot.getM_terrain().getPokemon(i).getVie() + 10);
                }
            }
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
        return "Soin de zone";
    }

    /**
     * Fournit une description du pouvoir Soin de zone.
     *
     * @return la description du pouvoir
     */
    @Override
    public String description(){

        return "Soin de zone, utilisable à chaque tour : chaque Pokémon de son camp regagne 10 points de vie.";}
}
