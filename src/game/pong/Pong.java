package game.pong;

import javax.swing.SwingUtilities;

import game.pong.ui.PongUI;

public class Pong {
	
	public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PongUI().setVisible(true);
			}
    	});
    }

}
