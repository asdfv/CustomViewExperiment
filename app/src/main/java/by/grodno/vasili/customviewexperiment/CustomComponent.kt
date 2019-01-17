package by.grodno.vasili.customviewexperiment

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.widget.Toast
import by.grodno.vasili.customviewexperiment.databinding.CustomComponentBinding

/**
 * Custom component with two interactive elements with customized onClick actions
 */
class CustomComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    ConstraintLayout(context, attrs, defStyle) {
    private var binding: CustomComponentBinding =
        DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.custom_component, this, true)
    private var defaultOkClickListener: OnClickListener =
        OnClickListener { Toast.makeText(context, "Default OK clicked!", Toast.LENGTH_SHORT).show() }
    private var defaultCancelClickListener: OnClickListener =
        OnClickListener { Toast.makeText(context, "Default CANCEL clicked!", Toast.LENGTH_SHORT).show() }

    init {
        binding.okLabel.setOnClickListener(defaultOkClickListener)
        binding.cancelLabel.setOnClickListener(defaultCancelClickListener)
    }

    /**
     * Setter for optional app:onCustomComponentOkClick component attribute
     */
    @Suppress("unused")
    fun setOnOkClick(runnable: Runnable) {
        binding.okLabel.setOnClickListener { runnable.run() }
    }

    /**
     * Setter for optional app:onCancelClick component attribute
     */
    @Suppress("unused")
    fun setOnCancelClick(runnable: Runnable) {
        binding.cancelLabel.setOnClickListener { runnable.run() }
    }
}
