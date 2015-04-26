package org.jointheleague.stephenh.newlevel3;

import javax.swing.JOptionPane;

public class StringBuilderManipulation {
	private StringBuilder sb1 = new StringBuilder("sarahbrown");
	private StringBuilder sb2 = new StringBuilder("tjchan");

	public static void main(String[] args) {
		new StringBuilderManipulation().run();
	}

	private void run() {
		result();
		sb1.insert(9, sb2).replace(2, 6, "hi");
		result();
		reset();
		sb2.insert(2, sb1.substring(5, 10));
		result();
		reset();
		sb2.replace(4, 6, sb1.append("rocks").toString());
		result();
		reset();
		sb1.replace(3, 4, sb2.substring(4)).append(sb2.append(true));
		result();
		reset();
		sb2.replace(5, 9, sb1.append(sb2.insert(4, false)).toString().toUpperCase());
		result();
		reset();
		result();
	}

	private void result() {
		speak(sb1.toString());
		speak(sb2.toString());
		JOptionPane.showMessageDialog(null, sb1 + "\n" + sb2);
	}

	private void reset() {
		sb1 = new StringBuilder("sarahbrown");
		sb2 = new StringBuilder("tjchan");
	}

	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
