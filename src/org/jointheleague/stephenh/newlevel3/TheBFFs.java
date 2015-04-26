package org.jointheleague.stephenh.newlevel3;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class TheBFFs {
	private HashMap<String, String> bffs = new HashMap<String, String>();
	
	public static void main(String[] args) {
		new TheBFFs().run();
	}

	private void run() {
		bffs.put("Stephen", "Cody");
		bffs.put("June", "Spock");
		bffs.put("Ethan", "Ian");
		bffs.put("Uhura", "Man");
		bffs.put("Sulu", "Scotty");
		loopFriends();
		bffs.remove("June");
		loopFriends();
		bffs.put("June", "Captain Kirk");
		loopFriends();
		bffs.put("Sulu", "Uhura");
		loopFriends();
		if (bffs.containsKey("Captain Kirk") || bffs.containsValue("Captain Kirk")) {
			System.out.println("Captain Kirk has a best friend");
			speak("Captain Kirk has a best friend");
		} else {
			System.out.println("Captain Kirk doesn't have a best friend");
			speak("Captain Kirk doesn't have a best friend");
		}
	}

	private void loopFriends() {
		for (String name : bffs.keySet()) {
			System.out.println(name + "'s best friend is " + bffs.get(name));
			speak(name + "'s best friend is " + bffs.get(name));
		}
		JOptionPane.showMessageDialog(null, "");
		System.out.println("\n\n");
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
