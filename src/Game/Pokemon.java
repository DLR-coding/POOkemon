package Game;

import Game.Elements.*;
//import Game.Pouvoir.Pouvoir;
import Game.Pouvoirs.Pouvoir;

/**
 * La classe Pokemon représente un Pokémon dans le jeu.
 */
public class Pokemon
{
    private String m_nom;
    private Element m_elements;
    private int m_vie;
    private int m_attaque;
    private int m_vieMax;
    private Pouvoir m_pouvoir;

    /**
     * Constructeur de la classe Pokemon.
     *
     * @param nom le nom du Pokémon
     * @param elements les éléments du Pokémon
     * @param vie la vie du Pokémon
     * @param attaque l'attaque du Pokémon
     */
    public Pokemon(String nom, Element elements, int vie, int attaque)
    {
        m_nom = nom;
        m_elements = elements;
        m_vie = vie ;
        m_attaque = attaque;
        m_vieMax = vie;
        m_pouvoir = null;
    }

    /**
     * Effectue une attaque par rapport au faible/fort contre sur un autre Pokémon.
     *
     * @param blesser le Pokémon à attaquer
     */
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

    /**
     * Obtient la vie du Pokémon.
     *
     * @return la vie du Pokémon
     */
    public int getVie() {
        return this.m_vie;
    }

    /**
     * Définit la vie du Pokémon.
     *
     * @param vie la vie à définir
     */
    public void setVie(int vie) {
        this.m_vie = vie;
    }

    /**
     * Obtient l'attaque du Pokémon.
     *
     * @return l'attaque du Pokémon
     */
    public int getM_attaque() {
        return m_attaque;
    }

    /**
     * Définit l'attaque du Pokémon.
     *
     * @param attaque l'attaque à définir
     */
    public void setM_attaque(int attaque) {
        this.m_attaque = attaque;
    }

    /**
     * Obtient le nom du Pokémon.
     *
     * @return le nom du Pokémon
     */
    public String getM_nom() {
        return m_nom;
    }

    /**
     * Obtient les éléments du Pokémon.
     *
     * @return les éléments du Pokémon
     */
    public Element getM_elements() {
        return m_elements;
    }

    /**
     * Présente les informations du Pokémon.
     */
    public void presenter() {
        String pouvoir = "Aucun";
        if(m_pouvoir != null){
         pouvoir = m_pouvoir.getNomPouvoir();
        }
        String Presenter = m_nom + " :  element - " + m_elements.toString() + ", Vie : " + m_vie + ", Atk : " + m_attaque + " Pouvoir : " + pouvoir;
        System.out.println(Presenter);
    }

    /**
     * Obtient la vie maximale du Pokémon.
     *
     * @return la vie maximale du Pokémon
     */
    public int getM_vieMax() {
        return m_vieMax;
    }

    /**
     * Définit le pouvoir du Pokémon.
     *
     * @param pouvoir le pouvoir à définir
     */
    public void setPouvoir(Pouvoir pouvoir) {
        this.m_pouvoir = pouvoir;
    }

    /**
     * Obtient le pouvoir du Pokémon.
     *
     * @return le pouvoir du Pokémon
     */
    public Pouvoir getM_pouvoir()
    {
        return this.m_pouvoir;
    }

    /**
     * Obtient le nom du pouvoir du Pokémon.
     *
     * @return le nom du pouvoir du Pokémon
     */
    public String getNom_pouvoir()
    {
        if (m_pouvoir != null) {
            String nomPouvoir = m_pouvoir.getNomPouvoir();
            return nomPouvoir;
        } else {
            return "Aucun";
        }
    }

}
