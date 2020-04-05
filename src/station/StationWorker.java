package station;

import java.util.ArrayList;
import java.util.Collections;

public class StationWorker {
    static class Event implements Comparable<Event> {
        int index, time, state, trainIndex;
        int beginIndex; // only if state == 1

        Event(int _time, int _index, int _state, int _trainIndex, int _beginIndex) {
            time = _time;
            index = _index;
            state = _state;
            trainIndex = _trainIndex;
            beginIndex = _beginIndex;
        }

        Event(int _time, int _index, int _state, int _trainIndex) {
            time = _time;
            index = _index;
            state = _state;
            trainIndex = _trainIndex;
            beginIndex = -1;
        }

        boolean isBegin() {
            return state == 0;
        }

        @Override
        public int compareTo(Event event) {
            if (this.time == event.time) return event.state - this.state;
            return this.time - event.time;
        }
    }

    /**
     * Count maximum amount we can earn
     * @param trains list of trains
     * @return maximum amount
     */
    static public int countMaxSum(Train[] trains) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < trains.length; ++i) {
            events.add(new Event(trains[i].arrivalTime, 2 * i, 0, i));
            events.add(new Event(trains[i].arrivalTime + trains[i].workTime, 2 * i + 1, 1, i, 2 * i));
        }
        Collections.sort(events);
        int[] newIndex = new int[events.size()];
        for (int i = 0; i < events.size(); ++i) {
            newIndex[events.get(i).index] = i;
        }
        int[] dp = new int[events.size()];
        dp[0] = 0;
        for (int i = 1; i < events.size(); ++i) {
            if (events.get(i).isBegin()) dp[i] = dp[i - 1];
            else {
                Event event = events.get(i);
                dp[i] = Math.max(dp[i - 1], dp[newIndex[event.beginIndex]] + trains[event.trainIndex].cost);
            }
        }

        return dp[events.size() - 1];
    }
}
