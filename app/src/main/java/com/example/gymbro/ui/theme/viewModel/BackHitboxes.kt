package com.example.gymbro.ui.theme.viewModel

class BackHitboxes(val zmienna: Float) {

    //Triple(Pair(), Pair(), Pair())
    val miesnie: MutableMap<String, MutableList<Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>>> = mutableMapOf<String, MutableList<Triple<Pair<Float, Float>, Pair<Float, Float>, Pair<Float, Float>>>>(
        "gorne_plecy" to mutableListOf(
            Triple(Pair(zmienna*81.750911f, zmienna*42.909049f), Pair(zmienna*96.615573f, zmienna*34.543465f), Pair(zmienna*88.267663f, zmienna*49.196905f)),
            Triple(Pair(zmienna*98.446728f, zmienna*34.434111f), Pair(zmienna*114.17311f, zmienna*43.018403f), Pair(zmienna*106.52534f, zmienna*49.415613f)),
            Triple(Pair(zmienna*88.967813f, zmienna*48.814167f), Pair(zmienna*97.531148f, zmienna*33.559282f), Pair(zmienna*105.98677f, zmienna*49.360936f))
        ),
        "barki_szersze" to mutableListOf(
            Triple(Pair(zmienna*114.60397f, zmienna*42.526309f), Pair(zmienna*126.29104f, zmienna*52.914943f), Pair(zmienna*124.45988f, zmienna*44.111943f)),
            Triple(Pair(zmienna*81.92127f, zmienna*42.374144f), Pair(zmienna*70.2342f, zmienna*52.762778f), Pair(zmienna*72.06536f, zmienna*43.959778f)),
            Triple(Pair(zmienna*124.35217f, zmienna*61.335203f), Pair(zmienna*119.39728f, zmienna*47.1001f), Pair(zmienna*126.12947f, zmienna*52.950541f)),
            Triple(Pair(zmienna*72.139852f, zmienna*61.042739f), Pair(zmienna*77.094742f, zmienna*47.1001f), Pair(zmienna*70.362552f, zmienna*52.950541f))
        ),
        "plecy_srodek_wieksze" to mutableListOf(
            Triple(Pair(zmienna*86.113365f, zmienna*49.142228f), Pair(zmienna*98.231297f, zmienna*63.576961f), Pair(zmienna*110.40308f, zmienna*49.196905f)),
            Triple(Pair(zmienna*98.231297f, zmienna*71.942545f), Pair(zmienna*94.784418f, zmienna*63.576961f), Pair(zmienna*101.6209764f, zmienna*63.686315f))
        ),
        "barki" to mutableListOf(
            Triple(Pair(zmienna*114.8194f, zmienna*43.182434f), Pair(zmienna*112.39581f, zmienna*52.313495f), Pair(zmienna*120.47443f, zmienna*50.727861f)),
            Triple(Pair(zmienna*81.788729f, zmienna*42.880872f), Pair(zmienna*84.212319f, zmienna*52.011933f), Pair(zmienna*76.133699f, zmienna*50.426299f)),
            Triple(Pair(zmienna*121.60544f, zmienna*58.984091f), Pair(zmienna*119.93586f, zmienna*50.837216f), Pair(zmienna*112.61124f, zmienna*52.696235f)),
            Triple(Pair(zmienna*75.076659f, zmienna*58.828214f), Pair(zmienna*76.746239f, zmienna*50.681339f), Pair(zmienna*84.070859f, zmienna*52.540358f))
        ),
        "plecy" to mutableListOf(
            Triple(Pair(zmienna*110.83395f, zmienna*49.524968f), Pair(zmienna*100.49331f, zmienna*68.552281f), Pair(zmienna*117.24298f, zmienna*60.350729f)),
            Triple(Pair(zmienna*85.545612f, zmienna*49.417185f), Pair(zmienna*95.886252f, zmienna*68.444787f), Pair(zmienna*79.136582f, zmienna*60.243235f)),
            Triple(Pair(zmienna*114.33468f, zmienna*92.227718f), Pair(zmienna*106.09449f, zmienna*89.329836f), Pair(zmienna*116.00426f, zmienna*61.280526f)),
            Triple(Pair(zmienna*81.994344f, zmienna*92.124908f), Pair(zmienna*90.234534f, zmienna*89.227026f), Pair(zmienna*80.324764f, zmienna*61.177716f))
        ),
        "plecy_srodek" to mutableListOf(
            Triple(Pair(zmienna*101.08574f, zmienna*68.7166f), Pair(zmienna*107.81793f, zmienna*82.768594f), Pair(zmienna*115.51954f, zmienna*61.663265f)),
            Triple(Pair(zmienna*95.174175f, zmienna*68.481323f), Pair(zmienna*88.441985f, zmienna*82.533317f), Pair(zmienna*80.740374f, zmienna*61.427988f))
        ),
        "tric1" to mutableListOf(
            Triple(Pair(zmienna*118.21242f, zmienna*60.515047f), Pair(zmienna*116.00427f, zmienna*70.083526f), Pair(zmienna*120.85144f, zmienna*66.693551f)),
            Triple(Pair(zmienna*78.27303f, zmienna*60.489116f), Pair(zmienna*80.481184f, zmienna*70.057595f), Pair(zmienna*75.634014f, zmienna*66.66762f))
        ),
        "tric2" to mutableListOf(
            Triple(Pair(zmienna*117.08141f, zmienna*57.343781f), Pair(zmienna*125.21389f, zmienna*61.827296f), Pair(zmienna*126.18332f, zmienna*68.989986f)),
            Triple(Pair(zmienna*78.948485f, zmienna*57.466658f), Pair(zmienna*70.816005f, zmienna*61.950173f), Pair(zmienna*69.846575f, zmienna*69.112863f))
        ),
        "tric3" to mutableListOf(
            Triple(Pair(zmienna*121.76701f, zmienna*64.342439f), Pair(zmienna*118.53556f, zmienna*76.043321f), Pair(zmienna*128.33763f, zmienna*72.871651f)),
            Triple(Pair(zmienna*74.824322f, zmienna*63.92891f), Pair(zmienna*78.055772f, zmienna*75.629792f), Pair(zmienna*68.253703f, zmienna*72.458525f))
        ),
        "plecy_dol" to mutableListOf(
            Triple(Pair(zmienna*98.285154f, zmienna*92.337071f), Pair(zmienna*100.866805f, zmienna*69.482078f), Pair(zmienna*107.114265f, zmienna*84.68229f)),
            Triple(Pair(zmienna*98.154019f, zmienna*92.626032f), Pair(zmienna*95.56885f, zmienna*69.771039f), Pair(zmienna*89.321397f, zmienna*84.971251f)),
            Triple(Pair(zmienna*100.3856f, zmienna*71.997222f), Pair(zmienna*96.076997f, zmienna*71.887868f), Pair(zmienna*98.177438f, zmienna*90.478054f))
        ),
        "przedramie1" to mutableListOf(
            Triple(Pair(zmienna*124.02903f, zmienna*74.785749f), Pair(zmienna*120.20515f, zmienna*76.262029f), Pair(zmienna*131.94607f, zmienna*99.718468f)),
            Triple(Pair(zmienna*72.486532f, zmienna*74.663812f), Pair(zmienna*76.310412f, zmienna*76.140092f), Pair(zmienna*64.569492f, zmienna*99.59653f)),
            Triple(Pair(zmienna*132.10765f, zmienna*100.15589f), Pair(zmienna*124.83689f, zmienna*92.993191f), Pair(zmienna*119.882f, zmienna*75.988645f)),
            Triple(Pair(zmienna*63.97729f, zmienna*101.03671f), Pair(zmienna*71.24805f, zmienna*93.874012f), Pair(zmienna*76.20294f, zmienna*76.869466f))
        ),
        "przedramie2" to mutableListOf(
            Triple(Pair(zmienna*124.51374f, zmienna*74.785749f), Pair(zmienna*129.14549f, zmienna*73.090761f), Pair(zmienna*139.3784f, zmienna*98.296867f)),
            Triple(Pair(zmienna*72.257491f, zmienna*74.2467082f), Pair(zmienna*67.625741f, zmienna*72.55172f), Pair(zmienna* 57.392831f, zmienna*97.757826f)),
            Triple(Pair(zmienna*133.13094f, zmienna*99.99185f), Pair(zmienna*138.83983f, zmienna*98.132835f), Pair(zmienna*124.99846f, zmienna*75.715259f)),
            Triple(Pair(zmienna*63.431814f, zmienna*99.91152f), Pair(zmienna*57.722924f, zmienna*98.0525f), Pair(zmienna*71.564294f, zmienna*75.634924f))
        ),
        "dlon" to mutableListOf(
            Triple(Pair(zmienna*54.876033f, zmienna*97.968804f), Pair(zmienna*67.747968f, zmienna*103.16312f), Pair(zmienna*57.46119f, zmienna*115.52013f)),
            Triple(Pair(zmienna*141.02318f, zmienna*98.36839f), Pair(zmienna*128.15124f, zmienna*103.5627f), Pair(zmienna*138.43802f, zmienna*115.91971f))
        ),
        "posladki_gorne" to mutableListOf(
            Triple(Pair(zmienna*90.475821f, zmienna*89.931283f), Pair(zmienna*84.9285f, zmienna*91.899656f), Pair(zmienna*90.745105f, zmienna*96.656557f)),
            Triple(Pair(zmienna*106.17407f, zmienna*89.794512f), Pair(zmienna*111.72139f, zmienna*91.762885f), Pair(zmienna*105.90479f, zmienna*96.519786f)),
            Triple(Pair(zmienna*84.605356f, zmienna*100.15589f), Pair(zmienna*84.820786f, zmienna*92.227718f), Pair(zmienna*90.152675f, zmienna*96.492526f)),
            Triple(Pair(zmienna*111.97571f, zmienna*100.15196f), Pair(zmienna*111.76028f, zmienna*92.223786f), Pair(zmienna*106.42839f, zmienna*96.488594f))
        ),
        "posladki" to mutableListOf(
            Triple(Pair(zmienna*97.638864f, zmienna*109.94307f), Pair(zmienna*90.852823f, zmienna*90.095313f), Pair(zmienna*97.638864f, zmienna*92.665135f)),
            Triple(Pair(zmienna*99.164179f, zmienna*109.92424f), Pair(zmienna*105.95022f, zmienna*90.07648f), Pair(zmienna*99.164179f, zmienna*92.646302f)),
            Triple(Pair(zmienna*85.359361f, zmienna*108.95889f), Pair(zmienna*97.100291f, zmienna*110.05243f), Pair(zmienna*91.983829f, zmienna*94.305445f)),
            Triple(Pair(zmienna*111.43551f, zmienna*109.17968f), Pair(zmienna*99.694585f, zmienna*110.27322f), Pair(zmienna*104.81104f, zmienna*94.526241f)),
            Triple(Pair(zmienna*85.197788f, zmienna*108.30276f), Pair(zmienna*84.713071f, zmienna*100.75733f), Pair(zmienna*90.583535f, zmienna*96.929942f)),
            Triple(Pair(zmienna*111.61427f, zmienna*108.70744f), Pair(zmienna*112.09899f, zmienna*101.16201f), Pair(zmienna*106.22852f, zmienna*97.33462f))
        ),
        "uda_male" to mutableListOf(
            Triple(Pair(zmienna*99.200731f, zmienna*110.65387f), Pair(zmienna*102.27061f, zmienna*111.91144f), Pair(zmienna*99.41616f, zmienna*124.70587f)),
            Triple(Pair(zmienna*97.461019f, zmienna*110.64452f), Pair(zmienna*94.39114f, zmienna*111.90209f), Pair(zmienna*97.24559f, zmienna*124.69652f))
        ),
        "uda_srednie" to mutableListOf(
            Triple(Pair(zmienna*102.59375f, zmienna*111.96612f), Pair(zmienna*107.49478f, zmienna*111.09129f), Pair(zmienna*108.51807f, zmienna*145.1002f)),
            Triple(Pair(zmienna*93.937807f, zmienna*111.88739f), Pair(zmienna*89.036777f, zmienna*111.01256f), Pair(zmienna*87.013487f, zmienna*145.02166f)),
            Triple(Pair(zmienna*102.70147f, zmienna*113.71579f), Pair(zmienna*98.231297f, zmienna*129.95486f), Pair(zmienna*107.9795f, zmienna*144.99104f)),
            Triple(Pair(zmienna*93.681578f, zmienna*113.6105f), Pair(zmienna*98.151751f, zmienna*129.84957f), Pair(zmienna*88.403548f, zmienna*144.88575f))
        ),
        "uda_duze" to mutableListOf(
            Triple(Pair(zmienna*84.066781f, zmienna*91.407562f), Pair(zmienna*76.472879f, zmienna*108.08405f), Pair(zmienna*83.905208f, zmienna*148.92779f)),
            Triple(Pair(zmienna*112.84353f, zmienna*91.705231f), Pair(zmienna*120.43743f, zmienna*108.38171f), Pair(zmienna*112.0051f, zmienna*149.22545f)),
            Triple(Pair(zmienna*83.797494f, zmienna*108.35744f), Pair(zmienna*88.536952f, zmienna*112.62225f), Pair(zmienna*84.551498f, zmienna*145.75652f)),
            Triple(Pair(zmienna*112.77537f, zmienna*108.21193f), Pair(zmienna*108.03592f, zmienna*112.47674f), Pair(zmienna*112.02137f, zmienna*145.61101f))
        ),
        "lydki1" to mutableListOf(
            Triple(Pair(zmienna*86.113365f, zmienna*152.86453f), Pair(zmienna*91.122111f, zmienna*149.41988f), Pair(zmienna*92.414689f, zmienna*171.39904f)),
            Triple(Pair(zmienna*110.09283f, zmienna*152.87427f), Pair(zmienna*105.08408f, zmienna*149.42962f), Pair(zmienna*103.7915f, zmienna*171.40978f)),
            Triple(Pair(zmienna*91.229826f, zmienna*168.50216f), Pair(zmienna*87.890662f, zmienna*169.86909f), Pair(zmienna*86.274937f, zmienna*153.57534f)),
            Triple(Pair(zmienna*104.47963f, zmienna*169.78005f), Pair(zmienna*107.81879f, zmienna*171.14798f), Pair(zmienna*109.43451f, zmienna*154.85423f))
        ),
        "lydki2" to mutableListOf(
            Triple(Pair(zmienna*114.11925f, zmienna*148.21698f), Pair(zmienna*116.70441f, zmienna*170.79858f), Pair(zmienna*107.94893f, zmienna*167.13523f)),
            Triple(Pair(zmienna*81.796597f, zmienna*148.46235f), Pair(zmienna*79.211437f, zmienna*170.04395f), Pair(zmienna*87.966917f, zmienna*166.3806f)),
            Triple(Pair(zmienna*113.84996f, zmienna*148.98246f), Pair(zmienna*110.45695f, zmienna*150.89616f), Pair(zmienna*109.32588f, zmienna*165.00283f)),
            Triple(Pair(zmienna*82.057368f, zmienna*149.04766f), Pair(zmienna*85.450378f, zmienna*150.96136f), Pair(zmienna*86.581448f, zmienna*165.06803f))
        )
    )
}