package me.okawa.graphqlsample.di.module

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import me.okawa.graphqlsample.BuildConfig
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val builder = request.newBuilder().addHeader(AUTHORIZATION_HEADER, BuildConfig.GITHUB_DEVELOPERS_TOKEN)
                chain.proceed(builder.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideApolloApi(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BuildConfig.BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

}