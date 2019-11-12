package jp.techacademy.ryota.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeSetButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.timeSetButton) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (hour in 2..9) {
                    greetingText.text = "おはよう"
                } else if (hour in 10..17) {
                    greetingText.text = "こんにちは"
                } else {
                    greetingText.text = "こんばんは"
                }
            },
            0, 0, true)
        timePickerDialog.show()
    }
}
