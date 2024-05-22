package Game;

import Game.Elements.*;

import java.util.ArrayList;

public class Pokemon
{
    private String m_nom;
    private Element m_elements;
    private int m_vie;
    private int m_attaque;

    public Pokemon(String nom){
        m_nom = nom;
    }

    public Pokemon(String nom, Element elements, int vie, int attaque )
    {
        m_nom = nom;
        m_elements = elements;
        m_vie = vie ;
        m_attaque = attaque;

    }


    public void Attaquer(Pokemon blesser)
    {
        int attaque = 0;
        if (m_elements.getFortContre() == blesser.m_elements.toString()) {
            attaque = 10;
        }
        else if (m_elements.getFaibleContre() == blesser.m_elements.toString()) {
            attaque = -10;
        }
        attaque = attaque + this.m_attaque;
        blesser.m_vie = blesser.m_vie - attaque ;
        System.out.println(m_nom + " attaque de " + attaque + " a été effectué a "+ blesser.m_nom);

    }

    public boolean estVivant(){
        if(m_vie <= 0){return true;}
        else {return false;}
    }


    public int getVie() {
        return this.m_vie;
    }

    public int getM_attaque() {
        return m_attaque;
    }

    public String getM_nom() {
        return m_nom;
    }

    public Element getM_elements() {
        return m_elements;
    }


    public void presenter() {
        String Presenter = m_nom + " :  element - " + m_elements.toString() + ", Vie : " + m_vie + ", Atk : " + m_attaque;
        System.out.println(Presenter);
    }


}
