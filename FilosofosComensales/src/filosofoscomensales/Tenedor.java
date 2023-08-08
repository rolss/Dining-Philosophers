package filosofoscomensales;

import static filosofoscomensales.Filosofo.frame;

public class Tenedor {
    public int id; // del 1 al 5
    private boolean libre=true; // Está libre o no?
    static GUI frame = new GUI();
    // Constructor
    public Tenedor(int id, GUI gui) {
        this.id = id;
        this.frame = gui;
    }
    
    // Sincronizado significa que solo puede acceder un hilo a la vez
    public synchronized void qTenedor(int i) throws InterruptedException {
        // Mientras que el tenedor no esté libre, tiene que esperar
        while(!libre) {
            wait(); // sale cuando le llegue el notify. Al probar el while, se sale del while y toma el tenedor
        }
        frame.updateFilosofoQ(i, id);
        System.out.println("Filosofo "+i+" toma el tenedor "+id);
        libre=false; // El filosofo toma el tenedor
    }
    
    public synchronized void sTenedor(int i) throws InterruptedException {
        libre=true; // Suelta el tenedor
        frame.updateFilosofoS(i, id);
        System.out.println("Filosofo "+i+" suelta el tenedor "+id);
        notify(); // Notifica al que esta en el wait para salir del wait
    } 
}
