package tugas1;

public class Konversi {
    private float celcius;
    private double reamur, farenheit, kelvin;
    
    public Konversi(float celcius) {
        this.celcius = celcius;
    }
    
    void ubahFarenheit(){
        farenheit = ((9*celcius)/5)+32;
    }
    
    void ubahReamur(){
        reamur = (4*celcius)/5;
    }
    
    void ubahKelvin(){
        kelvin = celcius+273.15;
    }
    
    String kondisiAir(){
        String kondisi = "Normal";
    
        if(celcius<0){
            kondisi = "Beku";
        } else if(celcius>=100){
            kondisi = "Mendidih";
        }
        return kondisi;
    }
    
    void hasilKonversi(){
        ubahFarenheit();
        ubahReamur();
        ubahKelvin();
        System.out.println("\n");
        System.out.println("Suhu dalam Celcius\t: " + this.celcius + "°C");
        System.out.println("Suhu dalam Farenheit\t: " + farenheit + "°F");
        System.out.println("Suhu dalam Reamur\t: " + reamur + "°R");
        System.out.println("Suhu dalam Kelvin\t: " + kelvin + "°K");
        System.out.println("\n");
        System.out.println("Kondisi Air " + kondisiAir());
    }
}