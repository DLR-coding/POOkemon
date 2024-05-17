package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Terrain implements EnsemblePokemon {
    private List<Pokemon> m_terrain;

    public Terrain() {
        this.m_terrain = new ArrayList<>();
    }

    public void ajouterPokemon(Pokemon p)
    {
        m_terrain.add(p);
    }

    @Override
    public Pokemon getPokemon(int index) {
        return m_terrain.get(index);
    }

    @Override
    public void afficher()
    {
        /////////
        for (int i = 0; i < m_terrain.size(); i++) {
            System.out.println("  *--------------------*");
            System.out.printf("  | Nom: %-14s |\n", m_terrain.get(i).getM_nom());
            System.out.printf("  | Element: %-10s |\n", m_terrain.get(i).getM_elements().getElmnt());
            System.out.printf("  | Vie: %-13d |\n", m_terrain.get(i).getVie());
            System.out.printf("  | Attaque: %-9d |\n", m_terrain.get(i).getM_attaque());
            System.out.println("  *--------------------*");
        }

    }

    public void retirerPokemon(Pokemon p) {
        m_terrain.remove(p);
    }

    public List<Pokemon> getM_terrain()
    {
        return new ArrayList<>(m_terrain);
    }

    public Pokemon getPokemonAvecLeMoinsDeVie() {
        Pokemon cible = null;
        for (Pokemon p : m_terrain) {
            if (cible == null || p.getVie() < cible.getVie()) {
                cible = p;
            }
        }
        return cible;
    }


}
