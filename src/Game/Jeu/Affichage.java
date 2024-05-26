package Game.Jeu;
import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.EnsemblePokemon.Terrain;
import Game.Joueur.JoueurHumain;
import Game.Joueur.RobotPlayer;
import Game.Pokemon;

import java.util.List;

public class Affichage {



    static void afficherMain(MainDuJoueur main) {

        for (int i = 0; i < main.getNbPokemon(); i++) {
            System.out.print(i+1 +" : ");
            main.getPokemon(i).presenter();
        }

    }

     static void afficherTerrain(Terrain terrain){

        afficherPokemon(terrain.getM_terrain());


    }

     static void afficherDefausse(Defausse defausse){
        System.out.println("defausse:" + defausse.getNombreDePokemons());
    }

     static void afficherPioche(Pioche pioche){
        System.out.println("pioche:" + pioche.getNbPokemon());
    }

   /* private void afficherPokemon(Pokemon p)
    {
        System.out.println("  *--------------------*");
        System.out.printf("  | Nom: %-14s |\n", p.getM_nom());
        System.out.printf("  | Element: %-10s |\n", p.getM_elements().getElmnt());
        System.out.printf("  | Vie: %-13d |\n", p.getVie());
        System.out.printf("  | Attaque: %-9d |\n", p.getM_attaque());
        System.out.println("  *--------------------*");
    }*/



    private static void afficherPokemon(List<Pokemon> pokemons){
        // Afficher la première ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *--------------------*    ");
        }
        System.out.println();

        // Afficher les lignes de contenu
        for (Pokemon p : pokemons) {
            System.out.printf("  | Attaque: %-9d |    ", p.getM_attaque());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Vie: %3d/%-8d  |    ", p.getVie(), p.getM_vieMax());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Element : %-6s   |    ", p.getM_elements());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  |     %-12s   |    ", p.getM_nom());
        }
        System.out.println();

        // Afficher la dernière ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *--------------------*    ");
        }
        System.out.println();
    }




     static void afficherJeu(LeJeu jeu){
        System.out.println("********************************************************************************");
         System.out.println("");
         System.out.println("");
        System.out.println("Tour :"+ jeu.getM_numTour());
        System.out.println("Robot");
        afficherPioche(jeu.getM_jRobot().getM_pioche());
        afficherDefausse(jeu.getM_jRobot().getM_defausse());
        afficherMain(jeu.getM_jRobot().getM_main());
        afficherTerrain(jeu.getM_jRobot().getM_terrain());


        System.out.println("Toi");
        afficherPioche(jeu.getM_jHumain().getM_pioche());
        afficherDefausse(jeu.getM_jHumain().getM_defausse());
        afficherMain(jeu.getM_jHumain().getM_main());
        afficherTerrain(jeu.getM_jHumain().getM_terrain());
        System.out.println("********************************************************************************");
        System.out.println("");
        System.out.println("");
    }
}




