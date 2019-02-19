package game;

public class Vector2D {
    public double x;
    public double y;

    public  Vector2D(){
        this.x = 0 ;
        this.y = 0;
    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Vector2D clone(){
        return null;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void minus (double x, double y){
        this.x -= x;
        this.y -= y;
    }


    // nhan gia tri rate vao vector duoc goi
    public void scale(double x, double y){
        this.x *= x;
        this.y *= y;
    }

    // tra ra do dai cua vector duoc goi
    public double getLength(){
        double length;
        length = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
        return length;
    }

    // giu nguyen huong cua vector duoc goi thay doi do dai =  do dai truyen vao
    public void setLength(double length){

    }

    // tra ra goc tao giua vector va truc hoanh
    public double getAngle(){
        return 0;
    }


    // giu nguyen do dai cua vector, quay vector den goc truyen vao
    public void setAngle(double angle){
        double len = this.getLength();
        this.x = Math.cos(angle)*len;
        this.y = Math.sin(angle)*len;
    }
}
