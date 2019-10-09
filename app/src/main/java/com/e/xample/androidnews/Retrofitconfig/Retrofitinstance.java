package com.e.xample.androidnews.Retrofitconfig;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitinstance {

    public static Retrofit retrofit = null;

    public static Retrofit getinstance(String url) {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getSupportSel().build())
                    .build();
        }

        return retrofit;
    }

    //BERFUNGSI UNTUK MEREQUEST LINK DENGAN HTTPS
    private static OkHttpClient.Builder getSupportSel() {

        try {

            TrustManager[] trustManagersSertifikat = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            SSLContext selContext = SSLContext.getInstance("SSl");
            selContext.init(null, trustManagersSertifikat, new SecureRandom());

            SSLSocketFactory sslSocketFactory = selContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustManagersSertifikat[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

            return builder;

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

}
