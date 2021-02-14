package uz.technickpro.addtofavourite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<FavPojo> pojos;
    private FavAdapter adapter;
    private DbHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_root);
        db = new DbHelper(this);
//        pojos = db.pojos();
        pojos = new ArrayList<>();
        adapter = new FavAdapter(this, pojos);
        listView.setAdapter(adapter);

        addName();

    }

    public void addName(){

        for (int i = 0; i < 20; i++) {

            pojos.add(new FavPojo("Bahromjon " + i, "false"));

        }

    }
}