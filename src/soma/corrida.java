package soma;

import java.util.concurrent.Semaphore;

class corrida {
    private static final int MAX_THREADS = 1;
    private static final Semaphore semaphore = new Semaphore(MAX_THREADS, true);

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 0) {

            if (Integer.parseInt(args[0]) < 0)
                System.err.println(args[0] + "precisa ser >= 0.");
            else {
                MutableInteger soma = new MutableInteger();

                int upper = Integer.parseInt(args[0]);

                Thread thrd1 = new Thread(new somatorio(upper, soma, semaphore));
                thrd1.start();

                Thread thrd2 = new Thread(new somatorio(upper, soma, semaphore));
                thrd2.start();

                try {
                    thrd1.join();
                    thrd2.join();
                    System.out.println("Soma Total: " + soma.getValue());
                } catch (InterruptedException ignored) {

                }
            }
        } else {
            System.err.println("Uso : Soma <Valor interior>");
        }
    }
}
   
