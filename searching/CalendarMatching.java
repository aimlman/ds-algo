package searching;

import java.util.*;

public class CalendarMatching {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>(Arrays.asList(
                                                    new StringMeeting("07:00","07:45"),
                                                    new StringMeeting("08:15","08:30"),
                                                    new StringMeeting("09:00","10:30"),
                                                    new StringMeeting("12:00","14:00"),
                                                    new StringMeeting("14:00","15:00"),
                                                    new StringMeeting("15:15","15:30"),
                                                    new StringMeeting("16:30","18:30"),
                                                    new StringMeeting("20:00","21:00")
                                                ));
        StringMeeting dailyBounds1 = new StringMeeting("06:30","22:00");
        List<StringMeeting> calendar2 = new ArrayList<>(Arrays.asList(
                                                    new StringMeeting("09:00","10:00"),
                                                    new StringMeeting("11:15","11:30"),
                                                    new StringMeeting("11:45","17:00"),
                                                    new StringMeeting("17:30","19:00"),
                                                    new StringMeeting("20:00","22:15")   
                                                ));
        StringMeeting dailyBounds2 = new StringMeeting("08:00", "22:30");
        int duration = 30;
        List<StringMeeting> possibleSlots = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, duration);
        for (StringMeeting meeting: possibleSlots) {
            System.out.println(meeting.start + " " + meeting.end);
        }

    }

    // Time: O(c1+c2), Space: O(c1+c2)
    public static List<StringMeeting> calendarMatching(
                        List<StringMeeting> calendar1,
                        StringMeeting dailyBounds1,
                        List<StringMeeting> calendar2,
                        StringMeeting dailyBounds2,
                        int duration) {

        // Update Calendar 1
        List<StringMeeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);

        // Update Calendar 2
        List<StringMeeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);

        // Merge the calendar
        List<StringMeeting> mergedCalendar = mergeCalendar(updatedCalendar1, updatedCalendar2);

        // Flatten the calendar
        List<StringMeeting> flattenCalendar = flattenCalendar(mergedCalendar);

        // Find Gaps in calendar
        List<StringMeeting> availableSlots = findAvailableSlots(flattenCalendar, duration);

        return availableSlots;
    }

    private static List<StringMeeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updatedCalendar = new ArrayList<>();
        updatedCalendar.add(new StringMeeting("00:00", dailyBounds.start));
        for (StringMeeting meeting: calendar) {
            Integer meetingStart = Math.max(meeting.startOffset, dailyBounds.startOffset);
            Integer meetingEnd = Math.min(meeting.endOffset, dailyBounds.endOffset);
            if (meetingStart < meetingEnd) {
                updatedCalendar.add(new StringMeeting(minOffsetToTime(meetingStart), minOffsetToTime(meetingEnd)));
            }
        }
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        return updatedCalendar;
    }

     private static List<StringMeeting> mergeCalendar(List<StringMeeting> calendar1, List<StringMeeting> calendar2) {
        List<StringMeeting> mergedCalendar = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {

            StringMeeting meeting1 = calendar1.get(i);
            StringMeeting meeting2 = calendar2.get(j);

            if (meeting1.startOffset < meeting2.startOffset) {
                mergedCalendar.add(meeting1);
                i++;
            } else {
                mergedCalendar.add(meeting2);
                j++;
            }
        }

        while (i < calendar1.size()) {
            mergedCalendar.add(calendar1.get(i));
            i++;
        }

        while (j < calendar2.size()) {
            mergedCalendar.add(calendar2.get(j));
            j++;
        }            

        return mergedCalendar;
    }

    private static List<StringMeeting> flattenCalendar(List<StringMeeting> calendar) {
        List<StringMeeting> flattenedCalendar = new ArrayList<>();
        flattenedCalendar.add(calendar.get(0));
        for (int i=1; i<calendar.size(); i++) {
            StringMeeting currentMeeting = calendar.get(i);
            StringMeeting previousMeeting = flattenedCalendar.get(flattenedCalendar.size()-1);
            if (previousMeeting.endOffset >= currentMeeting.startOffset) {
                Integer meetingStart = Math.min(previousMeeting.startOffset, currentMeeting.startOffset);
                Integer meetingEnd = Math.max(previousMeeting.endOffset, currentMeeting.endOffset);
                StringMeeting meeting = new StringMeeting(minOffsetToTime(meetingStart), minOffsetToTime(meetingEnd));
                flattenedCalendar.set(flattenedCalendar.size()-1, meeting);
            } else {
                flattenedCalendar.add(currentMeeting);
            }
        }
        return flattenedCalendar;
    }

    private static List<StringMeeting> findAvailableSlots(List<StringMeeting> calendar, int meetingDuration) {
        List<StringMeeting> slots = new ArrayList<>();

        for (int i = 1; i < calendar.size(); i++) {
            StringMeeting previousMeeting = calendar.get(i-1);
            StringMeeting currentMeeting = calendar.get(i);
            if ((currentMeeting.startOffset - previousMeeting.endOffset) >= meetingDuration) {
                StringMeeting slot = new StringMeeting(minOffsetToTime(previousMeeting.endOffset), minOffsetToTime(currentMeeting.startOffset));
                slots.add(slot);
            }
        }

        return slots;
    }

    private static String minOffsetToTime(Integer offset) {
        Integer hours = offset/60;
        Integer minutes = offset%60;

        String hourString = Integer.toString(hours);
        String minuteString = minutes < 10 ? "0" + minutes : Integer.toString(minutes);
        return hourString + ":" + minuteString;
    }

    private static Integer timeToMinutesOffset(String time) {
        String hourOffset = time.split(":")[0];
        String minuteOffset = time.split(":")[1];

        Integer totalOffset = Integer.valueOf(hourOffset) * 60 + Integer.valueOf(minuteOffset);
        return totalOffset;
    }

    static class StringMeeting {
        public String start;
        public String end;
        public Integer startOffset;
        public Integer endOffset;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
            this.startOffset = timeToMinutesOffset(start);
            this.endOffset = timeToMinutesOffset(end);
        }
    }
    
}
