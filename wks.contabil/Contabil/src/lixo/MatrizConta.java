
package lixo;

import contabil.model.entity.Conta;

public class MatrizConta implements java.io.Serializable{
	
	private Conta[][] contas = new Conta[2][2];
	
	public void setConta(int i, int j, Conta conta) {
		this.contas[i][j] = conta;
	}
	
	public String toString() {
		String rep = "";
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++)
				rep+= this.contas[i][j].getCodigo() + " ";
			rep+= "\n";
		}	
		return rep;

	}

}
