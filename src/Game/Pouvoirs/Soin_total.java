package Game.Pouvoirs;

import Game.Pokemon;

public class Soin_total implements Pouvoir {


    @Override
    public void activatePouvoir(Pokemon p) {

        p.setVie(p.getM_vieMax());
        p.setPouvoir(null);
    }

    @Override
    public String getNomPouvoir() {
        return "Soin_total";
    }


}
