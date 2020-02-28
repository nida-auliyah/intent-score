package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private static final String HASIL_KEY = "hasil";
    private TextView homeText;
    private TextView awayText;
    private ImageView homelogo;
    private ImageView awaylogo;
    int skorHome=0;
    int skorAway=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homelogo = findViewById(R.id.home_logo);
        awaylogo = findViewById(R.id.away_logo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // TODO: display value here
            Bundle extra = getIntent().getExtras();

            homeText.setText(extras.getString("home"));
            awayText.setText(extras.getString("away"));
        }
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
    public void addHome(View view) {
        skorHome++;
        addskorHome(skorHome);
    }

    public void addskorHome(int scoreHome) {
        TextView scoreView=findViewById(R.id.score_home);
        scoreView.setText(String.valueOf(scoreHome));
    }
    public void addAway(View view){
        skorAway++;
        addskorAway(skorAway);
    }
    public void addskorAway(int scoreAway){
        TextView scoreView=findViewById(R.id.score_away);
        scoreView.setText(String.valueOf(scoreAway));
    }

    public void CekHasil(View view) {
        String skor="" ;
        if(skorHome==skorAway){
            skor = "DRAW";
        } if(skorHome>skorAway){
            skor = homeText.getText().toString();
        } if(skorHome<skorAway){
            skor = awayText.getText().toString();
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(HASIL_KEY, skor );
        startActivity(intent);
    }
}
