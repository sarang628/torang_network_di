package com.sarang.torang.di.torang_network_di

object ApiUrl {
    //    val local = "http://192.168.55.100:8081/"
    val coffeeBean = "http://172.16.101.226:8081/"
    val starbucks = "http://172.30.42.212:8081/"
    val local = starbucks

    //    val local = "http://192.168.1.10:8081/"
    val prod = "http://sarang628.iptime.org:8081/"

    val alarm = prod
    val login = prod
    val join = prod
    val feed = prod
    val feedv1 = "${prod}feed/"
    val comment = prod
    val chat = prod
}