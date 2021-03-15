    protected operator fun <T> LiveData<T>.invoke(consumer: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer(consumer))
    }

    protected operator fun LiveData<Unit>.invoke(consumer: () -> Unit) {
        observe(viewLifecycleOwner, { consumer() })
    }
