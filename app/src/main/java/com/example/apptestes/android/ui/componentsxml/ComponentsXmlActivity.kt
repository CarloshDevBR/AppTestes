package com.example.apptestes.android.ui.componentsxml

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.DatePicker
import android.widget.FrameLayout
import android.widget.SeekBar
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apptestes.R
import com.example.apptestes.databinding.ActivityComponentsXmlBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class ComponentsXmlActivity : AppCompatActivity(),
    View.OnClickListener,
    AdapterView.OnItemSelectedListener,
    SeekBar.OnSeekBarChangeListener,
    CompoundButton.OnCheckedChangeListener,
    TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    private val binding by lazy {
        ActivityComponentsXmlBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)

        // Adquirindo string array XML
        /* resources.getStringArray(
            R.array.weight_array
        )*/

        binding.buttonGetSpinner.setOnClickListener(this)
        binding.buttonSetSpinner.setOnClickListener(this)

        binding.spinnerDinamic.onItemSelectedListener = this

        binding.seekbar.setOnSeekBarChangeListener(this)
        binding.seekbar.progress = 25

        binding.switchOnOff.setOnCheckedChangeListener(this)
        binding.switchOnOff.isChecked = true

        binding.checkboxOnOff.setOnCheckedChangeListener(this)
        binding.checkboxOnOff.isChecked = true

        binding.radioYes.setOnCheckedChangeListener(this)
        binding.radioYes.isChecked = true

        binding.buttonProgress.setOnClickListener(this)

        binding.buttonTimerPicker.setOnClickListener(this)

        binding.buttonDatePicker.setOnClickListener(this)

        binding.toggleOne.setOnClickListener(this)

        binding.toggleTwo.setOnClickListener(this)

        binding.buttonAlertDialog.setOnClickListener(this)

        loadSpinner()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_toast -> toast("Chamou o toast!")
            R.id.button_snack -> snack("Chamou o toast!")
            R.id.button_get_spinner -> {
                val str = binding.spinnerDinamic.selectedItem

                val id1 = binding.spinnerDinamic.selectedItemId

                val id2 = binding.spinnerDinamic.selectedItemPosition
            }

            R.id.button_set_spinner -> {
                binding.spinnerDinamic.setSelection(2)
            }

            R.id.button_progress -> {
                // binding.progressBar.visibility = View.GONE
                // binding.progressBar.visibility = View.VISIBLE

                binding.progressBar.incrementProgressBy(5)
            }

            R.id.button_timer_picker -> {
                TimePickerDialog(this, this, 20, 15, true).show()
            }

            R.id.button_date_picker -> {
                val calendar = Calendar.getInstance()

                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(this, this, year, month, dayOfMonth).show()
            }

            R.id.toggle_one -> toast("Toggle 01")

            R.id.toggle_two -> toast("Toggle 02")

            R.id.button_alert_dialog -> alertDialog()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        toast("$position - $id")
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        toast("NOTHING")
    }

    override fun onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) {
        binding.textSeekbar.text = "$progress - $fromUser"
    }

    override fun onStartTrackingTouch(seekbar: SeekBar) {
        toast("Start")
    }

    override fun onStopTrackingTouch(seekbar: SeekBar) {
        toast("Stop")
    }

    override fun onCheckedChanged(button: CompoundButton, isChecked: Boolean) {
        when (button.id) {
            R.id.switchOnOff -> toast("Switch: $isChecked")
            R.id.checkbox_on_off -> toast("Checkbox: $isChecked")
            R.id.radio_yes -> toast("Radio: $isChecked")
            R.id.radio_no -> toast("Radio: $isChecked")
        }
    }

    override fun onTimeSet(timerPicker: TimePicker, hourOfDay: Int, minute: Int) {
        binding.textTimerPicker.text = "$hourOfDay:$minute"
    }

    override fun onDateSet(datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        binding.textDatePicker.text = "$dayOfMonth/${(month + 1).toString().padStart(2, '0')}/$year"
    }

    private fun snack(message: String) {
        val snack = Snackbar.make(binding.linearRoot, message, Snackbar.LENGTH_LONG)

        snack
            .setTextColor(Color.MAGENTA)
            .setBackgroundTint(Color.GREEN)
            .setActionTextColor(Color.BLUE)
            .setTextMaxLines(4)
            .setAction("teste") {
                Snackbar.make(binding.linearRoot, message, Snackbar.LENGTH_LONG).show()
            }

        val snackbarView = snack.view

        val params = snackbarView.layoutParams as FrameLayout.LayoutParams

        params.gravity = Gravity.TOP

        snackbarView.layoutParams = params

        snack.show()
    }

    private fun alertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Hello world")
            .setMessage("Estou aqui para te animar")
            .setCancelable(false)
            .setIcon(R.drawable.ic_launcher_foreground)
            .setNegativeButton("Fechar") { dialog, posicao ->
                toast("Fechado")
            }
            .setPositiveButton("OK OK") { dialog, posicao ->
                toast("kiss kiss")
            }
            .setNeutralButton("precisa de ajuda?") { dialog, posicao ->
                toast("ajuda sim")
            }
            .show()
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun loadSpinner() {
        val list = listOf("Selecione um item", "Gramas", "Kg", "Arroba", "Tonelada")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        binding.spinnerDinamic.adapter = adapter
    }
}