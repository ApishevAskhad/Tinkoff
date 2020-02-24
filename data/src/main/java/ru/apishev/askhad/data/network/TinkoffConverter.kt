package ru.apishev.askhad.data.network

import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import ru.apishev.askhad.data.network.dto.TinkoffResponse
import java.lang.reflect.Type

class TinkoffConverter : Converter.Factory() {
    override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val responseType = TypeToken
                .getParameterized(TinkoffResponse::class.java, type)
                .type
        val delegate = retrofit.nextResponseBodyConverter<TinkoffResponse<*>>(this, responseType, annotations)
        return Converter<ResponseBody, Any> { body ->
            val response = delegate.convert(body)
            response?.payload
        }
    }
}
