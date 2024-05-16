package Jeu.ensemblePokemon;

import Jeu.Pokemon;

public class Pioche implements EnsemblePokemon {
    private Pokemon[] m_pioche;

    public Pioche(int joueur) {
        if (joueur == 1) {
            m_pioche = new Pokemon[20];
        } else if (joueur == 2) {
            m_pioche = new Pokemon[21];
        }
    }

    @Override
    public void ajouterPokemon(int index, Pokemon pokemon) {
        if (index >= 0 && index < m_pioche.length) {
            m_pioche[index] = pokemon;
        } else {
            System.out.println("Index invalide.");
        }
    }

    @Override
    public Pokemon getPokemon(int index) {
        if (index >= 0 && index < m_pioche.length) {
            return m_pioche[index];
        } else {
            System.out.println("Index invalide.");
            return null;
        }
    }

    @Override
    public void afficher() {
        for (int i = 0; i < m_pioche.length; i++) {
            if (m_pioche[i] != null) {
                System.out.println("Pokemon à l'index " + i + ": " + m_pioche[i].getNom() + " - Santé: " + m_pioche[i].getVie() + " - Attaque: " + m_pioche[i].getM_attaque());
            } else {
                System.out.println("Pokemon à l'index " + i + ": vide");
            }
        }
    }
}


