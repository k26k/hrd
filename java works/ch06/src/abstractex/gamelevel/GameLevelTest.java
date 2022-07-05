package abstractex.gamelevel;

public class GameLevelTest {

	public static void main(String[] args) {

		Player player = new Player();
		player.play(2);
		
		player.upgradeLevel(new AdvancedLevel());
		player.play(3);
		
		player.upgradeLevel(new SuperLevel());
		player.play(4);
		
	}

}
