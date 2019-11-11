package jp.ac.asojuku.s.mytoratora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    //グー・チョキ・パーを表す定数を定義する
    val gu = 0; val choki = 1; val pa = 2;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun onResume(){
        super.onResume()
        //じゃんけんで選んだView部品(ボタン)のidをインテントから取り出す
        val id = intent.getIntExtra("MY_HAND", 0);

        //前の画面で選んだ手を保持する定数を定義する
        val myHand : Int;

        //idの値によって処理を分岐、自分のじゃんけん画像を切り替える
        myHand = when(id){ //setImageResourceメソッドでイメージビューに画像を設定
            R.id.gu -> {myHandImage.setImageResource(R.drawable.gu); gu;} //グー画像で上書き gu;で0をmyHandに代入
            R.id.choki -> {myHandImage.setImageResource(R.drawable.choki); choki;} //チョキ画像で上書き choki;で1をmyHandに代入
            R.id.pa -> {myHandImage.setImageResource(R.drawable.pa); pa;} //パー画像で上書き pa;で2をmyHandに代入
            else -> gu;
        }

        //コンピュータの手を決める
        val comHand = (Math.random() * 3).toInt(); //0 or 1 or 2がランダムに変える

        //コンピュータの手に合わせてコンピュータの画像を切り替える
        when(comHand){ //setImageResourceメソッドでイメージビューに画像を設定
            gu -> {comHandImage.setImageResource(R.drawable.com_gu);}
            choki -> {comHandImage.setImageResource(R.drawable.com_choki);}
            pa -> {comHandImage.setImageResource(R.drawable.com_pa);}
        }

        //勝敗を判定する
        val gameResult = (comHand - myHand + 3) % 3; //計算結果が0：引き分け、1：自分が勝ち、2：相手の勝ち

        //計算結果に合わせて勝敗メッセージを切り替える
        when(gameResult){
            0 -> {resultLabel.setText(R.string.result_draw);} //引き分けメッセージで上書き
            1 -> {resultLabel.setText(R.string.result_win);} //自分の勝ちメッセージで上書き
            2 -> {resultLabel.setText(R.string.result_lose);} //相手の勝ちメッセージで上書き
        }

        //戻るボタンを押したらじゃんけん画面に遷移する
        backButton.setOnClickListener { this.finish() } //戻るボタンが押されたら結果画面を破棄する
    }
}
