package com.kaltura.playkit.plugins.youbora.pluginconfig

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class IsLiveDeserializer: JsonDeserializer<IsLive> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): IsLive? {
        json?.let {
            if (it.isJsonPrimitive) {
                return try {
                    val isLive = it.asBoolean
                    IsLive(isLive, null, null)
                } catch (exception: Exception) {
                    null
                }
            }

            if (it.isJsonObject) {
                return context?.deserialize(it, IsLive::class.java) as IsLive
            }
        }
        return null
    }
}

class CdnNodeDeserializer: JsonDeserializer<CdnNode> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CdnNode? {
        json?.let {
            if (it.isJsonPrimitive) {
                return try {
                    val parseCdnNode = it.asBoolean
                    CdnNode(parseCdnNode, null)
                } catch (exception: Exception) {
                    null
                }
            }

            if (it.isJsonObject) {
                return context?.deserialize(it, CdnNode::class.java) as CdnNode
            }
        }
        return null
    }
}

class ParseManifestDeserializer: JsonDeserializer<Manifest> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Manifest? {
        json?.let {
            if (it.isJsonPrimitive) {
                return try {
                    val parseManifest = it.asBoolean
                    Manifest(parseManifest, null)
                } catch (exception: Exception) {
                    null
                }
            }

            if (it.isJsonObject) {
                return context?.deserialize(it, Manifest::class.java) as Manifest
            }
        }
        return null
    }
}
