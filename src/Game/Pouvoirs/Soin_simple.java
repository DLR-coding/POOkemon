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
                pokemonJoueur.setVie(pokemonJoueur.getVie() + 30);
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
            if (cibleChoisie.getVie() + 30 < cibleChoisie.getM_vieMax()) {
                cibleChoisie.setVie(cibleChoisie.getVie() + 30);
            }
        }
            p.setPouvoir(null);


    }

    @Override
    public void RetourALanormal(Pokemon p){
        System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Soin simple";
    }


}
