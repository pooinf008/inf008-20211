package inf008.model;

public class ImagemRGB {
	
	private CorRGB[][] cores;
	
	
	public ImagemRGB(int altura, int largura) {
		this.cores = new CorRGB[altura][largura];
		for(int iCont = 0; iCont < this.cores.length; iCont++)
			for(int jCont = 0; jCont < this.cores[iCont].length; jCont++)
				this.cores[iCont][jCont] = CorRGB.BRANCA;
	}
	
	public void setPixel(int altura, int largura, CorRGB pixel) {
		this.cores[altura][largura] = pixel;
	}
	
	public CorRGB getPixel(int altura, int largura){
		return this.cores[altura][largura];
	}
	
	public int getLargura() {
		return this.cores[0].length; 
	}
	
	public int getAltura() {
		return this.cores.length; 
	}
	
	public void setPixel(int altura, int largura, int red, int green, int blue) {
		this.setPixel(altura, largura, new CorRGB(red, green, blue));
	}	
	
	public boolean equals(ImagemRGB imagem) {
		
		if(this.getAltura() != imagem.getAltura() ||
		   this.getLargura() != imagem.getLargura())
		     return false;
		
		for(int iCont = 0; iCont < this.cores.length; iCont++)
			for(int jCont = 0; jCont < this.cores[iCont].length; jCont++)
				if(!this.cores[iCont][jCont].equals(imagem.cores[iCont][jCont]))
					return false;
		return true;
							
	}
	
	public ImagemRGB getGrayScale() {
		ImagemRGB grayScale = new ImagemRGB(this.getAltura(), this.getLargura());
		for(int iCont = 0; iCont < this.cores.length; iCont++)
			for(int jCont = 0; jCont < this.cores[iCont].length; jCont++)
				grayScale.setPixel(iCont, jCont, this.getPixel(iCont, jCont).getGrayScale());
		return grayScale;
	}
	
	
	public ImagemRGB clone() {
		return this.recortar(0, 0, this.getAltura(), this.getLargura());
	}
	
	
	public boolean isFragmento(ImagemRGB imagem) {
		ImagemRGB copia = imagem.clone();
		for(int iCont = 0; iCont < 4; iCont++) {
			if(this.fragmento(copia))
				return true;
			copia = copia.girar90();		
		}	
		return false;
	}
	
	private boolean fragmento(ImagemRGB imagem) {
		for(int iCont = 0; iCont <= this.getAltura() - imagem.getAltura(); iCont++)		
			for(int jCont = 0; jCont <= this.getLargura() - imagem.getLargura(); jCont++)
				if (this.recortar(iCont, jCont, imagem.getAltura(), imagem.getLargura()).equals(imagem))
					return true;
		return false;
	}
	
	
	public String toString() {
		String rep = "";
		for(int iCont = 0; iCont < this.getAltura(); iCont++) {
			for(int jCont = 0; jCont < this.getLargura(); jCont++)
				rep = rep + "." + this.getPixel(iCont, jCont).toHex();
			rep += "\n";
		}	
		return rep.substring(0, rep.length() - 1);
	}
	
	public ImagemRGB recortar(int x, int y, int hTam, int lTam) {
		int altura = ((this.getAltura() - x) < hTam) ? (this.getAltura() - x) : hTam;
		int largura = ((this.getLargura() - y) < lTam) ? (this.getLargura() - y) : lTam;
		
		ImagemRGB nova = new ImagemRGB(altura, largura);
		for(int iCont = x, iNova = 0; iCont < altura + x; iCont++, iNova++)
			for(int jCont = y, jNova = 0; jCont < largura + y; jCont++, jNova++)
				nova.setPixel(iNova, jNova, this.getPixel(iCont, jCont));
		return nova;
	}
	
	public ImagemRGB girar90() {
		ImagemRGB nova = new ImagemRGB(this.getLargura(), this.getAltura());
		
		for(int jCont = 0; jCont < this.getLargura(); jCont++)
			for(int iCont = this.getAltura() - 1, iNova = 0; iCont >= 0; iCont--, iNova++)
				nova.setPixel(jCont, iNova, this.getPixel(iCont, jCont));
		return nova;			
	}	
	
}