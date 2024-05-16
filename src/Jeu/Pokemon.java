package Jeu;

import Jeu.elements.Element;

public class Pokemon
{
    private String m_nom;
    private Element m_elements;
    private int m_vie;
    private int m_attaque;

    public Pokemon(String nom, Element element, int vie, int attaque)
    {
       m_nom = nom;
       m_elements = element;
       m_vie = vie;
       m_attaque =attaque;
    }

public void Attaquer(Pokemon blesser)
{
    int attaque = 0;
    if (m_elements.Getforcontre() == blesser.m_elements.toString()) {
        attaque = 10;
    }
    else if (m_elements.Getfaible() == blesser.m_elements.toString()) {
        attaque = -10;
    }
    attaque = attaque + this.m_attaque;
    blesser.m_vie = blesser.m_vie - attaque ;
    System.out.println(m_nom + " attaque de " + attaque + " a été effectué a "+ blesser.toString());

}


    public String getNom() {
        return m_nom;
    }

    public int getVie() {
        return this.m_vie;
    }

    public int getM_attaque() {
        return m_attaque;
    }

    @Override
    public String toString() {
        return m_nom;
    }
}
