package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pokemon> pokemonListOfAsh = initializePokemons();

        // Every pokemon has a name and a type.
        // Certain types are effective against others, e.g. water is effective against fire.

        // Ash has a few pokemon.
        // A wild pokemon appeared!

        Pokemon wildPokemon = new Pokemon("Oddish", "grass", "water");


        List<Pokemon> pokeOptions = initializePokemons();
        Pokemon myPokeChoice =pokeOptions.get(0); // or no initialisation, however then the  sout() + 'myPokeChoice' reference works only placed within the for loop

        // Which pokemon should Ash use?
        // Write the necessary code to get the name of the right pokemon and print it:

        for (int i = 0; i < pokeOptions.size(); i++) {
           if ( pokeOptions.get(i).isEffectiveAgainst(wildPokemon)){
               myPokeChoice = pokeOptions.get(i);
//               System.out.println("I choose you, " + myPokeChoice.name );
           }
        }
        System.out.print("I choose you, " + myPokeChoice.name );
    }

    private static List<Pokemon> initializePokemons() {
        List<Pokemon> pokemon = new ArrayList<>();

        pokemon.add(new Pokemon("Bulbasaur", "grass", "water"));
        pokemon.add(new Pokemon("Pikachu", "electric", "water"));
        pokemon.add(new Pokemon("Charizard", "fire", "grass"));
        pokemon.add(new Pokemon("Pidgeot", "flying", "fighting"));
        pokemon.add(new Pokemon("Kingler", "water", "fire"));

        return pokemon;
    }
}
