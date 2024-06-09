package Game.Elements;

/**
 * Classe représentant l'élément Air dans le jeu.
 * Implémente l'interface {@link Element}.
 */
public class Air implements Element {

    /**
     * Retourne le nom de l'élément.
     *
     * @return Une chaîne de caractères représentant le nom de l'élément : "Air".
     */
    @Override
    public String getElmnt(){
        return "Air";
    }

    /**
     * Retourne l'élément contre lequel cet élément est fort.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est fort : "Terre".
     */
    @Override
    public String getFortContre(){
        return "Terre";
    }

    /**
     * Retourne l'élément contre lequel cet élément est faible.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est faible : "Feu".
     */
    @Override
    public String getFaibleContre(){
        return "Feu";
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de cet élément.
     *
     * @return Une chaîne de caractères représentant cet élément : "Air".
     */
    @Override
    public String toString() {
        return "Air";
    }
}
