package tp.v1;

public class FifoFactory implements LaneFactory {

    public Fifo createLane() {
        return new Fifo();
    }
}
