package eg.training123.currenyconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Spinner spinner1, spinner2;
    private Button btn;
    private EditText userinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        spinner1  = findViewById(R.id.spinner_from);
        spinner2  = findViewById(R.id.spinner_to);
        result    = findViewById(R.id.textView04);
        btn       = findViewById(R.id.button);
        userinput = findViewById(R.id.editText01);


        List<String> mylist = new ArrayList<String>();

        mylist.add("EGP");
        mylist.add("USD");
        mylist.add("EUR");

        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mylist);


        spinner1.setAdapter(dataAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x1 = "** Selected = " + spinner1.getSelectedItem().toString();
                Log.d("test",x1);

                Toast.makeText(getBaseContext(),x1,Toast.LENGTH_LONG).show();
            }
        });

    }

}
