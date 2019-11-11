package jp.ac.asojuku.s.mytoratora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //追加したライフサイクルメソッド
    override fun onResume() {
        super.onResume()
        //ボタンがクリックされたら処理を呼び出し
        gu.setOnClickListener { onJankenButtonTapped(it); } //グーボタンを押されたら実行する処理
        choki.setOnClickListener { onJankenButtonTapped(it); } //チョキボタンを押されたら実行する処理
        pa.setOnClickListener { onJankenButtonTapped(it); } //パーボタンを押されたら実行する処理
    }

    //ボタンがクリックされたら呼び出される処理
    fun onJankenButtonTapped(view : View?){
        //画面遷移のためのインテントのインスタンスを作る
        val intent = Intent(this, ResultActivity::class.java);

        //インテントにおまけ情報を(extra)でどのボタンを選んだかを設定する
        intent.putExtra("MY_HAND", view?.id);

        //OSにインテントを引き渡して画面遷移をしてもらう
        startActivity(intent);
    }

}
