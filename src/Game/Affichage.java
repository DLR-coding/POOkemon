package Game;

import java.util.List;
import Game.EnsemblePokemon.*;
public class Affichage {

    private Terrain terrain;

    public Affichage(Terrain terrain)
    {
        this.terrain = terrain;
    }

    public void afficher() {
        List<Pokemon> pokemons = terrain.getM_terrain();
        if (pokemons.isEmpty()) {
             System.out.println("Le terrain est vide.");
        } else {
            for (Pokemon p : pokemons) {
                afficherPokemon(p);
            }
        }
    }

    private void afficherPokemon(Pokemon p)
    {
        System.out.println("  *--------------------*");
        System.out.printf("  | Nom: %-14s |\n", p.getM_nom());
        System.out.printf("  | Element: %-10s |\n", p.getM_elements().getElmnt());
        System.out.printf("  | Vie: %-13d |\n", p.getVie());
        System.out.printf("  | Attaque: %-9d |\n", p.getM_attaque());
        System.out.println("  *--------------------*");
    }
}


