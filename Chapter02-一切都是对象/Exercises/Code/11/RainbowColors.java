public class RainbowColors {
	int anIntegerRepresentingColors;
	void changeTheHueOfTheColor(int newHue) {
		System.out.println("At the begining, the hue of the color is " + anIntegerRepresentingColors);
		anIntegerRepresentingColors = newHue;
		System.out.println("The hue of the color has been changed to " + anIntegerRepresentingColors);
	}
	public static void main(String[] args) {
		RainbowColors rc = new RainbowColors();
		rc.anIntegerRepresentingColors = 1;
		rc.changeTheHueOfTheColor(2);
	}
}
