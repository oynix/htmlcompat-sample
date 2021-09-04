package com.oynix.htmlcompat.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.oynix.htmlcompat.sample.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        addTextView(genBold())
        addTextView(genItalic())
        addTextView(genBig())
        addTextView(genSmall())
//        addTextView(genQuote())
        addTextView(genUnderline())
        addTextView(genDelLine())
        addTextView(genSup())
        addTextView(genSub())
        addTextView(genFont())
        addTextView(genSizeLabel())
    }

    private fun addTextView(spanned: Spanned) {
        val tv = TextView(this)
        tv.text = spanned
        binding.root.addView(tv)
    }

    private fun genSizeLabel() = HtmlCompat.fromHtml(
        "自定义标签size：<size>加大字号</size>", 0, null, SizeLabel(50)
    )

    private fun genFont() = HtmlCompat.fromHtml(
        "字体样式：<font color='#873748' face='monospace'>字体颜色</font>," +
                "<font face='sans'>字体Face sans</font>", 0
    )

    private fun genSub() = HtmlCompat.fromHtml(
        "下角标：a<sup>4</sup>", 0
    )

    private fun genSup() = HtmlCompat.fromHtml(
        "上角标：2<sup>3</sup>", 0
    )

    private fun genDelLine() = HtmlCompat.fromHtml(
        "删除线：<del>删除线</del>", 0
    )

    private fun genUnderline() = HtmlCompat.fromHtml(
        "下划线：<u>下划线</u>", 0
    )

    private fun genTT() = HtmlCompat.fromHtml(
        "TypeSpace效果：<tt>TT</tt>", 0
    )

    private fun genBold() = HtmlCompat.fromHtml(
        "加粗效果：<b>加粗</b> or <strong>加粗2</strong>", 0
    )

    private fun genItalic() = HtmlCompat.fromHtml(
        "倾斜效果: <i>倾斜</i> <em>倾斜</em> <cite>倾斜</cite>", 0
    )

    private fun genBig() = HtmlCompat.fromHtml(
        "变大效果：<big>变大</big>", 0
    )

    private fun genSmall() = HtmlCompat.fromHtml(
        "变小效果：<small>变小</small>", 0
    )

    private fun genQuote() = HtmlCompat.fromHtml(
        "引用效果：<blockquote>引用</blockquote>", 0
    )
}