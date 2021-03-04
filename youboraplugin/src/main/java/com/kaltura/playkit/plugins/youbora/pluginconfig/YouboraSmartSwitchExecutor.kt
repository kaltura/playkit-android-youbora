package com.kaltura.playkit.plugins.youbora.pluginconfig

import android.net.Uri
import android.os.Bundle
import androidx.annotation.Nullable
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

internal class YouboraSmartSwitchExecutor {

    private val smartSwitchUrl = "http://cdnbalancer.youbora.com/orderedcdn"
    private val smartSwitchExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    fun sendRequestToYoubora(accountCode: String, originCode: String, resource: String, @Nullable optionalParams: HashMap<String, String>?): Future<String> {
        val sendConfigToYoubora = SendConfigToYoubora(smartSwitchUrl, accountCode, originCode, resource, optionalParams)
        return smartSwitchExecutor.submit(sendConfigToYoubora)
    }

    private class SendConfigToYoubora(val smartSwitchUrl: String,
                                      val accountCode: String,
                                      val originCode: String,
                                      val resource: String,
                                      val optionalParams: HashMap<String, String>?): Callable<String> {

        private val connectionReadTimeOut: Int = 120000
        private val connectionTimeOut: Int = 120000
        private val successResponseCode: Int = 200
        private val requestMethod: String = "GET"
        private val accountCodeKey = "accountCode"
        private val resourceKey = "resource"
        private val originCodeKey = "originCode"

        override fun call(): String {
            var connection: HttpURLConnection? = null
            var inputStream: InputStream? = null

            try {
                var smartSwitchUri: Uri  = Uri.parse(smartSwitchUrl)
                smartSwitchUri = appendQueryParams(smartSwitchUri)
                val url = URL(smartSwitchUri.toString())
                connection = url.openConnection() as HttpURLConnection
                connection.readTimeout = connectionReadTimeOut
                connection.connectTimeout = connectionTimeOut
                connection.requestMethod = requestMethod
                connection.doInput = true
                connection.connect()

                if (connection.responseCode == successResponseCode) {
                    inputStream = connection.inputStream
                } else {
                //    log.e("Error downloading the image. Response code = " + connection.responseMessage)
                }
              //  spritesHashMap = framesFromImageStream(inputStream, spriteSlicesCount)
            } catch (exception: IOException) {
              //  log.e(exception.toString())
            } finally {
                connection?.disconnect()
            }

            return "TEST"
        }

        private fun appendQueryParams(uri: Uri): Uri {
            val builder: Uri.Builder = uri.buildUpon()
            builder.appendQueryParameter(accountCodeKey, accountCode)
            builder.appendQueryParameter(resourceKey, resource)
            builder.appendQueryParameter(originCodeKey, originCode)

            optionalParams?.let { it ->
                if (it.isNotEmpty()) {
                    it.forEach { (queryKey, queryValue) ->
                        builder.appendQueryParameter(queryKey, queryValue)
                    }
                }
            }

            return builder.build()
        }
    }
}
