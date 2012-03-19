import java.util.Properties;

import org.lwjgl.input.Keyboard;


public class WMLLGuiOutputOptions extends vl {
	
	protected WMLL wmll;
	private vl parent;
	private String title;
	private static final String[] colourNames = {"Black", "Dark Blue", "Dark Green", "Cyan", "Red", "Purple", "Orange", "Light Grey", "Dark Grey", "Lavender?", "Lime Green", "Light Blue", "Bright Red", "Pink", "Yellow", "White"};
	private static final String[] outputLocations = {"Top Left", "Top Right", "Bottom Left", "Bottom Right"};
	public static Properties outputOptions;
	
	@SuppressWarnings("static-access")
	public WMLLGuiOutputOptions(WMLL wmll, vl parent) {
		this.wmll = wmll;
		this.parent = parent;
		this.outputOptions = WMLL.outputOptions;
		title = "WMLL Output Configuration";
	}
	
	@SuppressWarnings("unchecked")
	public void c() {
		s.clear();
		if (outputOptions == null)
			outputOptions = new Properties();
		int tc = WMLL.TextColour;
		byte o = -16;
		/*
		 * New button
		 * abk((int)ID, x, y[, width, height], text)
		 * y = y+25 for each button
		*/
		s.add(new abk(1, q / 2 - 100, r / 4 + 150 + o, 98, 20, "Done"));
		//s.add(new abk(0, q / 2 - 152, r / 4 + 150 + o, 98, 20, "<<"));
		s.add(new abk(2, q / 2 + 2, r / 4 + 150 + o, 98, 20, ">>"));
		s.add(new abk(3, q / 2 - 112, r / 4 - 5 + o, 112, 20, outputLocations[WMLL.outputLocation]));
		s.add(new abk(4, q / 2 + 2, r / 4 - 5 + o, 112, 20, "\247"+Integer.toHexString(tc)+colourNames[tc]));
		if (WMLL.debugClassPresent)
			s.add(new abk(9001, 2, r - 22, 50, 20, "Reload"));
		s.add(new abk(5, q / 2 - 100, r / 4 + 120 + o, "Light Level options..."));
		s.add(new abk(6, q / 2 - 112, r / 4 + 20 + o, 112, 20, "Override F3: "+(wmll.wmllOverrideF3 ? "Yes" : "No")));
		s.add(new abk(7, q / 2 + 2, r / 4 + 20 + o, 112, 20, "F3 Type: "+(wmll.F3Type == 1 ? "Alternate" : "Classic")));
		s.add(new abk(8, q / 2 - 112, r / 4 + 45 + o, 112, 20, "Seed w/ Coords: "+(wmll.showSeedWithCoords ? "Yes" : "No")));
		s.add(new abk(9, q / 2 - 100, r / 4 + 98 + o, "Enter seed for server..."));
/*		s.add(new abk(2, q / 2 + 2, r / 4 + 45 + o, 98, 20, "f"));
		s.add(new abk(0, q / 2 - 100, r / 4 + 70 + o, 98, 20, "g"));
		s.add(new abk(2, q / 2 + 2, r / 4 + 70 + o, 98, 20, "h"));
		s.add(new abk(0, q / 2 - 100, r / 4 + 95 + o, 98, 20, "i"));
		s.add(new abk(2, q / 2 + 2, r / 4 + 95 + o, 98, 20, "j"));*/
		((abk)s.get(1)).h = ((abk)s.get(7)).h = false;
		((abk)s.get(8)).i = wmll.isMultiplayer();
		
	}
	
	protected void a(abk b) {
		if (b.f == 1 || b.f == 2) {
			if (b.f == 2) { // Next
				System.out.println("NO GUI YET!");
			}
			else // Done
				p.a(parent);
			WMLL.outputOptions = outputOptions;
		}
		else if (b.f == 3) { // Output location
			int a = WMLL.outputLocation;
			a++;
			if (a > 3)
				a = 0;
			getButton(2).e = outputLocations[a];
			WMLL.outputLocation = a;
		}
		else if (b.f == 4) { // Text Colour
			int a = WMLL.TextColour;
			a++;
			if (a > 15)
				a = 0;
			getButton(3).e = "\247"+Integer.toHexString(a)+colourNames[a];
			WMLL.TextColour = a;
		}
		else if (b.f == 6) { // F3 override
			wmll.wmllOverrideF3 = !wmll.wmllOverrideF3;
			b.e = "Override F3: "+(wmll.wmllOverrideF3 ? "Yes" : "No");
		}
		else if (b.f == 5) { // Light level options
			p.a(new WMLLGuiLightLevel(wmll, this));
		}
		else if (b.f == 7) {
			int a = wmll.F3Type;
			a++;
			if (a > 1)
				a = 0;
			wmll.F3Type = a;
			b.e = "F3 Type: "+(a == 1 ? "Alternate" : "Classic");
		}
		else if (b.f == 8) {
			boolean a = wmll.showSeedWithCoords;
			a = !a;
			wmll.showSeedWithCoords = a;
			b.e = "Seed w/ Coords: "+(a ? "Yes" : "No");
		}
		else if (b.f == 9) {
			p.a(new WMLLSMPSeed(wmll, this));
		}
		else if (b.f == 9001) // Debug button
			p.a(new WMLLGuiOutputOptions(wmll, parent));
	}
	
	protected void a(char c, int i) {
		if (Keyboard.KEY_ESCAPE == i)
			p.a(parent);
		else
			super.a(c, i);
	}
	
	public void a(int i, int j, float f) {
		k();
		// (fontrenderer, text, x, y, colour)
		a(u, title, q / 2, 20, 0xffffff);
		int a = (q - ((wmll.getFontRenderer().a(WMLL.WMLLVER) + 2) / 2));
		a(u, WMLL.WMLLVER, a, r - 9, 0x444444);
		super.a(i, j, f);
	}
	
	public void e() {
		Keyboard.enableRepeatEvents(false);
	}
	
	// Begin custom functions
	
	private abk getButton(int id) {
		return ((abk)s.get(id));
	}
	
}