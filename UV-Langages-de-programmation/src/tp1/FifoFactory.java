package tp1;

/**
 * Factory to create a Fifo
 */
public class FifoFactory implements LaneFactory{
    public Fifo createLane(){
        return new Fifo();
    }
}