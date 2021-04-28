//i. uma classe que represente uma cor RGB
public class CoresRGB
{
    //Atributos de classe
    //xvi. Atributos de classe que permitam reduzir o número de instâncias em uso de cores comuns
    //i. PRETA #000000
    public static final CoresRGB PRETA = new CoresRGB(0,0,0);
    //ii. BRANCA #FFFFFF
    public static final CoresRGB BRANCA = new CoresRGB(255,255,255);
    //iii. RED #FF0000
    public static final CoresRGB RED = new CoresRGB(255,0,0);
    //iv. GREEN #00FF00
    public static final CoresRGB GREEN = new CoresRGB(0,255,0);
    //v. BLUE #0000FF
    public static final CoresRGB BLUE = new CoresRGB(0,0,255);
    
    //Atributos
    //ii. a representação estática da classe criada
    private int red;
    private int green;
    private int blue;
    
    //Construtores
    //v. construtores sobrecarregados que permitam a criação de uma cor
    //vi. um construtor de cópia, que crie uma cor idêntica (mesmo valor de R, G e B)
    public CoresRGB(CoresRGB cores){
        this.red = cores.red;
        this.green = cores.green;
        this.blue = cores.blue;        
    }
    //vii. um construtor sem parâmetros, que crie a cor preta (<R=0, G=0, B=0>)
    public CoresRGB(){                     
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }
    //viii. um construtor que receba três valores como parâmetros e crie uma considerando estes valores como os valores de R, G e B, respectivamente
    public CoresRGB(int red, int green, int blue){
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);        
    }    
    //iv. um método que leia a luminosidade da cor
    public int getLuminosidade(){
        return (int) Math.round(this.getRed() * 0.3 + this.getGreen() * 0.59 + this.getBlue() * 0.11);
    }
    //iii. os métodos que lêem e alteram os valores das componentes RGB da cor
    //Altera o componente red 
    private void setRed(int red){
        if( red >= 0 && red <= 255 ){
            this.red = red;
        }else if(red < 0){
            this.red = 0;
        }else if(red > 255){
            this.red = 255;
        }
    }
    public int getRed(){
        return this.red;
    }
    //Altera o componente green 
    private void setGreen(int green){
        if( green >= 0 && green <= 255 ){
            this.green = green;
        }else if(green < 0){
            this.green = 0;
        }else if(green > 255){
            this.green = 255;
        }        
    }
    public int getGreen(){
        return this.green;
    }
    //Altera o componente blue
    private void setBlue(int blue){
        if(blue >= 0 && blue <= 255 ){
            this.blue = blue;
        }else if(blue < 0){
            this.blue = 0;
        }else if(blue > 255){
            this.blue = 255;
        }        
    }
    public int getBlue(){
        return this.blue;
    }
    //ix. um método que verifique se duas cores são iguais. As cores são consideradas iguais se seus valores de R, G e B são idênticos entre si (o R de uma cor igual o R da outra e assim por diante)
    public boolean equals(CoresRGB cores){
        /*if(cores.getRed() == this.getRed() && cores.getGreen() == this.getGreen() && cores.getBlue() == this.getBlue()){
            return true;
        }else{
            return false;
        }*/
        return (cores.getRed() == this.getRed() && cores.getGreen() == this.getGreen() && cores.getBlue() == this.getBlue());
    }
    //x. altere as propriedades Red, Green e Blue e Luminosidade para serem exclusivamente leitura
    //Para atender a este item, todos os métodos "set" foram transformados de "public" para "private".
    
    //xi. um método que gere e retorne uma nova cor RGB equivalente ao cinza da cor RGB em questão. Essa cor possui os valores de R, G e B iguais entre si e iguais ao valor da luminosidade da cor original. Por exemplo, para a cor #2596BE, a cor gerada deverá ser #797979.
    public CoresRGB novaInstanciaCinza(CoresRGB cores){
        int red = cores.getLuminosidade();
        int green = cores.getLuminosidade();
        int blue = cores.getLuminosidade();          
        CoresRGB coresCinza = new CoresRGB(red, green, blue);
        return coresCinza;
    }
    //xii. um método que gere uma representação String da cor como hexadecimal. A representação é composta pelo caracter # seguida de dois dígitos representando o valor de R, G e B em hexadecimal. Por exemplo, para a cor RGB, onde R=37, G=150, B=190, o método deve retornar: #2596BE
    public String hexadecimal(){
        String red = Integer.toHexString(this.getRed());
        red = red.toUpperCase();
        String green = Integer.toHexString(this.getGreen());
        green = green.toUpperCase();
        String blue = Integer.toHexString(this.getBlue());
        blue = blue.toUpperCase();
        if(red.equals("0")){
            red = "00";
        }
        if(green.equals("0")){
            green = "00";
        }
        if(blue.equals("0")){
            blue = "00";
        }
        return ("#" + red + green + blue);
    }
    //xiii. um método clarear que receba um valor e modifique a tonalidade da cor em questão a tornando mais clara. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual maior, onde p deve ser indicado como parâmetro. Por exemplo, para a cor #2596BE, se o parâmetro de clarear for 0.1 (10%), a cor deve se tornar #3BA1C5. 
    public void clarearTonalidade(double p){
        this.red = (int) (this.getRed() + (this.getRed() * p));
        this.green = (int) (this.getGreen() + (this.getGreen() * p));
        this.blue = (int) (this.getBlue() + (this.getBlue() * p));       
    }
    //xiv. um método escurecer que receba um valor e modifique a tonalidade da cor em questão a tornando mais escura. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual maior, onde p deve ser indicado como parâmetro. Por exemplo, para a cor #2596BE, se o parâmetro de escurecer for 0.1 (10%), a cor deve se tornar #2187AB.
    public void escurecerTonalidade(double p){
        this.red = (int) (this.getRed() - (this.getRed() * p));
        this.green = (int) (this.getGreen() - (this.getGreen() * p));
        this.blue = (int) (this.getBlue() - (this.getBlue() * p));       
    }
    //xv. Um método que retorne uma nova instância de CorRGB, igual a cor que recebeu a mensagem
    public CoresRGB novaInstancia(CoresRGB cores){
        CoresRGB coresNovo = new CoresRGB(cores);
        return coresNovo;
    }
    //Imprimir
    public void imprimir(){
        System.out.println("Red: " + this.getRed());
        System.out.println("Green: " + this.getGreen());
        System.out.println("Blue: " + this.getBlue());
        System.out.println("Luminosidade: " + this.getLuminosidade());
        System.out.println("Hexadecimal: " + this.hexadecimal());
    }
}
