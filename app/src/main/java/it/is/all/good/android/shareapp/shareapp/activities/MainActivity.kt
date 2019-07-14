package it.`is`.all.good.android.shareapp.shareapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import it.`is`.all.good.android.shareapp.shareapp.Constants.USER_MESSAGE_KEY
import it.`is`.all.good.android.shareapp.shareapp.R
import it.`is`.all.good.android.shareapp.shareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i(TAG, "ShowToast is clicked !")
            showToast(getString(R.string.show_toast_is_clicked))
        }

        btnSendToNextActivity.setOnClickListener {
            val message = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(USER_MESSAGE_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message = etUserMessage.text.toString()
            val intent = Intent()
            with(intent) {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        btnShowHobbiesList.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
