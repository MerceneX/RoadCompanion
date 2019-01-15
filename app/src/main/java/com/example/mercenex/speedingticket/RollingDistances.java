package com.example.mercenex.speedingticket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RollingDistances extends AppCompatActivity {
    private Button calculate;


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText distanceTraveled = findViewById(R.id.distance_Trraveled_editText);
            EditText tireDiameter = findViewById(R.id.tire_Diameter_EditText);
            double result = (Double.parseDouble(String.valueOf(distanceTraveled.getText()))*1000) / (Double.parseDouble(String.valueOf(tireDiameter.getText())) * Math.PI);
            TextView resultLabel = findViewById(R.id.distance_Traveled_Result_PlainText);
            resultLabel.setText(String.valueOf(result));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolling_distance);

        calculate = findViewById(R.id.calculate_Distance_Traveled_Button);
        calculate.setOnClickListener(listener);
    }


}
