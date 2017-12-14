package com.andshine.app.net.callback

import com.lzy.okgo.callback.AbsCallback
import com.lzy.okgo.exception.HttpException
import com.lzy.okgo.exception.StorageException
import com.lzy.okgo.request.Request

import okhttp3.Response
import java.lang.IllegalStateException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 自定义BaseCallback
 */

abstract class BaseCallback<T> : AbsCallback<T>() {
    override fun onStart(request: Request<T, out Request<*, *>>?) {
        super.onStart(request)
    }

    @Throws(Throwable::class)
    override fun convertResponse(response: Response): T? {
        return null
    }

    override fun onError(response: com.lzy.okgo.model.Response<T>?) {
        super.onError(response)
        if (response != null) {
            val exception = response.exception
            exception?.printStackTrace()
            if (exception is UnknownHostException || exception is ConnectException) {
                println("网络连接失败，请连接网络!")
            } else if (exception is SocketTimeoutException) {
                println("网络请求超时!")
            } else if (exception is HttpException) {
                println("服务端响应码:${exception.code()}")
            } else if (exception is StorageException) {
                println("SD卡不存在或者没有权限")
            } else if (exception is IllegalStateException) {
                println(exception.message)
            }
        }
    }
}
