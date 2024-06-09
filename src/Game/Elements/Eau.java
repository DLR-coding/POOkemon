package Game.Elements;

/**
 * Classe représentant l'élément Eau dans le jeu.
 * Implémente l'interface {@link Element}.
 */
public class Eau implements Element {

    /**
     * Retourne le nom de l'élément.
     *
     * @return Une chaîne de caractères représentant le nom de l'élément : "Eau".
     */
    @Override
    public String getElmnt(){
        return "Eau";
    }

    /**
     * Retourne l'élément contre lequel cet élément est fort.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est fort : "feu".
     */
    @Override
    public String getFortContre(){
        return "feu";
    }

    /**
     * Retourne l'élément contre lequel cet élément est faible.
     *
     * @return Une chaîne de caractères représentant l'élément contre lequel cet élément est faible : "terre".
     */
    @Override
    public String getFaibleContre(){
        return "terre";
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de cet élément.
     *
     * @return Une chaîne de caractères représentant cet élément : "Eau".
     */
    @Override
    public String toString() {
        return "Eau";
    }
}



