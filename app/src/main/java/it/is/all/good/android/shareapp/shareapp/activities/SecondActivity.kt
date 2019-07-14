package it.`is`.all.good.android.shareapp.shareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.`is`.all.good.android.shareapp.shareapp.Constants.USER_MESSAGE_KEY
import it.`is`.all.good.android.shareapp.shareapp.R
import it.`is`.all.good.android.shareapp.shareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val message = bundle.getString(USER_MESSAGE_KEY)
        showToast("Received : $message")
        txvShowMessage.text = message
    }
}