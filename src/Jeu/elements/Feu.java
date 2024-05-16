package Jeu.elements;

public class Feu implements Element {


    @Override
    public String element(){
        return "feu";
    }

    @Override
    public String Getforcontre(){
        return "air";
    }

    @Override
    public String Getfaible(){
        return "eau";
    }

    @Override
    public String toString() {
        return "feu";
    }


}
