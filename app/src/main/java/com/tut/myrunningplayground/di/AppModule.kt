package com.tut.myrunningplayground.di

import android.content.Context
import com.tut.myrunningplayground.db.RunDao
import com.tut.myrunningplayground.db.RunsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): RunsDataBase {
        return RunsDataBase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDoa(runsDataBase: RunsDataBase): RunDao {
        return runsDataBase.getRunDao()
    }


}