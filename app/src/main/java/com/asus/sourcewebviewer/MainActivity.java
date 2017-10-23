package com.asus.sourcewebviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] spinnerValue;
    getSourceTask c1;
    static TextView showSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinnerValue = new String[]{
                "http://",
                "https://"
        };

        Spinner prot = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerValue);
        prot.setAdapter(adapter);

        showSource = (TextView) findViewById(R.id.showSource);
        showSource.setMovementMethod(new ScrollingMovementMethod());
    }

    public void eksekusibos(View view) {
        //String text = prot.getSelectedItem().toString();
        Spinner protokol = (Spinner) findViewById(R.id.spinner1);
        String protokols = protokol.getSelectedItem().toString();
        EditText addressnyaom = (EditText) findViewById(R.id.address);
        String iniaddressnya = addressnyaom.getText().toString();

        Toast.makeText(this,protokols+""+iniaddressnya,Toast.LENGTH_LONG).show();

        c1 = new getSourceTask(this);
        c1.execute(protokols+""+iniaddressnya);
        //www.c1.execute("https://www.google.com");

    }
}
