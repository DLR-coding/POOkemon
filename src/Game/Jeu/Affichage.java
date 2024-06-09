package Game.Jeu;
import Game.Pokemons.EnsemblePokemon.Defausse;
import Game.Pokemons.EnsemblePokemon.MainDuJoueur;
import Game.Pokemons.EnsemblePokemon.Pioche;
import Game.Pokemons.EnsemblePokemon.Terrain;
import Game.Pokemons.Pokemon;
import java.io.IOException;
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
        System.out.println("defausse:" + defausse.getNbPokemon());
    }

     static void afficherPioche(Pioche pioche){
        System.out.println("pioche:" + pioche.getNbPokemon());
    }


    private static void afficherPokemon(List<Pokemon> pokemons) {

        int longueurMaxPouvoir = 22;

        // Afficher la première ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *----------------------------------*    ");
        }
        System.out.println();

        // Afficher les lignes de contenu
        for (Pokemon p : pokemons) {
            System.out.printf("  | Attaque: %-9d               |    ", p.getM_attaque());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Vie: %3d/%-8d                |    ", p.getVie(), p.getM_vieMax());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Element : %-6s                 |    ", p.getM_elements());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            String pouvoir = "aucun";
            if (p.getM_pouvoir() != null) {
                pouvoir = p.getM_pouvoir().getNomPouvoir();
                System.out.printf("  | Power : %-10s   |    ", adjustLength(pouvoir, longueurMaxPouvoir));
            }
            else{
            System.out.printf("  | Power : %-10s   |    ", adjustLength(pouvoir, longueurMaxPouvoir));
           }

        }

        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  |         %-12s             |    ", p.getM_nom());
        }
        System.out.println();

        // Afficher la dernière ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *----------------------------------*    ");
        }
        System.out.println();
    }

    private static String adjustLength(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length);
        } else {
            return String.format("%-" + length + "s", str);
        }
    }



     static void afficherJeu(Tour tour){

         clearConsole();

        System.out.println("********************************************************************************");
        System.out.println("Tour : " + tour.getM_numTour());
        System.out.println("Robot");
        afficherPioche(tour.getM_jRobot().getM_pioche());
        afficherDefausse(tour.getM_jRobot().getM_defausse());
        afficherMain(tour.getM_jRobot().getM_main());
        afficherTerrain(tour.getM_jRobot().getM_terrain());

         System.out.println("****************************************************************************************************************************");

        System.out.println("Toi");
        afficherTerrain(tour.getM_jHumain().getM_terrain());
        afficherPioche(tour.getM_jHumain().getM_pioche());
        afficherDefausse(tour.getM_jHumain().getM_defausse());
        afficherMain(tour.getM_jHumain().getM_main());
         System.out.println("");
         System.out.println("");
        System.out.println("********************************************************************************");
        System.out.println("");
        System.out.println("");
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Assumes a Unix-like system
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}




