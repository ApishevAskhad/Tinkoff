package ru.askhad.apishev.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.askhad.apishev.R
import ru.askhad.apishev.fragment.NewsPreviewFragment
import ru.askhad.apishev.view_model.ActivityViewModel

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ActivityViewModel::class.java]
        viewModel.result.observe(this, Observer {

        })
        replaceFragment(NewsPreviewFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }

}
