package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<VehicleData> vehicleData= new ArrayList<>();
    private int rowNo = 0;
    private TextView[] textViews;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "Just Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readVehicleData();

        /*textViews = new TextView[]{
                findViewById(R.id.textView1),
                findViewById(R.id.textView2),
                findViewById(R.id.textView3),
                findViewById(R.id.textView4),
                findViewById(R.id.textView5),
                findViewById(R.id.textView6),
        };

        handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(updateUITask, 1000);*/

    }

    /*private final Runnable updateUITask = new Runnable() {
        @Override
        public void run() {
            // Update the TextViews with new data
            updateTextViews();

            // Schedule the task again after 1 second
            handler.postDelayed(this, 1000);
        }
    };

    private void updateTextViews() {

        VehicleData obj = vehicleData.get(rowNo);

        type.setText(obj.getType());
        airTemp.setText(Double.toString(obj.getAirTemp()));
        processTemp.setText(Double.toString(obj.getProcessTemp()));
        rpm.setText(Integer.toString(obj.getRpm()));
        torque.setText(Double.toString(obj.getTorque()));
        toolWear.setText(Integer.toString(obj.getToolWear()));
        output.setText(obj.getFailureType());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the callback to prevent memory leaks
        handler.removeCallbacks(updateUITask);
    }

    TextView type = (TextView)findViewById(R.id.textView1);
    TextView airTemp = (TextView)findViewById(R.id.textView2);
    TextView processTemp = (TextView)findViewById(R.id.textView3);
    TextView rpm = (TextView)findViewById(R.id.textView4);
    TextView torque = (TextView)findViewById(R.id.textView5);
    TextView toolWear = (TextView)findViewById(R.id.textView6);
    TextView output = (TextView)findViewById(R.id.dataTextView);*/

    private void readVehicleData() {
        InputStream is = getResources().openRawResource(R.raw.predictive_maintenance);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";

        try{
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                Log.d("MainActivity", line);
                VehicleData sample = new VehicleData();

                sample.setUDI(Integer.parseInt(tokens[0]));
                sample.setProductID((tokens[1]));
                sample.setType(tokens[2]);
                sample.setAirTemp(Double.parseDouble(tokens[3]));
                sample.setProcessTemp(Double.parseDouble(tokens[4]));
                sample.setRpm(Integer.parseInt(tokens[5]));
                sample.setTorque(Double.parseDouble(tokens[6]));
                sample.setToolWear(Integer.parseInt(tokens[7]));
                sample.setTarget(Integer.parseInt(tokens[8]));
                sample.setFailureType(tokens[9]);

                vehicleData.add(sample);

                Log.d("MyActivity", "Just created: " + sample);

            }
        } catch(IOException e){
            Log.wtf("MyActivity", "Error Reading data file on line" + line);
            e.printStackTrace();
        }
    }

}