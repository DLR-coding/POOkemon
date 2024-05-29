package Game.Elements;

public class Air implements Element {

    @Override
    public String getElmnt(){
        return "Air";
    }

    @Override
    public String getFortContre(){
        return "Terre";
    }

    @Override
    public String getFaibleContre(){
        return "Feu";
    }
}
