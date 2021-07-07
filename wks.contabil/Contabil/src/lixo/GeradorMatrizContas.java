package lixo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import contabil.model.entity.Ativo;
import contabil.model.entity.Conta;
import contabil.model.entity.Passivo;
import contabil.model.entity.PatrLiquido;

public class GeradorMatrizContas {
	

	private void montar() throws IOException {
		Random random = new Random();
		MatrizConta matrizConta = new MatrizConta();
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(new Ativo("C", "AtivoC", 10));
		contas.add(new Ativo("E", "AtivoE", 20));
		contas.add(new Passivo("B", "PassivoB", 3));
		contas.add(new PatrLiquido("A", "PatrLiqA", 50));
		contas.add(new PatrLiquido("G", "PatrLiqG", 1));		
		
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++) 
				matrizConta.setConta(i, j,
						contas.get(random.nextInt(contas.size())));
		this.writeFileContas(matrizConta);
		System.out.println(matrizConta);
	}
	
	  private void writeFileContas(MatrizConta mc) throws IOException {
		  FileOutputStream out = new FileOutputStream("D:\\MATRIZ01.CONTAS");
		  ObjectOutputStream oos = new ObjectOutputStream(out);
		  oos.writeObject(mc);
		  oos.close();
		  out.close();
	  }
	  

		
		  private void readFileContas() throws IOException, ClassNotFoundException{
			  MatrizConta matrizConta;
			  FileInputStream in = new FileInputStream("D:\\MATRIZ01.CONTAS");
			  ObjectInputStream ois = new ObjectInputStream(in);
			  matrizConta = (MatrizConta) ois.readObject();
			  ois.close();
			  in.close();
			  System.out.println(matrizConta);
		  }		
	
	
	  public static void main(String[] args) throws IOException, ClassNotFoundException {
		  (new GeradorMatrizContas()).readFileContas();
	  }


	
	

}
