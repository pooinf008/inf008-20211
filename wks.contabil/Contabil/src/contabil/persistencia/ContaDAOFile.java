package contabil.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import contabil.model.entity.Conta;
import contabil.model.exception.ContaInexistenteException;

public class ContaDAOFile implements ContaDAOIF{
	
  private static String CONTAS_FILE_NAME = "D:\\CONTAS.BIN"; 
	
  public List<Conta> contas;
  
  
  private void readFileContas() throws IOException, ClassNotFoundException{
	  FileInputStream in = new FileInputStream(ContaDAOFile.CONTAS_FILE_NAME);
	  ObjectInputStream ois = new ObjectInputStream(in);
	  this.contas = (List<Conta>) ois.readObject();
	  ois.close();
	  in.close();
  }
  
  private void writeFileContas() throws IOException {
	  FileOutputStream out = new FileOutputStream(ContaDAOFile.CONTAS_FILE_NAME);
	  ObjectOutputStream oos = new ObjectOutputStream(out);
	  oos.writeObject(this.contas);
	  oos.close();
	  out.close();
  }
  
  
  public ContaDAOFile() throws ClassNotFoundException, IOException {
    this.contas = new ArrayList<Conta>();
    try {
    	this.readFileContas();
    }catch(FileNotFoundException ex) {
    	
    }
  }
  
  public void salvar(Conta conta) throws IOException{
	  this.contas.add(conta);
	  this.writeFileContas();
  } 

  public Conta findByNome(String nome) throws Exception{
      for(Conta conta : this.contas)
          if(conta.getNome().equals(nome))
            return conta;
      throw new ContaInexistenteException(nome);      
  }    
  
  public Collection<Conta> findAll() {
	  return this.contas;
  }

  @Override
  public void atualizar(Conta c) throws Exception {
	  int index = this.contas.indexOf(c);
	  if(index == -1)
		   throw new ContaInexistenteException(c.getNome());
	  this.contas.remove(index);
	  this.contas.add(c);
	  this.writeFileContas();
  }
  

}
