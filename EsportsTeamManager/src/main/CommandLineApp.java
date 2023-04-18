package main;

import java.util.Scanner;

import main.GameEnvironment.Difficulty;

/**
 * Command line interface to play the game
 */
public final class CommandLineApp {
	/**
	 * Scanner instance for reading command line input
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Line divider string
	 */
	private static final String LINE = "===========================\n";
	
	/**
	 * GameEnvironment instance to interact with game
	 */
	private GameEnvironment game;
	
	/**
	 * Constructor to set game property
	 * 
	 * @param game	GameEnvironment instance to interact with game
	 */
	public CommandLineApp(GameEnvironment game) {
		this.game = game;
	}
	
	public String readConsoleAndClear() {
		String option = scanner.nextLine();
		System.out.println("\n\n\n\n\n");
		return option;
	}
	
	private String overviewString() {
    	return String.format("Week %s of %s\n"
    				+ "Money: $%s\n\n", 
    				game.getCurrentWeek(), game.getSeasonDuration(), game.getMoney());
    }
	
    /**
     * Launches the game
     */
    public void launchGame() {
    	mainMenu();
    }
    
    private void mainMenu() {
    	while (true) {
    		System.out.printf(LINE
    				+ "   E-SPORTS TEAM MANAGER\n" + LINE 
    				+ "1. New game\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "1":
    			startMenu();
    			break;
    		}
    	}
    }
    
    private void startMenu() {
    	while (true) {
    		System.out.printf(LINE 
    				+ "NEW GAME\n" + LINE 
    				+ "1. Difficulty: %s\n"
    				+ "2. Team name: %s\n"
    				+ "3. Season duration: %s\n"
    				+ "4. Draft players: %s\n\n"
    				+ "5. Begin game\n" + LINE, 
    				game.getDifficultyString(), game.getTeamName(), game.getSeasonDurationString(), game.getTeam());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "1":
    			difficultyMenu();
    			break;
    		case "2":
    			teamNameMenu();
    			break;
    		case "3":
    			seasonDurationMenu();
    			break;
    		case "4":
    			startingDraftMenu();
    			break;
    		case "5":
    			overviewMenu();
    			break;
    		}
    	}
    }
    
    private void difficultyMenu() {
    	menu: while(true) {
    		System.out.printf(LINE 
    				+ "SELECT DIFFICULTY\n" + LINE 
    				+ "1. Easy\n"
    				+ "2. Not easy\n"
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		case "1":
    			game.setDifficulty(Difficulty.EASY);
    			break menu;
    		case "2":
    			game.setDifficulty(Difficulty.NOT_EASY);
    			break menu;
    		}
    	}
    }
    
    private void teamNameMenu() {
    	String prompt = "";
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "CHOOSE TEAM NAME\n" + LINE 
    				+ prompt
    				+ "Pick a name (3-15 characters long, no special characters)\n"
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		default:
    			if (game.setTeamName(option)) {
    				break menu;
    			} else {
    				prompt = "Team name must be between 3-15 characters, no special characters.\n\n";
    				break;
    			}
    		}
    	}
    }
    
    private void seasonDurationMenu() {
    	String prompt = "";
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "SELECT SEASON DURATION\n" + LINE 
    				+ prompt
    				+ "How long do you want to play? (5-15 weeks)\n"
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		default:
    			try {
    				int duration = Integer.parseInt(option);
    				if (game.setSeasonDuration(duration)) {
    					break menu;
    				}
    			} catch (NumberFormatException e) {
    			} finally {
    				prompt = "Please enter a valid duration\n\n";
    			}
    		}
    	}
    }
    
    private void startingDraftMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "DRAFT STARTING PLAYERS\n" + LINE 
    				+ "Draft your starting team (4 starters and 4 reserves minimum)\n"
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void overviewMenu() {
    	while (true) {
    		System.out.printf(LINE 
    				+ "OVERVIEW\n" + LINE + "%s"
    				+ "1. Visit the club\n"
    				+ "2. Visit the stadium\n"
    				+ "3. Visit the market\n"
    				+ "4. Finish the week/Take a bye\n" + LINE,
    				overviewString());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "1":
    			clubMenu();
    			break;
    		case "2":
    			stadiumMenu();
    			break;
    		case "3":
    			marketMenu();
    			break;
    		case "4":
    			break;
    		}
    	}
    }
    
    private void clubMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "CLUB\n" + LINE + "%s"
    				+ "Welcome to Team %s\n\n"
    				+ "1. View athletes\n"
    				+ "2. View inventory\n"
    				+ "\n0. Return\n" + LINE,
    				overviewString(), game.getTeamName());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		case "1":
    			currentTeamMenu();
    			break;
    		case "2":
    			inventoryMenu();
    			break;
    		}
    	}
    }
    
    private void currentTeamMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "THE TEAM\n" + LINE + "%s"
    				+ "Select an athlete for more information\n\n"
    				+ "Main roster\n"
    				+ "\nReserves\n"
    				+ "\n0. Return\n" + LINE,
    				overviewString());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void inventoryMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "INVENTORY\n" + LINE + "%s"
    				+ "Select an item to view it's effects or use it on an athlete\n\n"
    				+ "\n0. Return\n" + LINE,
    				overviewString());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void stadiumMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "STADIUM\n" + LINE + "%s"
    				+ "Available matches\n"
    				+ "\n0. Return\n" + LINE,
    				overviewString());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void matchMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "MATCH\n" + LINE 
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void marketMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "MARKET\n" + LINE + "%s"
    				+ "1. Hire athletes\n"
    				+ "2. Purchase items\n"
    				+ "3. Sell athletes\n"
    				+ "4. Sell items\n"
    				+ "\n0. Return\n" + LINE,
    				overviewString(), game.getMoney());
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void randomEventMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "RANDOM EVENT\n" + LINE 
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
    private void gameOverMenu() {
    	menu: while (true) {
    		System.out.printf(LINE 
    				+ "GAME OVER\n" + LINE 
    				+ "\n0. Return\n" + LINE);
    		
    		String option = readConsoleAndClear();
    		switch (option) {
    		case "0":
    			break menu;
    		}
    	}
    }
    
	/**
	 * Launches command line interface
	 * 
	 * @param args	command line arguments
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		CommandLineApp app = new CommandLineApp(game);
		app.launchGame();
	}
	
}
