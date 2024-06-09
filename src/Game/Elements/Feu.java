package Game.Elements;

/**
 * Classe représentant l'élément Feu dans le jeu.
 * Implémente l'interface {@link Element}.
 */
public class Feu implements Element {

    /**
     * Retourne le nom de l'élément.
     *
     * @return Une chaîne de caractères représentant le nom de l'élément : "feu".
     */
    @Override
    public String getElmnt(){
        return "feu";
    }

    /**
     * Retourne l'élément contre lequel cet élément est fort.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est fort : "Air".
     */
    @Override
    public String getFortContre(){
        return "Air";
    }

    /**
     * Retourne l'élément contre lequel cet élément est faible.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est faible : "Eau".
     */
    @Override
    public String getFaibleContre(){
        return "Eau";
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de cet élément.
     *
     * @return Une chaîne de caractères représentant cet élément : "feu".
     */
    @Override
    public String toString() {
        return "feu";
    }


}
