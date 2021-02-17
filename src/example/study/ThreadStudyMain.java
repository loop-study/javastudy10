package example.study;

public class ThreadStudyMain {

    public static void main(String[] args) throws InterruptedException {
        // 쓰레드 구현 방법
        // 1. Runnable 인터페이스 사용
//        TestRunnable r = new TestRunnable();
//        Thread runnableSample = new Thread(r);
//
//        // 2. Thread 클래스 사용
        TestThread threadSample = new TestThread();
//
//        runnableSample.start();
//        threadSample.start();
//
//        System.out.println("");
//        // 상태 가져오기
//        System.out.println("runnableSample.getState() = " + runnableSample.getState());
//        System.out.println("threadSample.getState() = " + threadSample.getState());

        // 실행이 종료된 쓰레드 다시 호출하면?
        //threadSample.start(); // 에러가 발생함
/**
        쓰레드 상태
        NEW : 쓰레드 객체가 생성되고 start() 호출이 안된 상태
        RUNNABLE : 실행 대기중이며 언제든지 실행 상태로 변할 수 있다
        WAITING : 일시정지 상태로 다른 쓰레드의 중지를 대기하는 상태
        TIMED_WAITING : 일정시간 동안 일시정지 대기하는 상태
        BLOCKED : 공유중이 객체를 다른 쓰레드가 사용중일 때 락이 걸려서 풀리기 기다리는 상태
        TERMINATED : 실행을 마친 상태
 **/
        // 쓰레드 상태 제어 메서드
//        threadSample.getState();
//        threadSample.interrupt();
//        threadSample.notify();
//        threadSample.notifyAll();
//        threadSample.resume();
//        threadSample.sleep(1000);
//        threadSample.sleep(1000, 1000000);
//        threadSample.join();
//        threadSample.join(1000);
//        threadSample.join(1000, 1000000);
//        threadSample.wait();
//        threadSample.wait(1000);
//        threadSample.wait(1000, 1000000);
//        threadSample.suspend();
//        threadSample.yield();
//        threadSample.stop();


        // 쓰레드 우선 순위 테스트
//        for (int i = 1; i <= 30; i++) {
//            Thread thread = new PriorityTest("thread " + i);
//            if (i != 30) {
//                thread.setPriority(Thread.MIN_PRIORITY);
//            } else {
//                thread.setPriority(Thread.MAX_PRIORITY);
//            }
//            thread.start();
//        }

        // 메인 쓰레드
//        System.out.println(Thread.currentThread().getName());

        // 동기화

    }
}

// Runnable 인터페이스
class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("r");
        }
    }
}

// Thread 클래스 상속
class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("T");
        }
    }
}

// 쓰레드 우선 순위 테스트용
class PriorityTest extends Thread {

    public PriorityTest(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000000000; i++) {

        }

        System.out.println("Thread getName() = " + getName());
    }
}

// 동기화 예제
class Calc {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
}

class Order1 extends Thread {
    private Calc calc;

    public void setCalc(Calc calc) {
        this.setName("Order 1");
        this.calc = calc;
    }

    @Override
    public void run() {
        calc.setCount(5000);
    }
}

class Order2 extends Thread {
    private Calc calc;

    public void setCalc(Calc calc) {
        this.setName("Order 2");
        this.calc = calc;
    }

    @Override
    public void run() {
        calc.setCount(10000);
    }
}