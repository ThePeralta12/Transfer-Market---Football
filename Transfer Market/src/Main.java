import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner input = new Scanner(System.in);
	private static int centralTeamID = 101;
	private static int centralID = 10001;
private static ArrayList<Player> allPlayers = new ArrayList<Player>();
private static ArrayList<Manager> allManagers = new ArrayList<Manager>();
private static ArrayList<Team> allTeams = new ArrayList<Team>();
private static String[] positions ={"Goalkeeper", "right back", "Left back","Centre Half", "Defensive Midfield", "Left Wing", "right wing", "central Midfield","Attacking Midfield","sticker"};
private static String[] firstNames ={"Alan", "joe","brick", "troy", "mick", "suane", "trru", "Temmy", "yoyo", "toyu", "roro" , "wowo","jajaje", "Roepr", "eoryt", "toyiu", "toto"};
private static String[] lastNames ={"richie", "Canga","topo","recess", "tewwwwa", "rpokgvdf" ,"daniels", "willie" , "backy", "nelly", "Naoto", "eron", "tommy", "thomas", "tiyi", "stocky"};

	
	public static void main(String[] args) {
		
		File f = new File("Player.ser");
		
		if(f.exists())
		{
			try {
				importDatabase();
				importTeams();
			} catch (Exception e) {
				System.out.println("error reading file");
			}
			centralID = 10001+ allPlayers.size();
			centralTeamID =101 + allTeams.size();
			menu();
		}
		menu();
	}


	

	private static void importDatabase() throws Exception {
	 FileInputStream importFile = new FileInputStream("Player.ser");
	 ObjectInputStream read = new ObjectInputStream(importFile);
allPlayers = (ArrayList<Player>) read.readObject();
read.close();
	}
	private static void importTeams() throws Exception {
		 FileInputStream importFile = new FileInputStream("Teams.ser");
		 ObjectInputStream read = new ObjectInputStream(importFile);
	allTeams = (ArrayList<Team>) read.readObject();
	read.close();
		}

	private static void menu() {

		System.out.println("Press 1 for Team menu");
		System.out.println("Press 2 for player Menu");
		System.out.println("Press 3 for Transfer funds");
		System.out.println("Press 4 to save and exit");
		
		String choice = input.next();
		
		switch(choice){
		
		
		case "1":
		{
			teamMenu();
			break;
		}
		case"2":
		{
			playerMenu();
			break;
		}
		case"3":
		{
			TransferMarket();
			break;
		}
		case"4":
		{
			try {
				exportDatabase();
				exportTeams();
			} catch (Exception e) {
		
			System.out.println("error writing file");
			}
			System.out.println("datasaved. System closing");
			System.exit(0);
		}
		
		
		
		
		
		
		menu();
		
	}
	}


	private static void teamMenu() {
		
		System.out.println("1\t Creat a Team");
		System.out.println("2\t View all Teams");
		System.out.println("3\t Edit Team");
		System.out.println("4\t Delete Team");
		System.out.println("5\t Print team Squad");
		System.out.println("6\t Return to Main Menu");
		
		
		String choice = input.next();
		switch(choice){
		
		case"1":
		{
			try {
				createTeam();
			} catch (Exception e) {
							}
			break;
		}
		case"2":
		{
			viewAllTeams();
			break;
		}
		case"6":
		{
		  menu();
		  break;
		}
		
		
		}
		
		teamMenu();
		
	}

private static void createPlayers(int numPlayers){
	
	for(int i =0; i < numPlayers; i++)
	{
		Player p = new Player();
		p.setPlayerId(centralID);
		centralID++;
		//to access a value square bracket position
		String name =firstNames[1];
		String fname = firstNames[(int)(Math.random()*firstNames.length)];
		String lname = lastNames[(int)(Math.random()*lastNames.length)];
		p.setName(firstNames +""+ lastNames);
	
		p.setAge(18);
		 p.setConsistency((int)Math.random()*20);
		 p.setPosition(positions[(int) Math.random()*positions.length]);
		p.setHeading((int) Math.random()*20);
		p.setShooting((int) Math.random()*20);
		p.setTackling((int) Math.random()*20);
		p.setPace((int) Math.random()*20);
		p.setTeam("Unattached");
		
		double totalAttributes = p.getConsistency() + p.getPace() + p.getShooting() + p.getTackling() + p.getHeading();
		if(totalAttributes< 20)
		{
			p.setTransferValue(0);
			
		}
		else if(totalAttributes < 30)
		{
			p.setTransferValue(10000);
		}
		else if(totalAttributes <40){
			p.setTransferValue(50000);
		}
		else if(totalAttributes < 50)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 60)
		{
			p.setTransferValue(1000000);
		}
		else if(totalAttributes < 70)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 80)
		{
			p.setTransferValue(500000);
		}
		else if(totalAttributes < 90)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 95)
		{
			p.setTransferValue(200000);
		}
		else if(totalAttributes < 100)
		{
			p.setTransferValue(300000);
		}
	}
	
}
	private static void viewAllTeams() {
		for(Team t: allTeams)
		{
			System.out.println(t.getTeamId() + "\t" + t.getTeamName() + "\t" + t.getTransferBudget());
		}
	}


	private static void createTeam() throws Exception {
		//constructor
		//this is a null constructor
		Team t = new Team();
		t.setTeamId(centralTeamID);
		centralTeamID++;
		
		//asking for user input
		System.out.println("enter Team Name: ");
		//reader for text not numbers
		t.setTeamName(reader.readLine());
		System.out.println("Enter Manager Name");
		t.setManager(reader.readLine());
		System.out.println("enter Transfer Budget");
		t.setTransferBudget(input.nextDouble());
		allTeams.add(t);
		System.out.println(t.getTeamName()+ " has been successfully created.");
		
	}


	private static void playerMenu() {
		System.out.println("1\t Create new Player");
		System.out.println("2\t Create 1000 Players");
		System.out.println("3\t Print Player");
		System.out.println("4\t Search for a Player");
		System.out.println("5\t Return to Menu");
		
		String choice = input.next();
		
		switch(choice)
		{
				case"1":
				{
					try {
						createPlayer();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case"2":
				{
					createPlayers(1000);
					break;
				}
				
				case"3":
				{
					printPlayers();
					break;
				}
				case"5":
				{
					menu();
					break;
				}
		}
		playerMenu();
	}


	private static void printPlayers() {
		for(Player p: allPlayers)
		{
			System.out.println(p.getPlayerId() + "\t"+ p.getName()+ "\t" + p.getTransferValue());
			
			
		}
		System.out.println("Please choose a player by id to view more details");
		int chosenPlayer = input.nextInt();
		for(Player p: allPlayers)
		{
			if(chosenPlayer==p.getPlayerId())
			{
				p.printStats();
			}
		}
		
	}




	private static void createPlayer() throws Exception {
		Player p = new Player();
		p.setPlayerId(centralID);
		centralID++;
		System.out.println("Enter Player Name: ");
		p.setName(reader.readLine());
		System.out.println("Enter age");
		p.setAge(input.nextInt());
		 p.setConsistency((int)Math.random()*20);
		p.setHeading((int) Math.random()*20);
		p.setShooting((int) Math.random()*20);
		p.setTackling((int) Math.random()*20);
		p.setPace((int) Math.random()*20);
		p.setTeam("Unattached");
		
		double totalAttributes = p.getConsistency() + p.getPace() + p.getShooting() + p.getTackling() + p.getHeading();
		if(totalAttributes< 20)
		{
			p.setTransferValue(0);
			
		}
		else if(totalAttributes < 30)
		{
			p.setTransferValue(10000);
		}
		else if(totalAttributes <40){
			p.setTransferValue(50000);
		}
		else if(totalAttributes < 50)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 60)
		{
			p.setTransferValue(1000000);
		}
		else if(totalAttributes < 70)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 80)
		{
			p.setTransferValue(500000);
		}
		else if(totalAttributes < 90)
		{
			p.setTransferValue(100000);
		}
		else if(totalAttributes < 95)
		{
			p.setTransferValue(200000);
		}
		else if(totalAttributes < 100)
		{
			p.setTransferValue(300000);
		}
		
	}




	private static void TransferMarket() {
		// TODO Auto-generated method stub
		
	}

	private static void exportTeams()throws Exception {
		FileOutputStream exportFile = new FileOutputStream("Teams.ser");
		ObjectOutputStream write = new ObjectOutputStream(exportFile);
		write.writeObject(allTeams);
		write.close();
		
		
		
	}

	private static void exportDatabase()throws Exception {
		FileOutputStream exportFile = new FileOutputStream("player.ser");
		ObjectOutputStream write = new ObjectOutputStream(exportFile);
		write.writeObject(allPlayers);
		write.close();
		
		
		
	}

}
