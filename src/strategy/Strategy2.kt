package strategy

interface CloudDataSource {

    fun translate(text: String)

    class ToEnglish : CloudDataSource {

        override fun translate(text: String) {
            println("text $text")
        }
    }

    class ToRussian : CloudDataSource {

        override fun translate(text: String) {
            println("текст $text")
        }
    }
}

interface Repository {

    fun changeTargetLanguage(english: Boolean)

    fun translate(text: String)

    class Base: Repository {

        private lateinit var cloudDataSource: CloudDataSource

        private val russianCloudDataSource by lazy { CloudDataSource.ToRussian() }
        private val englishCloudDataSource by lazy { CloudDataSource.ToEnglish() }

        override fun changeTargetLanguage(english: Boolean) {
            cloudDataSource = if (english) this.englishCloudDataSource else russianCloudDataSource
        }

        override fun translate(text: String) {
            cloudDataSource.translate(text)
        }
    }
}

interface ViewModel {

    fun translate(text: String)

    fun changeTargetLanguage(english: Boolean)

    class Base(private val repository: Repository) : ViewModel {

        override fun translate(text: String) {
            repository.translate(text)
        }

        override fun changeTargetLanguage(english: Boolean) {
            repository.changeTargetLanguage(english)
        }
    }
}

class Activity {

    private val editText: String? = null
    private val switch = Switch.Base()

    private val viewModel = ViewModel.Base(Repository.Base())

    fun onCreate() {
        val button = Button.Base()

        switch.setCheckedListener {
            viewModel.changeTargetLanguage(it)
        }

        button.setOnCLickListener {
            viewModel.translate(editText!!)
        }
    }
}

interface Switch {

    fun isChecked(): Boolean

    fun setCheckedListener(block: (Boolean) -> Unit)

    class Base : Switch {

        private var checked = false

        override fun isChecked() = checked

        override fun setCheckedListener(block: (Boolean) -> Unit) {
            //todo
        }
    }
}

interface Button {

    fun setOnCLickListener(block: () -> Unit)

    class Base : Button {
        override fun setOnCLickListener(block: () -> Unit) {
            TODO("Not yet implemented")
        }
    }
}
