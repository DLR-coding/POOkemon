package Game.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Peur implémente le pouvoir Peur pour un Pokémon.
 * Peur réduit l'attaque d'un Pokémon adverse choisi de 10.
 *
 * Implémente l'interface {@link Pouvoir}.
 */
public class Peur implements Pouvoir{

    /**
     * Active le pouvoir Peur sur un Pokémon adverse.
     *
     * @param p le Pokémon utilisant le pouvoir
     * @param j1 le joueur humain
     * @param Robot le joueur robot
     * @param joueur le joueur actuel
     */
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

    /**
     * Retourne rien pour se pouvoir.
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
        return "Peur";
    }

    /**
     * Fournit une description du pouvoir Peur.
     *
     * @return la description du pouvoir
     */
    @Override
    public String description(){

        return "Peur, à utilisation unique : le Pokémon choisit un Pokémon du camp adverse.\n Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégats de moins.";}

}


