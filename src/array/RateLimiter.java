package array;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class RequestData{
    AtomicInteger count;
    AtomicLong startTime;

}
public class RateLimiter {

    public int N;
    public int T;
    public Map<String,RequestData> requestDataMap ;

    private final ScheduledExecutorService scheduler;


    public RateLimiter(int n, int t ){
        N=n;
        T=t;
        requestDataMap = new ConcurrentHashMap<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
        startCleanupTask();
    }

    private void startCleanupTask() {
        scheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            requestDataMap.forEach((requestId, data) -> {
                if (currentTime - data.startTime.get() > T) {
                    requestDataMap.remove(requestId);
                }
            });
        }, T, T, TimeUnit.MILLISECONDS);
    }




    public boolean allowRequest(String requestId) {
        long currentTime = System.currentTimeMillis();

        RequestData requestData  = requestDataMap.computeIfAbsent(requestId, k->{
            RequestData newData = new RequestData();
            newData.startTime.set(currentTime);
            return newData;
        });
              // check the count nd time
        if(currentTime - requestData.startTime.get() > T){
            requestData.count.set(0); // Reset the count.
            requestData.startTime.set(currentTime); // Reset the start time.
        }
        int currentCount = requestData.count.incrementAndGet();
        if (currentCount > N) {
            requestData.count.decrementAndGet();
            return false;
        }

         return true;
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1);

        for (int i = 0; i < 10; i++) {
            String requestId = "user1";
            if (rateLimiter.allowRequest(requestId)) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " blocked.");
            }
            Thread.sleep(200);
        }
        Thread.sleep(2000);
        rateLimiter.shutdown();
    }


}
