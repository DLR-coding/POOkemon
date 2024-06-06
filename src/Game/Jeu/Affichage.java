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
            System.out.print("  *---------------------*    ");
        }
        System.out.println();

        // Afficher les lignes de contenu
        for (Pokemon p : pokemons) {
            System.out.printf("  | Attaque: %-9d  |    ", p.getM_attaque());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Vie: %3d/%-8d   |    ", p.getVie(), p.getM_vieMax());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Element : %-6s    |    ", p.getM_elements());
        }
        System.out.println();


         String[] tab;
        for (Pokemon p : pokemons) {
            String pouvoir = "nul";
                if (p.getM_pouvoir() != null) {
                    if(!p.getM_pouvoir().getNomPouvoir().contains(" ") ) {
                        pouvoir = p.getM_pouvoir().getNomPouvoir();
                        System.out.printf("  | Power : %-10s  |     ", pouvoir);
                    }
                    else{
                         String pouvoir1 = p.getM_pouvoir().getNomPouvoir();
                        tab = pouvoir1.split(" ");
                        if(tab.length == 2){
                            pouvoir1 = " ";
                        }else {
                            pouvoir1 = tab[0];
                        }

                        System.out.printf("  | Power : %-10s |     ", pouvoir1);

                    }

                }else {
                    System.out.printf("  | Power : %-10s |     ", pouvoir);
                }
        }

        System.out.println();


          for (Pokemon p : pokemons) {

            String pouvoir2;
            if (p.getM_pouvoir() != null) {
                if(p.getM_pouvoir().getNomPouvoir().contains(" ") ) {
                    pouvoir2 = p.getM_pouvoir().getNomPouvoir();
                    tab = pouvoir2.split(" ");
                    pouvoir2 = p.getM_pouvoir().getNomPouvoir();
                    if(tab.length == 3){
                        pouvoir2 = tab[1];
                        pouvoir2 = pouvoir2 + " " + tab[2];
                        System.out.printf("  |     %-10s   |    ", pouvoir2);
                    }else {

                        System.out.printf("  |    %-10s  |    ", pouvoir2);
                    }
                }
                else {
                    pouvoir2 = " ";
                    System.out.printf("  |      %-10s     |    ", pouvoir2);

                }
            }
            else {
                pouvoir2 = "nul";
                System.out.printf("  |      %-10s     |    ", pouvoir2);
                  }
         }

        System.out.println();



        for (Pokemon p : pokemons) {
            System.out.printf("  |     %-12s    |    ", p.getM_nom());
        }
        System.out.println();

        // Afficher la dernière ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *---------------------*    ");
        }
        System.out.println();
    }




     static void afficherJeu(Tour tour){
        System.out.println("********************************************************************************");
        System.out.println("Tour :"+ tour.getM_numTour());
        System.out.println("Robot");
        afficherPioche(tour.getM_jRobot().getM_pioche());
        afficherDefausse(tour.getM_jRobot().getM_defausse());
        afficherMain(tour.getM_jRobot().getM_main());
        afficherTerrain(tour.getM_jRobot().getM_terrain());

         System.out.println("********************************************************************************");

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
}




