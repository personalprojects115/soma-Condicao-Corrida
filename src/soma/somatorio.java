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

    //início da região crítica
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < upper; i++) {
            ValorSoma.setValue(ValorSoma.getValue() + 1);
        }
        semaphore.release();
    }
    //fim da região crítica
}
