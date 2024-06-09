package Game.Pokemons.Elements;

public class Eau implements Element {

    @Override
    public String getElmnt(){
        return "Eau";
    }

    @Override
    public String getFortContre(){
        return "feu";
    }

    @Override
    public String getFaibleContre(){
        return "terre";
    }

    @Override
    public String toString() {
        return "Eau";
    }
}



