package Game.Pouvoir;

import Game.Pokemon;

public class Soin_total implements Pouvoir {


    @Override
    public void activatePouvoir(Pokemon p) {
         p.setVie(p.getM_vieMax());
    }

    @Override
    public String getNomPouvoir() {
        return "Soin_total";
    }


}
