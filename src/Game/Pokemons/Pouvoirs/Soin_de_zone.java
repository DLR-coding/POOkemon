package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

public class Soin_de_zone implements Pouvoir{

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

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
        System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Soin de zone";
    }

    @Override
    public String description(){

        return "Soin de zone, utilisable à chaque tour : chaque Pokémon de son camp regagne 10 points de vie.";}
}
