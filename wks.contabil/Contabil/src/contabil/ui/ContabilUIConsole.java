package contabil.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import contabil.model.AppRegistroContabil;
import contabil.model.ContabilLogicaIF;

public class ContabilUIConsole {
	
	private ContabilLogicaIF logica;
	
	public ContabilUIConsole() throws Exception {
		this.logica = new AppRegistroContabil();
	}
	
	public void run() throws IOException {
		String data;  
		String descricao;
		String debito;
		String credito;
		double valor;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("****************************************");
		System.out.println("*******Registro de Fato Contabil********");
		System.out.print("Data do Fato (dd/mm/yyyy): ");
		data = in.readLine();
		System.out.print("Descrição do Fato: ");
		descricao = in.readLine();
		System.out.print("Conta debito: ");
		debito = in.readLine();
		System.out.print("Conta credito: ");
		credito = in.readLine();
		System.out.print("Valor: ");
		valor = Double.parseDouble(in.readLine());
		try {
			logica.registarFatoContabil(data, descricao, debito, credito, valor);
			System.out.println("FATO REGISTRADO");
		} catch (Exception e) {
			System.out.println("ERRO NO REGISTRO FATO: " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		(new ContabilUIConsole()).run();
	}

}
