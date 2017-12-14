package com.andshine.app.net.callback

import android.app.Activity
import com.lzy.okgo.request.Request
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * 对于网络请求是否需要弹出进度对话框
 */
abstract class StringDialogCallback(act: Activity) : StringCallback() {

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

    override fun onStart(request: Request<String, out Request<*, *>>?) {
        if (dialog != null && activity.hasWindowFocus())
            dialog?.show()
    }

    override fun onFinish() {
        if (dialog != null)
            dialog?.dismiss()
    }
}
