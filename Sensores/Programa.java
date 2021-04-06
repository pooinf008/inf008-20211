public class Programa{
    private AreaMonitorada area = new AreaMonitorada();
    private int qtdeSensor;
    
    public Programa(int qtdeSensor){
        this.qtdeSensor = qtdeSensor;
    }    
    
    public void popular(int qtdeNos){
        
        java.util.Random random = new java.util.Random();
        
        for(int iCont = 0; iCont < qtdeNos; iCont++){ 
            NoSensor no = new NoSensor("NO_" + iCont, 
                                        random.nextInt(50), 
                                        random.nextInt(50),
                                        random.nextInt(50));
            this.area.adicionarNo(no);
        }
        
        System.out.println(this.area);
    } 
    
    
    public void lerTemperatura(){
        this.area.lerTemperatura();
    } 
    
    public void exibirArea(){
        System.out.println(this.area);
        System.out.println("Amplitude Termica: " + this.area.getAmplitudeTermica() + "°C");
        System.out.println("Amplitude Termica (Mais Distantes): " + this.area.getAmplitudeEntreMaisDistantes() + "°C");
        System.out.println("Distancia (Mais Distantes): " + this.area.getDistanciaEntreMaisDistantes()+ "m");
    } 
    
    public void exibirArea(double maxAltura){
        System.out.println(this.area);
        System.out.println("Amplitude Termica: " + this.area.getAmplitudeTermica(maxAltura) + "°C");
        System.out.println("Amplitude Termica (Mais Distantes): " + this.area.getAmplitudeEntreMaisDistantes() + "°C");
        System.out.println("Distancia (Mais Distantes): " + this.area.getDistanciaEntreMaisDistantes()+ "m");
    }     
    
    public void rodar(){
        this.popular(this.qtdeSensor);
        this.lerTemperatura();
        this.exibirArea();
    }    
    
 
    public static void main(String[] args){
        Programa p = new Programa(Integer.parseInt(args[0]));
        p.rodar();
    }    
   
}
