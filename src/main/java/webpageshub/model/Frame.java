package webpageshub.model;

public class Frame {

    private FrameTime startTime;

    private FrameTime endTime;

    private FrameURL[] urls;

    public FrameTime getStartTime() {
        return startTime;
    }

    public void setStartTime(FrameTime startTime) {
        this.startTime = startTime;
    }

    public FrameTime getEndTime() {
        return endTime;
    }

    public void setEndTime(FrameTime endTime) {
        this.endTime = endTime;
    }

    public FrameURL[] getUrls() {
        return urls;
    }

    public void setUrls(FrameURL[] urls) {
        this.urls = urls;
    }
}
