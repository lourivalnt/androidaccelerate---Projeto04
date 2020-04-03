package br.com.androidpro.bollyfilmes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements MainFragment.Callback {

    public static final String KEY_FILME = "FILME";

    private boolean isTablet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_filme_detalhe) != null) {

            if(savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_filme_detalhe, new FilmeDetalheFragment())
                        .commit();
            }

            isTablet = true;
        } else {
            isTablet = false;
        }
    }

    @Override
    public void onItemSelected(ItemFilme itemFilme) {
        if (isTablet) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FilmeDetalheFragment detalheFragment = new FilmeDetalheFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(MainActivity.KEY_FILME, itemFilme);
            detalheFragment.setArguments(bundle);

            fragmentTransaction.replace(R.id.fragment_filme_detalhe, detalheFragment);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, FilmeDetalheActivity.class);
            intent.putExtra(MainActivity.KEY_FILME, itemFilme);
            startActivity(intent);
        }
    }
}
