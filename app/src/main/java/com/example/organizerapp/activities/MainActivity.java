package com.example.organizerapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.organizerapp.R;
import com.example.organizerapp.data.map.MapDataClass;
import com.example.organizerapp.data.map.MapRepository;
import com.example.organizerapp.date.DateService;
import com.example.organizerapp.model.Card;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private MapRepository mapRepository = MapDataClass.SINGLETON_MAP.getMapRepository();
    private DateService dateService = new DateService();
    private ArrayAdapter<String> adapter;
    private Date date = new Date();
    private TextView dateTextView;
    private String cardCreateDate;
    private String actualDay;
    private Context context;
    private int dayCounter;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        actualDay = dateService.getFormatedDate(dateService.getDate());

        System.out.println("Day " + actualDay);
        dateTextView = findViewById(R.id.dateTextView);

        //
        Button addCardsButton = findViewById(R.id.addCardButton);
        ImageButton previousDayButton = findViewById(R.id.previousDay);
        ImageButton nextDayButton = findViewById(R.id.nextDay);


        //Wczytanie listy aktyności
        String dayOfWeek = dateService.getDayOfWeek(dateService.getDate());
        dateTextView.setText(dayOfWeek + " " + dateService.getFormatedDate(dateService.getDate()));



            loadActivities();


        createCardByBundle(getIntent().getExtras());
        loadActivities();


        //BUTTONS



        //Dodawanie aktywności w ciagu dnia
        addCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddCardsActivity.class);
                intent.putExtra("createDate", actualDay);
                startActivity(intent);

            }
        });

        //Wybranie poprzedniego dnia
        previousDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Day " + actualDay);
                dayCounter--;
                String prDate = dateService.getDayOfWeek(dateService.getAnotherDate(date, dayCounter));
                Date anotherDate = dateService.getAnotherDate(date, dayCounter);
                System.out.println("GetAnotherDate: " + dateService.getAnotherDate(date, dayCounter));
                dateTextView.setText(prDate + " " +  dateService.getFormatedDate(dateService.getAnotherDate(date, dayCounter)));
                actualDay = dateService.getFormatedDate(dateService.getAnotherDate(date, dayCounter));
                Toast.makeText(context, actualDay, Toast.LENGTH_SHORT).show();
                loadActivities();
            }
        });

        //Wybranie następnego dnia
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Day " + actualDay);
                dayCounter++;
                String prDate = dateService.getDayOfWeek(dateService.getAnotherDate(date, dayCounter));
                dateTextView.setText(prDate + " " +  dateService.getFormatedDate(dateService.getAnotherDate(date, dayCounter)));
                actualDay = dateService.getFormatedDate(dateService.getAnotherDate(date, dayCounter));
                Toast.makeText(context, actualDay, Toast.LENGTH_SHORT).show();
                loadActivities();

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadActivities() {


        Set<Card> activities = mapRepository.getActivities(actualDay);
        ListView list = findViewById(R.id.listView);

        List<String> activitiesString = activities.stream()
                .map(card -> String.format("Godzina rozpoczęcia %s\nGodzina zakończeniaa %s\nTreść zadania %s", card.getStartAt(), card.getEndAt(), card.getText()))
                .collect(Collectors.toList());
        adapter = new ArrayAdapter<String>(this, R.layout.row, activitiesString);
        list.setAdapter(adapter);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createCardByBundle(Bundle bundle) {
        if (bundle != null) {
            Card card = new Card(bundle.getString("startAt") + "-", bundle.getString("endAt"), bundle.getString("text"));
            cardCreateDate = bundle.getString("createDate");
            mapRepository.add(cardCreateDate, card);
        }
    }


}