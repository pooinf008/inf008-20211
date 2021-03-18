public class NoSensor{
    private String id;
    private double latitude;
    private double longitude;
    private double altura;
    private double temperatura;
    
    public NoSensor(String id, double latitude,
                    double longitude, double altura){
        this.setId(id);
        this.mover(latitude, longitude, altura);        
    }
    
    public NoSensor(String id){
        this(id, 0, 0, 0);
    } 
    
    public NoSensor(NoSensor no){
        this(no.getId(), no.getLatitude(), no.getLongitude(), 
             no.getAltura());
    }     
    
    public String getId(){
        return this.id;
    } 
    
    private void setId(String id){
        this.id = id;
    }     
    
    public double getLatitude(){
        return this.latitude;
    } 
    
    public void mover(double latitude, 
                     double longitude, double altura){
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setAltura(altura);                        
    } 
    
    public void mover(){
        this.mover(0, 0, 0);
    } 
    
    public void mover(NoSensor no){
        this.mover(no.getLatitude(), no.getLongitude(), 
                   no.getAltura());
    }    
    
    private void setLatitude(double latitude){
        this.latitude = latitude;
    }     
    
    public double getLongitude(){
        return this.longitude;
    } 
    
    private void setLongitude(double longitude){
        this.longitude = longitude;
    }     
    
    public double getAltura(){
        return this.altura;
    } 
    
    private void setAltura(double altura){
        this.altura = altura;
    }     
    
    public double getTemperatura(){
        return this.temperatura;
    } 
    
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }  
    
    public double getDistancia(){
        return Math.sqrt(Math.pow(this.getLatitude() - 0, 2) +
                         Math.pow(this.getLongitude() - 0, 2) +
                         Math.pow(this.getAltura() - 0, 2));
        
    }    
    
    public double getDistancia(NoSensor no){
        return Math.sqrt(Math.pow(no.getLatitude() - this.getLatitude(), 2) +
                         Math.pow(no.getLongitude() - this.getLongitude(), 2) +
                         Math.pow(no.getAltura() - this.getAltura(), 2));
    } 
    
    public boolean equals(NoSensor no){
        return no.getId().equals(this.getId());
    }    
    
    
    public String toString(){
        return "[" + this.getId() + "]" + " (lat:" + this.getLatitude() +
                                   ", long: " + this.getLongitude() + 
                                   ", h: " + this.getAltura() + ")";
    }
        
}
