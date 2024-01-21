package com.slab11.infinitemonkey

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Esto es solo para darle información a Dagger del contexto de la App, por si le hiciese falta
 */
@HiltAndroidApp
class InfiniteMonkeyApplication : Application() {
}