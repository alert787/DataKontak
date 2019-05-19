//15-05-2019
//Muhammad Ilyas
//10116339
//IF -8

package com.example.datakontak.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datakontak.fragment.KontakFragment;
import com.example.datakontak.model.ContactModel;
import com.example.datakontak.R;

public class TambahActivity extends AppCompatActivity {

    EditText nama, NIM, kelas, telepon, email, fb,gambar;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        nama = (EditText) findViewById(R.id.nama);
        NIM = (EditText) findViewById(R.id.nim);
        kelas = (EditText) findViewById(R.id.kelas);
        telepon = (EditText) findViewById(R.id.telepon);
        email = (EditText) findViewById(R.id.email);
        fb = (EditText) findViewById(R.id.fb);
        bt = (Button) findViewById(R.id.check);

        onbtnClick();

    }

    public void onbtnClick(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KontakFragment.tambah(new ContactModel(nama.getText().toString(),
                        NIM.getText().toString(),
                        kelas.getText().toString(),
                        telepon.getText().toString(),
                        email.getText().toString(),
                        fb.getText().toString(),
                        R.drawable.people
                ));

                Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
