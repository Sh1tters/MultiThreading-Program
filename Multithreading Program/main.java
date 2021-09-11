/** Multi-threading enables you to write in a way where multiple activities can proceed concurrently in the same program. */

/** If your class is intended to be executed as a thread then you can achieve this by implementing a Runnable interface. You will need to follow three basic steps */
class MultiThreading implements Runnable {
    private Thread t;
    private String threadName;
    
    MultiThreading( String name ){
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run(){
        System.out.println("Running " + threadName);
        try {
            for(int i = 4; i > 0; i--){
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch(InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class main {

    public static void main(String args[]) {
        MultiThreading MT1 = new MultiThreading("Thread-1");
        MT1.start();

        MultiThreading MT2 = new MultiThreading("Thread-2");
        MT2.start();
    }
}


/** Thread Methods
 * Following is the list of important methods available in the Thread class.
 * 
 * public void start()
 * Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.
 * 
 * public void run() 
 * If this Thread object was instantiated using a separate Runnable target, the run() method is invoked on that Runnable object.
 * 
 * public final void setName(String name) 
 * Changes the name of the Thread object. There is also a getName() method for retrieving the name.
 * 
 * public final void setPriority(int priority)
 * Sets the priority of this Thread object. The possible values are between 1 and 10.
 * 
 * public final void setDaemon(boolean on)
 * A parameter of true denotes this Thread as a daemon thread.
 * 
 * public final void join(long millisec)
 * The current thread invokes this method on a second thread, causing the current thread to block until the second thread terminates or the specified number of milliseconds passes.
 * 
 * public void interrupt()
 * Interrupts this thread, causing it to continue execution if it was blocked for any reason.
 * 
 * public final boolean isAlive()
 * Returns true if the thread is alive, which is any time after the thread has been started but before it runs to completion.
 * 
 * ****
 * The previous methods are invoked on a particular Thread object. 
 * The following methods in the Thread class are static. Invoking one of the static methods performs the operation on the currently running thread.
 * ****
 * 
 * public static void yield()
 * Causes the currently running thread to yield to any other threads of the same priority that are waiting to be scheduled.
 * 
 * public static void sleep(long millisec)
 * Causes the currently running thread to block for at least the specified number of milliseconds.
 * 
 * public static boolean holdsLock(Object x)
 * Returns true if the current thread holds the lock on the given Object.
 * 
 * public static Thread currentThread()
 * Returns a reference to the currently running thread, which is the thread that invokes this method.
 * 
 * public static void dumpStack()
 * Prints the stack trace for the currently running thread, which is useful when debugging a multithreaded application.
 */