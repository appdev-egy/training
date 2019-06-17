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

import java.text.DecimalFormat;
import java.text.NumberFormat;
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


        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mylist);


        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = userinput.getText().toString();
                if (input.isEmpty()){
                    Toast.makeText(getBaseContext(), "The field is Empty!", Toast.LENGTH_LONG).show();

                } else {
                    double value = Double.valueOf(input);
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    if (spinner1.getSelectedItem().toString().equals("USD") && spinner2.getSelectedItem().toString().equals("EGP")) {
                        Toast.makeText(getBaseContext(), "USD to EGP", Toast.LENGTH_LONG).show();

                        value = value * 16.70;
                        result.setText(String.valueOf(formatter.format(value)) + " EGP");


                    } else if (spinner1.getSelectedItem().toString().equals("EGP") && spinner2.getSelectedItem().toString().equals("USD")) {
                        Toast.makeText(getBaseContext(), "EGP to USD", Toast.LENGTH_LONG).show();
                        value = value / 16.70;
                        result.setText(String.valueOf(formatter.format(value))  + " USD");


                    } else {
                        Toast.makeText(getBaseContext(), "No Conversion is needed!", Toast.LENGTH_LONG).show();

                    }

                }


            }
        });

    }

}
