import org.junit.Assert;
import org.junit.Test;
import station.StationWorker;
import station.Train;


public class StationWorkerTest {

    @Test
    public void testOneTrain() {
        Train[] trains = new Train[1];

        trains[0] = new Train(1, 0, 10, 100);

        int answer = StationWorker.countMaxSum(trains);

        Assert.assertEquals(answer, 100);
    }

    @Test
    public void testTwoTrainsInSeries() {
        Train[] trains = new Train[2];

        trains[0] = new Train(1, 0, 5, 10);
        trains[1] = new Train(2, 5, 5, 4);

        int answer = StationWorker.countMaxSum(trains);

        Assert.assertEquals(answer, 14);
    }

    @Test
    public void testTwoParallelTrains() {
        Train[] trains = new Train[2];

        trains[0] = new Train(1, 0, 10, 100);
        trains[1] = new Train(2, 1, 6, 101);

        int answer = StationWorker.countMaxSum(trains);

        Assert.assertEquals(answer, 101);
    }

    @Test
    public void testTrickyTrains() {
        Train[] trains = new Train[3];

        trains[0] = new Train(1, 0, 10, 10);
        trains[1] = new Train(2, 1, 5, 7);
        trains[2] = new Train(3, 6, 4, 4);

        int answer = StationWorker.countMaxSum(trains);

        Assert.assertEquals(answer, 11);
    }
}
