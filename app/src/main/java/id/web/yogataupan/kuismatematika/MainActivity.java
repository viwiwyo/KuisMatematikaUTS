package id.web.yogataupan.kuismatematika;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    double ang1,ang2;
    int op,benar=0,salah=0;
    TextView jwb,jb,js;
    EditText angk1,angk2,ope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angk1=(EditText)findViewById(R.id.editText);
        angk2=(EditText)findViewById(R.id.editText3);
        ope=(EditText)findViewById(R.id.editText2);
        jwb=(TextView)findViewById(R.id.jawab);
        jb=(TextView)findViewById(R.id.textView7);
        js=(TextView)findViewById(R.id.textView8);

    }

    public void soal(View view) {
        EditText angk1 = (EditText) findViewById(R.id.editText);
        EditText angk2 = (EditText) findViewById(R.id.editText3);
        EditText opr = (EditText) findViewById(R.id.editText2);

        int random1, random2, random3;
        random1 = (int) (Math.random() * 100 + 1);
        random2 = (int) (Math.random() * 100 + 1);
        random3 = (int) (Math.random() * 4);

        String st1 = String.valueOf(random1);
        String st2 = String.valueOf(random2);

        angk1.setText(st1);
        angk2.setText(st2);

        if (random3 == 0) {
            opr.setText("+");
        } else if (random3 == 1) {
            opr.setText("-");
        } else if (random3 == 2) {
            opr.setText("/");
        } else if (random3 == 3) {
            opr.setText("*");
        }
        ang1 = random1;
        ang2 = random2;
        op = random3;

    }

    public void cekjawab(View view) {
        EditText edt = (EditText) findViewById(R.id.input);
        TextView jawaban = (TextView) findViewById(R.id.jawab);

        double hasil=0;
        if (op == 0) {
            hasil = ang1+ang2;
        } else if (op == 1) {
            hasil = ang1-ang2;
        } else if (op == 2) {
            hasil = ang1/ang2;
            hasil = (double) Math.round(hasil*100)/100;
        } else if (op == 3) {
            hasil = ang1*ang2;
        }
        if (hasil == Double.parseDouble(edt.getText().toString())) {
            jawaban.setText("Jawaban anda Benar");
            benar++;
            jb.setText(Integer.toString(benar));
        } else {
            jawaban.setText("Jawaban anda Salah");
            salah++;
            js.setText(Integer.toString(salah));

        }
    }
}


