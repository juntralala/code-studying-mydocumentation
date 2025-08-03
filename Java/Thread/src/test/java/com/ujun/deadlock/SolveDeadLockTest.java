package com.ujun.deadlock;

import org.junit.jupiter.api.Test;

/**
 * Cara Menangani Deadlock
 * Sayangnya tidak ada cara menyelesaikan masalah deadlock secara otomatis di Java
 * Masalah deadlock harus diselesaikan sendiri oleh programmer yang membuat kode program nya
 */

// salah satu penyelsaian deadlock adalah jangan membuat nested synchronized

public class SolveDeadLockTest {
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

        public static void transfer(DeadLockTest.Balance from, DeadLockTest.Balance to, Long amountTransfer) throws InterruptedException {
            synchronized (from) {
                Thread.sleep(1000);
                from.setBalance(from.getBalance() - amountTransfer);
            }

            synchronized (to) {
                Thread.sleep(1000);
                to.setBalance(to.getBalance() + amountTransfer);
            }
        }
    }

    @Test
    public void deadlock() throws InterruptedException {
        var balace1 = new DeadLockTest.Balance(2_000L);
        var balace2 = new DeadLockTest.Balance(2_000L);

        var thread1 = new Thread(() -> {
            try {
                Balance.transfer(balace1, balace2, 500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balace2, balace1, 500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balace1.getBalance());
        System.out.println(balace2.getBalance());
    }
}
