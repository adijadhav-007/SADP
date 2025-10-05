interface BeatModelInterface {
    void initialize();
    int getHeartRate();
}

class HeartModel {
    public void startHeart() {
        System.out.println("Heart started beating...");
    }

    public int getRate() {
        return 72; 
    }
}

class HeartAdapter implements BeatModelInterface {
    private HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void initialize() {
        heartModel.startHeart();
    }

    @Override
    public int getHeartRate() {
        return heartModel.getRate();
    }
}

public class HeartToBeatAdapterDemo {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        BeatModelInterface beatModel = new HeartAdapter(heartModel);

        beatModel.initialize();
        System.out.println("Current heart rate: " + beatModel.getHeartRate() + " bpm");
    }
}

