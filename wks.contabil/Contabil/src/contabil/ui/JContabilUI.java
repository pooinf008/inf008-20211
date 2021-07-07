package contabil.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import contabil.model.AppRegistroContabil;
import contabil.model.ContabilLogicaIF;

public class JContabilUI extends JFrame implements ActionListener{
	
	private ContabilLogicaIF logica;
	private Collection<String> nomeContas;
	
	private JButton btnRegistrar;
	private JTextField txtData;
	private JTextField txtDescricao;
	private JTextField txtCredito;
	private JTextField txtDebito;
	private JComboBox<String> cmbDebito;
	private JComboBox<String> cmbCredito;	
	private JTextField txtValor;
	
	public JContabilUI() throws Exception {
		this.logica = new AppRegistroContabil();
		this.nomeContas = this.logica.getNomeContas();
	}
	
	protected void montar() {
		JPanel jPanelCenter = new JPanel();
		JPanel jPanelSouth = new JPanel();
		this.btnRegistrar = new JButton("Registrar Fato Contábil..."); 
		this.btnRegistrar.addActionListener(this);
		
		//montando o panel na area sul onde vai ancorar o botão
		jPanelSouth.setLayout(new GridLayout(2, 3));
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(btnRegistrar);
		jPanelSouth.add(new JPanel());

		//montando a area central com os campos (Labels e Texts)
		jPanelCenter.setLayout(new GridLayout(5, 2));
		jPanelCenter.add(new JLabel("Data do Fato:"));
		this.txtData = new JTextField(); 
		jPanelCenter.add(this.txtData);
		jPanelCenter.add(new JLabel("Descricao:"));
		this.txtDescricao = new JTextField(); 
		jPanelCenter.add(this.txtDescricao);
		jPanelCenter.add(new JLabel("Conta Debito:"));
		this.cmbDebito = new JComboBox<String>();
		this.loadCombo(this.cmbDebito);
		jPanelCenter.add(this.cmbDebito);
		jPanelCenter.add(new JLabel("Conta Credito:"));
		this.cmbCredito = new JComboBox<String>();
		this.loadCombo(this.cmbCredito);
		jPanelCenter.add(this.cmbCredito);
		jPanelCenter.add(new JLabel("Valor:"));
		this.txtValor = new JTextField(); 
		jPanelCenter.add(this.txtValor);			
		
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		this.getContentPane().add(jPanelSouth, BorderLayout.SOUTH);
//		this.getContentPane().add(btnRegistrar, BorderLayout.SOUTH);
		
		this.setTitle("Adicionar Lancamento");
		this.setSize(800, 600);
	}
	
	public void run() {
		this.montar();
		this.setVisible(true);
	}
	
	private void loadCombo(JComboBox combo) {
		for(String nomeConta : this.nomeContas)
			combo.addItem(nomeConta);
	}
	
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			this.registrarFatoContabil();
			JOptionPane.showMessageDialog(this,
				    "Fato Registrado.");			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
				    "Erro: " + e.getMessage(),
				    "Erro no Registro de Fato",
				    JOptionPane.ERROR_MESSAGE);			
		}
		
	}
	
	public void registrarFatoContabil() throws Exception {
		String data;  
		String descricao;
		String debito;
		String credito;
		double valor;
		data = this.txtData.getText();
		descricao = this.txtDescricao.getText();
		debito = (String) this.cmbDebito.getSelectedItem();
		credito = (String) this.cmbCredito.getSelectedItem();
		valor = Double.parseDouble(this.txtValor.getText());
		this.logica.registarFatoContabil(data, descricao, debito, credito, valor);
	}	
	
	public static void main(String[] args) throws Exception {
		(new JContabilUI()).run();  
	}	
	
}
