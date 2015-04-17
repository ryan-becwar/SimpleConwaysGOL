/**
 * Created by Grace on 4/15/15. 
 * Allows user to switch between pre-designated color schemes.
 * Implements FlyWeight pattern.
 */

package cu.cs.cpsc215.project3;
import java.awt.Color;

public class ColorScheme {
	
	private Color liveColor;
	private Color deadColor;
	
	private static int count = -1;
	
	/**
	 * Designated Color Schemes. Default is blue and light gray.
	 */
	private static ColorScheme[] mySchemes = {new ColorScheme(Color.BLUE, Color.LIGHT_GRAY),
											  new ColorScheme(Color.ORANGE, Color.MAGENTA),
											  new ColorScheme(new Color(82, 45, 128), new Color(234, 106, 32)),
											  new ColorScheme(Color.RED, Color.GREEN),
											  new ColorScheme(Color.CYAN, Color.DARK_GRAY)};
	/**
	 * Private constructor inhibits unnecessary addition of new schemes.
	 * @param c1
	 * @param c2
	 */
	private ColorScheme(Color c1, Color c2) {
		liveColor = c1; 
		deadColor = c2;
	}

	/**
	 * Returns live color
	 * @return
	 */
	public Color getLiveColor() {
		// TODO Auto-generated method stub
		return liveColor;
	}

	/**
	 * Returns dead color
	 * @return
	 */
	public Color getDeadColor() {
		// TODO Auto-generated method stub
		return deadColor;
	}
	
	/**
	 * Returns next color scheme.
	 * @return
	 */
	public static ColorScheme getNextScheme() {
		count++;
		return mySchemes[count % mySchemes.length];
	}

}
