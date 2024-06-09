package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

import java.util.Scanner;

public class Extension_du_territoire implements Pouvoir {

    @Override
    public void activatePouvoir(Pokemon p, Player j1, Player Robot,Player joueur) {

        if(joueur == j1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tu places tes Pokémon de ta main sur ton terrain...");
            for (int i = 0; i < j1.getM_main().getNbPokemon(); i++) {
                System.out.print(i + 1 + " : ");
                j1.getM_main().getPokemon(i).presenter();
            }

            for (int i = 0; i < 1; i++) {
                System.out.println("Quel Pokémon souhaites-tu placer ? (Choisissez le numéro de Pokémon dans votre main)");
                int index = scanner.nextInt();

                if (index >= 1 && index <= 5) {
                    j1.placeSurTerrain(j1.getM_main().getPokemon(index - 1));
                } else {
                    System.out.println("Index invalide. Veuillez choisir un Pokémon valide.");
                    i--; // Pour redemander le choix pour le même emplacement
                }
            }
        }else{
            Robot.getM_main().transferPokemon(Robot.getM_main().getPokemon(1),Robot.getM_terrain());
            System.out.println("Robot repioche pour automatiquement remplir sa main...");
            Robot.piocherPokemon(Robot.getPokemonFromPioche(5-1));
        }

        p.setPouvoir(null);
    }

    @Override
    public void RetourALanormal(Pokemon p,Player joueur){
        System.out.print("");
    }

    @Override
    public String getNomPouvoir() {
        return "Extension du territoire";
    }

    @Override
    public String description(){

        return "Extension du territoire, à utilisation unique :  le terrain du joueur gagne un quatrième emplacement sur lequel il peut placer immédiatement un Pokémon de sa main. Lorsque le Pokémon qui a utilisé ce pouvoir meurt, son emplacement est perdu et le terrain possède de nouveau trois emplacements.";}
}
