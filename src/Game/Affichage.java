package Game;
import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Pioche;
import Game.EnsemblePokemon.Terrain;
import Game.Joueur.JoueurHumain;
import Game.Joueur.RobotPlayer;
import Game.Pokemon;

import java.util.List;

public class Affichage {


    public Affichage()
    {
    }


    public void afficherMain(MainDuJoueur main) {

        for (int i = 0; i < main.getNbPokemon(); i++) {
            main.getPokemon(i).presenter();
        }

    }

    public void afficherTerrain(Terrain terrain){

        afficherPokemon(terrain.getM_terrain());

    }

    public void afficherDefausse(Defausse defausse){
        System.out.println("defausse:" + defausse.getNombreDePokemons());
    }

    public void afficherPioche(Pioche pioche){
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



    private void afficherPokemon(List<Pokemon> pokemons){
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
            System.out.printf("  | Vie: %3d/%-8d |    ", p.getVie(), p.getM_vieMax());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  | Element : %-6s |    ", p.getM_elements());
        }
        System.out.println();

        for (Pokemon p : pokemons) {
            System.out.printf("  |     %-12s |    ", p.getM_nom());
        }
        System.out.println();

        // Afficher la dernière ligne des cadres
        for (Pokemon p : pokemons) {
            System.out.print("  *--------------------*    ");
        }
        System.out.println();
    }




    public void afficherJeu(JoueurHumain joueur1, RobotPlayer joueur2){
        System.out.println("********************************************************************************");
        System.out.println("Tour :");
        System.out.println("Joueur 1");
        afficherPioche(joueur1.getM_pioche());
        afficherDefausse(joueur1.getM_defausse());
        afficherMain(joueur1.getM_main());
        afficherTerrain(joueur1.getM_terrain());


        System.out.println("Joueur 2");
        afficherPioche(joueur2.getM_pioche());
        afficherDefausse(joueur2.getM_defausse());
        afficherMain(joueur2.getM_main());
        afficherTerrain(joueur2.getM_terrain());
        System.out.println("********************************************************************************");
    }
}




