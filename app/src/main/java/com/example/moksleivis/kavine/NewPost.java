package com.example.moksleivis.kavine;

import android.content.Intent;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewPost extends LoggedActivity {



    private EditText mPavadinimasView;
    private EditText mKiekisView;

    private String pavadinimas;
    private String kiekis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        mPavadinimasView = (EditText) findViewById(R.id.pavadinimasText);
        mKiekisView = (EditText) findViewById(R.id.kiekisText);

        Button saugoti = (Button) findViewById(R.id.submitButton);
        saugoti.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View v) {

        mPavadinimasView.setError(null);
        mKiekisView.setError(null);


   // public void saug() {

        String pavadinimas = mPavadinimasView.getText().toString();
        String kiekis = mKiekisView.getText().toString();


        //final EditText pavadinimas = (EditText) findViewById(R.id.pavadinimasText);

                boolean cancel = false;
                View focusView = null;

                if (!isValid(pavadinimas)) {
                    mPavadinimasView.setError("Neįvestas pavadinimas");
                    focusView = mPavadinimasView;
                    cancel = true;
                }
                if (!isValid(kiekis)) {
                    mKiekisView.setError("Neįvestas kiekis");
                    focusView = mKiekisView;
                    cancel = true;
                }
                final Spinner rusys = (Spinner) findViewById(R.id.rusysSelect);
                List<String> list = new ArrayList<String>();
                list.add("Vištienos kepsnys");
                list.add("Jautienos kepsnys");
                list.add("Kiaulienos kepsnys");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(NewPost.this,
                        android.R.layout.simple_spinner_dropdown_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                rusys.setAdapter(dataAdapter);


                //final EditText kiekis = (EditText) findViewById(R.id.kiekisText);


                final CheckBox garnyraiBulves = (CheckBox) findViewById(R.id.garnyraiBulves);
                final CheckBox garnyraiMorkos = (CheckBox) findViewById(R.id.garnyraiMorkos);
                final CheckBox garnyraiDarzoves = (CheckBox) findViewById(R.id.garnyraiDarzoves);

                final RadioGroup padazai = (RadioGroup) findViewById(R.id.padazaiRadioGroup);
                final RadioButton[] padazas = new RadioButton[1];
                int selectedId = padazai.getCheckedRadioButtonId();
                padazas[0] = (RadioButton) findViewById(selectedId);

                StringBuffer garnyrai = new StringBuffer();
                if (garnyraiBulves.isChecked()) {
                    garnyrai.append(getResources().getString(R.string.garnyrai_Bulves) + ",");
                }
                if (garnyraiMorkos.isChecked()) {
                    garnyrai.append(getResources().getString(R.string.garnyrai_Morkos) + ",");
                }
                if (garnyraiDarzoves.isChecked()) {
                    garnyrai.append(getResources().getString(R.string.garnyrai_Darzoves));
                }


                if (cancel) {
                    focusView.requestFocus();
                }

                else {

                    int kiekis_num = Integer.parseInt(kiekis);

                    Patiekalas food = new Patiekalas(pavadinimas, String.valueOf(rusys.getSelectedItem()), kiekis_num,
                            garnyrai.toString(), padazas[0].getText().toString());


                    Intent intent = new Intent(NewPost.this, NewPost.class);
                    startActivity(intent);

                   /* Toast.makeText(NewPost.this,
                            mPavadinimasView.getText() + "\n" +
                                    String.valueOf(rusys.getSelectedItem()) + "\n" +
                                    mKiekisView.getText() + "\n" +
                                    garnyrai.toString() +
                                    padazas[0].getText(), Toast.LENGTH_SHORT).show();*/

                    /*Toast.makeText(NewPost.this, pavadinimas + "" + kiekis,
                            Toast.LENGTH_SHORT).show();*/


                    Toast.makeText(NewPost.this,
                            food.getPavadinimas() +"\n" +
                            food.getRusis() + "\n" +
                            food.getKiekis() + "\n" +
                            food.getGarnyras() + "\n" +
                            food.getPadazas() + "\n", Toast.LENGTH_LONG).show();

                }
    }
        });
}
    private boolean isValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^([A-Za-z0-9]{1,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
}

