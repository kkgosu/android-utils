fun View.getString(@StringRes stringResId: Int): String = context.getString(stringResId)

inline fun View.onClick(crossinline action: () -> Unit) = setOnClickListener { action.invoke() }

inline fun View.onLongClick(crossinline action: () -> Unit) {
    setOnLongClickListener {
        action()
        true
    }
}

fun EditText.getTextString(): String = text?.toString().orEmpty()

// region Visibility

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.visibleOrGone(visible: Boolean) {
    if (visible) {
        visible()
    } else {
        gone()
    }
}

inline fun EditText.doOnEditorAction(
    action: Int = EditorInfo.IME_ACTION_DONE,
    crossinline func: () -> Unit
) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == action) {
            func()
            true
        } else {
            false
        }
    }
}

fun View.showKeyboard() {
    val context = this.context ?: return
    requestFocus()
    context.getSystemService<InputMethodManager>()!!.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    context.getSystemService<InputMethodManager>()!!.hideSoftInputFromWindow(windowToken, 0)
}
