package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView hasilText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        hasilText = findViewById(R.id.textView3);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // TODO: display value here
            Bundle extra = getIntent().getExtras();

            hasilText.setText(extras.getString("hasil"));

        }
    }
}
