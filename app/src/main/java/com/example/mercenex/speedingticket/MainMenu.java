package com.example.mercenex.speedingticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainMenu extends AppCompatActivity {

    private Button goPenaltyButton = null;
    private Button goConsumptionButton = null;
    private Button goCameraButton = null;
    private Button goTireDistance = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        goPenaltyButton = findViewById(R.id.penaltyButton);
        goConsumptionButton = findViewById(R.id.consumptionButton);
        goCameraButton = findViewById(R.id.cameraButton);
        goTireDistance = findViewById(R.id.rolling_Distance_Button);

        goPenaltyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CalculatePenalty.class);
                startActivity(i);
            }
        });

        goConsumptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CalculateConsumption.class);
                startActivity(i);
            }
        });

        goCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Camera.class);
                startActivity(i);
            }
        });

        goTireDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), RollingDistances.class);
                startActivity(i);
            }
        });


    }

}
