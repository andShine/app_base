package com.andshine.app.net.callback

import android.graphics.Bitmap
import android.widget.ImageView
import com.lzy.okgo.convert.BitmapConvert
import okhttp3.Response

/**
 * 自定义Bitmap回调
 */

abstract class BitmapCallback : BaseCallback<Bitmap> {

    private var convert: BitmapConvert? = null

    constructor() {
        convert = BitmapConvert()
    }

    constructor(maxWidth: Int, maxHeight: Int) {
        convert = BitmapConvert(maxWidth, maxHeight)
    }

    constructor(maxWidth: Int, maxHeight: Int, decodeConfig: Bitmap.Config, scaleType: ImageView.ScaleType) {
        convert = BitmapConvert(maxWidth, maxHeight, decodeConfig, scaleType)
    }

    @Throws(Throwable::class)
    override fun convertResponse(response: Response): Bitmap? {
        val bitmap = convert?.convertResponse(response)
        response.close()
        return bitmap
    }
}
