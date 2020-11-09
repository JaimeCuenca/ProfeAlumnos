import java.util.Random;

public class Alumno extends Thread{

    @Override
    public void run() {
        Random r = new Random();
        boolean tarde = r.nextBoolean();
        try {
                if (tarde) {
                    sleep(r.nextInt(20000) + 5000);
                    System.out.println(getName() + " ha llegado a clase");
                    System.out.println(getName() + " espera a ser desinfectado");
                    synchronized (Main.alumnos) {
                        Main.alumnos.wait();
                        Main.alumnos.add(this);
                        Main.alumnos.wait();
                    }
                } else {
                    sleep(r.nextInt(4000));
                    System.out.println(getName() + " ha llegado a clase");
                    System.out.println(getName() + " espera a ser desinfectado");
                    synchronized (Main.alumnos) {
                        Main.alumnos.add(this);
                        Main.alumnos.wait();
                    }
                }

            } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
