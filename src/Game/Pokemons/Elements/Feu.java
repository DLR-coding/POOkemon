package Game.Pokemons.Elements;

public class Feu implements Element {


    @Override
    public String getElmnt(){
        return "feu";
    }

    @Override
    public String getFortContre(){
        return "Air";
    }

    @Override
    public String getFaibleContre(){
        return "Eau";
    }

    @Override
    public String toString() {
        return "feu";
    }


}
