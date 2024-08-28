package template.app

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import template.app.DI.initKoin

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        if(BuildConfig.DEBUG)
        Napier.base(DebugAntilog())
    }
}