package com.example.mercenex.speedingticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.izracunKazni_Button);
        final Spinner spinner = (Spinner) findViewById(R.id.obmocjeHitrosti_spinner);
        final CheckBox chk = (CheckBox) findViewById(R.id.toleranca_checkBox);
        final EditText hitrostPrebrana = (EditText) findViewById(R.id.vasaHitrost_EditText);
        final TextView kazen = (TextView) findViewById(R.id.prikazKazni_TextView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.obmoceje_hitrosti, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.add("Izberite območje vožnje");
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            EditText omejitev = (EditText) findViewById(R.id.omejitev_editText);

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (spinner.getSelectedItem().toString())
                {
                    case "Območje Umirjenega Prometa":
                    {
                        omejitev.setText("10");
                        break;
                    }
                    case "Cona 30":
                    {
                        omejitev.setText("30");
                        break;
                    }
                    case "Naselje":
                    {
                        omejitev.setText("50");
                        break;
                    }
                    case "Izven Naselja":
                    {
                        omejitev.setText("90");
                        break;
                    }
                    case "Hitra Cesta":
                    {
                        omejitev.setText("110");
                        break;
                    }
                    case "Avtocesta":
                    {
                        omejitev.setText("130");
                        break;
                    }
                    default:
                    {
                        omejitev.setText("");
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //int hitrost = Integer.parseInt(String.valueOf(hitrostPrebrana));
//                int omejitev;
//                int obmocje;
//                if (chk.isChecked()) // Računanje tolerance
//                {
//                    if(hitrost < 100)
//                    {
//                        hitrost = hitrost - 5;
//                        if(hitrost < 0)
//                        {
//                            hitrost = 0;
//                        }
//                    }
//                    else if (hitrost >= 100 && hitrost < 200)
//                    {
//                        hitrost = hitrost - 7;
//                    }
//                    else
//                    {
//                        hitrost = hitrost - 11;
//                    }
//                }
                //kazen.setText(String.valueOf(hitrost));



            }
        });
    }
}
