import org.lwjgl.input.Keyboard;


public class WMLLOptionsMisc extends awb {

	private WMLL wmll;
	private awb parent;
	private int resetClicks = 0;
	
	public WMLLOptionsMisc(WMLL wmll, awb aum) {
		this.wmll = wmll;
		this.parent = aum;
	}
	
	@SuppressWarnings("unchecked")
	public void A_() {
		i.clear();
		if (wmll.debugClassPresent || WMLL.WMLLDebugActive())
			i.add(new auq(9001, g - 60, 0, 60, 20, "Reload GUI"));
		i.add(new auq(0, g / 2 - 190, h - 30, 380, 20, "Done"));
		i.add(new auq(1, g / 2 - 100, h / 4 + 25, 200, 20, "Reload Settings from file"));
		i.add(new auq(2, g / 2 - 100, h / 4 + 50, 200, 20, "Reset Settings to defaults"));
		i.add(new auq(3, g / 2 - 100, h / 4, 200, 20, "Automatically check for updates: "+(wmll.autoUpdateCheck ? "ON" : "OFF")));
	}
	
	public void a(auq b) {
		switch (b.g) {
		case 9001:
			f.a(new WMLLOptionsMisc(this.wmll, this.parent));
			return;
		case 0:
			f.a(parent);
			return;
		case 1:
			wmll.loadOptions();
			f.a(new WMLLOptionsMisc(this.wmll, this.parent));
			return;
		case 2:
			resetClicks++;
			if (resetClicks == 2) {
				WMLL.options.clear();
				wmll.deleteSettingsFile();
				wmll.loadOptions();
				wmll.lastWorld = "";
				wmll.warnedAboutConflicts = false;
				f.a(new WMLLOptionsMisc(this.wmll, this.parent));
			}
			return;
		}
	}
	
	protected void a(char c, int i) {
		if (i == Keyboard.KEY_ESCAPE)
			f.a(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) ? null : parent);
	}
	
	public void a(int i, int j, float f) {
		e();
		if (resetClicks == 1)
			a(o, "\247cClick again to confirm.", g / 2, h / 4 + 75, 0xffffff);
		super.a(i, j, f);
	}

}
