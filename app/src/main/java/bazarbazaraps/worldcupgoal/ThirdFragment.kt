package bazarbazaraps.worldcupgoal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import bazarbazaraps.worldcupgoal.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ThirdFragment : Fragment() {
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var listView: ListView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        MobileAds.initialize(context, "ca-app-pub-9103822257004637~2938245107")

        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = "ca-app-pub-9103822257004637/7068513060"
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        val rootView = inflater.inflate(R.layout.fragment_third, container, false)



        val testList = arrayOf(
                "Colombia Goal 1",
                "Colombia Goal 2",
                "Colombia Goal 3",
                "Colombia Goal 4")

        val sample_names_const = arrayOf(
                "colombiagoal1",
                "colombiagoal2",
                "colombiagoal3",
                "colombiagoal4")

        val  MP_instances = ArrayList<Int>()

        MP_instances.add(R.raw.colombiagoal1)
        MP_instances.add(R.raw.colombiagoal2)
        MP_instances.add(R.raw.colombiagoal3)
        MP_instances.add(R.raw.colombiagoal4)

        val adapter = MySimpleArrayAdapter(context, testList)

        listView = rootView.findViewById(R.id.listview3)
        listView.adapter = adapter


        val mediaPlayer = MediaPlayerSingleton.instance


        fun share_audio( file_path: String ){
            val audio =  Uri.parse(file_path)

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "audio/mpeg"
            shareIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            shareIntent.putExtra(Intent.EXTRA_STREAM, audio);

            startActivity(Intent.createChooser(shareIntent, "Rick Morty SB share..."))

        }

        listView.setOnItemClickListener {

            parent, view, position, id ->
            mediaPlayer.reset_sound(MP_instances[position],context)
            // reset_sound(mediaPlayer, MP_instances[position])
            mediaPlayer.MPplay( MP_instances[position],context)
            //  mInterstitialAd.show()
            mInterstitialAd.show()
        }

        listView.setOnItemLongClickListener { parent, view, position, id ->
            share_audio("android.resource://bazarbazaraps.worldcupgoal/raw/" + sample_names_const[position])
            true
        }


        return rootView

    }

}

