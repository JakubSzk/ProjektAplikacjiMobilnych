package com.example.gymbro.ui.theme.viewModel

class FrontHitboxes(val zmienna: Float) {

    //Triple(Pair(), Pair(), Pair())
    val miesnie: MutableMap<String, MutableList<Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>>> = mutableMapOf<String, MutableList<Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>>>(
        "klata_gora" to mutableListOf(
            Triple(Pair(zmienna*102.111f, zmienna*69.3118f), Pair(zmienna*83.1919f, zmienna*73.9332f), Pair(zmienna*103.975f, zmienna*88.6776f)),
            Triple(Pair(zmienna*128.693f, zmienna*74.1532f), Pair(zmienna*109.7744f, zmienna* 69.38509f), Pair(zmienna*107.70302f, zmienna*88.45749f))
        ),
        "klata_dol" to mutableListOf(
            Triple(Pair(zmienna*81.5389f, zmienna*76.4331f), Pair(zmienna*104.393f, zmienna*90.8108f), Pair(zmienna*90.8601f, zmienna*91.9845f)),
            Triple(Pair(zmienna*130.281f, zmienna*76.3539f), Pair(zmienna*107.4267f, zmienna* 90.7316f), Pair(zmienna*120.9597f, zmienna*91.90529f))
        ),
        "barki" to mutableListOf(
            Triple(Pair(zmienna*93.6784f, zmienna*69.0936f), Pair(zmienna*82.4239f, zmienna*64.69227f), Pair(zmienna*73.51695f, zmienna*72.61466f)),
            Triple(Pair(zmienna*118.474f, zmienna*69.0917f), Pair(zmienna*129.7285f, zmienna* 64.69037f), Pair(zmienna*138.63545f, zmienna*72.61276f)),
            Triple(Pair(zmienna*76.2973f, zmienna*85.6755f), Pair(zmienna*83.68524f, zmienna* 71.0778f), Pair(zmienna*72.84494f, zmienna*73.20511f)),
            Triple(Pair(zmienna*135.736f, zmienna*85.67f), Pair(zmienna*128.34806f, zmienna* 71.0723f), Pair(zmienna*139.18835f, zmienna*73.19961f))
        ),
        "szyja" to mutableListOf(
            Triple(Pair(zmienna*88.2323f, zmienna*65.4973f), Pair(zmienna*98.7273f, zmienna*55.59431f), Pair(zmienna*103.62958f, zmienna*69.16511f)),
            Triple(Pair(zmienna*123.505f, zmienna*65.7657f), Pair(zmienna*113.01f, zmienna* 55.8627f), Pair(zmienna*108.108f, zmienna*69.4334f))
        ),
        "brzuch" to mutableListOf(
            Triple(Pair(zmienna*104.44919f, zmienna*92.877689f), Pair(zmienna*95.818434f, zmienna*94.418153f), Pair(zmienna*95.335104f, zmienna*121.85311f)),
            Triple(Pair(zmienna*107.70327f, zmienna*93.152298f), Pair(zmienna*116.33403f, zmienna* 94.692762f), Pair(zmienna*116.81736f, zmienna*122.12772f)),
            Triple(Pair(zmienna*106.0903f, zmienna*149.39414f), Pair(zmienna*95.664345f, zmienna* 122.03254f), Pair(zmienna*104.77843f, zmienna*93.277185f)),
            Triple(Pair(zmienna*106.11521f, zmienna*149.78275f), Pair(zmienna*116.54117f, zmienna* 122.42115f), Pair(zmienna* 107.42708f, zmienna*93.665785f))
        ),
        "boki" to mutableListOf(
            Triple(Pair(zmienna*84.841468f, zmienna*90.812612f), Pair(zmienna*86.705708f, zmienna*121.25515f), Pair(zmienna* 92.988898f, zmienna*96.534341f)),
            Triple(Pair(zmienna*126.89808f, zmienna*89.631232f), Pair(zmienna*125.03384f, zmienna*120.07377f), Pair(zmienna*118.75065f, zmienna*95.352961f)),
            Triple(Pair(zmienna*91.917678f, zmienna*135.85072f), Pair(zmienna*93.160518f, zmienna*97.852555f), Pair(zmienna*86.393988f, zmienna*127.12141f)),
            Triple(Pair(zmienna*119.92443f, zmienna*135.40508f), Pair(zmienna*118.68159f, zmienna*97.406916f), Pair(zmienna*125.44812f, zmienna*126.67577f))
        )
    )


}