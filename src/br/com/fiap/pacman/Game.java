import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player(50, 50, 180);
	private Ghost ghost1 = new Ghost(0, 0, 0);
	private Ghost ghost2 = new Ghost(500, 0, 0);
	private Ghost ghost3 = new Ghost(0, 500, 0);
	private Ghost ghost4 = new Ghost(500, 500, 0);
	private ArrayList<Ghost> listGhosts = new ArrayList<>();
	private Bomb bomb = new Bomb(100, 100);
	private ArrayList<Bomb> listBombs = new ArrayList<>();
	private Booster booster = new Booster(400, 400, 5);
	private ArrayList<Booster> listBoosters = new ArrayList<>();

	private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
	private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
	private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

	private final int SCREENSIZE = 600;
	private int speed = 50;

	public static void main(String[] args) {
		new Game().init();
	}

	private void init() {
		listGhosts.add(ghost1);
		listGhosts.add(ghost2);
		listGhosts.add(ghost3);
		listGhosts.add(ghost4);
		listBombs.add(bomb);
		listBoosters.add(booster);
		
		setLayout(null);
		player.setScreenSize(SCREENSIZE);
		player.setLife(15);

		ghost1.setScreenSize(SCREENSIZE);
		ghost2.setScreenSize(SCREENSIZE);
		ghost3.setScreenSize(SCREENSIZE);
		ghost4.setScreenSize(SCREENSIZE);

		add(imgPlayer);
		add(imgGhost1);
		add(imgGhost2);
		add(imgGhost3);
		add(imgGhost4);
		add(imgBomb);
		add(imgBooster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {

		updateLocation(imgPlayer, player);
		updateLocation(imgGhost1, ghost1);
		updateLocation(imgGhost2, ghost2);
		updateLocation(imgGhost3, ghost3);
		updateLocation(imgGhost4, ghost4);
		updateLocation(imgBomb, bomb);
		updateLocation(imgBooster, booster);
		setTitle("Life: " + player.getLife());
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void updateLocation(JLabel label, GameObject object) {
		label.setBounds(object.getPositionX(), object.getPositionY(), 50, 50);
		ImageIcon myImage = (ImageIcon) label.getIcon();
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(newImg));
	}

	private void run() {
		while (player.getLife() > 0) {
			player.move();
			ghost1.move();
			ghost2.move();
			ghost3.move();
			ghost4.move();
			
			for (Ghost ghost : listGhosts) {
				if (player.getPositionX() == ghost.getPositionX() && player.getPositionY() == ghost.getPositionY()) {
					player.setLife(player.getLife() - 1);
				}
			}

			for (Bomb bomb : listBombs) {
				if (player.getPositionX() == bomb.getPositionX() && player.getPositionY() == bomb.getPositionY()
						&& bomb.isVisible()) {
					player.setLife(player.getLife() - 1);
					bomb.setVisible(false);
				}
			}

			for (Booster booster : listBoosters) {
				if (player.getPositionX() == booster.getPositionX() && player.getPositionY() == booster.getPositionY()
						&& booster.isVisible()) {
					player.setGodMode(true);
					;
					booster.setVisible(false);
				}

				if (!booster.isVisible() && booster.getDuration() > 0)
					booster.setDuration(booster.getDuration() - 1);
			}
			

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '8' || c == 'w')
			player.setDirection(0);
		if (c == '6' || c == 'd')
			player.setDirection(90);
		if (c == '2' || c == 's')
			player.setDirection(180);
		if (c == '4' || c == 'a')
			player.setDirection(270);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
