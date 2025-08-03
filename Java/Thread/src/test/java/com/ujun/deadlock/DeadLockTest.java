package com.ujun.deadlock;

import org.junit.jupiter.api.Test;

/**
 * Dead Lock
 * Race condition sangat mudah diselesaikan dengan synchronization dan lock, namun masalah lain bisa mengintai jika kita
 * salah melakukan synchronization, yaitu Deadlock
 * Deadlock merupakan kondisi dimana beberapa thread saling menunggu satu sama lain karena biasanya terjadi ketika thread
 * tersebut melakukan lock dan menunggu lock lain dari thread lain dan ternyata thread tersebut juga menunggu lock lain
 * Karena saling menunggu, akhirnya terjadi deadlock, keadaan dimana semua thread tidak berjalan karena hanya menunggu lock
 */
public class DeadLockTest {
    public static class Balance {

        private Long balance = 0L;

        public Balance(Long balance) {
            this.balance = balance;
        }

        public Long getBalance() {
            return balance;
        }

        public void setBalance(Long balance) {
            this.balance = balance;
        }

        public static void transfer(Balance from, Balance to, Long amountTransfer) throws InterruptedException {
            synchronized (from) {
                Thread.sleep(1000);
                synchronized (to) {
                    Thread.sleep(1000);
                    from.setBalance(from.getBalance() - amountTransfer);
                    to.setBalance(to.getBalance() + amountTransfer);
                }
            }
        }
    }

    @Test
    public void deadlock() throws InterruptedException {
        var balace1 = new Balance(2_000L);
        var balace2 = new Balance(2_000L);

        var thread1 = new Thread(() -> {
            try {
                Balance.transfer(balace1, balace2, 500L);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balace2, balace1, 500L);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balace1.getBalance());
    }

}
