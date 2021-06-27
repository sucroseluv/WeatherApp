package com.morlag.weatherapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.morlag.weatherapp.data.local.daos.CityDao
import com.morlag.weatherapp.data.local.entities.City
import com.morlag.weatherapp.utils.ResourceFetcher
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase{
            val tempInst = INSTANCE
            if(tempInst != null) {
                return tempInst
            }
            synchronized(this){
                return buildDatabase(context).also { INSTANCE = it }
            }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                "local_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Completable.fromAction {
                            ResourceFetcher(context).fillCities(getDatabase(context))
                        }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()

                    }
                })
                .build()
    }

}