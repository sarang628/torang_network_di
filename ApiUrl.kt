package com.sarang.torang.di.torang_network_di

object ApiUrl {
    //    val local = "http://192.168.55.100:8081/"
    val emulator = "http://10.0.2.2:8081/"
    val coffeeBean = "http://172.16.101.226:8081/"
    val starbucks = "http://172.30.42.212:8081/"
    val local = emulator

    //    val local = "http://192.168.1.10:8081/"
    val prod = "http://sarang628.iptime.org:8081/"

    val alarm = "${prod}api/alarm/"
    val login = prod
    val join = prod
    val feed = prod
    val feedv1 = "${prod}feed/"
    val comment = "${prod}api/comment/"
    val commentLike = "${local}api/commentLike/"
    val chat = "${local}api/chat/"

    val menu = "${prod}api/menu/"
}