import java.util.Arrays;

public class Imagem {

    private CorRGB [][] pixels;


        Imagem(int x, int y)
        {
            pixels = new CorRGB[x][y];

                for(int k=0; k<x; k++)
                {
                    for(int w=0; w<y; w++)
                    {
                        pixels[k][w]= CorRGB.branca;
                    }
                }
        }

    
    public int getLargura()
    {
        return this.pixels[0].length;
    }
    
    public int getAltura()
    {
        return this.pixels.length;
    }
    
    public CorRGB getPixel(int x, int y)
    {
        return this.pixels[x][y];
    }

    public String getPixels()
    {
        String s = "";

        for(int k=0; k<this.pixels.length; k++)
        {
            for(int w=0; w<this.pixels[k].length; w++)
            {

                s += this.pixels[k][w];

            }
        }
            return s;
    }
    
     public void setModificaPixel(int x, int y, CorRGB k)
    {

        this.pixels[x][y] = k;
    }
    
    public void setModificaPixels(int x, int y, int a, int b, int c)
    {
    
           this.pixels[x][y].setValorRed(a);
           this.pixels[x][y].setValorGreen(b);
           this.pixels[x][y].setValorBlue(c);
    
    }
    
    public Imagem imagemCinza() {

        int cinza = 0;

        Imagem imagem = new Imagem(this.pixels.length,this.pixels[0].length);


        for (int x = 0; x < this.pixels.length; x++)
        {
            for (int y = 0; y < this.pixels[x].length; y++)
            {
                cinza = (int) this.pixels[x][y].getLuminosidade();
               imagem.setModificaPixels(x,y,cinza,cinza,cinza);
            }

        }
                return imagem;
    }
    
     public boolean verificarIgualdadeImagem(Imagem x)
    {
          if(Arrays.deepEquals(this.pixels, x.pixels))
          {
              return true;
          }
          else
          {
              return false;
          }
    }
    
    private void rotacionar()
    {
        CorRGB[][] pixelsAuxiliar = new CorRGB[this.pixels[0].length][this.pixels.length];
   
        int cont1Largura, cont1Altura, cont2Largura, cont2Altura;
        for(cont1Altura = 0, cont2Largura = this.getAltura() - 1;cont1Altura < this.getAltura();cont1Altura++,cont2Largura--)
        {
            for(cont1Largura = 0, cont2Altura = 0;cont1Largura < this.getLargura();cont1Largura++,cont2Altura++)
            {
                pixelsAuxiliar[cont2Altura][cont2Largura] = pixels[cont1Altura][cont1Largura]; 
            }
        }
        this.pixels = pixelsAuxiliar;
    }
    
    private boolean compararFragmentoImagem(Imagem fragmento,int inicioAltura,int inicioLargura)
    {
        for(int cont1 = inicioAltura,cont1frag = 0;cont1frag < fragmento.getAltura();cont1++,cont1frag++)
            {
                for(int cont2 = inicioLargura,cont2frag = 0;cont2frag < fragmento.getLargura();cont2++,cont2frag++)
                {
                    if(!this.pixels[cont1][cont2].equals(fragmento.getPixel(cont1frag,cont2frag)))
                    {
                        return false;
                    }
                }
            }
            return true;
    }
    
    public boolean isFragmento(Imagem outraImagem)
    {
        if(outraImagem.getAltura()==1&&outraImagem.getLargura()==1)
        {System.out.println("este tamanho nao configura uma imagem");
            return false;}
        
        if(outraImagem.getAltura() <= this.getAltura() && outraImagem.getLargura() <= this.getLargura())
        {
            for(int cont = 0;cont < 4; cont++)
            {
                for(int correAltura = 0;correAltura + outraImagem.getAltura()<= this.getAltura();correAltura++)
                {
                    for(int correLargura = 0;correLargura + outraImagem.getLargura()<= this.getLargura();correLargura++)
                    {
                        if(compararFragmentoImagem(outraImagem,correAltura,correLargura))
                        {
                            return true;
                        }
                    }
                }
                outraImagem.rotacionar();
            }
        }
        return false;
    }
    
      public String toString() {
        String s = "";

        for(int k=0; k<pixels.length; k++)
        {
            for(int w=0; w<pixels[k].length; w++)
            {
                if(w==0)
                { s += "\n"+ pixels[k][w];}
                else
                { s += pixels[k][w];}
            }
        }

        return s;
    }
    
}