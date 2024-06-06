package Game.EnsemblePokemon;

import Game.Elements.*;
import Game.Pokemon;
import Game.Pouvoirs.*;
import Game.Pouvoirs.Ferveur_guerrière;
import Game.Pouvoirs.Pouvoir;
import Game.Pouvoirs.Soin_simple;
import Game.Pouvoirs.Soin_total;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PokemonGenerateur {


    static final List<String> listeNomsPokemon = new ArrayList<>(Arrays.asList(
            "Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu",
            "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion",
            "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage",
            "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu",
            "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina", "Nidoqueen",
            "Nidoran♂", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix",
            "Feunard", "Rondoudou", "Grodoudou", "Nosferapti"));

    static final List<Pouvoir> listePouvoirs;

    static {
        listePouvoirs = new ArrayList<>(Arrays.asList(
                new Ferveur_guerrière(),new Berserk() , new Soin_simple(),new Intimidation() ,new Extension_du_territoire() ,new Soin_de_zone(), new Kamikaze(), new Soin_total()));
    }

    static Pokemon genererPokemon() {
        Random randomNumbers = new Random();

        // Choisir aléatoirement un nom de Pokémon dans la liste
        int indexNomPokemon = randomNumbers.nextInt(listeNomsPokemon.size());
        String nomPokemon = listeNomsPokemon.get(indexNomPokemon);

        // Enlever le nom de Pokémon sélectionné de la liste pour éviter qu'il reviennent 2 fois
        listeNomsPokemon.remove(indexNomPokemon);

        // Générer aléatoirement les points de vie (entre 100 et 200)
        int vie = randomNumbers.nextInt(11) * 10 + 100;

        // Générer aléatoirement la valeur d'attaque (entre 10 et 40)
        int attaque = randomNumbers.nextInt(4) * 10 + 10;

        int ele = randomNumbers.nextInt(4)+1;
        Element elements;
        if(ele == 1){ elements = new Feu();}
        else if (ele == 2) { elements = new Eau();}
        else if (ele == 3) {elements = new Terre();}
        else if (ele == 4) {elements = new Air();}
        else {elements = null;}

        // Créer le Pokémon avec les valeurs générées
        Pokemon pokemon = new Pokemon(nomPokemon, elements, vie, attaque);
        if (listePouvoirs.isEmpty()) {
            System.out.println("le ListPouvoir est vide");
        }
        if (!listePouvoirs.isEmpty()) {

            // Générer un index aléatoire pour sélectionner un pouvoir
            int indexPouvoir = randomNumbers.nextInt(listePouvoirs.size());
            System.out.println("il y a " + listePouvoirs.size() + " pouvoirs");
            // Sélectionner le pouvoir à l'index généré
            Pouvoir pouvoir = listePouvoirs.get(indexPouvoir);

            // Supprimer le pouvoir sélectionné de la liste
            listePouvoirs.remove(indexPouvoir);

            // Attribuer le pouvoir sélectionné au Pokémon
            pokemon.setPouvoir(pouvoir);
        }
        if (pokemon.getM_pouvoir() != null)
        {
            System.out.println("Pokemon crée : " + pokemon.getM_nom() + " atk :" + pokemon.getM_attaque() + "HP : " +  pokemon.getVie() + " Pouvoir : " + pokemon.getM_pouvoir().getNomPouvoir());
        }
        else {
            System.out.println("Pokemon crée : " + pokemon.getM_nom() + " atk :" + pokemon.getM_attaque() + "HP : " +  pokemon.getVie() + " Pouvoir : " + "Aucun");
        }
        // Retourner le Pokémon généré
        return pokemon;
    }



}


