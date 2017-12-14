package com.andshine.app.net.callback

import com.lzy.okgo.convert.StringConvert
import okhttp3.Response

/**
 * 自定义String回调
 */

abstract class StringCallback : BaseCallback<String>() {

    private val convert: StringConvert = StringConvert()

    @Throws(Throwable::class)
    override fun convertResponse(response: Response): String {
        val s = convert.convertResponse(response)
        response.close()
        return s
    }
}
