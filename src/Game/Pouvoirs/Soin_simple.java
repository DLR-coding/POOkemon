package Game.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Soin_simple implements Pouvoir {

    @Override
    public void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur  ) {

        if(joueur == j1) {
            System.out.println("Selectionner le Pokemon a donner le pouvoir : ");
            Scanner scanner = new Scanner(System.in);
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = j1.getM_terrain().getPokemonByName(nomPokemonJoueur);

            if (pokemonJoueur.getVie() + 30 < pokemonJoueur.getM_vieMax()) {
                if(j1.getM_terrain().getPokemonByName(nomPokemonJoueur) != null) {
                    pokemonJoueur.setVie(pokemonJoueur.getVie() + 30);
                }
            }
        }
        else {

            List<Pokemon> ciblesPotentielles = new ArrayList<>();

            for (int i = 0; i < Robot.getM_terrain().getNbPokemon(); i++) {
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
            if (cibleChoisie.getVie() + 30 < cibleChoisie.getM_vieMax()) {
                cibleChoisie.setVie(cibleChoisie.getVie() + 30);
            }
        }

    }

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
        System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Soin simple";
    }

    @Override
    public String description(){

        return "Soin simple, utilisable à chaque tour : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même).\n Celui-ci regagne 30 points de vie (mais ne peut pas dépasser son nombre de points de vie initial).";}


}
