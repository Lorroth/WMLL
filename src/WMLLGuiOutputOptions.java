import java.util.Properties;

import org.lwjgl.input.Keyboard;


public class WMLLGuiOutputOptions extends apm {

	protected WMLL wmll;
	private apm parent;
	private String title;
	private static final String[] colourNames = {"Black", "Dark Blue", "Dark Green", "Cyan", "Red", "Purple", "Orange", "Light Grey", "Dark Grey", "Lavender?", "Lime Green", "Light Blue", "Bright Red", "Pink", "Yellow", "White"};
	private static final String[] outputLocations = {"Top Left", "Top Right", "Bottom Left", "Bottom Right"};
	public static Properties outputOptions;
	private aog SMPSeedButton;

	@SuppressWarnings("static-access")
	public WMLLGuiOutputOptions(WMLL wmll, apm parent) {
		this.wmll = wmll;
		this.parent = parent;
		this.outputOptions = WMLL.outputOptions;
		title = "WMLL Output Configuration";
	}

	@SuppressWarnings("unchecked")
	public void w_() {
			h.clear();
			if (outputOptions == null)
				outputOptions = new Properties();
			int tc = WMLL.TextColour;
			byte o = -16;
			if (WMLL.debugClassPresent)
				h.add(new aog(9001, f - 52, g - 22, 50, 20, "Reload"));
			h.add(new aog(1, f / 2 - 112, g / 4 + 150 + o, 226, 20, "Done"));
			h.add(new aog(3, f / 2 - 112, g / 4 - 5 + o, 112, 20, outputLocations[WMLL.outputLocation]));
			h.add(new aog(4, f / 2 + 2, g / 4 - 5 + o, 112, 20, "\247"+Integer.toHexString(tc)+colourNames[tc]));
			h.add(new aog(5, f / 2 + 2, g / 4 + 100 + o, 112, 20, "Light Level options..."));
			h.add(new aog(6, f / 2 - 112, g / 4 + 20 + o, 112, 20, "Override F3: "+(wmll.wmllOverrideF3 ? "Yes" : "No")));
			h.add(new aog(8, f / 2 + 2, g / 4 + 20 + o, 112, 20, "Seed w/ Coords: "+(wmll.showSeedWithCoords ? "Yes" : "No")));
			h.add(SMPSeedButton = new aog(9, f / 2 - 112, g / 4 + 125 + o, 226, 20, "Enter seed for this server..."));
			h.add(new aog(11, f / 2 - 112, g / 4 + 100 + o, 112, 20, "Enabled outputs..."));
			h.add(new aog(10, f / 2 - 112, g / 4 + 75 + o, 226, 20, "Show: "+getStringForLightOption(WMLL.WMLLI)));
		}

	protected void a(aog b) {
		if (b.f == 1 || b.f == 2) {
			if (b.f == 2) { // Next
				System.out.println("NO GUI YET!");
			}
			else // Done
				e.a(parent);
			WMLL.outputOptions = outputOptions;
		}
		else if (b.f == 3) { // Output location
			int a = WMLL.outputLocation;
			a++;
			if (a > 3)
				a = 0;
			b.e = outputLocations[a];
			WMLL.outputLocation = a;
		}
		else if (b.f == 4) { // Text Colour
			int a = WMLL.TextColour;
			a++;
			if (a > 15)
				a = 0;
			b.e = "\247"+Integer.toHexString(a)+colourNames[a];
			WMLL.TextColour = a;
		}
		else if (b.f == 6) { // F3 override
			wmll.wmllOverrideF3 = !wmll.wmllOverrideF3;
			b.e = "Override F3: "+(wmll.wmllOverrideF3 ? "Yes" : "No");
		}
		else if (b.f == 5) { // Light level options
			e.a(new WMLLGuiLightLevel(wmll, this));
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
			e.a(new WMLLGuiSMPSeed(wmll, this));
		}
		else if (b.f == 10) {
			int i2 = WMLL.WMLLI;
			i2++;
			if (i2 > 11)
				i2 = 0;
			b.e = "Show: "+getStringForLightOption(i2);
			WMLL.WMLLI = i2;
		}
		else if (b.f == 11) {
			e.a(new WMLLEnabledOutputs(wmll, this));
		}
		else if (b.f == 9001) // Debug button
			e.a(new WMLLGuiOutputOptions(wmll, parent));
	}

	protected void a(char c, int i) {
		if (Keyboard.KEY_ESCAPE == i)
			e.a(parent);
		else
			super.a(c, i);
	}

	public void a(int i, int j, float f) {
		v_();
		// (fontrenderer, text, x, y, colour)
		a(k, title, this.f / 2, 20, 0xffffff);
		WMLLOptions.renderWMLLVersion();
		super.a(i, j, f);
	}

	// Begin custom functions

	public String getStringForLightOption(int o) {
		switch (o) {
		case 0:
			return "Just Light";
		case 1:
			return "Light + Indicators";
		case 2:
			return "Light + FPS/Chunk Updates";
		case 3:
			return "Light & Compass";
		case 4:
			return "Light, Indicators & Compass";
		case 5:
			return "Light, FPS & Coordinates";
		case 6:
			return "Just Indicators";
		case 7:
			return "Just FPS/Chunk updates";
		case 8:
			return "Just Compass";
			//		case 7: 
			//			return "Just Seed";
		case 9:
			return "Just Indicators and Compass";
		case 10:
			return "Just FPS & Coordinates";
		default:
			return "Nothing";
		}
	}

}
