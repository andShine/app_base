package com.andshine.app.net.callback

import com.andshine.app.entity.BaseEntity
import com.andshine.app.entity.SimpleEntity
import com.andshine.app.net.Convert
import com.google.gson.stream.JsonReader
import com.lzy.okgo.request.Request
import okhttp3.Response
import java.lang.reflect.ParameterizedType

/**
 * 默认将返回的数据解析成需要的Bean,可以是 BaseBean，String，List，Map
 */

abstract class JsonCallback<T> : BaseCallback<T>() {

    override fun onStart(request: Request<T, out Request<*, *>>?) {
        super.onStart(request)
        // 主要用于在所有请求之前添加公共的请求头或请求参数
        // 例如登录授权的 token
        // 使用的设备信息
        // 可以随意添加,也可以什么都不传
        // 还可以在这里对所有的参数进行加密，均在这里实现
        /*request.headers("header1", "HeaderValue1")//
                .params("params1", "ParamsValue1")//
                .params("token", "3215sdf13ad1f65asd4f3ads1f");*/
    }

    @Throws(Throwable::class)
    override fun convertResponse(response: Response): T? {
        // 接受的参数是，Response<BaseEntity<UserDetailEntity>>
        val genType = javaClass.genericSuperclass
        val params = (genType as ParameterizedType).actualTypeArguments
        // 这里得到第二层泛型的所有的类型，BaseEntity<UserDetailEntity>
        val type = params[0] as? ParameterizedType ?: throw IllegalStateException("没有填写泛型参数")

        // 这里得到第二层数据的真实类型，BaseEntity
        val rawType = type.rawType
        // 这里得到第二层数据的泛型的真是类型，UserDetailEntity
        val typeArgument = type.actualTypeArguments[0]

        val body = response.body() ?: return null
        val jsonReader = JsonReader(body.charStream())
        if (rawType !== BaseEntity::class.java) {
            val data = Convert.fromJson<T>(jsonReader, type)
            response.close()
            return data
        } else {
            if (typeArgument === Void::class.java) {
                // 无数据类型，new DialogCallback<BaseEntity<Void>>() 以这种形式传递的数据
                val simpleResponse = Convert.fromJson<SimpleEntity>(jsonReader, SimpleEntity::class.java)
                response.close()

                return simpleResponse.toBaseEntity() as T
            } else {
                // 有数据，
                val baseEntiy = Convert.fromJson<BaseEntity<*>>(jsonReader, type)
                response.close()
                val status = baseEntiy.status
                if (status) {
                    // 接口访问正常，但不保证返回数据正常
                    return baseEntiy as T
                } else {
                    throw IllegalStateException("错误信息：" + baseEntiy.msg)
                }
            }
        }
    }
}
