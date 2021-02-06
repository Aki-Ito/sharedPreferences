package app.ito.akki.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //"DataStore"という名前でインスタンスを生成
            val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        saveButton.setOnClickListener{
            //エディットテキストのテキストを取得
            val stringText = editText.text.toString()
            saveText.text = stringText

            //有力文字列を"Input"に書き込む
            val editor = dataStore.edit()
            editor.putString("Input", stringText)
            editor.apply()
        }

        readButton.setOnClickListener{
            //"Input"から読みだす
            val str = dataStore.getString("Input", "NoData")
            readText.text = str
        }
    }
}