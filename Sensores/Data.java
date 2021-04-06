public class Data{

    public static boolean FORMATO;
    public static final Data CONF_UNIVERSAL= new Data(01,01,1900);
    public static final Data NATAL = new Data(25,12,1900);
    
    private int dia;
    private int mes;
    private int ano;
    private final java.util.Date timeStamp = new java.util.Date();
    
    static{
        FORMATO = true; 
    }    
    
    
    public Data(int dia, int mes, int ano){
        this.setDia(dia);
        this.setMes(mes);
        this.setAno(ano);
    }    
    
    private void setDia(int dia){
        this.dia = dia;
    }    
    
    
    private void setMes(int mes){
        this.mes = mes;
    }    
    
    private void setAno(int ano){
        this.ano = ano;
    }   
    
    private int getDia(){
        return this.dia;
    }    
    
    private int getMes(){
        return this.mes;
    }    
    
    private int getAno(){
        return this.ano;
    }   
    
    public String toString(){
        String rep;
        if(Data.FORMATO)
         rep = this.getDia() + "/" + this.getMes()  + "/" + this.getAno();
        else
         rep = this.getAno() + "," +  this.getMes() + "/" + this.getDia();
        return rep; 
    }   
    
    public static void fmtAmericano(){
        Data.FORMATO = false;
    }    
    
    public static void fmtBrasileiro(){
        Data.FORMATO = true;
    } 
    
    public java.util.Date getTimeStamp(){
        return this.timeStamp;
    }    
    
    
    
    
}
