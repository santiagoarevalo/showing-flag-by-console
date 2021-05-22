package model;

public class Flag {
	
	public final static String ESC   = "\u001b[";
	
	public synchronized String showLine(int color) {
		return ESC + color + "m ";
	}
}
