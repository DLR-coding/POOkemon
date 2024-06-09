package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Intimidation implements Pouvoir {

    private Pokemon m_pj1;
    private Pokemon m_pRobot;

    @Override
    public void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur) {

        if(joueur == j1) {
            System.out.println("Selectionner le Pokemon a donner le pouvoir : ");
            Scanner scanner = new Scanner(System.in);
            String nomPokemonJoueur = scanner.nextLine();
            Pokemon pokemonJoueur = Robot.getM_terrain().getPokemonByName(nomPokemonJoueur);

            if(Robot.getM_terrain().getPokemonByName(nomPokemonJoueur) != null) {
                GetPokemonJ1(pokemonJoueur);
                pokemonJoueur.setM_attaque(pokemonJoueur.getM_attaque() / 2);
            }
        }
        else {

            List<Pokemon> ciblesPotentielles = new ArrayList<>();

            for (int i = 0; i < j1.getM_terrain().getNbPokemon(); i++) {
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
            GetPokemonRobot(cibleChoisie);
            cibleChoisie.setM_attaque(cibleChoisie.getM_attaque() / 2);
        }
    }

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
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

    @Override
    public String getNomPouvoir() {
        return "Intimidation";
    }

    public void GetPokemonJ1(Pokemon p){this.m_pj1 = p ; }

    public void GetPokemonRobot(Pokemon p){this.m_pRobot = p ; }

    @Override
    public String description(){

        return "Intimidation, à utilisation unique : le Pokémon choisit un Pokémon du camp adverse.\n Pour le prochain tour de l'adversaire, les dégats infligés par le Pokémon choisi sont réduits de moitié.";}
}



