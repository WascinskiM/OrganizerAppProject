package com.example.organizerapp.date;

import android.icu.util.ULocale;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateService {
    //Określenie długości dnia
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    //Stworzenie tablicy z dniami (w wersji polskiej, ponieważ dostępna javowa metoda posiada w języku Angielskim)
    String[] daysOfWeek={
            "Niedziela",
            "Poniedziałek",
            "Wtorek",
            "Środa",
            "Czwartek",
            "Piątek",
            "Sobota"
            };

    //Funckja zwracająca dzień tygodnia słownie
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDayOfWeek(Date date){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayInNumber = cal.get(Calendar.DAY_OF_WEEK);
        return daysOfWeek[dayInNumber-1];
    }


    //Funkcja zwracająca dzień w odpowiednim formacjie daty
    @RequiresApi(api = Build.VERSION_CODES.O)

    public String getFormatedDate(Date date){
        SimpleDateFormat localDateStringFormater = new SimpleDateFormat("dd-MM-YYYY");
        return localDateStringFormater.format(date);
    }
    //Zwrócenie sformatowanej daty dla dnia poprzedniego lub następnego
    public Date getAnotherDate(Date data, int counter){
        Date anotherDate = new Date(data.getTime()+ (MILLIS_IN_A_DAY*(counter)));
        return anotherDate;
    }

    //Funkcja zwracająca aktualną date
    @RequiresApi(api = Build.VERSION_CODES.O)
    public  Date getDate(){
        return  new Date();
    }

    public Date stringtoDate(String date){
        try {
            Date date1 = new SimpleDateFormat("dd-MM-YYYY").parse(date);
            return date1;
        } catch (ParseException e) {
            return new Date();
        }

    }

}
