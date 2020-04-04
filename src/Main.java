import station.StationWorker;
import station.Train;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Train[] trains = new Train[num];
        for (int i = 0; i < num; ++i) {
            trains[i] = new Train(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
        System.out.println(StationWorker.countMaxSum(trains));
    }
}
