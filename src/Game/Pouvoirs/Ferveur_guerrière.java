package Game.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Ferveur_guerrière implémente le pouvoir Ferveur Guerrière pour un Pokémon.
 * Ferveur Guerrière augmente l'attaque d'un Pokémon choisi de 10 points jusqu'à la fin de la partie ou à sa mort
 *
 * Implémente l'interface {@link Pouvoir}.
 */
public class Ferveur_guerrière implements Pouvoir  {

    /**
     * Active le pouvoir Ferveur Guerrière sur un Pokémon.
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
                pokemonJoueur.setM_attaque(pokemonJoueur.getM_attaque() + 10);
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
            cibleChoisie.setM_attaque(cibleChoisie.getM_attaque() + 10);
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
        return "Ferveur Guerriere";
    }

    /**
     * Fournit une description du pouvoir Ferveur Guerrière.
     *
     * @return la description du pouvoir
     */
    @Override
    public String description(){

        return "Ferveur guerrière, à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). \nJusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégâts de plus.";}

}
