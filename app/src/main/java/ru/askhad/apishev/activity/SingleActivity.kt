package ru.askhad.apishev.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.askhad.apishev.R
import ru.askhad.apishev.view_model.ActivityViewModel

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ActivityViewModel::class.java]
        viewModel.result.observe(this, Observer {

        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}
