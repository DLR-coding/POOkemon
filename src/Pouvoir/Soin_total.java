package Pouvoir;

import Game.Pokemon;

public class Soin_total implements Pouvoir {


    @Override
    public void Activation(Pokemon p) {
         p.setVie(p.getM_vieMax());
        p.setM_pouvoir(null);
    }
}
