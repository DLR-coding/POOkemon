package Game.Elements;

/**
 * Interface représentant un élément dans le jeu.
 * Les classes implémentant cette interface doivent fournir des informations
 * sur le nom de l'élément, ainsi que sur ses forces et faiblesses par rapport à d'autres éléments.
 */
public interface Element
{

    /**
     * Retourne le nom de l'élément.
     *
     * @return Une chaîne de caractères représentant le nom de l'élément.
     */
    public String getElmnt();

    /**
     * Retourne l'élément contre lequel cet élément est fort.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est fort.
     */
    public String getFortContre();

    /**
     * Retourne l'élément contre lequel cet élément est faible.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est faible.
     */
    public String getFaibleContre();


}
