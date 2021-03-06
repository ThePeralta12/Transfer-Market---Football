import java.io.Serializable;
import java.util.ArrayList;


public class Team implements Serializable {
	
	
	private int teamId;
	private String teamName;
	private ArrayList<Player> squad = new ArrayList<Player>();
	private String Manager;
	private double transferBudget;
	
	private static final long serialVersionUID = 1L;
	public Team(){
		
	}
	
	
	public void printTeamDetails(){
		System.out.println("Team ID: \t" + teamId);
		System.out.println("Team Name: " + teamName);
		System.out.println("manager" +Manager);
		System.out.println("Squad size:" + squad.size());
		System.out.println("Tranferfunds"+ transferBudget);
		printSquad();
		
	}
	
	public void printSquad(){
		System.out.println("ID \t Name \t \t Position \t Value");
		for(Player p: squad){
			System.out.println(p.getPlayerId()+"\t" + p.getName()+ "\t"+ p.getPosition()+p.getTransferValue());
		}
	}
	public void removePlayer(Player p){
		if(squad.isEmpty())
		{
			System.out.println("there are no players to sell or release");
			
		}
		else{
			squad.remove(p);
		}
	}
	
	public void addPlayer(Player p){
		if(squad.size()>=25)
		{
			System.out.println("You must sell a player.The teams is full");
		}
		else
		{
			squad.add(p);
		}
		
	}
	
	
	
	public int getTeamId() {
		return teamId;
	}


	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public ArrayList<Player> getSquad() {
		return squad;
	}


	public void setSquad(ArrayList<Player> squad) {
		this.squad = squad;
	}


	public String getManager() {
		return Manager;
	}


	public void setManager(String manager) {
		Manager = manager;
	}


	public double getTransferBudget() {
		return transferBudget;
	}


	public void setTransferBudget(double transferBudget) {
		this.transferBudget = transferBudget;
	}


	
}
