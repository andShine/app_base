package com.andshine.app.net.callback

import android.app.Activity
import android.graphics.Bitmap
import com.lzy.okgo.request.Request
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * 描    述：请求图图片的时候显示对话框
 */
abstract class BitmapDialogCallback(act: Activity) : BitmapCallback(1000, 1000) {

    private var dialog: QMUITipDialog? = null
    private val activity: Activity = act

    init {
        initDialog()
    }

    private fun initDialog() {
        dialog = QMUITipDialog.Builder(activity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create()
        dialog?.setCancelable(true)
    }

    override fun onStart(request: Request<Bitmap, out Request<*, *>>?) {
        if (dialog != null && activity.hasWindowFocus())
            dialog?.show()
    }

    override fun onFinish() {
        if (dialog != null)
            dialog?.dismiss()
    }
}
