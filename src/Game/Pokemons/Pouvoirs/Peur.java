package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Peur implements Pouvoir{

    @Override
    public void activatePouvoir(Pokemon p, Player j1, Player Robot, Player joueur) {
        int nb = 0;
        if(joueur == j1) {
            System.out.println("Selectionner le Pokemon a donner le pouvoir : ");
            Scanner scanner = new Scanner(System.in);
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = Robot.getM_terrain().getPokemonByName(nomPokemonJoueur);
            if(Robot.getM_terrain().getPokemonByName(nomPokemonJoueur) != null) {
                nb = 1;
                pokemonJoueur.setM_attaque(pokemonJoueur.getM_attaque() - 10);

            }

        }else{

            List<Pokemon> ciblesPotentielles = new ArrayList<>();

            for (int i = 0 ; i < j1.getM_terrain().getNbPokemon(); i++) {
                ciblesPotentielles.add(j1.getM_terrain().getPokemon(i));
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
            cibleChoisie.setM_attaque(cibleChoisie.getM_attaque() - 10);
            System.out.println(cibleChoisie.getM_attaque());
        }
        if(nb != 0) {
            nb = 0;
            p.setPouvoir(null);
        }

    }

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
        System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Peur";
    }

    @Override
    public String description(){

        return "Peur, à utilisation unique : le Pokémon choisit un Pokémon du camp adverse.\n Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégats de moins.";}

}


