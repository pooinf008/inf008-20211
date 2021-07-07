package contabil.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import contabil.model.AppRegistroContabil;
import contabil.model.ContabilLogicaIF;

public class ContabilUIConsole {
	
	private ContabilLogicaIF logica;
	private BufferedReader in;

	
	public ContabilUIConsole() throws Exception {
		this.logica = new AppRegistroContabil();
		this.in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run() throws Exception{
		char option;
		do {
			System.out.println("****************************************");
			System.out.println("*******Sistema Contabil********");
			System.out.println("[1] - Adicionar Conta");
			System.out.println("[2] - Registrar Fato");
			System.out.println("[0] - Fim");
			System.out.println("==>");
			option = in.readLine().charAt(0);
			switch(option) {
				case '1' : this.adicionarConta(); break;
				case '2' : this.registrarFatoContabil(); break;
			}
		}while(option != '0');
		
		
		
	}
	
	
	private void adicionarConta()  throws Exception {
		String cod;  
		String nome;
		int tipo;
		System.out.println("****************************************");
		System.out.println("*******Adicionar Conta********");
		System.out.print("Código da Conta: ");
		cod = this.in.readLine();
		System.out.print("Número da Conta: ");
		nome = this.in.readLine();
		System.out.print("Tipo da Conta ([1] Ativo - [2] Passivo - [3] Patr. Líquido): ");
		tipo = Integer.parseInt(this.in.readLine());
		try {
			this.logica.addConta(cod, nome, tipo);
			System.out.println("CONTA INSERIDA");
		} catch (Exception e) {
			System.out.println("ERRO NA INSERÇÃO DE CONTA: " + e.getMessage());
		}		
	}

	public void registrarFatoContabil() throws IOException {
		String data;  
		String descricao;
		String debito;
		String credito;
		double valor;
		System.out.println("****************************************");
		System.out.println("*******Registro de Fato Contabil********");
		System.out.print("Data do Fato (dd/mm/yyyy): ");
		data = this.in.readLine();
		System.out.print("Descrição do Fato: ");
		descricao = this.in.readLine();
		System.out.print("Conta debito: ");
		debito = this.in.readLine();
		System.out.print("Conta credito: ");
		credito = this.in.readLine();
		System.out.print("Valor: ");
		valor = Double.parseDouble(this.in.readLine());
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
