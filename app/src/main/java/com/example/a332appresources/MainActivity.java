package com.example.a332appresources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner language;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        btnChange = findViewById(R.id.btn_change);
        language = findViewById(R.id.spinner);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinner = language.getSelectedItem().toString();

                if ("Русский".equalsIgnoreCase(spinner) | "Russian".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                } else if ("Английский".equalsIgnoreCase(spinner) |
                        "English".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }
}
