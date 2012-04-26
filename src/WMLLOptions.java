import org.lwjgl.input.Keyboard;

public class WMLLOptions extends xa {
	
	
	
	public WMLLOptions(WMLL i) {
		this.wmll = i;
	}


	public WMLLOptions(WMLL wmll, xa parent) {
		this.wmll = wmll;
		this.parent = parent;
	}


	@SuppressWarnings({ "unchecked", "static-access" })
	public void c() {
		s.clear();
		String debug = WMLL.WMLLDebugActive() == true ? "ON": "OFF";
		String ikey = Keyboard.getKeyName(wmll.F4Key);
		String clockformat = "24 hr";
		int a = wmll.clockSetting;
		if (a < 3)
			clockformat = (a == 2 ? "24 hr" : "12 hr");
		else clockformat = "OFF";

		//String clockformat = wmll.clockSetting == 2 ? "24 hr" : "12 hr";
		byte offset = -16;
		/*
		 * New button
		 * adi((int)ID, x, y[, width, height], text)
		 */
		s.add(new adi(1, q / 2 - 100, r / 4 + 150 + offset, "Done"));
		s.add(new adi(0, q / 2 - 100, r / 4 - 5 + offset, 98, 20, "Debug: "+debug));
		s.add(new adi(2, q / 2 + 2, r / 4 - 5 + offset, 98, 20, "Cycle Key: "+ikey));
		s.add(new adi(5, q / 2 - 100, r / 4 + 20 + offset, 98, 20, (clockformat == "OFF" ? "Clock is " : "Time Format: ")+clockformat));
		s.add(new adi(6, q / 2 + 2, r / 4 + 20 + offset, 98, 20, "Images: "+(wmll.useImages ? "ON" : "OFF")));
		s.add(new adi(3, q / 2 - 100, r / 4 + 125 + offset, "Output options..."));
		s.add(new adi(4, q / 2 - 100, r / 4 + 85 + offset, "Force options reload"));
		//s.add(new adi(4, q / 2 - 100, r / 4 + 130 + offset, "\247"+Integer.toHexString(TextColour)+"Text Colour"));
		String enabledString = "Enabled on "+(wmll.getWorldName() == "MpServer" ? "SMP" : "this world")+": "+(wmll.Enabled ? "Yes" : "No");
		int i = wmll.getFontRenderer().a(enabledString);
		s.add(new adi(8, (q - (i + 10)) / 2, r / 4 + 45 + offset, i + 10, 20, enabledString));
		if (WMLL.debugClassPresent)
			s.add(new adi(9001, q - 52, r - 22, 50, 20, "Reload"));
		if (!wmll.Enabled)
			for (int x = 3; x < 6; x++)
				((adi)s.get(x)).h = false;
	}

	@SuppressWarnings("static-access")
	protected void a(adi button) {
		if (button.f == 1) {
			wmll.optionsOpen = false;
			wmll.saveOptions();
			if (parent == null) {
				p.s = null;
				p.g();
			}
			else {
				p.a(parent);
			}
		}
		if (button.f == 0) {
			WMLL.toggleDebug();
			String debug = wmll.debugActive == true ? "ON": "OFF";
			button.e = "Debug: "+debug;
		}
		if (button.f == 2) {
			isBinding = true;
			button.e = "Press a key...";
		}
		if (button.f == 3) {
			p.a(new WMLLGuiOutputOptions(WMLL.i, this));
		}
		if (button.f == 4) {
			wmll.loadOptions();
		}
		if (button.f == 5) {
			int a = wmll.clockSetting;
			a++;
			if (a > 3)
				a = 1;
			button.e = (a < 3 ? "Time Format: " : "Clock is ")+ buttonTextForClockSetting(a);
			wmll.clockSetting = a;
		}
		if (button.f == 6) {
			wmll.useImages = !wmll.useImages;
			button.e = "Images: "+(wmll.useImages ? "ON" : "OFF");
		}
		if (button.f == 8) {
			boolean a = wmll.Enabled;
			wmll.Enabled = !a;
			wmll.options.setProperty("World-"+wmll.getWorldName(), Boolean.toString(!a));
			for (int x = 3; x < 6; x++)
				((adi)s.get(x)).h = !a;
			button.e = "Enabled on "+(wmll.getWorldName() == "MpServer" ? "SMP" : "this world")+": "+(!a ? "Yes" : "No");
		}
		if (button.f == 9001) // Debug button
			p.a(new WMLLOptions(wmll));
	}

	private static String buttonTextForClockSetting(int i) {
		switch (i) {
		case 1:
			return "12 hr";
		case 2:
			return "24 hr";
		default:
			return "OFF";
		}
	}

	public String getStringForLightOption(int o) {
		switch (o) {
		case 0:
			return "Just Light";
		case 1:
			return "Light + Indicators";
		case 2:
			return "Light + FPS/Chunk Updates";
		case 3:
			return "Light + Coords, Facing, Biome & Seed";
//		case 4:
//			return "Light + Seed";
		case 4:
			return "Just Indicators";
		case 5:
			return "Just FPS/Chunk updates";
		case 6:
			return "Just Coords, Facing, Biome & Seed";
//		case 7: 
//			return "Just Seed";
		default:
			return "Nothing";
		}
	}

	protected void a(char c1, int i1) {
		if (i1 == Keyboard.KEY_ESCAPE && parent != null) {
			p.a(parent);
		}
		else if (isBinding && i1 != Keyboard.KEY_ESCAPE) {
			WMLL.F4Key = i1;
			isBinding = false;
			((adi)s.get(2)).e = "Cycle Key: "+Keyboard.getKeyName(i1);
		}
		else {
			super.a(c1, i1);
		}
	}
	
	public void a() {

	}

	public void a(int i, int j, float f) {
		r_();
		// (fontrenderer, text, x, y, colour)
		a(u, title, q / 2, 20, 0xffffff);
		a(u, "\247cReloading options will undo any changes you've made!", q / 2, 150, 0xffffff);
		renderWMLLVersion();
		super.a(i, j, f);
	}
	
	public static void renderWMLLVersion() {
		WMLL wmll = WMLL.i;
		int r = wmll.getWindowSize().b();
		String ver = "WMLL "+WMLL.WMLLVER+" ("+WMLL.getMinecraftVersion()+")";
		wmll.drawStringUsingPixels(ver, 2, r - 9, 0x444444);
	}

	private String title = "WMLL Configuration";;
	private WMLL wmll;
	protected xa parent;
	public static boolean isBinding;

}