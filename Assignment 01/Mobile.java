interface Camera {
    void takePhoto();
}

interface VideoRecorder {
    void recordVideo();
}

class iPhoneCamera implements Camera {
    public void takePhoto() {
        System.out.println("iPhone: Taking a photo.");
    }
}

class iPhoneVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("iPhone: Recording a video.");
    }
}

class SamsungCamera implements Camera {
    public void takePhoto() {
        System.out.println("Samsung: Taking a photo.");
    }
}

class SamsungVideoRecorder implements VideoRecorder {
    public void recordVideo() {
        System.out.println("Samsung: Recording a video.");
    }
}

interface MobileFactory {
    Camera createCamera();
    VideoRecorder createVideoRecorder();
}

class iPhoneFactory implements MobileFactory {
    public Camera createCamera() {
        return new iPhoneCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new iPhoneVideoRecorder();
    }
}

class SamsungFactory implements MobileFactory {
    public Camera createCamera() {
        return new SamsungCamera();
    }

    public VideoRecorder createVideoRecorder() {
        return new SamsungVideoRecorder();
    }
}

public class Mobile {
    public static void main(String[] args) {
        MobileFactory factory = new iPhoneFactory();
        Camera camera = factory.createCamera();
        VideoRecorder recorder = factory.createVideoRecorder();
        camera.takePhoto();
        recorder.recordVideo();

        MobileFactory samsungFactory = new SamsungFactory();
        Camera samsungCamera = samsungFactory.createCamera();
        VideoRecorder samsungRecorder = samsungFactory.createVideoRecorder();
        samsungCamera.takePhoto();
        samsungRecorder.recordVideo();
    }
}

