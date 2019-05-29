package me.okawa.graphqlsample.di.module

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import me.okawa.graphqlsample.BuildConfig
import okhttp3.OkHttpClient
import javax.inject.Singleton
import com.apollographql.apollo.response.CustomTypeValue
import com.apollographql.apollo.response.CustomTypeAdapter
import com.apollographql.apollo.sample.type.CustomType
import java.lang.Exception
import java.lang.RuntimeException
import java.net.URI


@Module
class ApiModule {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
        private const val AUTHORIZATION_PREFIX = "Bearer "
    }

    @Singleton
    @Provides
    fun provideCustomTypeAdapter(): CustomTypeAdapter<URI> {
        return object : CustomTypeAdapter<URI> {
            override fun encode(value: URI): CustomTypeValue<*> {
                return CustomTypeValue.GraphQLString(value.toString())
            }

            override fun decode(value: CustomTypeValue<*>): URI {
                return try {
                    URI.create(value.value.toString())
                } catch (exception: Exception) {
                    throw RuntimeException(exception)
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val builder = request
                    .newBuilder()
                    .method(request.method(), request.body())
                    .addHeader(AUTHORIZATION_HEADER, "$AUTHORIZATION_PREFIX${BuildConfig.GITHUB_DEVELOPERS_TOKEN}")
                chain.proceed(builder.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideApolloApi(okHttpClient: OkHttpClient, uriTypeAdapter: CustomTypeAdapter<URI>): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BuildConfig.BASE_URL)
            .okHttpClient(okHttpClient)
            .addCustomTypeAdapter(CustomType.URI, uriTypeAdapter)
            .build()
    }

}