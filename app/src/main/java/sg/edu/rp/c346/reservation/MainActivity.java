package sg.edu.rp.c346.reservation;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTele;
    EditText etSize;
    EditText etDay;
    EditText etTime;
    CheckBox cbSmoking;
    Button btReserve;
    Button btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTele = findViewById(R.id.editTextTele);
        etSize = findViewById(R.id.editTextSize);
        etDay = findViewById(R.id.editTextDay);
        etTime = findViewById(R.id.editTextTime);
        cbSmoking = findViewById(R.id.checkBoxSmoking);
        btReserve = findViewById(R.id.buttonReserve);
        btReset = findViewById(R.id.buttonReset);

        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.dialog, null);

                final EditText etName = viewDialog.findViewById(R.id.editTextName);
                final EditText etTele = viewDialog.findViewById(R.id.editTextName);
                final EditText etSize = viewDialog.findViewById(R.id.editTextName);
                final EditText etDay = viewDialog.findViewById(R.id.editTextName);
                final EditText etTime = viewDialog.findViewById(R.id.editTextName);


                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this );
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = etName.getText().toString();
                        String tele = etTele.getText().toString();
                        String size = etSize.getText().toString();
                        String day = etDay.getText().toString();
                        String time = etTime.getText().toString();
                        myBuilder.setMessage(name);
                        myBuilder.setMessage(tele);
                        myBuilder.setMessage(size);
                        myBuilder.setMessage(day);
                        myBuilder.setMessage(time);
                        if (cbSmoking.isChecked()== true){
                            myBuilder.setMessage("Smoking");
                        }

                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });



        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etDay.setText("");
                etSize.setText("");
                etTele.setText("");
                etTime.setText("");
                cbSmoking.setChecked(false);
            }
        });

    }
}
