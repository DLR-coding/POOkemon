package Game.Elements;

/**
 * Classe représentant l'élément Terre dans le jeu.
 * Implémente l'interface {@link Element}.
 */
public class Terre implements Element {

    /**
     * Retourne le nom de l'élément.
     *
     * @return Une chaîne de caractères représentant le nom de l'élément : "terre".
     */
    @Override
    public String getElmnt(){
        return "terre";
    }

    /**
     * Retourne l'élément contre lequel cet élément est fort.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est fort : "Eau".
     */
    @Override
    public String getFortContre(){
        return "Eau";
    }

    /**
     * Retourne l'élément contre lequel cet élément est faible.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est faible : "Air".
     */
    @Override
    public String getFaibleContre(){
        return "Air";
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de cet élément.
     *
     * @return Une chaîne de caractères représentant cet élément : "terre".
     */
    @Override
    public String toString() {
        return "terre";
    }
}
