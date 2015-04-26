package org.jointheleague.stephenh.newlevel3;

import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DressColorSurvey {
	HashMap<String, String> surveyResults = new HashMap<String, String>(); 
	
	public static void main(String[] args) {
		new DressColorSurvey().run();
	}

	private void run() {
		boolean continueSurvey = true;
		while (continueSurvey) {
			speak ("What is your name?");
			String name = JOptionPane.showInputDialog("Enter name");
			speak("Okay " + name + ". Tell me. What is the color of this dress?");
			String answer = "";
			try {
				answer = (String) JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE,
						new ImageIcon(new URL("https://lh3.googleusercontent.com/MKByGTq1TnIvPkVSESMTQRfwd4kDpNLS3nr66bZSiNA2g60oBOjSvXahp8zakG2L7n3K9fk9ONUiJQ0jr9XIBI_kJmzS9PDpa6NuG072AGTXCbP47Dt7vdxsJAGdlxmRnGcYRw")), 
						new String[] {"Black & Blue", "White & Gold"}, "Black & Blue");
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			System.out.println(name + " said the dress was " + answer);
			surveyResults.put(name, answer);
			speak("Thank you " + name + ". You said the dress was " + answer);
			if (JOptionPane.showConfirmDialog(null, "Continue survey?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				continueSurvey = false;
			}
		}
		//TODO calculate results
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
