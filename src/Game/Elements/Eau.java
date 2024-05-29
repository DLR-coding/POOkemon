package Game.Elements;

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


}



