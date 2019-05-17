package ru.askhad.apishev;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ru.askhad.apishev.fragment.ContentFragment;
import ru.askhad.apishev.fragment.RecyclerFragment;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnItemClickListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.container, RecyclerFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onItemClick() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, ContentFragment.newInstance())
                .addToBackStack(ContentFragment.class.getName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0)
            finish();
        else
            fragmentManager.popBackStack();
    }
}
