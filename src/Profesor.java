import java.util.ArrayList;

public class Profesor extends Thread{

    @Override
    public void run() {
        try {
            sleep(5000);
            System.out.println("\n===========PRIMERA TANDA==========");
            desinfectar(Main.alumnos);
            Main.alumnos.clear();
            sleep(30000);
            synchronized (Main.alumnos) {
                Main.alumnos.notifyAll();
            }
            sleep(1000); //Parto el tiempo de espera para cercionarme de que le da tiempo a notificar a todos los hilos y se añadan al array sin que entre en la funcion desinfectar sin tener todos los hilos añadidos.
            System.out.println("\n===========SEGUNDA TANDA==========");
            desinfectar(Main.alumnos);
            synchronized (Main.alumnos) {
                Main.alumnos.notifyAll();
            }
            Main.alumnos.clear();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void desinfectar(ArrayList<Alumno> al){
        try {
            while(true) {
                System.out.println("El profesor empieza a desinfectar al " + al.get(0).getName());
                sleep(1000);
                System.out.println("El "+ al.get(0).getName() + " está desinfectado");
                al.remove(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
    }
}

