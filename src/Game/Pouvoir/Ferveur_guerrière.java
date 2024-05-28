package Game.Pouvoir;

import Game.Pokemon;

public class Ferveur_guerrière implements Pouvoir {
    @Override
    public void Activation(Pokemon p) {
        p.setM_attaque(p.getM_attaque() + 10);
        p.setM_pouvoir(null);
    }
}
