package Game.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemon;

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
            GetPokemonJ1(pokemonJoueur);
            pokemonJoueur.setM_attaque(pokemonJoueur.getM_attaque() / 2);
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
    public void RetourALanormal(Pokemon p){
      m_pj1.setM_attaque(m_pj1.getM_attaque() * 2);
      m_pRobot.setM_attaque(m_pRobot.getM_attaque() * 2);
      m_pj1 = null;
      m_pRobot = null;
      p.setPouvoir(null);
    }

    @Override
    public String getNomPouvoir() {
        return "Intimidation";
    }

    public void GetPokemonJ1(Pokemon p){this.m_pj1 = p ; }

    public void GetPokemonRobot(Pokemon p){this.m_pRobot = p ; }
}



