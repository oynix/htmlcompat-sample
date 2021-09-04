package com.oynix.htmlcompat.sample

import android.text.Editable
import android.text.Html
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import org.xml.sax.XMLReader
import java.util.*

/**
 * author: xiaoyu
 * date: 2021/9/4 11:42 上午
 * email: xiaoyu@palmax.cn
 * description:
 */
class SizeLabel(private val size: Int) : Html.TagHandler {
    // 记录开始的角标和结束的角标
    private var startIndex = 0
    private var stopIndex = 0

    // 这个方法会被调用两次，开始标签调用一次，opening=true，结束标签调用一次，opening=false
    // output就是实时解析出来的内容
    override fun handleTag(opening: Boolean, tag: String, output: Editable, xmlReader: XMLReader?) {
        // tag就是标签的名字，这个名字不可与系统支持的重复，因为自定义的标签是放在判断的最后一个else里处理的
        if (tag.lowercase(Locale.getDefault()) == "size") {
            if (opening) {
                startIndex = output.length
            } else {
                stopIndex = output.length
                output.setSpan(
                    AbsoluteSizeSpan(size),
                    startIndex,
                    stopIndex,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }

}