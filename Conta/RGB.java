public class RGB{
    
    private int red;
    private int green;
    private int blue;

    
   public static final RGB PRETO = new RGB(0, 0, 0);
   public static final RGB BRANCO = new RGB(255, 255, 255);
   public static final RGB RED = new RGB(255, 0, 0);
   public static final RGB GREEN = new RGB(0, 255, 0);
   public static final RGB BLUE = new RGB(0, 0, 255);
   

    
     //Construtor para objetos da classe RGB
    public RGB(int clrRed, int clrGreen, int clrBlue){
        this.setRed(clrRed);
        this.setGreen(clrGreen);
        this.setBlue(clrBlue);
    }

    // Um construtor sem parâmetros, que crie a cor preta
    public RGB(){
        this(0, 0, 0);
    }     

    // Um construtor de cópia, que crie uma cor idêntifica (mesmo valor de R, G e B)
    public RGB(RGB cor){
        this(cor.getRed(), cor.getGreen(), cor.getBlue());
    }


    private void setRed(int red){
        if(red>=0 && red<256)
            this.red = red;
    }
    
    private void setGreen(int green){
        if(green>=0 && green<256)
            this.green = green;
    }
    
    private void setBlue(int blue){
        if(blue>=0 && blue<256)
            this.blue = blue;
    }
    
    public int getRed(){
        return this.red;
    } 
    
     public int getGreen(){
        return this.green;
    } 
    
      public int getBlue(){
        return this.blue;
    } 
    
      //Método de luminosidade 
    private int getLuminosidadeRGB(){
        double calcLumin;
        calcLumin = (this.red*0.3+this.green*0.59+this.blue*0.11); 
        return (int)(Math.ceil(calcLumin));
    }
    
    @Override
    public String toString() {
    	return this.getRed()  +"," + this.getGreen()  + "," + this.getBlue();
    }
    
    //Converte RGB em hexa
    public String toHexaDecimal(){
        return "#" + Integer.toHexString(this.getRed()) +
                    Integer.toHexString(this.getGreen()) +
                    Integer.toHexString(this.getBlue());
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RGB other = (RGB) obj;
		if (blue != other.blue)
			return false;
		if (green != other.green)
			return false;
		if (red != other.red)
			return false;
		return true;
	}
	
	//Métodos clarear cor
        public RGB clarearCor(double p){
        	RGB claro = new RGB((this.getRed() + (int)(this.getRed()*p)),
            	(this.getGreen() + (int)(this.getGreen()*p)),(this.getBlue() + (int)(this.getBlue()*p))); 
                return claro;
       }
        
    //Métodos escurecer cor
	public RGB escurecerCor(double p){
        	RGB escuro = new RGB((this.getRed() - (int)(this.getRed()*p)),
                (this.getGreen() - (int)(this.getGreen()*p)),(this.getBlue() - (int)(this.getBlue()*p))); 
                return escuro;
    }
	
	//Método nova imagem com o equivalente em tons de cinza
    public RGB corCinza () {
           int lumi = this.getLuminosidadeRGB();
           RGB cinza = new RGB(lumi, lumi, lumi);
           return cinza;
    }

	//Método que retorna uma nova instância de CorRGB, igual a cor que recebeu a mensagem
     public RGB corRGBIgual(){
           return new RGB(this.getRed(), this.getGreen(), this.getBlue());
    }
   
}