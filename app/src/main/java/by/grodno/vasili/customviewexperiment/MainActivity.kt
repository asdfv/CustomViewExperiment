package by.grodno.vasili.customviewexperiment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import by.grodno.vasili.customviewexperiment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this
    }

    /**
     * Handler for OK element in CustomComponent
     */
    fun onCustomComponentOkClick() = Toast.makeText(this, "Override OK clicked!", Toast.LENGTH_SHORT).show()
}
