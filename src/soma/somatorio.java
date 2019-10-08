/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soma;

import java.util.concurrent.Semaphore;

class somatorio implements Runnable {
    private int upper;
    private MutableInteger ValorSoma;
    private Semaphore semaphore;

    public somatorio(int upper, MutableInteger ValorSoma, Semaphore semaphore) {
        this.upper = upper;
        this.ValorSoma = ValorSoma;
        this.semaphore = semaphore;
    }


    public void run() {

        for (int i = 0; i < upper; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //início da região crítica
            ValorSoma.setValue(ValorSoma.getValue() + 1);
            //fim da região crítica
            semaphore.release();
        }
    }
}
