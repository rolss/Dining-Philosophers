package filosofoscomensales;

public class Silla {
    private int sLibre = 4;
    static GUI frame = new GUI();
    
    public Silla(GUI gui) {
        this.frame = gui;
    }
    
    public synchronized void qSilla(int i) throws InterruptedException {
        while(sLibre==0) { // Esperar si no hay sillas libres
            frame.esperandoSilla(i);
            wait();
        }
        frame.logSilla("Filosofo "+i+" se sienta en la mesa");
        System.out.println("Filosofo "+i+" se sienta en la mesa");
        sLibre--;
    }
    
    public synchronized void sSilla(int i) throws InterruptedException {
        sLibre++;
        frame.logSilla("Filosofo "+i+" abandona la mesa");
        System.out.println("Filosofo "+i+" abandona la mesa");
        notify(); // notifica que se desocupó una silla
    }
}
