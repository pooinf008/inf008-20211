package inf008.model;

public class CorRGB {
	
	public static CorRGB PRETA = new CorRGB(0, 0, 0);
	public static CorRGB BRANCA = new CorRGB(255, 255, 255);
	public static CorRGB RED = new CorRGB(255, 0, 0);
	public static CorRGB GREEN = new CorRGB(0, 255, 0);
	public static CorRGB BLUE = new CorRGB(0, 0, 255);
	
	private int red;
	private int green;
	private int blue;
	
	
	public static CorRGB parse(String hex) {
		String sRed = hex.substring(1, 3);
		String sGreen = hex.substring(3, 5);
		String sBlue = hex.substring(5, 7);
		return new CorRGB(CorRGB.hextoInt(sRed), CorRGB.hextoInt(sGreen), CorRGB.hextoInt(sBlue));
	}
	
	private static int hextoInt(String numero) {
		return CorRGB.charHextoInt(numero.charAt(0)) * 16 + CorRGB.charHextoInt(numero.charAt(1)); 
	}
	
	private static int charHextoInt(char digito) {
		if (digito >= '0' &&  digito <= '9')
			return digito - '0';
		else
			return digito - 'A' + 10;
	}

	
	public CorRGB(int red, int green, int blue) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}
	
	public CorRGB(CorRGB cor) {
		this(cor.getRed(), cor.getGreen(), cor.getBlue());
	}
	
	public CorRGB() {
		this(0, 0, 0);
	}
	
	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}
	
	public int getLuminosidade() {
		return (int)(this.getRed() * 0.3 +
					 this.getGreen() * 0.59 +
					 this.getBlue() * 0.11
					);
	}

	private void setRed(int red) {
		int valor = (red < 0) ? 0 : red;
		valor = (valor > 255) ? 255 : valor;
		this.red = valor;
	}
	
	private void setGreen(int green) {
		int valor = (green < 0) ? 0 : green;
		valor = (valor > 255) ? 255 : valor;
		this.green = valor;
	}
	
	private void setBlue(int blue) {
		int valor = (blue < 0) ? 0 : blue;
		valor = (valor > 255) ? 255 : valor;
		this.blue = valor;
	}
	
	public boolean equals(CorRGB cor) {
		return this.getRed() == cor.getRed() &&
			   this.getGreen() == cor.getGreen() &&
			   this.getBlue() == cor.getBlue();
	}
	
	public CorRGB clone() {
		return new CorRGB(this);
	}
	
	public CorRGB getGrayScale() {
		return new CorRGB(this.getLuminosidade(), 
						  this.getLuminosidade(), 
						  this.getLuminosidade());
	}
	
	public void clarear(double parametro) {
		parametro = 1 + parametro;
		this.mudarPct(parametro);		
	}
	
	public void escurecer(double parametro) {
		parametro = 1 - parametro;
		this.mudarPct(parametro);
	}
	
	private void mudarPct(double parametro) {
		this.setRed((int)(this.getRed() * parametro));
		this.setGreen((int)(this.getGreen() * parametro));
		this.setBlue((int)(this.getBlue() * parametro));
	}
	
	public String toHex() {
		return "#" + this.intToHex(this.getRed()) + 
					 this.intToHex(this.getGreen()) + 
					 this.intToHex(this.getBlue());
	}
	
	private String intToHex(int valor) {
		String res = "";
		int dig1 = valor / 16;
		int dig2 = valor % 16;
		res = res + intToCharHex(dig1) + intToCharHex(dig2); 
		return res;
	}
	
	private char intToCharHex(int valor) {
		char charHex;
		if(valor >= 0 && valor <= 9)
			charHex = (char) ('0' + valor);
		else
			charHex = (char) ('A' + valor - 10);
		return charHex;

	}

}
