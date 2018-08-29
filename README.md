MetaWeather Application 
===============================

This repository holds the source code of the MetaWeather Application, a simple Android client for the [MetaWeather.com](https://www.metaweather.com/) REST API.
This application was created by Tri Vo, as part of the technical assessment by the Volvo Cars Mobile team.

--------------------
### Development Tools ###

* Android Studio v3.1.3
* gradle-plugin v4.4
* Android SDK Build Tools v27.1.1
* MinSdkVersion 16
* CompileSDKVersion 27

--------------------
### Dependencies ###

* Android Support Tools (recyclerView, cardView) v27.1.1
* Retrofit v2.4.0
* OkHttp v3.11.0
* HttpLoggingInterceptor v3.11.0
* Dagger v2.16
* RxJava2 v2.1.13
* RxAndroid v2.0.2
* RxKotlin v2.2.0
* Picasso v2.71828

--------------------
### Application Notes ###

The application is a single Activity application. The Main Activity show cases the weather forecast for tomorrow of the cities: Gothenburg, Stockholm, Mountain View, London, New York, and Berlin, showcasing information like minimun and maximum temperature for the day, wind speed and direction, humidity, air pressure, among others.

All the information is retrieved from the open REST API supplied by [MetaWeather.com](https://www.metaweather.com/) and the official documentation for it can be found [here](https://www.metaweather.com/api/).

With more time available, it would have been ideal to include Unit Tests for the main WeatherPresenter using JUnit and Mockito. In the same lines I would have included at leasat one Instrumented test using the Android JUnit Runner and Espresso.

### Application Structure ###

The Application implemented and structured based on the MVP architectural pattern, using Dagger 2 to enable the decoupling of the View and Presenter as well as the different dependencies such as the NetworkModule. I decided to include RxJava, RxAndroid and RxKotlin to chain a couple of network calls and transform their responses dynamically from a single presenter method. 

The entire application is written using Kotlin.

The networking and API calls are done using [Retrofit](http://square.github.io/retrofit/) and I also enabled a [LoggingInterceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) to capture logs while the application is running in Debug variant, and dynamically disable them when the application is running in Relase variant. For loading network images the application relies on the [Picasso](http://square.github.io/picasso/) library.

Some minor utility functions are added inside a "utils" package to handle easily some tasks like calculating the date for tomorrow, BindingAdapters, etc.

The Application UIs use the most recent ConstraintLayout and Design Views like the RecyclerView and CardView not to be more Material Design oriented but also more performant.

Finally, with more time I would've try to use an ORM like ROOM or Sugar to expediate the offline caching of the forecasts and with them implement a Repository Pattern to abstract from where the data is actually being retrieved by the WeatherPresenter.

--------------------

### Technical requirements... ###
The Application is based from the technical specifications disclosed in the CCDP Mobile Engineer test assignment v1.1 document shared with me.