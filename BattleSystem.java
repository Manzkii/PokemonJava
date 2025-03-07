import java.util.Scanner;

public class BattleSystem {
    private Bag bag; 
    private Encounter encounterSystem; 
    private Catch catchSystem;
    private boolean battleEnded = false;

    public BattleSystem(Bag bag, Catch catchSystem, Encounter encounterSystem) {
        this.encounterSystem = encounterSystem; 
        this.bag = bag;
        this.catchSystem = catchSystem;
    }

    public void startBattle(AITrainer ai, Player player, TurnbasedSystem tbs) {
        if (ai == null || player == null) {
            System.out.println("Invalid battle participants.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int playerMoveChoice = 0;
        battleEnded = false;

        System.out.println(player.name + " is battling " + ai.name);

        while (!player.hasLost && !ai.hasLost && !battleEnded) {
            if (player.returnequippedPokemon().isDead == false && ai.returnequippedPokemon().isDead == false) {
                playerCommand(tbs, player);
                playerMoveChoice = sc.nextInt();

                //repeats playerMoveChoice command if wrong input
                while (playerMoveChoice < 1 || playerMoveChoice > 4) {
                    System.out.println("Invalid command, please try again.");
                    playerCommand(tbs, player);
                    playerMoveChoice = sc.nextInt();
                }

                if (playerMoveChoice == 1 || playerMoveChoice == 2) {
                    sc.nextLine();
                    tbs.proceedDialogue(new Scanner(System.in));
                    attackDialogue(playerMoveChoice, player.returnequippedPokemon());
                    player.fightCommand(playerMoveChoice, ai.returnequippedPokemon());
    
                    // Display opponent's HP after the player's attack
                    displayPokemonHP(ai.returnequippedPokemon());
                    System.out.println();
                } else if (playerMoveChoice == 3) {
                    System.out.println("Player chose to interact with the bag.");
                    interactWithBag(ai.returnequippedPokemon(), sc); // Update flag based on catch result
                }

                // Check if the opponent has been defeated
                if (ai.returnequippedPokemon().isDead) {
                    battleEnd(player, bag);
                    battleEnded = true; // End the battle
                    break;
                }

                
                // Check if the battle has ended
                if (battleEnded) {
                    break;
                }

                // Opponent's turn (only if the battle hasn't ended)
                if (!battleEnded) {
                    System.out.println("Ai's turn");
                    int random = (int) (Math.random() * 2);
                    attackDialogue(random + 1, ai.returnequippedPokemon());
                    ai.fightCommand(random + 1 , player.returnequippedPokemon());

                    // Display player's HP after the opponent's attack
                    displayPokemonHP(player.returnequippedPokemon());
                    tbs.proceedDialogue(new Scanner(System.in));
                }


            }else {
                if (player.returnequippedPokemon().isDead) {
                    if (player.numofPokemonsAlive() > 0) {
                        System.out.println("Your " + player.returnequippedPokemon() + " feinted. " + "\n Please switch to another pokemon.");
                        switchPokemonDialogue(player);
                    } else {
                        player.lose();
                        battleEnded = true; // End the battle if the player has no more Pokémon
                        break;
                    }
                }
    
                if (ai.returnequippedPokemon().isDead) {
                    if (ai.numofPokemonsAlive() > 0) {
                        System.out.println("Your " + player.returnequippedPokemon() + " feinted. " + "\n Please switch to another pokemon.");
                        switchPokemonDialogue(ai);
                    } else {
                        battleEnd(player, bag);
                        battleEnded = true; // End the battle if the player has no more Pokémon
                        break;
                    }
                }
            }

        }
    }

    public void startBattle(Pokemon pokemonOpponent, Player player, TurnbasedSystem tbs) {
        Scanner sc = new Scanner(System.in);
        int playerMoveChoice = 0;
        battleEnded = false;
    
        System.out.println(player.name + " is battling " + pokemonOpponent.name);
    
        while (!player.hasLost && pokemonOpponent.currenthp > 0 && !battleEnded) {
            if (player.returnequippedPokemon().isDead == false && pokemonOpponent.isDead == false) {
                // Player's turn
                playerCommand(tbs, player);
                playerMoveChoice = sc.nextInt();
    
                // Validate player input (1-4)
                while (playerMoveChoice < 1 || playerMoveChoice > 4) {
                    System.out.println("Invalid command, please try again.");
                    playerCommand(tbs, player);
                    playerMoveChoice = sc.nextInt();
                }
    
                if (playerMoveChoice == 1 || playerMoveChoice == 2) {
                    sc.nextLine();
                    tbs.proceedDialogue(new Scanner(System.in));
                    attackDialogue(playerMoveChoice, player.returnequippedPokemon());
                    player.fightCommand(playerMoveChoice, pokemonOpponent);
    
                    // Display opponent's HP after the player's attack
                    displayPokemonHP(pokemonOpponent);
                    System.out.println();
                } if (playerMoveChoice == 3) {
                    System.out.println("Player chose to interact with the bag.");
                    interactWithBag(player, pokemonOpponent, sc); // Pass player, pokemonOpponent, and scanner
                } if (playerMoveChoice == 4) {
                    if (player.numofPokemonsAlive() > 1) { // Ensure player has more than one Pokémon alive
                        System.out.println("Player chose to switch Pokémon.");
                        switchPokemon(player, sc); // Call the improved function
                    } else {
                        System.out.println("You have no other Pokémon to switch to!");
                    }
                }
                
                
    
                // Check if the opponent has been defeated
                if (pokemonOpponent.isDead) {
                    battleEnd(player, bag);
                    battleEnded = true; // End the battle
                    break;
                }
    
                // Check if the battle has ended (e.g., after a successful catch)
                if (battleEnded) {
                    break; // Exit the loop immediately
                }
    
                // Opponent's turn (only if the battle hasn't ended)
                if (!battleEnded) {
                    System.out.println("Pokemon's turn");
                    int random = (int) (Math.random() * 2);
                    attackDialogue(random + 1, pokemonOpponent);
                    if (random == 0) {
                        pokemonOpponent.physicalAttack(player.returnequippedPokemon());
                    } else {
                        pokemonOpponent.elementalAttack(player.returnequippedPokemon());
                    }
    
                    // Display player's HP after the opponent's attack
                    displayPokemonHP(player.returnequippedPokemon());
                    tbs.proceedDialogue(new Scanner(System.in));
                }
            } else {
                if (player.returnequippedPokemon().isDead) {
                    if (player.numofPokemonsAlive() > 0) {
                        System.out.println("Your " + player.returnequippedPokemon() + " feinted. " + "\n Please switch to another pokemon.");
                        switchPokemon(player, sc); // Switch Pokémon
                    } else {
                        player.lose();
                        battleEnded = true; // End the battle if the player has no more Pokémon
                        break;
                    }
                }
    
                if (pokemonOpponent.isDead) {
                    battleEnd(player, bag);
                if (player.insideGym) { 
                        player.gymsBeaten++;
                        System.out.println("You have defeated a Gym! Total Gyms beaten: " + player.gymsBeaten);
                    }
                    battleEnd(player, bag);
                    
                    battleEnded = true; // End the battle if the opponent Pokémon is defeated
                    break;
                }
            }
        }
    }

    private boolean interactWithBag(Player player, Pokemon pokemonOpponent, Scanner sc) {
        System.out.println("Interacting with the bag...");
        bag.displayBagContents();
    
        System.out.println("Select a Pokéball to use or enter 0 to cancel:");
        int pokeballChoice = sc.nextInt();
    
        if (pokeballChoice == 0) {
            System.out.println("Cancelled bag interaction.");
            return false; // Battle continues
        }
    
        String pokeballType = catchSystem.getPokeballType(pokeballChoice);
        if (pokeballType == null) {
            System.out.println("Invalid choice. Please try again.");
            return false; // Battle continues
        }
    
        if (!bag.hasItem(pokeballType)) {
            System.out.println("You don't have any " + pokeballType + "!");
            return false; // Battle continues
        }
    
        boolean caught = catchSystem.tryToCatch(pokemonOpponent, pokeballChoice);
        if (caught) {
            System.out.println("You caught " + pokemonOpponent.name + "!");
            battleEnd(player, bag); // Automatically win the battle
            return true; // Battle ends
        }
    
        return false; // Battle continues
    }

    public void displayAvailablePokemon(Player player) {
        System.out.println("Available Pokémon:");
        for (int i = 0; i < player.pokemonCollection.size(); i++) {
            Pokemon pokemon = player.pokemonCollection.get(i);
            if (!pokemon.isDead) {
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " (HP: " + pokemon.currenthp + "/" + pokemon.maxhp + ")");
            } else {
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " [Fainted]");
            }
        }
    }

    public void attackDialogue(int moveChoice, Pokemon pokemon) {
        switch (moveChoice) {
            case 1:
                System.out.println(pokemon.name + " used " + " physical attack.");
                break;
            case 2:
                System.out.println(pokemon.name + " used " + " elemental attack.");
                break;
        }
    }

    public void playerCommand(TurnbasedSystem tbs, Player player) {
        System.out.println("What's your move?");
        System.out.println("[1] Physical Attack");
        System.out.println("[2] Elemental Attack");
        System.out.println("[3] Interact with Bag");
        System.out.println("[4] Switch Pokémon");
    }
    

    public void displayPokemonHP(Pokemon pokemon) {
        System.out.println("The health of " + pokemon.name + " is " + pokemon.currenthp + "/" + pokemon.maxhp);
    }

    public void switchPokemon(Player player, Scanner sc) {
        System.out.println("\nAvailable Pokémon:");
        
        boolean hasAlivePokemon = false; // Check if the player has any non-fainted Pokémon
        for (int i = 0; i < player.pokemonCollection.size(); i++) {
            Pokemon pokemon = player.pokemonCollection.get(i);
            if (!pokemon.isDead) {
                hasAlivePokemon = true;
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " (HP: " + pokemon.currenthp + "/" + pokemon.maxhp + ")");
            } else {
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " [Fainted]");
            }
        }
    
        if (!hasAlivePokemon) {
            System.out.println("You have no other Pokémon to switch to!");
            return;
        }
    
        System.out.println("\nSelect a Pokémon to switch to (or enter 0 to cancel):");
        int choice = sc.nextInt();
    
        if (choice == 0) {
            System.out.println("Switching cancelled.");
            return; // Exit without switching
        }
    
        if (choice < 1 || choice > player.pokemonCollection.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }
    
        Pokemon selectedPokemon = player.pokemonCollection.get(choice - 1);
    
        if (selectedPokemon.isDead) {
            System.out.println(selectedPokemon.name + " is fainted and cannot be switched in!");
            return;
        }
    
        if (choice - 1 == player.equippedPokemon) {
            System.out.println(selectedPokemon.name + " is already in battle!");
            return;
        }
    
        // Switch Pokémon
        player.equippedPokemon = choice - 1;
        System.out.println("Go, " + selectedPokemon.name + "!");
    }
    
    

    public void switchPokemonDialogue(Player player) {
        int index = 0;
        System.out.println("Alive Pokemons");
        for (Pokemon pokemon : player.pokemonCollection) {
            index += 1;
            if(pokemon.isDead){
                System.out.println("[" + index + "] " + pokemon.name + "[Dead]");
            }else{
                System.out.println("[" + index + "] " + pokemon.name);
            }
            
        }

        player.switchPokemon();
        
    }

    public void switchPokemonDialogue(AITrainer ai) {
        int index = 0;
        System.out.println("Alive Pokemons");
        for (Pokemon alivePokemon : ai.PokemonsAlive()) {
            index += 1;
            System.out.println("[" + index + "] " + alivePokemon);
        }

        ai.switchPokemon();
    }

    public void playerAllPokemonIsDead(Player player) {
        if (player.numofPokemonsAlive() <= 0) {
            System.out.println("You're out of pokemons. You have lost");
            player.lose();
        }
    }

    public void battleEnd(Player player, Bag bag) {
        System.out.println("You have won the battle!");
        player.receiveRandomPokeballs(bag); // Give the player random Pokéballs
        battleEnded = true;
    }

    private void interactWithBag(Pokemon returnequippedPokemon, Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
