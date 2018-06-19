package bazarbazaraps.worldcupgoal

import android.content.Context
import android.media.MediaPlayer


class MediaPlayerSingleton private constructor()  {

    lateinit var mp: MediaPlayer
    companion object {

        val instance: MediaPlayerSingleton by lazy{ MediaPlayerSingleton() }

    }

    fun MPplay(sample: Int, context: Context?){
        this.mp = MediaPlayer.create( context, sample )
        this.mp.start()
        this.mp.isLooping = false

    }

    fun reset_sound(sample: Int, context: Context?) {
        //this.mp  = MediaPlayer.create (context, sample)

            if (this.mp.isPlaying) {

                this.mp.reset();
                this.mp = MediaPlayer.create(context, sample)

            }



    }
}

