class CorRGB
{
    private int valorRed;
    private int valorGreen;
    private int valorBlue;
    private double valorLuminosidade;

    public static final CorRGB preto = new CorRGB(0,0,0);
    public static final CorRGB branca = new CorRGB(255,255,255);
    public static final CorRGB red = new CorRGB(255,0,0);
    public static final CorRGB green = new CorRGB(0,255,0);
    public static final CorRGB blue = new CorRGB(0,0,255);


    //construtor cor RGB
    CorRGB(int red, int green, int blue)
    {
        try
        {
            if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255)

                throw new Exception("Número inválido");
            else {
                this.setValorRed(red);
                this.setValorGreen(green);
                this.setValorBlue(blue);
                this.setLuminosidade();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //CorPreta
    CorRGB()
    {
        this.setValorRed(0);
        this.setValorGreen(0);
        this.setValorBlue(0);
        this.setLuminosidade();
    }

    //Copia
    CorRGB(CorRGB x){

        this.setValorRed(x.getValorRed());
        this.setValorGreen(x.getValorGreen());
        this.setValorBlue(x.getValorBlue());
        this.setLuminosidade();

    }



    public int getValorRed() {
        return valorRed;
    }

    protected void setValorRed(int valorRed)
    {
        if(valorRed >= 255)
        {this.valorRed = 255;}
        else
        {
            if(valorRed < 0)
            {this.valorRed = 0;}
            else
            {this.valorRed = valorRed;}
        }
        this.setLuminosidade();
    }

    public int getValorGreen() {
        return valorGreen;
    }

    protected void setValorGreen(int valorGreen) {
        if(valorGreen >= 255)
        {this.valorGreen = 255;}
        else
        {
            if(valorGreen < 0)
            {this.valorGreen = 0;}
            else
            {this.valorGreen = valorGreen;}
        }
        this.setLuminosidade();
    }


    public int getValorBlue() {
        return valorBlue;
    }

    protected void setValorBlue(int valorBlue) {
        if(valorBlue >= 255)
        {this.valorBlue = 255;}
        else
        {
            if(valorBlue < 0)
            {this.valorBlue = 0;}
            else
            {this.valorBlue = valorBlue;}
        }
        this.setLuminosidade();
    }

    public double getLuminosidade()
    {
        return valorLuminosidade;
    }

    private void setLuminosidade()
    {
        this.valorLuminosidade = (this.getValorRed()*0.3 + this.getValorGreen()*0.59 + this.getValorBlue()*0.11);
    }

    public CorRGB clonar()
    {
        CorRGB clone = new CorRGB(this.getValorRed(),this.getValorGreen(),this.getValorBlue());
        return clone;
    }

    public boolean setIgualdadeCores(CorRGB x)
    {
        if (this.getValorRed() == x.getValorRed() &&
                this.getValorGreen() == x.getValorGreen() &&
                this.getValorBlue() == x.getValorBlue())
        {return true;}
        else
        {return false;}
    }

    private String conversorHexadecimal(int valor) {

        int dezenaHexa;
        int unidadeHexa;
        String dezenaHexaStr = "";
        String unidadeHexaStr = "";

        dezenaHexa = (int) valor/16;
        unidadeHexa = (int) ((valor/16.0 - dezenaHexa) * 16.0);

        switch(unidadeHexa)
        {
            case 10: unidadeHexaStr = "A";break;
            case 11: unidadeHexaStr = "B";break;
            case 12: unidadeHexaStr = "C";break;
            case 13: unidadeHexaStr = "D";break;
            case 14: unidadeHexaStr = "E";break;
            case 15: unidadeHexaStr = "F";break;
            default: unidadeHexaStr = "" + unidadeHexa;
        }
        switch(dezenaHexa)
        {
            case 10: dezenaHexaStr = "A";break;
            case 11: dezenaHexaStr = "B";break;
            case 12: dezenaHexaStr = "C";break;
            case 13: dezenaHexaStr = "D";break;
            case 14: dezenaHexaStr = "E";break;
            case 15: dezenaHexaStr = "F";break;
            default: dezenaHexaStr = "" + dezenaHexa;
        }
        return dezenaHexaStr + unidadeHexaStr;
    }

    public String corRGBHexadecimal(){
        String r= "RGB em Hexa: #";
        r += this.conversorHexadecimal(getValorRed()) +
                this.conversorHexadecimal(getValorGreen())+
                this.conversorHexadecimal(getValorBlue());

        return r;
    }

    public void clarear(float percentual)
    {
        setValorRed(getValorRed() + (int)(getValorRed()*percentual));
        setValorGreen(getValorGreen() + (int)(getValorGreen()*percentual));
        setValorBlue(getValorBlue() + (int)(getValorBlue()*percentual));
    }

    public void escurecer(float percentual)
    {
        setValorRed(getValorRed() - (int)(getValorRed()*percentual));
        setValorGreen(getValorGreen() - (int)(getValorGreen()*percentual));
        setValorBlue(getValorBlue() - (int)(getValorBlue()*percentual));
    }

    public CorRGB corCinza()
    {
        int x = (int) this.getLuminosidade();


        CorRGB corCinza = new CorRGB(x, x, x);

        return corCinza;
    }



    
    public String toString(){
        String s = "";


        s +=    "valor de vermelho: "+ this.valorRed +"\n"+
                "valor de verde: "+ this.valorGreen +"\n"+
                "valor de azul: " + this.valorBlue +"\n"+
                "Luminosidade: " + this.valorLuminosidade +"\n"+
                "Escala de Cinza: "+ corCinza() +"\n"+
                "Cor em Hexa: " + corRGBHexadecimal()+"\n";;
        return s;
    }
}