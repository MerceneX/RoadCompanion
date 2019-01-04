package com.example.mercenex.speedingticket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculatePenalty extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_penalty);
		Button button = findViewById(R.id.izracunKazni_Button);
		final Spinner spinner = findViewById(R.id.obmocjeHitrosti_spinner);
		final CheckBox chk = findViewById(R.id.toleranca_checkBox);
		final EditText hitrostPrebrana = findViewById(R.id.vasaHitrost_EditText);
		final TextView kazen = findViewById(R.id.prikazKazni_TextView);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
              .obmoceje_hitrosti, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
			{
				EditText omejitev = findViewById(R.id.omejitev_editText);
				switch(spinner.getSelectedItem().toString())
				{
					case "Območje Umirjenega Prometa":
						omejitev.setText("10");
						break;
					case "Cona 30":
						omejitev.setText("30");
						break;
					case "Naselje":
						omejitev.setText("50");
						break;
					case "Izven Naselja":
						omejitev.setText("90");
						break;
					case "Hitra Cesta":
						omejitev.setText("110");
						break;
					case "Avtocesta":
						omejitev.setText("130");
						break;
					default:
						omejitev.setText("");
						break;
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
				int hitrost = 0;
				try
				{
					hitrost = Integer.parseInt(String.valueOf(hitrostPrebrana.getText()));
				}catch(Exception e){ kazen.setText("Vnesite omejitev");}
				int omejitevNum = 0;
				try
				{
					EditText omejitev = findViewById(R.id.omejitev_editText);
					if(omejitev.getText().equals("")) omejitev.setText("0");
					omejitevNum = Integer.parseInt(String.valueOf(omejitev.getText()));
				}catch(Exception e){ kazen.setText("Vnesite omejitev"); }

				if(chk.isChecked()) // Računanje tolerance
				{
					if(hitrost < 100)
					{
						hitrost = hitrost - 5;
						if(hitrost < 0)
						{
							hitrost = 0;
						}
					}else if(hitrost >= 100 && hitrost < 200)
					{
						hitrost = hitrost - 7;
					}else
					{
						hitrost = hitrost - 11;
					}
				}
				switch(spinner.getSelectedItem().toString())
				{
					case "Območje Umirjenega Prometa":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 5)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 20)
						{
							kazen.setText("Kazen: 300€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 1000€ in 5 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 30)
						{
							kazen.setText("Kazen: 1200€, 18 kazenskih točk\nin odvzem vozniškega dovoljenja");
						}
						break;
					case "Cona 30":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 5)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 20)
						{
							kazen.setText("Kazen: 300€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 1000€ in 5 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 30)
						{
							kazen.setText("Kazen: 1200€, 18 kazenskih točk\nin odvzem vozniškega dovoljenja");
						}
						break;
					case "Naselje":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 5)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 20)
						{
							kazen.setText("Kazen: 250€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 500€ in 5 kazenskih točk");
						}else if(hitrost <= omejitevNum + 50)
						{
							kazen.setText("Kazen: 1000€ in 9 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 50)
						{
							kazen.setText("Kazen: 1200€, 18 kazenskih točk\nin odvzem vozniškega dovoljenja");
						}
						break;
					case "Izven Naselja":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 20)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 160€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 40)
						{
							kazen.setText("Kazen: 250€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 50)
						{
							kazen.setText("Kazen: 500€ in 5 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 50)
						{
							kazen.setText("Kazen: 1200€, 18 kazenskih točk\nin odvzem vozniškega dovoljenja");
						}
						break;
					case "Hitra Cesta":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 40)
						{
							kazen.setText("Kazen: 160€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 50)
						{
							kazen.setText("Kazen: 250€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 60)
						{
							kazen.setText("Kazen: 500€ in 5 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 30)
						{
							kazen.setText("Kazen: 1200€, 9 kazenskih točk");
						}
						break;
					case "Avtocesta":
						if(hitrost <= omejitevNum)
						{
							kazen.setText("Vozili ste po omejitvah");
						}else if(hitrost <= omejitevNum + 10)
						{
							kazen.setText("Kazen: 40€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 30)
						{
							kazen.setText("Kazen: 80€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 40)
						{
							kazen.setText("Kazen: 160€ in 0 kazenskih točk");
						}else if(hitrost <= omejitevNum + 50)
						{
							kazen.setText("Kazen: 250€ in 3 kazenske točke");
						}else if(hitrost <= omejitevNum + 60)
						{
							kazen.setText("Kazen: 500€ in 5 kazenskih točk");
						}
						else if(hitrost > omejitevNum + 30)
						{
							kazen.setText("Kazen: 1200€, 9 kazenskih točk");
						}
						break;
					default:
						kazen.setText("Izberite območje vožnje");
						break;
				}
			}
		});
	}
}
