package Lesson7.Seminar7;

public class Point3D {

    private double x,y,z;


    public Point3D(double x) {
        this.x = x;
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Возвращает длину вектора точки (из начала координат)
     * @return длина типом double
     */
    public double lengthVector(){
        return Math.sqrt(x*x+y*y+z*z);
    }

    /**
     * Возвращает скалярное произведение от текущей точки до указанной
     * @param b - экземпляр Point3D()
     */
    public double scalarMultiply(Point3D b){
        return this.x*b.x+this.y*b.y+this.z*b.z;
    }

    /**
     * возвращает результирующий вектор двух исходных(перемножение векторов)
     * @param pointIn
     * @return
     */
    public Point3D multiVector (Point3D pointIn){
        return new Point3D(y*pointIn.z - z*pointIn.y,
                z*pointIn.x-x*pointIn.z,x* pointIn.y - y* pointIn.x);
    }

    public double getCosToVector(Point3D b){
        return this.scalarMultiply(b)/(this.lengthVector() *  b.lengthVector());
    }

    public Point3D sumVector (Point3D B){
        return new Point3D(x+B.x,y+B.y,z+B.z);
    }

    public Point3D substractVector (Point3D B){
        return new Point3D(x-B.x,y-B.y,z-B.z);
    }


}
