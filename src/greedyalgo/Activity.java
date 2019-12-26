package greedyalgo;

public class Activity {
    private static int count=0;
    private int id;
    private int startTime;
    private int endTime;

    Activity(int startTime, int endTime){
        this.id=count;
        count++;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public int getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
