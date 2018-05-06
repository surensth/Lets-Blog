package com.surensth.letsblog.injection.module

import android.app.Application
import android.content.Context
import com.surensth.letsblog.base.BaseView
import dagger.Module
import dagger.Provides

/**
 * Created by surensth on 5/1/18.
 */
@Module
object ContextModule {
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }


    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }

}