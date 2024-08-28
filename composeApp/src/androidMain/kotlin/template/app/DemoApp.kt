package template.app

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)
        Napier.base(DebugAntilog())
    }
}