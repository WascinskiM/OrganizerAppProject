package com.example.organizerapp.date;

import android.icu.util.ULocale;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DateService {
    //Określenie długości dnia
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    //Stworzenie tablicy z dniami (w wersji polskiej, ponieważ dostępna javowa metoda posiada w języku Angielskim)
    String[] daysOfWeek={
            "Poniedziałek",
            "Wtorek",
            "Środa",
            "Czwartek",
            "Piątek",
            "Sobota",
            "Niedziela"};

    //Funckja zwracająca dzień tygodnia słownie
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDayOfWeek(LocalDate localDate){

        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
        int dayInNumber = dayOfWeek.getValue();

        return daysOfWeek[dayInNumber-1];
    }


    //Funkcja zwracająca dzień w odpowiednim formacjie daty
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getFormatedDate(){
        Date date = new Date();
        SimpleDateFormat localDateStringFormater = new SimpleDateFormat("dd-MM-YY");

        return localDateStringFormater.format(date);
    }
    //Zwrócenie sformatowanej daty dla dnia poprzedniego lub następnego
    public String getFormatedAnotherDate(Date data, int counter){
        Date date1 = new Date(data.getTime()+ (MILLIS_IN_A_DAY*(counter)));
        SimpleDateFormat localDateStringFormater = new SimpleDateFormat("dd-MM-YY");
        return localDateStringFormater.format(date1);
    }

    //Funkcja zwracająca aktualną date
    @RequiresApi(api = Build.VERSION_CODES.O)
    public  LocalDate getDate(){
        return  LocalDate.now();
    }

}
