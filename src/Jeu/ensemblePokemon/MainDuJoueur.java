package Jeu.ensemblePokemon;

import Jeu.Pokemon;
public class MainDuJoueur implements EnsemblePokemon
    {
            private Pokemon[] m_mainJoueur;

            public MainDuJoueur()
            {
                m_mainJoueur = new Pokemon[5];
            }

            @Override
            public void ajouterPokemon(int index, Pokemon pokemon) {
                if (index >= 0 && index < m_mainJoueur.length)
                {
                    m_mainJoueur[index] = pokemon;
                } else
                {
                    System.out.println("Index invalide.");
                }
            }

            @Override
            public Pokemon getPokemon(int index) {
                if (index >= 0 && index < m_mainJoueur.length) {
                    return m_mainJoueur[index];
                } else {
                    System.out.println("Index invalide.");
                    return null;
                }
            }

            @Override
            public void afficherMain() {
                for (int i = 0; i < m_mainJoueur.length; i++) {
                    if (m_mainJoueur[i] != null) {
                        System.out.println("Pokemon" + i + ": " + m_mainJoueur[i].getNom() + " - Santé: " + m_mainJoueur[i].getVie() + " - Attaque: " + m_mainJoueur[i].getM_attaque());
                    } else {
                        System.out.println("Pokemon " + i + ": vide");
                    }
                }
            }

    }
