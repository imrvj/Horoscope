package com.example.unishop.horoscope;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Spinner Spinner;
    private Spinner Spinner2;
    private Button button;
    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init() {
        Spinner = findViewById(R.id.spinner);
        Spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.city_click);

        TextView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView.setText("Fetching..!");
               fetchWeatherDetails();

            }
        });

    }
    private void fetchWeatherDetails() {
        //Obtain an instance of Retrofit by calling the static method.
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        WeatherAPIs weatherAPIs = retrofit.create(WeatherAPIs.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        String text = Spinner.getSelectedItem().toString().toLowerCase();


        Call call = weatherAPIs.getHoroscope(text);
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    WResponse wResponse = (WResponse) response.body();

                    String TAG="";
                    Log.i(TAG, "onResponse: "+wResponse);


                    TextView.setText(wResponse.getHoroscope());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
               TextView.setText("Server Down");
            }
        });

    }
}
