package kirimin.me.emojires

import android.content.Intent
import com.google.firebase.appindexing.FirebaseAppIndex
import com.google.firebase.appindexing.Indexable
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.support.v4.app.JobIntentService
import android.util.Log


class StickerIndexingService : JobIntentService() {

    companion object {
        private const val UNIQUE_JOB_ID = 42
        private const val URI = "mystickers://sticker/"
        
        private const val IS_PART_OF = "isPartOf"
        private const val HAS_STICKER = "hasSticker"
        private const val STICKER = "Sticker"
        private const val STICKER_PACK = "StickerPack"
        private const val STICKER_PACK_NAME = "emojirespack"

        fun enqueueWork(context: Context) {
            enqueueWork(context, StickerIndexingService::class.java, UNIQUE_JOB_ID, Intent())
        }
    }

    override fun onHandleWork(intent: Intent) {
        val update = FirebaseAppIndex.getInstance().update(
            Indexable.Builder(STICKER_PACK)
                .setName(STICKER_PACK_NAME)
                .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.teetee))
                .setUrl(URI + "pack/0")
                .setDescription("A sticker pack of Nihongo")
                .put(
                    HAS_STICKER,
                    Indexable.Builder(STICKER)
                        .setName("Etsu")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.etsu))
                        .setUrl(URI + "etsu")
                        .setDescription("Etsu")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Gomenne")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.gomenne))
                        .setUrl(URI + "gomenne")
                        .setDescription("Gomenne")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("kami")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.kami))
                        .setUrl(URI + "kumi")
                        .setDescription("Kami")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Kawaii")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.kawaii))
                        .setUrl(URI + "kawaii")
                        .setDescription("Kawaii")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Kusa")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.kusa))
                        .setUrl(URI + "kusa")
                        .setDescription("Kusa")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Ohayou")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.ohayou))
                        .setUrl(URI + "ohayou")
                        .setDescription("Ohayou")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Oyasumi")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.oyasumi))
                        .setUrl(URI + "oyasumi")
                        .setDescription("Oyasumi")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Sasuga")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.sasuga))
                        .setUrl(URI + "sasuga")
                        .setDescription("Sasuga")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                        Indexable.Builder(STICKER)
                        .setName("Sasuganikusa")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.sasuganikusa))
                            .setUrl(URI + "sasuganikusa")
                        .setDescription("Sasuganikusa")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("shounin")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.shounin))
                        .setUrl(URI + "shounin")
                        .setDescription("Shounin")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Sorena")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.sorena))
                        .setUrl(URI + "sorena")
                        .setDescription("Sorena")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("suki")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.suki))
                        .setUrl(URI + "suki")
                        .setDescription("Suki")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Tasukaru")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.tasukaru))
                        .setUrl(URI + "tasukaru")
                        .setDescription("Tasukaru")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Teetee")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.teetee))
                        .setUrl(URI + "teetee")
                        .setDescription("Teetee")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Toutoi")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.toutoi))
                        .setUrl(URI + "toutoi")
                        .setDescription("Toutoi")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build(),
                    Indexable.Builder(STICKER)
                        .setName("Wakaru")
                        .setImage(convertUrlFromDrawableResId(applicationContext, R.drawable.wakaru))
                        .setUrl(URI + "wakaru")
                        .setDescription("Wakaru")
                        .put(IS_PART_OF, STICKER_PACK_NAME)
                        .build()
                )
                .build()
        )
    }

    private fun convertUrlFromDrawableResId(context: Context, drawableResId: Int): String {
        val sb = StringBuilder()
        sb.append(ContentResolver.SCHEME_ANDROID_RESOURCE)
        sb.append("://")
        sb.append(context.resources.getResourcePackageName(drawableResId))
        sb.append("/")
        sb.append(context.resources.getResourceTypeName(drawableResId))
        sb.append("/")
        sb.append(context.resources.getResourceEntryName(drawableResId))
        Log.d("test-url", Uri.parse(sb.toString()).toString())
        return Uri.parse(sb.toString()).toString()
    }
}
