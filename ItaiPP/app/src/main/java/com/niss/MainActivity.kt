package com.niss

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_input.view.*
import kotlinx.android.synthetic.main.view_input.view.titleTextView
import kotlinx.android.synthetic.main.view_output.view.*
import java.util.logging.XMLFormatter

class MainActivity : AppCompatActivity() {

    lateinit var editTexts: ArrayList<EditText>

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTexts = arrayListOf(highInput.editText, lowInput.editText, closeInput.editText)
        setupViews()
        showKeyboard()
        //
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun setupViews() {
        highInput.titleTextView.text = "High"
        lowInput.titleTextView.text = "Low"
        closeInput.titleTextView.text = "Close"
        highInput.editText.imeOptions = EditorInfo.IME_ACTION_NEXT
        lowInput.editText.imeOptions = EditorInfo.IME_ACTION_NEXT
        closeInput.editText.imeOptions = EditorInfo.IME_ACTION_DONE
        //
        pipoOutput.titleTextView.text = "PIPO"
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
        try {
            val h = highInput.editText.text.toString().toFloat()
            val l = lowInput.editText.text.toString().toFloat()
            val c = closeInput.editText.text.toString().toFloat()
            val x  = (h + l + c) / 3
            //
            val r3 = x - 2*(h-l)
            val r2 = x - (h-l)
            val r1 = 2*x - h
            val s1 = 2*x - l
            val s2 = x + (h-l)
            val s3 = x + 2*(h-l)
            val delta = h - l
            val range = delta - x
            //
            pipoOutput.dataTextView.text = x.toString()
            r3Output.dataTextView.text = r3.toString()
            r2Output.dataTextView.text = r2.toString()
            r1Output.dataTextView.text = r1.toString()
            s1Output.dataTextView.text = s1.toString()
            s2Output.dataTextView.text = s2.toString()
            s3Output.dataTextView.text = s3.toString()
            deltaOutput.dataTextView.text = delta.toString()
            rangeOutput.dataTextView.text = range.toString()
            //
            editTexts.forEach { it.clearFocus() }
        } catch (ignored: NumberFormatException) { }

    }
    fun clear(view: View) {
        editTexts.forEach { it.setText("") }
        //
        pipoOutput.dataTextView.text = "-"
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
