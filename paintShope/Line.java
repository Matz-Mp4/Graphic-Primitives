public class Line {
    
    private Dot a;
    private Dot b;
    private double distancia;
    private double m;
    private double c;

    Line(Dot A, Dot B){
        this.a = A;
        this.b = B;
        init();
    }

    public void init(){
        calculateDistance();
        calculateM();
        calculateB();
    }

    private void calculateDistance(){
        this.distancia = Math.sqrt(Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
    }

    private void calculateM(){
        double aux = a.getY() - b.getY();
        if(aux == 0) aux = 1;
        this.m = (a.getX() - b.getX()/aux);
    }
    
    private void calculateB(){
        double aux = m;
        if(m == 0) aux = 1;
        this.c = (a.getY()/aux) - a.getX();
    }

    public double calculateY(double x){
        return (m*x + c);
    }

    public void setDotA(Dot A){
        this.a = A;
    }

    public void setDotB(Dot B){
        this.b = B;
    }

    public Dot getDotA(){
        return this.a;
    }

    public Dot getDotB(){
        return this.b;
    }
}
