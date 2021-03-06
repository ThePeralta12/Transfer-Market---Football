
public class Player extends Person{

	
	private int playerId;
	private String position;
	private double transferValue;
	private boolean transferListed = false;
	
	//Attributes
	private int pace;
	private int shooting;
	private int heading;
	private int tackling;
	private int consistency;
	
	
	
	public Player(){
		
	}
	
	public void printStats(){
		System.out.println("-----------------------------------");
		System.out.println("Player Details");
		System.out.println("--------------------------------------");
		System.out.println("PlayerID: \t" + playerId);
		System.out.println("Player Name: \t" + getName());
		System.out.println("Player Age: \t" + getAge());
		System.out.println("Club" + getTeam());
		System.out.println("Team Position"+ position);
	System.out.println("Tranfer Value"+transferValue);
	System.out.println("Player Attributes");
	System.out.println("------------------------------------------------");
	System.out.println("Pace: \t" + pace);
	System.out.println("Shooting"+ shooting);
	System.out.println("Heading "+ heading);
	System.out.println("Tackling"+ tackling);
	System.out.println("Consistency" + consistency);
	System.out.println("--------------------------------------");
	}
	public int getPlayerId() {
		return playerId;
	}



	public void setPlayerId(int playerId) {
		playerId = playerId;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public double getTransferValue() {
		return transferValue;
	}



	public void setTransferValue(double transferValue) {
		this.transferValue = transferValue;
	}



	public boolean isTransferListed() {
		return transferListed;
	}



	public void setTransferListed(boolean transferListed) {
		this.transferListed = transferListed;
	}



	public int getPace() {
		return pace;
	}



	public void setPace(int pace) {
		this.pace = pace;
	}



	public int getShooting() {
		return shooting;
	}



	public void setShooting(int shooting) {
		this.shooting = shooting;
	}



	public int getHeading() {
		return heading;
	}



	public void setHeading(int heading) {
		this.heading = heading;
	}



	public int getTackling() {
		return tackling;
	}



	public void setTackling(int tackling) {
		this.tackling = tackling;
	}



	public int getConsistency() {
		return consistency;
	}



	public void setConsistency(int consistency) {
		this.consistency = consistency;
	}



	
}
