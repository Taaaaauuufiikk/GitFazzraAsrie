package com.example.pljc_pc.project01;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //MENAMBAHKAN OBJECK KALENDER
    Calendar Kalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* INI ADALAH CASTING COMPONENTS */
        final EditText na = (EditText) findViewById(R.id.etNama);
        final EditText alamat = (EditText) findViewById(R.id.etAlamat);
        final EditText tempat_lahir = (EditText) findViewById(R.id.etTempat);
        final EditText tanggal_lahir = (EditText) findViewById(R.id.etTanggal);
        final EditText telepon = (EditText) findViewById(R.id.etPhone);
        final Spinner kelamin = (Spinner) findViewById(R.id.spJKelamin);
        final Button tambah = (Button) findViewById(R.id.btTambah);
        final Button ulangi = (Button) findViewById(R.id.btUlangi);
        final Button batal = (Button) findViewById(R.id.btBatal);

        Kalender = Calendar.getInstance();

        //MENAMBAGKAN FASILITAS KLIK PADA TANGGAL//
        tanggal_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Kalender.set(Calendar.YEAR, year);
                        Kalender.set(Calendar.MONTH, month);
                        Kalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String format = "dd-mm-yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat(format);
                        tanggal_lahir.setText(sdf.format(Kalender.getTime()));
                    }
                },
                        Kalender.get(Calendar.YEAR), Kalender.get(Calendar.MONTH), Kalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        /*TOAST = MsgBox
        --------------------------------------------------------
        BUTTON TAMBAH DIKLIK*/
        tambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Tombol Tambah ditekan", Toast.LENGTH_SHORT).show();
            }
        });


        /*DIALOG = MsgBox WITH OPTION YES/NO
        --------------------------------------------------------
        BUTTON ULANGI DIKLIK*/
        ulangi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder alertDialogBuilder = new
                        AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage(("Ulangi data?"));
                alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //menutup dialog
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View b){
                View parentView = findViewById(R.id.main_layout_id);
                String pesan = "Test SnackBar";

                final Snackbar snackbar = Snackbar
                        .make(parentView, pesan, Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout_action_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}