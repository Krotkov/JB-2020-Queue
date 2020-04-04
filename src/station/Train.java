package station;

public class Train {
    public int number, arrivalTime, workTime, cost;

    public Train() {
        number = -1;
        arrivalTime = 0;
        workTime = 0;
        cost = 0;
    }

    public Train(int _number, int _arrivalTime, int _workTime, int _cost) {
        number = _number;
        arrivalTime = _arrivalTime;
        workTime = _workTime;
        cost = _cost;
    }
}
