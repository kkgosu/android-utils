fun Fragment.setupToolbar(toolbar: Toolbar, block: (ActionBar.() -> Unit)? = null) {
    (requireActivity() as AppCompatActivity).run {
        setSupportActionBar(toolbar)
        supportActionBar?.run { block?.invoke(this) }
     }
}
fun Fragment.setToolbarTitle(title: String) {
    requireActivity() as AppCompatActivity).supportActionBar!!.title = title
}

fun Fragment.shortToast(@StringRes textStringRes: Int) {
    Toast.makeText(requireContext(), textStringRes, Toast.LENGTH_SHORT).show()
}

fun Fragment.shortToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
