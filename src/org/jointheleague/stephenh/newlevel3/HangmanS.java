package org.jointheleague.stephenh.newlevel3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class HangmanS extends JPanel implements Runnable, KeyListener {
	private JFrame frame = new JFrame("Stephen's Hangman S");
	private ArrayList<String> puzzles = new ArrayList<String>();
	private String puzzle = "";
	private ArrayList<JLabel> boxes = new ArrayList<JLabel>();
	private int lives = 9;
	private JLabel livesLabel = new JLabel("#");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new HangmanS());
	}

	@Override
	public void run() {
		createPuzzles();
		createUI();
		getPuzzle();
	}

	private void createPuzzles() {
		puzzles.add("purple");
		puzzles.add("smash");
		puzzles.add("crazy");
		puzzles.add("recognizable");
		puzzles.add("easy");
		puzzles.add("blue");
		puzzles.add("red");
		puzzles.add("master");
		puzzles.add("top");
		puzzles.add("a");
		puzzles.add("i");
		puzzles.add("globalization");
		puzzles.add("panorama");
		puzzles.add("localization");
		puzzles.add("ball");
	}
	
	private void createUI() {
		frame.add(this);
		frame.addKeyListener(this);
		this.setPreferredSize(new Dimension(1000, 50));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		livesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		frame.pack();
		frame.setVisible(true);
	}
	
	private void updateSpacesWithUserInput(char keyChar) {
		for (int i = 0; i < puzzle.length(); i++) {
			if (puzzle.charAt(i) == keyChar) {
				boxes.get(i).setText("" + keyChar);
			}
		}
		if (getCurrentAnswer().equals(puzzle)) {
			JOptionPane.showMessageDialog(this, "You're nice\nThe answer was " + puzzle, "Victory", JOptionPane.INFORMATION_MESSAGE);
			getPuzzle();
		}
	}
	
	private String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : boxes) {
			answer.append(textBox.getText());
		}
		return answer.toString();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if ('a' <= c && c <= 'z' ) {
			if (puzzle.contains("" + c)) {
				updateSpacesWithUserInput(c);
			} else {
				lives -= 1;
				livesLabel.setText("" + lives);
				if (lives == 0) {
					JOptionPane.showMessageDialog(this, "Are you a banana, or is your spoon too big?\nThe answer was " + puzzle,
							"FAIL!", JOptionPane.ERROR_MESSAGE);
					getPuzzle();
				}
			}
		}
	}
	
	private void getPuzzle() {
		//System.out.println("getting puzzles");
		clearBoxes();
		Random r = new Random();
		puzzle = puzzles.get(r.nextInt(puzzles.size()));
		boxes.clear();
		for (int i = 0; i < puzzle.length(); i++) {
			boxes.add(new JLabel("_"));
		}
		lives = 9;
		livesLabel.setText("" + lives);
		addBoxes();
	}

	private void addBoxes() {
		//System.out.println("boxes size:" + boxes.size());
		for (JLabel label : boxes) {
			this.add(label);
		}
		this.add(livesLabel);
		repaint();
		frame.pack();
		//System.out.println("boxes added");
	}

	private void clearBoxes() {
		for (JLabel label : boxes) {
			this.remove(label);
		}
		this.remove(livesLabel);
		repaint();
		frame.pack();
		//System.out.println("boxes cleared");
	}
}
