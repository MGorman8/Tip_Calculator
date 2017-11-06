package com.gorman.tip_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

import static java.lang.Double.*;

public class MainActivity extends AppCompatActivity {
    double tab;
    double tip;
    double total;
    String lotChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText bill =(EditText)findViewById(R.id.txtBill);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        Button calc = (Button)findViewById(R.id.btnTip);
                calc.setOnClickListener(new TextView.OnClickListener() {
                    TextView result = ((TextView)findViewById(R.id.txtResult));
                    TextView pay = ((TextView)findViewById(R.id.txtTotal));
                    @Override
                    public void onClick(View view) {
                        tab = parseDouble(bill.getText().toString());
                        DecimalFormat currency = new DecimalFormat("$###,##0.00");
                        lotChoice = group.getSelectedItem().toString();
                        double t = Double.parseDouble(lotChoice);
                        tip = tab * t;
                        total = tip + tab;
                        String tp = String.valueOf(currency.format(tip));
                        String ttl = String.valueOf(currency.format(total));
                        result.setText("Tip " + tp);
                        pay.setText("Pay " + ttl);
                    }
                });
        ArrayAdapter adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.txtGroup, android.R.layout.simple_spinner_item);
        group.setAdapter(adapter);


    }

}
