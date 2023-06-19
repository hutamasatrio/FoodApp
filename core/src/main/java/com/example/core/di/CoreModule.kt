package com.example.core.di

import androidx.room.Room
import com.example.core.domain.repository.CategoryRepo
import com.example.core.domain.repository.DetailRepo
import com.example.core.domain.repository.FoodRepo
import com.example.core.source.db.lokal.room.FavoriteDao
import com.example.core.source.db.lokal.room.FavoriteDatabase
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.mapper.*
import com.example.core.source.repo.CategoryRepository
import com.example.core.source.repo.DetailRepository
import com.example.core.source.repo.FoodRepository
import com.example.core.utils.AppExecutors
import com.example.foodappdagger.core.data.mapper.ItemCategoriesMapper
import com.example.foodappdagger.core.data.mapper.ItemCategoriesMapperImp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return  Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideNetworkApi(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

    val networkModule = module {
        factory {

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }
        factory { provideRetrofit(get()) }
        factory { get<FavoriteDatabase>().favoriteDao() }
        single {
            Room.databaseBuilder(
                androidContext(),
                FavoriteDatabase::class.java, "Foods.db"
            ).fallbackToDestructiveMigration().build()
        }
        single<ApiService> { provideNetworkApi(get()) }

//        single {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://tourism-api.dicoding.dev/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(get())
//                .build()
//            retrofit.create(ApiService::class.java)
//        }
    }

//    fun getExecutor(): Executor {
//        return Executors.newFixedThreadPool(2)
//    }

    val repositoryModule = module {
        factory { AppExecutors() }
        factory { RemoteDataSource(get()) }

        factory<CategoryRepo> {
            CategoryRepository(
                get(),
                get(),
                get ()
            )
        }

        factory<FoodRepo> {
            FoodRepository(
                get(),
                get(),
                get()

            )
        }

        factory<DetailRepo> {
            DetailRepository(
                get(),
                get(),
                get(),
                get(),
                get()

            )
        }
    }

    val mapperModule = module {
        single<ItemCategoriesMapper> { ItemCategoriesMapperImp() }
        single<CategoryMapper> { CategoryMapperImp() }
        single<FoodMapper>{FoodMapper()}
        single<DetailMapper>{DetailMapper()}
        single { DetailEntityMapper() }

    }
