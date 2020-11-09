import java.util.ArrayList;

public class Main {
    public static final int NumAl=10;
    public static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    public static void main(String[] args) {
        for(int i=1; i<=NumAl; i++){
            Alumno al = new Alumno();
            al.setName("Alumno"+i);
            al.start();
        }
        Profesor profe = new Profesor();
        profe.start();
    }
}
