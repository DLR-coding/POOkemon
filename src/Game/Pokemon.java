package Game;

import Game.Elements.*;
//import Game.Pouvoir.Pouvoir;
import Game.Pouvoirs.Pouvoir;

public class Pokemon
{
    private String m_nom;
    private Element m_elements;
    private int m_vie;
    private int m_attaque;

    private int m_vieMax;
    private Pouvoir m_pouvoir;


    public Pokemon(String nom, Element elements, int vie, int attaque)
    {
        m_nom = nom;
        m_elements = elements;
        m_vie = vie ;
        m_attaque = attaque;
        m_vieMax = vie;
        m_pouvoir = null;
    }


    public void attaquer(Pokemon blesser)
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

    public void setVie(int vie) {
        this.m_vie = vie;
    }

    public int getM_attaque() {
        return m_attaque;
    }

    public void setM_attaque(int attaque) {
        this.m_attaque = attaque;
    }
    public String getM_nom() {
        return m_nom;
    }

    public Element getM_elements() {
        return m_elements;
    }


    public void presenter() {
        String pouvoir = "nul";
        if(m_pouvoir != null){
         pouvoir = m_pouvoir.getNomPouvoir();
        }
        String Presenter = m_nom + " :  element - " + m_elements.toString() + ", Vie : " + m_vie + ", Atk : " + m_attaque + " Pouvoir : " + pouvoir;
        System.out.println(Presenter);
    }

    public int getM_vieMax() {
        return m_vieMax;
    }

    public void setPouvoir(Pouvoir pouvoir) {
        this.m_pouvoir = pouvoir;
    }

    public Pouvoir getM_pouvoir()
    {
        return this.m_pouvoir;
    }
}
