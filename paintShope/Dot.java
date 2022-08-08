class Dot {
    private double x;
    private double y;

    Dot(double x, double y){
        setX(x);
        setY(y);
    }

    void setX(double x){
        this.x = x;
    }

    void setY(double y){
        this.y = y;
    }

    double getX(){
        return this.x;
    }

    double getY(){
        return this.y;
    }
}