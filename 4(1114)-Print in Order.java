import java.util.concurrent.CountDownLatch;

class Foo {

    private CountDownLatch firstDone;
    private CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) {

        // printFirst.run() outputs "first".
        printFirst.run();

        // Signal that first() has finished.
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // Wait until first() is completed.
        firstDone.await();

        // printSecond.run() outputs "second".
        printSecond.run();

        // Signal that second() has finished.
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // Wait until second() is completed.
        secondDone.await();

        // printThird.run() outputs "third".
        printThird.run();
    }
}
