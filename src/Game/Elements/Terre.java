package Game.Elements;

public class Terre implements Element {

    @Override
    public String getElmnt(){
        return "terre";
    }

    @Override
    public String getFortContre(){
        return "Eau";
    }

    @Override
    public String getFaibleContre(){
        return "Air";
    }

    @Override
    public String toString() {
        return "terre";
    }
}
