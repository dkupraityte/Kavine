package com.example.moksleivis.kavine;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewPost extends LoggedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);


        final EditText pavadinimas = (EditText) findViewById(R.id.pavadinimasText);

        final Spinner rusys = (Spinner) findViewById(R.id.rusysSelect);
        List<String> list = new ArrayList<String>();
        list.add("Vištienos kepsnys");
        list.add("Jautienos kepsnys");
        list.add("Kiaulienos kepsnys");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rusys.setAdapter(dataAdapter);


        final EditText kiekis = (EditText) findViewById(R.id.kiekisText);


        final CheckBox garnyraiBulves = (CheckBox) findViewById(R.id.garnyraiBulves);
        final CheckBox garnyraiMorkos = (CheckBox) findViewById(R.id.garnyraiMorkos);
        final CheckBox garnyraiDarzoves = (CheckBox) findViewById(R.id.garnyraiDarzoves);

        final RadioGroup padazai = (RadioGroup) findViewById(R.id.padazaiRadioGroup);
        final RadioButton[] padazas = new RadioButton[1];


        Button saugoti = (Button) findViewById(R.id.submitButton);
        saugoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = padazai.getCheckedRadioButtonId();
                padazas[0] = (RadioButton) findViewById(selectedId);

               StringBuffer garnyrai = new StringBuffer();
                garnyrai.append("Gruzdintos bulvės su rozmarinais")
                        .append(garnyraiBulves.isChecked());

                garnyrai.append("Morkų traškučiai")
                        .append(garnyraiMorkos.isChecked());

                garnyrai.append("Daržovės")
                        .append(garnyraiDarzoves.isChecked());

                Toast.makeText(NewPost.this,
                        pavadinimas.getText() + "\n" +
                                String.valueOf(rusys.getSelectedItem()) + "\n" +
                                kiekis.getText() + "\n" +
                                garnyrai.toString() +
                                padazas[0].getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
