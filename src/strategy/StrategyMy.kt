package strategy

interface MyCloudDataSource {

    fun translate(text: String)

    class ToEnglish: MyCloudDataSource {

        override fun translate(text: String) {
            println("text: $text")
        }
    }

    class ToRussian: MyCloudDataSource {

        override fun translate(text: String) {
            println("текст $text")
        }
    }
}

interface MyRepository {

    fun translate(text: String)

    fun changeTargetLanguage(english: Boolean)

    class Base(
        private var cloudDataSource: MyCloudDataSource = MyCloudDataSource.ToEnglish()
    ): MyRepository {

        override fun translate(text: String) {
            cloudDataSource.translate(text)
        }

        override fun changeTargetLanguage(english: Boolean) {
            cloudDataSource = if(english) MyCloudDataSource.ToEnglish() else MyCloudDataSource.ToRussian()
        }
    }
}

interface MyViewModel {

    fun translate(text: String)

    fun changeTargetLanguage(english: Boolean)

    class Base(private val repository: MyRepository): MyViewModel {

        override fun translate(text: String) {
            repository.translate(text)
        }

        override fun changeTargetLanguage(english: Boolean) {
            repository.changeTargetLanguage(english)
        }
    }
}

class MyActivity {

//    val editText = findViewById<EditText>(R.id.editText)
//    val switch = findViewById<Switch>(R.id.switch)
//    val button = findViewById<Button>(R.id.button)

    val viewModel = MyViewModel.Base(MyRepository.Base())

    fun onCreate() {
        //switch.setOnCheckedListener {
        //  viewModel.changeTargetLanguage(false)
        //}

        //button.setOnClickListener {
        //  viewModel.translate(editText)
        //}
    }
}