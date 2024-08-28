package template.app.DI

import org.koin.core.context.startKoin
import org.koin.dsl.module
import template.app.common.NetworkClient
import template.app.launches.data.LaunchesRemoteService
import template.app.launches.repository.LaunchesRepository
import template.app.launches.screens.list.LaunchScreenModel
import template.app.rockets.data.RocketsRemoteService
import template.app.rockets.repository.RocketRepository

fun initKoin() {
    startKoin {
        modules(
            screenModelModule,
            repositoryModule,
            serviceModule,
            commonModule
        )
    }
}

val screenModelModule = module {
    factory { LaunchScreenModel(get(), get()) }
}

val repositoryModule = module {
    single { LaunchesRepository(get()) }
    single { RocketRepository(get()) }
}

val serviceModule = module {
    single { LaunchesRemoteService(get()) }
    single { RocketsRemoteService(get()) }
}

val commonModule = module {
    single { NetworkClient.client }
}

