package filosofoscomensales;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo extends Thread{
    private int id;
    private int counter=0;
    private Silla s;
    static GUI frame = new GUI();
    public Tenedor izq, der; // Cada filosofo tiene dos tenedores posibles
    
    // Constructor
    public Filosofo(int id, Tenedor izq, Tenedor der, Silla s, GUI gui) {
        this.id = id;
        this.izq = izq;
        this.der = der;
        this.s = s;
        this.frame = gui;
    }
    
    int time = frame.getSpeed();
    // Comer y pensar (loop infinito)
    @Override
    public void run() {
        int veces = ThreadLocalRandom.current().nextInt(1, 10);
        frame.maxVeces(id, veces);
        while(counter<veces){ // Todos comen 2 veces, hacer esto random con libreria
            try {
                s.qSilla(id); // Se sienta en la mesa (toma una silla)
//                frame.logSilla("Filosofo "+id+" se sienta en la mesa");
                frame.spawn(id);
                Thread.sleep(time);
                izq.qTenedor(id); // Coger tenedor de la izq
                Thread.sleep(time);
                der.qTenedor(id); // Coger tenedor de la der
                Thread.sleep(time);
                der.sTenedor(id); // Come y suelta derecha
                Thread.sleep(time);
                izq.sTenedor(id); // Come y suelta izquierda
                Thread.sleep(time);
                counter++;
                frame.updateCounters(id, counter);
                s.sSilla(id); // Se para de la mesa (deja una silla)
                frame.despawn(id);
//                frame.logSilla("Filosofo "+id+" abandona la mesa");
//                Thread.sleep(a);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        frame.updateSaciado(id);
    }
}
