package com.codeconsole.androidutil.Util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by madhan on 9/4/17.
 */

public class DateTimePicker {
    private static final String TAG = "DateTimePicker";

    private Context context;
    private onDateTimeListener listener;

    public DateTimePicker(Context context) {
        this.context = context;
    }

    public onDateTimeListener getListener() {
        return listener;
    }

    public void setListener(onDateTimeListener listener) {
        this.listener = listener;
    }

    public void showDatePicker() {
        final Calendar dateCalendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {

                dateCalendar.set(y, m, d);
                listener.onDateComplete(dateCalendar);
            }
        }, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void showTimePicker() {
        final Calendar timeCalendar = Calendar.getInstance(Locale.ENGLISH);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                timeCalendar.set(timeCalendar.get(Calendar.YEAR),
                        timeCalendar.get(Calendar.MONTH), timeCalendar.get(Calendar.DAY_OF_MONTH),
                        h, m);
                listener.onTimeComplete(timeCalendar);
            }
        }, timeCalendar.get(Calendar.HOUR_OF_DAY), timeCalendar.get(Calendar.MINUTE), false);
        timePickerDialog.show();
    }

    interface onDateTimeListener {
        void onTimeComplete(Calendar time);

        void onDateComplete(Calendar date);
    }
}
