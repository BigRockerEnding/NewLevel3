package org.jointheleague.stephenh.newlevel3;

import java.util.Random;

public class TastyEgg {
	public static void main(String[] args) {
		KinderSurprise myKinderSurprise = new KinderSurprise(new Egg(new Toy()));
		String result = "You got a " + myKinderSurprise.getKinderSurpriseContents().getEggContents().getToyName();
		System.out.println(result);
		new TastyEgg().speak(result);
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class KinderSurprise {
	private Egg egg;

	public KinderSurprise(Egg egg) {
		this.egg = egg;
	}

	Egg getKinderSurpriseContents() {
		return egg;
	}
}

class Egg {

	private Toy toy;

	public Egg(Toy toy) {
		this.toy = toy;
	}

	Toy getEggContents() {
		return toy;
	}

}

class Toy {
	String getToyName() {
		int randomToySelector = new Random().nextInt(3);
		//System.out.println(randomToySelector);
		if (randomToySelector == 0)
			return "play doh";
		else if (randomToySelector == 1)
			return "train";
		else
			return "spongebob";
	}

}