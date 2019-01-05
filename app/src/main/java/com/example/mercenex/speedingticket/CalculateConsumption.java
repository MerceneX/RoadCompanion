package com.example.mercenex.speedingticket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculateConsumption extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_consumption);

        //setting spinner values
        final Spinner spinner = findViewById(R.id.valute_spinner);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.valutes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        //
       final Button buttonForConsumption = findViewById(R.id.poraba_Button);
       final EditText editTextConsumption = findViewById(R.id.kolicinaGoriva_EditText);
       final EditText editTextKilometers =findViewById(R.id.prevozeniKilometri_editText);
       final EditText editTextPriceOfFuel =(findViewById(R.id.cena_EditText));
        findViewById(R.id.table_layout).setVisibility(View.INVISIBLE);

       buttonForConsumption.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
            TextView result = findViewById(R.id.prikazPorabe_TextView);
            TextView expanse = findViewById(R.id.prikazCene_TextView);
            String spinnerValue = spinner.getSelectedItem().toString();
            double consumption =  Double.parseDouble(editTextConsumption.getText().toString());
            double kilometers = Double.parseDouble(editTextKilometers.getText().toString());
            double priceOfFuel = Double.parseDouble(editTextPriceOfFuel.getText().toString());
            double resultConsumption =(kilometers*consumption)/100;
            double expanseForTheTrip = resultConsumption*priceOfFuel;

            TextView cellPriceValue =findViewById(R.id.cenaValue);
            cellPriceValue.setText(expanseForTheTrip+" "+spinnerValue);

            TextView cellConsumptionValue = findViewById(R.id.porabaValue);
            cellConsumptionValue.setText(resultConsumption+" litrov");

            findViewById(R.id.table_layout).setVisibility(View.VISIBLE);

           }

       });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView valute = findViewById(R.id.valuta_TextView);
                ArrayList listOfItems = new ArrayList(adapter.getCount());
                for(int i=0; i<adapter.getCount(); i++){
                    listOfItems.add(adapter.getItem(i));
                }
                valute.setText(listOfItems.get(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                TextView valute = findViewById(R.id.valuta_TextView);
                valute.setText("Valuta");
            }
        });





    }

}
