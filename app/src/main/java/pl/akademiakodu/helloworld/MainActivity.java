package pl.akademiakodu.helloworld;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    Button buttonChange;
    TextView textView;

    List<String> mindList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mindList = new ArrayList<>();

        buttonChange = (Button) findViewById(R.id.buttonChange);
        textView = (TextView) findViewById(R.id.textChange);


        buttonChange.setOnClickListener(this);

//        buttonChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // jakaś akcja od razu do zaprogramowania
//            }
//        });
//

        loadMinds();
    }

    @Override
    protected void onPause() {
        // To odpali się, gdy aplikcja przejdzie do backgroundu
        super.onPause();
    }



    private void loadMinds() {
        mindList.add("Witaj świecie!");
        mindList.add("Jak leci życie?");
        mindList.add("Co u Ciebie?");
        mindList.add("Błogo");
        mindList.add("Brzydka pogoda ;(");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == buttonChange.getId()) {
            Random rand = new Random();
            textView.setText(mindList.get(rand.nextInt(mindList.size())));
            Toast.makeText(this, "Witaj świecie to ja Toast!", Toast.LENGTH_SHORT).show();
        }
    }
}
