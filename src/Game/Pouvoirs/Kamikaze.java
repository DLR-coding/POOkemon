package Game.Pouvoirs;

import Game.Jeu.Affichage;
import Game.Joueur.Player;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Kamikaze implements Pouvoir {

    @Override
    public void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur) {

        if(joueur == j1) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Selectionner le Pokemon a expolser : ");
            String nomPokemonRobot = scanner.nextLine();
            Pokemon pokemonRobot = Robot.getM_terrain().getPokemonByName(nomPokemonRobot);

            j1.getM_terrain().transferPokemon(p, j1.getM_defausse());
            Robot.getM_terrain().transferPokemon(pokemonRobot, Robot.getM_defausse());


            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");
            for (int i = 0; i < j1.getM_main().getNbPokemon(); i++) {
                System.out.print(i + 1 + " : ");
                j1.getM_main().getPokemon(i).presenter();
            }

            for (int i = 0; i < 1; i++) {
                System.out.println("Quel Pokémon souhaites-tu placer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner.nextInt();

                if (index >= 1 && index <= 5) {
                    j1.placeSurTerrain(j1.getM_main().getPokemon(index - 1));
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
                System.out.println("Robot place ses pokemon de sa main à son terrain... ");
                for (int j = 0; i < 1; i++) {
                    Robot.placeSurTerrain(Robot.getM_main().getPokemon(index - 1));
                }
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
            Robot.getM_terrain().transferPokemon(p, Robot.getM_defausse());
            j1.getM_terrain().transferPokemon(cibleChoisie, j1.getM_defausse());

        }

    }

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
      System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Kamikaze";
    }

    @Override
    public String description(){

        return "Kamikaze, à utilisation unique : le Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés.";}
}
