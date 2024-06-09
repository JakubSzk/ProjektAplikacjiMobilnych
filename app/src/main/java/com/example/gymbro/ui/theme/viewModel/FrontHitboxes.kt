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
        ),
        "barki_szersze" to mutableListOf(
            Triple(Pair(zmienna*80.403573f, zmienna*64.798092f), Pair(zmienna*71.078385f, zmienna*74.653426f), Pair(zmienna*71.468969f, zmienna*67.49534f)),
            Triple(Pair(zmienna*132.14281f, zmienna*65.174638f), Pair(zmienna*141.468f, zmienna*75.029972f), Pair(zmienna*141.07742f, zmienna*67.871886f)),
            Triple(Pair(zmienna*72.250135f, zmienna*89.384558f), Pair(zmienna*75.863036f, zmienna*85.753645f), Pair(zmienna*69.320758f, zmienna*70.815032f)),
            Triple(Pair(zmienna*139.9871f, zmienna*89.831918f), Pair(zmienna*136.3742f, zmienna*86.201005f), Pair(zmienna*142.91648f, zmienna*71.262392f))
        ),
        "triceps" to mutableListOf(
            Triple(Pair(zmienna*76.546557f, zmienna*86.479827f), Pair(zmienna*69.760163f, zmienna*106.29423f), Pair(zmienna*69.760163f, zmienna*93.586042f)),
            Triple(Pair(zmienna*135.71766f, zmienna*86.382517f), Pair(zmienna*142.50405f, zmienna*106.19692f), Pair(zmienna*142.50405f, zmienna*93.488732f))
        ),
        "biceps" to mutableListOf(
            Triple(Pair(zmienna*139.18643f, zmienna*97.631917f), Pair(zmienna*128.39656f, zmienna*93.378558f), Pair(zmienna*129.91007f, zmienna*78.854911f)),
            Triple(Pair(zmienna*73.079019f, zmienna*97.249474f), Pair(zmienna*62.378558f, zmienna*93.378558f), Pair(zmienna*60.854911f, zmienna*78.854911f)),
            Triple(Pair(zmienna*128.78714f, zmienna*93.845396f), Pair(zmienna*136.54999f, zmienna*78.854911f), Pair(zmienna*138.14656f, zmienna*69.414531f)),
            Triple(Pair(zmienna*83.414177f, zmienna*93.360596f), Pair(zmienna*75.651327f, zmienna*78.854911f), Pair(zmienna*73.146872f, zmienna*69.414531f))
        ),
        "przedramie_gorne" to mutableListOf(
            Triple(Pair(zmienna*147.58398f, zmienna*101.47031f), Pair(zmienna*142.35993f, zmienna*112.72614f), Pair(zmienna*153.44274f, zmienna*140.6323f)),
            Triple(Pair(zmienna*64.195766f, zmienna*101.43472f), Pair(zmienna*75.419816f, zmienna*112.72614f), Pair(zmienna*64.195766f, zmienna*140.6323f))
        ),
        "przedramie_dolne" to mutableListOf(
            Triple(Pair(zmienna*149.5369f, zmienna*143.79638f), Pair(zmienna*152.61275f, zmienna*141.151f), Pair(zmienna*141.18818f, zmienna*110.54759f)),
            Triple(Pair(zmienna*62.73229f, zmienna*143.38659f), Pair(zmienna*59.65644f, zmienna*140.74121f), Pair(zmienna*71.08101f, zmienna*110.1378f)),
            Triple(Pair(zmienna*149.29279f, zmienna*143.64077f), Pair(zmienna*134.69472f, zmienna*116.77201f), Pair(zmienna*140.99288f, zmienna*110.59946f)),
            Triple(Pair(zmienna*62.929397f, zmienna*142.96966f), Pair(zmienna*77.527467f, zmienna*116.1009f), Pair(zmienna*71.229307f, zmienna*109.92835f))
        ),
        "dlon" to mutableListOf(
            Triple(Pair(zmienna*143.53167f, zmienna*146.70111f), Pair(zmienna*157.59269f, zmienna*140.58042f), Pair(zmienna*161.30324f, zmienna*163.45517f)),
            Triple(Pair(zmienna*67.88924f, zmienna*146.7778f), Pair(zmienna*53.828226f, zmienna*140.65712f), Pair(zmienna*50.117676f, zmienna*163.53187f))
        ),
        "uda1" to mutableListOf(
            Triple(Pair(zmienna*86.652913f, zmienna*133.00738f), Pair(zmienna*94.855172f, zmienna*172.58433f), Pair(zmienna*105.5474f, zmienna*154.48164f)),
            Triple(Pair(zmienna*125.63308f, zmienna*132.95083f), Pair(zmienna*117.43082f, zmienna*172.52778f), Pair(zmienna*106.73859f, zmienna*154.42509f)),
            Triple(Pair(zmienna*100.71393f, zmienna*185.75936f), Pair(zmienna*95.343401f, zmienna*172.94742f), Pair(zmienna*77.085101f, zmienna*154.68912f)),
            Triple(Pair(zmienna*111.43772f, zmienna*185.42265f), Pair(zmienna*116.80825f, zmienna*172.6107f), Pair(zmienna*106.16484f, zmienna*154.3524f))
        ),
        "uda2" to mutableListOf(
            Triple(Pair(zmienna*88.557008f, zmienna*170.76887f), Pair(zmienna*88.215247f, zmienna*148.6203f), Pair(zmienna*94.705247f, zmienna*174.34791f)),
            Triple(Pair(zmienna*123.50584f, zmienna*170.96553f), Pair(zmienna*123.8476f, zmienna*148.81795f), Pair(zmienna*118.3576f, zmienna*174.54446f)),
            Triple(Pair(zmienna*92.218731f, zmienna*187.7823f), Pair(zmienna*88.752301f, zmienna*171.23571f), Pair(zmienna*94.562236f, zmienna*174.50353f)),
            Triple(Pair(zmienna*119.77033f, zmienna*187.96489f), Pair(zmienna*123.23676f, zmienna*171.4183f), Pair(zmienna*117.42683f, zmienna*174.68612f))
        ),
        "uda3" to mutableListOf(
            Triple(Pair(zmienna*85.725275f, zmienna*133.16299f), Pair(zmienna*87.58055f, zmienna*166.35991f), Pair(zmienna*80.745334f, zmienna*165.73746f)),
            Triple(Pair(zmienna*126.44762f, zmienna*131.96967f), Pair(zmienna*124.59235f, zmienna*165.16659f), Pair(zmienna*131.42756f, zmienna*164.54414f)),
            Triple(Pair(zmienna*77.57184f, zmienna*165.63373f), Pair(zmienna*87.482903f, zmienna*166.87861f), Pair(zmienna*90.216991f, zmienna*205.47002f)),
            Triple(Pair(zmienna*134.51186f, zmienna*164.76106f), Pair(zmienna*124.6008f, zmienna*166.00594f), Pair(zmienna*121.86671f, zmienna*205.59735f))
        ),
        "uda4" to mutableListOf(
            Triple(Pair(zmienna*95.050465f, zmienna*175.43719f), Pair(zmienna*93.488128f, zmienna*198.98625f), Pair(zmienna*102.08097f, zmienna*192.24313f)),
            Triple(Pair(zmienna*117.25443f, zmienna*175.07692f), Pair(zmienna*118.81667f, zmienna*198.98625f), Pair(zmienna*109.22472f, zmienna*192.24313f))
        ),
        "lydy1" to mutableListOf(
            Triple(Pair(zmienna*96.4175065f, zmienna*209.10094f), Pair(zmienna*89.142884f, zmienna*228.24104f), Pair(zmienna*99.249241f, zmienna*231.66447f)),
            Triple(Pair(zmienna*115.58961f, zmienna*208.88366f), Pair(zmienna*122.86423f, zmienna*228.24104f), Pair(zmienna*112.75787f, zmienna*231.66447f)),
            Triple(Pair(zmienna*94.562234f, zmienna*250.13025f), Pair(zmienna*98.419247f, zmienna*231.66447f), Pair(zmienna*89.142884f, zmienna*228.24104f)),
            Triple(Pair(zmienna*117.55311f, zmienna*249.78815f), Pair(zmienna*113.6961f, zmienna*231.66447f), Pair(zmienna*122.86423f, zmienna*228.24104f))
        ),
        "lydy2" to mutableListOf(
            Triple(Pair(zmienna*85.481162f, zmienna*205.10694f), Pair(zmienna*91.437564f, zmienna*252.20506f), Pair(zmienna*84.602349f, zmienna*225.49192f)),
            Triple(Pair(zmienna*126.19986f, zmienna*205.75406f), Pair(zmienna*120.24346f, zmienna*252.20506f), Pair(zmienna*127.07868f, zmienna*225.49192f))
        ),
        "lydy3" to mutableListOf(
            Triple(Pair(zmienna*128.20126f, zmienna*214.33983f), Pair(zmienna*126.88304f, zmienna*229.90088f), Pair(zmienna*130.15418f, zmienna*234.25798f)),
            Triple(Pair(zmienna*83.444443f, zmienna*213.90029f), Pair(zmienna*84.762663f, zmienna*229.46134f), Pair(zmienna*81.491523f, zmienna*233.81844f)),
            Triple(Pair(zmienna*121.41487f, zmienna*256.45842f), Pair(zmienna*129.7636f, zmienna*237.94076f), Pair(zmienna*126.68775f, zmienna*230.62706f)),
            Triple(Pair(zmienna*90.133184f, zmienna*255.68452f), Pair(zmienna*81.784454f, zmienna*237.16686f), Pair(zmienna*84.860304f, zmienna*229.85316f))
        )
    )


}