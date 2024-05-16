package Jeu;
import Jeu.ensemblePokemon.*;
import Jeu.elements.*;
import Jeu.Pokemon;

import java.util.zip.Deflater;

public class Joueur
{
    private String m_nom;
    private MainDuJoueur m_main;
    private Pioche m_pioche;
    private Terrain m_terrain;
    private Defausse m_defausse;

    public Joueur (String nom ,MainDuJoueur main , Pioche pioche, Terrain terrain, Defausse defausse)
    {
        m_nom = nom;
        m_main = main;
        m_pioche = pioche;
        m_terrain = terrain;
        m_defausse = defausse;
    }



}
