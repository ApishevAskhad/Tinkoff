package ru.askhad.apishev.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity.*
import ru.apishev.askhad.data.network.TinkoffApi
import ru.askhad.apishev.R
import ru.askhad.apishev.view_model.ActivityViewModel

class SingleActivity : AppCompatActivity() {
    val compositeDisposable = CompositeDisposable()
    val service = TinkoffApi.create()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ActivityViewModel::class.java]
        viewModel.result.observe(this, Observer {

        })

        val request = service
                .getContentById("10024")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { content ->
                    Log.d("ji39", content.content)
                }

        make_request.setOnClickListener {
            compositeDisposable.add(request)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }
}
