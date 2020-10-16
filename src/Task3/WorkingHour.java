package Task3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkingHour {
        int startHr, startMin, endHr, endMin;

        public WorkingHour(int startHr, int startMin, int endHr, int endMin) {
            this.startHr = startHr;
            this.startMin = startMin;
            this.endHr = endHr;
            this.endMin = endMin;
        }

        boolean checkIsInInterval(){
            Calendar startCal = Calendar.getInstance()
                    , endCal = Calendar.getInstance();

            startCal.set(Calendar.HOUR_OF_DAY, startHr);
            startCal.set(Calendar.MINUTE, startMin);
            startCal.set(Calendar.SECOND, 0);
            startCal.set(Calendar.MILLISECOND, 0);

            endCal.set(Calendar.HOUR_OF_DAY, endHr);
            endCal.set(Calendar.MINUTE, endMin);
            endCal.set(Calendar.SECOND, 0);
            endCal.set(Calendar.MILLISECOND, 0);

            long startTimeStamp = startCal.getTimeInMillis()
                    , endTimeStamp = endCal.getTimeInMillis()
                    , currTimeStamp = Calendar.getInstance().getTimeInMillis();

            return currTimeStamp >= startTimeStamp && currTimeStamp <= endTimeStamp;
        }
}
