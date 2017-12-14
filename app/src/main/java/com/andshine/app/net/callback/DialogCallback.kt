package com.andshine.app.net.callback

import android.app.Activity
import com.lzy.okgo.request.Request
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * 描    述：对于网络请求是否需要弹出进度对话框
 */
abstract class DialogCallback<T>(act: Activity) : JsonCallback<T>() {

    private var dialog: QMUITipDialog? = null
    private var isShow: Boolean = true
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

    constructor(act: Activity, isShow: Boolean) : this(act) {
        this.isShow = isShow
    }

    override fun onStart(request: Request<T, out Request<*, *>>?) {
        if (dialog != null && isShow && activity.hasWindowFocus()) {
            dialog?.show()
        }
    }

    override fun onFinish() {
        //网络请求结束后关闭对话框
        if (dialog != null) {
            dialog?.dismiss()
        }
    }
}
