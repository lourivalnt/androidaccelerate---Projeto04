package br.com.androidpro.bollyfilmes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FilmeDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);

        Intent intent = getIntent();
        Uri uri = intent.getData();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FilmeDetalheFragment fragment = new FilmeDetalheFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MainActivity.FILME_DETALHE_URI, uri);
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_filme_detalhe, fragment);

        fragmentTransaction.commit();
    }
}
