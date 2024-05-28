package Pouvoir;

import Game.Pokemon;

public class Soin_de_zone implements Pouvoir{

    @Override
    public void Activation(Pokemon p) {
            p.setVie(p.getVie() + 10);

    }
}
