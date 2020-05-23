package com.niss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_input.view.*
import kotlinx.android.synthetic.main.view_input.view.titleTextView
import kotlinx.android.synthetic.main.view_output.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        showKeyboard()
    }

    fun setupViews() {
        highInput.titleTextView.text = "High"
        lowInput.titleTextView.text = "Low"
        closeInput.titleTextView.text = "Close"
        highInput.editText.imeOptions = EditorInfo.IME_ACTION_NEXT
        lowInput.editText.imeOptions = EditorInfo.IME_ACTION_NEXT
        closeInput.editText.imeOptions = EditorInfo.IME_ACTION_DONE
        //
        r3Output.titleTextView.text = "R1"
        r2Output.titleTextView.text = "R2"
        r1Output.titleTextView.text = "R1"
        s1Output.titleTextView.text = "S1"
        s2Output.titleTextView.text = "S2"
        s3Output.titleTextView.text = "S3"
        deltaOutput.titleTextView.text = "Delta"
        rangeOutput.titleTextView.text = "Range"
    }

    fun calc(view: View) {

    }
    fun clear(view: View) {
        highInput.editText.setText("")
        lowInput.editText.setText("")
        closeInput.editText.setText("")
        //
        r3Output.dataTextView.text = "-"
        r2Output.dataTextView.text = "-"
        r1Output.dataTextView.text = "-"
        s1Output.dataTextView.text = "-"
        s2Output.dataTextView.text = "-"
        s3Output.dataTextView.text = "-"
        deltaOutput.dataTextView.text = "-"
        rangeOutput.dataTextView.text = "-"
        //
        showKeyboard()
    }

    fun showKeyboard() {
        highInput.requestFocus()
        (getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager)?.toggleSoftInputFromWindow(highInput.applicationWindowToken, InputMethodManager.SHOW_FORCED, 0)
    }
}