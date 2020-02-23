package ru.askhad.apishev.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.askhad.apishev.R;
import ru.askhad.apishev.fragment.ContentFragment;
import ru.askhad.apishev.fragment.RecyclerFragment;
import ru.askhad.apishev.recycler.NewsAdapter;

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
