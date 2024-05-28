package Game.Pouvoirs;

import Game.Pokemon;

public class Soin_de_zone implements Pouvoir{

    @Override
    public void activatePouvoir(Pokemon p) {
            p.setVie(p.getVie() + 10);

    }

    @Override
    public String getNomPouvoir() {
        return "Soin_simple";
    }
}
