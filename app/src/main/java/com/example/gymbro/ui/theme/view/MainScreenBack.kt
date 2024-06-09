package com.example.gymbro.ui.theme.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.gymbro.ui.theme.viewModel.BackHitboxes

@Composable
fun MainScreenBack(modifier: Modifier = Modifier.fillMaxSize()){
    val zmienna = 6.5f
    val miesnie = BackHitboxes(zmienna)
    var selectedMuscle by remember { mutableStateOf("") }

    Canvas(modifier = Modifier.offset(x = (-50).dp).size((zmienna*210).dp, (zmienna*297).dp)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {tapOffset ->
                    var index = 0
                    //var porown: Pair<Float, Float> = Pair<Float, Float>(tapOffset.x, tapOffset.y)

                    val prawa: Boolean = tapOffset.x > 2
                    for (miesien in miesnie.miesnie)
                    {
                        var counter: Int = zmienna.toInt()*(81 + 130)/2
                        for (trojkot in miesien.value)
                        {
                            if(counter % 2 == 1 && prawa || counter % 2 == 0 && !prawa) {
                                val d1 =
                                    tapOffset.x * (trojkot.first.second - trojkot.second.second) + tapOffset.y * (trojkot.second.first - trojkot.first.first) + (trojkot.first.first * trojkot.second.second - trojkot.first.second * trojkot.second.first)
                                val d2 =
                                    tapOffset.x * (trojkot.second.second - trojkot.third.second) + tapOffset.y * (trojkot.third.first - trojkot.second.first) + (trojkot.second.first * trojkot.third.second - trojkot.second.second * trojkot.third.first)
                                val d3 =
                                    tapOffset.x * (trojkot.third.second - trojkot.first.second) + tapOffset.y * (trojkot.first.first - trojkot.third.first) + (trojkot.third.first * trojkot.first.second - trojkot.third.second * trojkot.first.first)
                                if ((d1 <= 0) && (d2 <= 0) && (d3 <= 0) || (d1 >= 0) && (d2 >= 0) && (d3 >= 0)) {
                                    println(miesien.key)
                                    selectedMuscle = miesien.key
                                }
                            }
                        }
                    }
                })})

    {
        val path1 = Path()

        path1.relativeMoveTo(zmienna*105.97024f, zmienna*170.46546f)
        path1.relativeMoveTo(zmienna*2.1476f, zmienna*16.13959f)
        path1.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*-4.95216f, zmienna*12.66808f, zmienna*-1.26614f, zmienna*12.93271f)
        path1.relativeCubicTo(zmienna*13.81801f, zmienna*0.99205f, zmienna*15.93666f, zmienna*5.11841f, zmienna*23.7401f, zmienna*3.43666f)
        path1.relativeCubicTo(zmienna*2.27508f, zmienna*-0.49031f, zmienna*1.41102f, zmienna*-2.87335f, zmienna*-0.4974f, zmienna*-4.20539f)
        path1.relativeCubicTo(zmienna*-1.29597f, zmienna*-0.90456f, zmienna*-4.98793f, zmienna*-1.48783f, zmienna*-9.58649f, zmienna*-3.93408f)
        path1.relativeCubicTo(zmienna*-4.7218f, zmienna*-2.51183f, zmienna*-4.7028f, zmienna*-4.88368f, zmienna*-4.7028f, zmienna*-4.88368f)
        path1.relativeLineTo(zmienna*1.98029f, zmienna*-18.86337f)
        path1.close()


        val path2 = Path()

        path2.relativeMoveTo(zmienna*107.74803f, zmienna*20.290347f)
        path2.relativeCubicTo(zmienna*0.38913f, zmienna*2.346069f, zmienna*-0.56944f, zmienna*13.000492f, zmienna*-1.90469f, zmienna*13.929799f)
        path2.relativeCubicTo(zmienna*-5.22209f, zmienna*3.634462f, zmienna*-11.15181f, zmienna*3.654476f, zmienna*-16.262483f, zmienna*-0.435734f)
        path2.relativeCubicTo(zmienna*-1.03254f, zmienna*-0.826371f, zmienna*-1.535086f, zmienna*-11.049943f, zmienna*-1.367548f, zmienna*-13.313188f)
        path2.relativeCubicTo(zmienna*0.550372f, zmienna*-7.434892f, zmienna*18.241921f, zmienna*-7.975101f, zmienna*19.534721f, zmienna*-0.180877f)
        path2.close()


        val path3 = Path()

        path3.moveTo(zmienna*82.351034f, zmienna*42.362189f)
        path3.cubicTo(zmienna*82.351034f, zmienna*42.362189f, zmienna*74.609129f, zmienna*42.26162f, zmienna*72.226052f, zmienna*44.822838f)
        path3.cubicTo(zmienna*68.246366f, zmienna*49.100025f, zmienna*71.579488f, zmienna*60.788317f, zmienna*71.579488f, zmienna*60.788317f)
        path3.cubicTo(zmienna*71.579488f, zmienna*60.788317f, zmienna*75.1862f, zmienna*60.283888f, zmienna*75.67275f, zmienna*53.133623f)
        path3.cubicTo(zmienna*76.210599f, zmienna*45.229308f, zmienna*82.351034f, zmienna*42.362189f, zmienna*82.351034f, zmienna*42.362189f)
        path3.close()
        path3.moveTo(zmienna*114.17298f, zmienna*42.526211f)
        path3.cubicTo(zmienna*114.17298f, zmienna*42.526211f, zmienna*120.31372f, zmienna*45.39333f, zmienna*120.85157f, zmienna*53.297645f)
        path3.cubicTo(zmienna*121.33812f, zmienna*60.44791f, zmienna*124.94453f, zmienna*60.95234f, zmienna*124.94453f, zmienna*60.95234f)
        path3.cubicTo(zmienna*124.94453f, zmienna*60.95234f, zmienna*128.27796f, zmienna*49.264048f, zmienna*124.29827f, zmienna*44.986861f)
        path3.cubicTo(zmienna*121.91519f, zmienna*42.425642f, zmienna*114.17298f, zmienna*42.526211f, zmienna*114.17298f, zmienna*42.526211f)
        path3.close()


        val path4 = Path()

        path4.relativeMoveTo(zmienna*92.41469f, zmienna*35.52765f)
        path4.relativeCubicTo(zmienna*0.345795f, zmienna*-1.548686f, zmienna*11.21873f, zmienna*-1.338745f, zmienna*11.42564f, zmienna*0.07442f)
        path4.relativeCubicTo(zmienna*0.71639f, zmienna*4.89283f, zmienna*8.16879f, zmienna*7.50052f, zmienna*8.16879f, zmienna*7.50052f)
        path4.relativeLineTo(zmienna*2.39923f, zmienna*-0.3093f)
        path4.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*-0.77209f, zmienna*5.687084f, zmienna*-4.18914f, zmienna*5.954023f)
        path4.relativeCubicTo(zmienna*-10.09805f, zmienna*0.788859f, zmienna*-14.293038f, zmienna*0.706174f, zmienna*-23.763768f, zmienna*0f)
        path4.relativeCubicTo(zmienna*-2.963893f, zmienna*-0.220999f, zmienna*-4.646124f, zmienna*-5.954023f, zmienna*-4.646124f, zmienna*-5.954023f)
        path4.relativeLineTo(zmienna*2.361145f, zmienna*0.3093f)
        path4.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*6.891633f, zmienna*-1.517182f, zmienna*8.244227f, zmienna*-7.57494f)
        path4.close()


        val path5 = Path()

        path5.moveTo(zmienna*81.840184f, zmienna*43.063893f)
        path5.cubicTo(zmienna*81.840184f, zmienna*43.063893f, zmienna*76.13289f, zmienna*48.203179f, zmienna*76.20391f, zmienna*50.100613f)
        path5.cubicTo(zmienna*76.38121f, zmienna*54.837335f, zmienna*74.147278f, zmienna*58.838168f, zmienna*74.147278f, zmienna*58.838168f)
        path5.cubicTo(zmienna*74.147278f, zmienna*58.838168f, zmienna*79.754925f, zmienna*57.516592f, zmienna*81.687853f, zmienna*55.551783f)
        path5.cubicTo(zmienna*83.512411f, zmienna*53.697127f, zmienna*85.810116f, zmienna*49.16702f, zmienna*84.734487f, zmienna*48.321984f)
        path5.cubicTo(zmienna*82.638449f, zmienna*46.675292f, zmienna*81.840184f, zmienna*43.063893f, zmienna*81.840184f, zmienna*43.063893f)
        path5.close()
        path5.moveTo(zmienna*114.6749f, zmienna*43.179802f)
        path5.cubicTo(zmienna*114.6749f, zmienna*43.179802f, zmienna*113.87664f, zmienna*46.791201f, zmienna*111.7806f, zmienna*48.437894f)
        path5.cubicTo(zmienna*110.70497f, zmienna*49.282929f, zmienna*113.00268f, zmienna*53.813349f, zmienna*114.82724f, zmienna*55.668004f)
        path5.cubicTo(zmienna*116.76016f, zmienna*57.632813f, zmienna*122.36781f, zmienna*58.954077f, zmienna*122.36781f, zmienna*58.954077f)
        path5.cubicTo(zmienna*122.36781f, zmienna*58.954077f, zmienna*120.13388f, zmienna*54.953244f, zmienna*120.31118f, zmienna*50.216522f)
        path5.cubicTo(zmienna*120.3822f, zmienna*48.319088f, zmienna*114.6749f, zmienna*43.179802f, zmienna*114.6749f, zmienna*43.179802f)
        path5.close()


        val path6 = Path()

        path6.relativeMoveTo(zmienna*77.016473f, zmienna*170.46546f)
        path6.relativeMoveTo(zmienna*2.913955f, zmienna*19.16284f)
        path6.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*0.019f, zmienna*2.37185f, zmienna*-4.7028f, zmienna*4.88368f)
        path6.relativeCubicTo(zmienna*-4.59856f, zmienna*2.44625f, zmienna*-8.29052f, zmienna*3.02952f, zmienna*-9.58649f, zmienna*3.93408f)
        path6.relativeCubicTo(zmienna*-1.90842f, zmienna*1.33204f, zmienna*-2.77248f, zmienna*3.71508f, zmienna*-0.4974f, zmienna*4.20539f)
        path6.relativeCubicTo(zmienna*7.80344f, zmienna*1.68175f, zmienna*9.92209f, zmienna*-2.44461f, zmienna*23.7401f, zmienna*-3.43666f)
        path6.relativeCubicTo(zmienna*3.68602f, zmienna*-0.26463f, zmienna*-1.26614f, zmienna*-12.93271f, zmienna*-1.26614f, zmienna*-12.93271f)
        path6.relativeLineTo(zmienna*1.018643f, zmienna*-14.88296f)
        path6.close()


        val path7 = Path()

        path7.moveTo(zmienna*85.389052f, zmienna*49.095233f)
        path7.cubicTo(zmienna*85.389052f, zmienna*49.095233f, zmienna*83.528212f, zmienna*55.496389f, zmienna*79.143451f, zmienna*57.29167f)
        path7.cubicTo(zmienna*77.066717f, zmienna*58.141962f, zmienna*82.13701f, zmienna*70.087094f, zmienna*83.028064f, zmienna*75.927122f)
        path7.cubicTo(zmienna*83.853512f, zmienna*81.337161f, zmienna*82.037754f, zmienna*92.319997f, zmienna*82.037754f, zmienna*92.319997f)
        path7.cubicTo(zmienna*82.037754f, zmienna*92.319997f, zmienna*85.666296f, zmienna*90.545291f, zmienna*89.806672f, zmienna*89.76812f)
        path7.cubicTo(zmienna*91.381912f, zmienna*89.472439f, zmienna*88.839508f, zmienna*83.407989f, zmienna*89.502009f, zmienna*80.334484f)
        path7.cubicTo(zmienna*90.485031f, zmienna*75.774002f, zmienna*96.059418f, zmienna*70.080162f, zmienna*95.671598f, zmienna*67.807854f)
        path7.cubicTo(zmienna*93.794645f, zmienna*56.810425f, zmienna*85.389052f, zmienna*49.095233f, zmienna*85.389052f, zmienna*49.095233f)
        path7.close()
        path7.moveTo(zmienna*110.97801f, zmienna*49.149907f)
        path7.cubicTo(zmienna*110.97801f, zmienna*49.149907f, zmienna*102.57243f, zmienna*56.865099f, zmienna*100.69547f, zmienna*67.862528f)
        path7.cubicTo(zmienna*100.30765f, zmienna*70.134836f, zmienna*105.88203f, zmienna*75.828676f, zmienna*106.86506f, zmienna*80.389159f)
        path7.cubicTo(zmienna*107.52756f, zmienna*83.462663f, zmienna*104.98515f, zmienna*89.527113f, zmienna*106.56039f, zmienna*89.822794f)
        path7.cubicTo(zmienna*110.70077f, zmienna*90.599965f, zmienna*114.32931f, zmienna*92.374671f, zmienna*114.32931f, zmienna*92.374671f)
        path7.cubicTo(zmienna*114.32931f, zmienna*92.374671f, zmienna*112.51355f, zmienna*81.391835f, zmienna*113.339f, zmienna*75.981797f)
        path7.cubicTo(zmienna*114.23006f, zmienna*70.141768f, zmienna*119.30034f, zmienna*58.196636f, zmienna*117.22361f, zmienna*57.346345f)
        path7.cubicTo(zmienna*112.83885f, zmienna*55.551063f, zmienna*110.97801f, zmienna*49.149907f, zmienna*110.97801f, zmienna*49.149907f)
        path7.close()


        val path8 = Path()

        path8.relativeMoveTo(zmienna*86.113366f, zmienna*49.142228f)
        path8.relativeCubicTo(zmienna*8.721068f, zmienna*0.689702f, zmienna*16.618434f, zmienna*0.835336f, zmienna*23.805004f, zmienna*0f)
        path8.relativeCubicTo(zmienna*0.98719f, zmienna*-0.114747f, zmienna*-6.49604f, zmienna*7.997387f, zmienna*-7.97091f, zmienna*12.903777f)
        path8.relativeCubicTo(zmienna*-0.52174f, zmienna*1.735658f, zmienna*-7.014731f, zmienna*1.670024f, zmienna*-7.486187f, zmienna*0f)
        path8.relativeCubicTo(zmienna*-1.446124f, zmienna*-5.122562f, zmienna*-8.998339f, zmienna*-12.955216f, zmienna*-8.347907f, zmienna*-12.903777f)
        path8.close()


        val path9 = Path()

        path9.relativeMoveTo(zmienna*94.94599f, zmienna*63.057528f)
        path9.relativeCubicTo(zmienna*1.003365f, zmienna*0.503531f, zmienna*5.0612f, zmienna*0.617896f, zmienna*6.46289f, zmienna*0.05467f)
        path9.relativeCubicTo(zmienna*0.69904f, zmienna*-0.280882f, zmienna*-1.862965f, zmienna*8.557975f, zmienna*-3.123727f, zmienna*8.556958f)
        path9.relativeCubicTo(zmienna*-1.32214f, zmienna*-0.0011f, zmienna*-4.342527f, zmienna*-9.115162f, zmienna*-3.339163f, zmienna*-8.611632f)
        path9.close()


        val path10 = Path()

        path10.moveTo(zmienna*90.779441f, zmienna*89.767182f)
        path10.cubicTo(zmienna*90.779441f, zmienna*89.767182f, zmienna*90.24318f, zmienna*91.342171f, zmienna*90.99486f, zmienna*92.938596f)
        path10.cubicTo(zmienna*92.93391f, zmienna*97.056765f, zmienna*84.693558f, zmienna*100.37459f, zmienna*84.693558f, zmienna*100.37459f)
        path10.cubicTo(zmienna*84.693558f, zmienna*100.37459f, zmienna*82.452911f, zmienna*108.17002f, zmienna*86.203027f, zmienna*109.43894f)
        path10.cubicTo(zmienna*90.669729f, zmienna*110.95033f, zmienna*97.555627f, zmienna*111.9648f, zmienna*97.823938f, zmienna*108.62133f)
        path10.cubicTo(zmienna*97.986825f, zmienna*106.59156f, zmienna*98.27885f, zmienna*103.98704f, zmienna*98.319708f, zmienna*101.29843f)
        path10.cubicTo(zmienna*98.358305f, zmienna*104.0007f, zmienna*98.652736f, zmienna*106.62059f, zmienna*98.816402f, zmienna*108.66007f)
        path10.cubicTo(zmienna*99.084713f, zmienna*112.00354f, zmienna*105.9703f, zmienna*110.98876f, zmienna*110.43701f, zmienna*109.47737f)
        path10.cubicTo(zmienna*114.18712f, zmienna*108.20844f, zmienna*111.94678f, zmienna*100.41333f, zmienna*111.94678f, zmienna*100.41333f)
        path10.cubicTo(zmienna*111.94678f, zmienna*100.41333f, zmienna*103.70643f, zmienna*97.095505f, zmienna*105.64548f, zmienna*92.977336f)
        path10.cubicTo(zmienna*106.39716f, zmienna*91.380912f, zmienna*105.8609f, zmienna*89.805923f, zmienna*105.8609f, zmienna*89.805923f)
        path10.cubicTo(zmienna*105.8609f, zmienna*89.805923f, zmienna*100.82587f, zmienna*90.095341f, zmienna*99.667306f, zmienna*92.703653f)
        path10.cubicTo(zmienna*98.689689f, zmienna*94.904594f, zmienna*98.360624f, zmienna*97.537903f, zmienna*98.320324f, zmienna*100.1584f)
        path10.cubicTo(zmienna*98.282705f, zmienna*97.525157f, zmienna*97.955457f, zmienna*94.876988f, zmienna*96.973034f, zmienna*92.665225f)
        path10.cubicTo(zmienna*95.81447f, zmienna*90.056913f, zmienna*90.779441f, zmienna*89.767182f, zmienna*90.779441f, zmienna*89.767182f)
        path10.close()


        val path11 = Path()

        path11.moveTo(zmienna*105.91598f, zmienna*89.729692f)
        path11.cubicTo(zmienna*105.91598f, zmienna*89.729692f, zmienna*106.7887f, zmienna*90.463098f, zmienna*105.34451f, zmienna*94.485093f)
        path11.cubicTo(zmienna*104.65539f, zmienna*96.404252f, zmienna*112.08527f, zmienna*100.40052f, zmienna*112.08527f, zmienna*100.40052f)
        path11.cubicTo(zmienna*112.08527f, zmienna*100.40052f, zmienna*113.24486f, zmienna*93.996818f, zmienna*111.43778f, zmienna*91.662657f)
        path11.cubicTo(zmienna*110.52149f, zmienna*90.479112f, zmienna*105.91598f, zmienna*89.729692f, zmienna*105.91598f, zmienna*89.729692f)
        path11.close()
        path11.moveTo(zmienna*90.699736f, zmienna*89.76812f)
        path11.cubicTo(zmienna*90.699736f, zmienna*89.76812f, zmienna*86.093923f, zmienna*90.517853f, zmienna*85.177634f, zmienna*91.701398f)
        path11.cubicTo(zmienna*83.370556f, zmienna*94.035558f, zmienna*84.530147f, zmienna*100.43895f, zmienna*84.530147f, zmienna*100.43895f)
        path11.cubicTo(zmienna*84.530147f, zmienna*100.43895f, zmienna*91.960023f, zmienna*96.442992f, zmienna*91.270904f, zmienna*94.523834f)
        path11.cubicTo(zmienna*89.826715f, zmienna*90.501839f, zmienna*90.699736f, zmienna*89.76812f, zmienna*90.699736f, zmienna*89.76812f)
        path11.close()


        val path12 = Path()

        path12.relativeMoveTo(zmienna*96.014271f, zmienna*69.161107f)
        path12.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*-5.464949f, zmienna*6.938751f, zmienna*-6.283692f, zmienna*11.134798f)
        path12.relativeCubicTo(zmienna*-0.574595f, zmienna*2.944791f, zmienna*0.870627f, zmienna*8.874084f, zmienna*1.142489f, zmienna*8.931036f)
        path12.relativeCubicTo(zmienna*4.745122f, zmienna*0.994048f, zmienna*7.273849f, zmienna*3.363636f, zmienna*7.273849f, zmienna*3.363636f)
        path12.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*3.620963f, zmienna*-2.475249f, zmienna*7.197683f, zmienna*-3.363636f)
        path12.relativeCubicTo(zmienna*0.62569f, zmienna*-0.155409f, zmienna*1.69635f, zmienna*-6.677673f, zmienna*0.95207f, zmienna*-9.93626f)
        path12.relativeCubicTo(zmienna*-0.84648f, zmienna*-3.706102f, zmienna*-5.90286f, zmienna*-9.974923f, zmienna*-5.90286f, zmienna*-9.974923f)
        path12.relativeCubicTo(zmienna*0f, zmienna*0f, zmienna*-0.734642f, zmienna*2.874598f, zmienna*-2.132644f, zmienna*2.899687f)
        path12.relativeCubicTo(zmienna*-1.486739f, zmienna*0.02668f, zmienna*-2.246895f, zmienna*-3.054338f, zmienna*-2.246895f, zmienna*-3.054338f)
        path12.close()


        val path13 = Path()

        path13.moveTo(zmienna*84.532609f, zmienna*91.723892f)
        path13.lineTo(zmienna*82.171621f, zmienna*92.806441f)
        path13.cubicTo(zmienna*82.171621f, zmienna*92.806441f, zmienna*78.771173f, zmienna*107.15202f, zmienna*78.820323f, zmienna*114.45741f)
        path13.cubicTo(zmienna*78.878923f, zmienna*123.1651f, zmienna*81.057236f, zmienna*139.76092f, zmienna*83.161624f, zmienna*140.20675f)
        path13.cubicTo(zmienna*88.686828f, zmienna*141.3773f, zmienna*88.645566f, zmienna*110.43651f, zmienna*88.645566f, zmienna*110.43651f)
        path13.cubicTo(zmienna*88.645566f, zmienna*110.43651f, zmienna*84.152368f, zmienna*109.6175f, zmienna*83.694939f, zmienna*107.1117f)
        path13.cubicTo(zmienna*82.77288f, zmienna*102.06065f, zmienna*84.532609f, zmienna*91.723892f, zmienna*84.532609f, zmienna*91.723892f)
        path13.close()
        path13.moveTo(zmienna*112.12343f, zmienna*91.778566f)
        path13.cubicTo(zmienna*112.12343f, zmienna*91.778566f, zmienna*113.88315f, zmienna*102.11533f, zmienna*112.9611f, zmienna*107.16637f)
        path13.cubicTo(zmienna*112.50367f, zmienna*109.67217f, zmienna*108.01047f, zmienna*110.49119f, zmienna*108.01047f, zmienna*110.49119f)
        path13.cubicTo(zmienna*108.01047f, zmienna*110.49119f, zmienna*107.96921f, zmienna*141.43197f, zmienna*113.49441f, zmienna*140.26142f)
        path13.cubicTo(zmienna*115.5988f, zmienna*139.81559f, zmienna*117.77711f, zmienna*123.21977f, zmienna*117.83571f, zmienna*114.51208f)
        path13.cubicTo(zmienna*117.88486f, zmienna*107.2067f, zmienna*114.48441f, zmienna*92.861115f, zmienna*114.48441f, zmienna*92.861115f)
        path13.lineTo(zmienna*112.12343f, zmienna*91.778566f)
        path13.close()


        val path14 = Path()

        path14.moveTo(zmienna*89.081943f, zmienna*110.87266f)
        path14.lineTo(zmienna*87.304431f, zmienna*134.05575f)
        path14.cubicTo(zmienna*87.304431f, zmienna*134.05575f, zmienna*87.512878f, zmienna*144.97994f, zmienna*90.159036f, zmienna*142.53056f)
        path14.cubicTo(zmienna*92.805193f, zmienna*140.08117f, zmienna*97.803831f, zmienna*129.9581f, zmienna*96.514193f, zmienna*122.57355f)
        path14.cubicTo(zmienna*93.591015f, zmienna*117.20053f, zmienna*94.659904f, zmienna*112.08984f, zmienna*93.767605f, zmienna*111.63809f)
        path14.cubicTo(zmienna*93.009686f, zmienna*111.25439f, zmienna*89.081943f, zmienna*110.87266f, zmienna*89.081943f, zmienna*110.87266f)
        path14.close()
        path14.moveTo(zmienna*107.49469f, zmienna*110.92733f)
        path14.cubicTo(zmienna*107.49469f, zmienna*110.92733f, zmienna*103.56695f, zmienna*111.30906f, zmienna*102.80903f, zmienna*111.69277f)
        path14.cubicTo(zmienna*101.91673f, zmienna*112.14452f, zmienna*102.98562f, zmienna*117.2552f, zmienna*100.06244f, zmienna*122.62823f)
        path14.cubicTo(zmienna*98.772812f, zmienna*130.01278f, zmienna*103.77144f, zmienna*140.13584f, zmienna*106.4176f, zmienna*142.58523f)
        path14.cubicTo(zmienna*109.06376f, zmienna*145.03462f, zmienna*109.27221f, zmienna*134.11042f, zmienna*109.27221f, zmienna*134.11042f)
        path14.lineTo(zmienna*107.49469f, zmienna*110.92733f)
        path14.close()


        val path15 = Path()

        path15.moveTo(zmienna*99.539285f, zmienna*110.51368f)
        path15.cubicTo(zmienna*99.315338f, zmienna*110.51462f, zmienna*99.175228f, zmienna*110.52993f, zmienna*99.175228f, zmienna*110.52993f)
        path15.cubicTo(zmienna*99.175228f, zmienna*110.52993f, zmienna*97.666155f, zmienna*120.35323f, zmienna*100.16523f, zmienna*121.74219f)
        path15.cubicTo(zmienna*101.21973f, zmienna*122.32827f, zmienna*102.78208f, zmienna*112.46165f, zmienna*102.29787f, zmienna*111.68996f)
        path15.cubicTo(zmienna*101.63725f, zmienna*110.6371f, zmienna*100.21113f, zmienna*110.51088f, zmienna*99.539285f, zmienna*110.51368f)
        path15.close()
        path15.moveTo(zmienna*97.193377f, zmienna*110.59116f)
        path15.cubicTo(zmienna*96.521535f, zmienna*110.58836f, zmienna*95.095409f, zmienna*110.71427f, zmienna*94.434787f, zmienna*111.76713f)
        path15.cubicTo(zmienna*93.950578f, zmienna*112.53882f, zmienna*95.512936f, zmienna*122.40544f, zmienna*96.567432f, zmienna*121.81936f)
        path15.cubicTo(zmienna*99.066509f, zmienna*120.4304f, zmienna*97.557434f, zmienna*110.60741f, zmienna*97.557434f, zmienna*110.60741f)
        path15.cubicTo(zmienna*97.557434f, zmienna*110.60741f, zmienna*97.417324f, zmienna*110.5921f, zmienna*97.193377f, zmienna*110.59116f)
        path15.close()


        val path16 = Path()

        path16.moveTo(zmienna*81.827259f, zmienna*148.54503f)
        path16.cubicTo(zmienna*81.827259f, zmienna*148.54503f, zmienna*76.214567f, zmienna*170.28404f, zmienna*83.33519f, zmienna*170.03322f)
        path16.cubicTo(zmienna*88.606034f, zmienna*169.84756f, zmienna*86.88146f, zmienna*159.00788f, zmienna*85.920521f, zmienna*153.52069f)
        path16.cubicTo(zmienna*85.354641f, zmienna*150.28937f, zmienna*81.827259f, zmienna*148.54503f, zmienna*81.827259f, zmienna*148.54503f)
        path16.close()
        path16.moveTo(zmienna*114.11912f, zmienna*148.54503f)
        path16.cubicTo(zmienna*114.11912f, zmienna*148.54503f, zmienna*110.59205f, zmienna*150.28937f, zmienna*110.02617f, zmienna*153.52069f)
        path16.cubicTo(zmienna*109.06523f, zmienna*159.00788f, zmienna*107.34035f, zmienna*169.84756f, zmienna*112.61119f, zmienna*170.03322f)
        path16.cubicTo(zmienna*119.73182f, zmienna*170.28404f, zmienna*114.11912f, zmienna*148.54503f, zmienna*114.11912f, zmienna*148.54503f)
        path16.close()


        val path17 = Path()

        path17.moveTo(zmienna*106.82536f, zmienna*150.73043f)
        path17.cubicTo(zmienna*106.62954f, zmienna*150.74014f, zmienna*106.46895f, zmienna*150.82287f, zmienna*106.36375f, zmienna*151.00536f)
        path17.cubicTo(zmienna*104.90427f, zmienna*153.53707f, zmienna*103.88643f, zmienna*162.43289f, zmienna*103.88643f, zmienna*162.43289f)
        path17.cubicTo(zmienna*103.88643f, zmienna*162.43289f, zmienna*103.75486f, zmienna*169.57218f, zmienna*106.30989f, zmienna*169.8692f)
        path17.cubicTo(zmienna*108.02288f, zmienna*170.06833f, zmienna*109.2898f, zmienna*167.11162f, zmienna*109.00293f, zmienna*165.3856f)
        path17.cubicTo(zmienna*108.28967f, zmienna*161.09407f, zmienna*109.97232f, zmienna*152.75525f, zmienna*109.97232f, zmienna*152.75525f)
        path17.cubicTo(zmienna*109.97232f, zmienna*152.75525f, zmienna*107.88278f, zmienna*150.67797f, zmienna*106.82536f, zmienna*150.73043f)
        path17.close()
        path17.moveTo(zmienna*89.104408f, zmienna*150.7851f)
        path17.cubicTo(zmienna*88.046984f, zmienna*150.73264f, zmienna*85.95745f, zmienna*152.80992f, zmienna*85.95745f, zmienna*152.80992f)
        path17.cubicTo(zmienna*85.95745f, zmienna*152.80992f, zmienna*87.640093f, zmienna*161.14874f, zmienna*86.926833f, zmienna*165.44028f)
        path17.cubicTo(zmienna*86.639964f, zmienna*167.1663f, zmienna*87.906885f, zmienna*170.123f, zmienna*89.619874f, zmienna*169.92387f)
        path17.cubicTo(zmienna*92.174901f, zmienna*169.62685f, zmienna*92.043333f, zmienna*162.48756f, zmienna*92.043333f, zmienna*162.48756f)
        path17.cubicTo(zmienna*92.043333f, zmienna*162.48756f, zmienna*91.025498f, zmienna*153.59174f, zmienna*89.566019f, zmienna*151.06004f)
        path17.cubicTo(zmienna*89.460818f, zmienna*150.87755f, zmienna*89.300227f, zmienna*150.79482f, zmienna*89.104408f, zmienna*150.7851f)
        path17.close()


        val path18 = Path()

        path18.moveTo(zmienna*117.94311f, zmienna*57.890587f)
        path18.cubicTo(zmienna*117.94311f, zmienna*57.890587f, zmienna*118.08507f, zmienna*62.618819f, zmienna*121.65939f, zmienna*64.014405f)
        path18.cubicTo(zmienna*124.60108f, zmienna*65.16298f, zmienna*126.23704f, zmienna*69.646155f, zmienna*126.23704f, zmienna*69.646155f)
        path18.cubicTo(zmienna*126.23704f, zmienna*69.646155f, zmienna*126.97502f, zmienna*63.362848f, zmienna*124.83682f, zmienna*61.389733f)
        path18.cubicTo(zmienna*121.51441f, zmienna*58.323849f, zmienna*117.94311f, zmienna*57.890587f, zmienna*117.94311f, zmienna*57.890587f)
        path18.close()
        path18.moveTo(zmienna*78.370406f, zmienna*57.945261f)
        path18.cubicTo(zmienna*78.370406f, zmienna*57.945261f, zmienna*74.799109f, zmienna*58.378523f, zmienna*71.476703f, zmienna*61.444407f)
        path18.cubicTo(zmienna*69.338495f, zmienna*63.417522f, zmienna*70.076482f, zmienna*69.700829f, zmienna*70.076482f, zmienna*69.700829f)
        path18.cubicTo(zmienna*70.076482f, zmienna*69.700829f, zmienna*71.712748f, zmienna*65.217654f, zmienna*74.654435f, zmienna*64.069079f)
        path18.cubicTo(zmienna*78.228761f, zmienna*62.673493f, zmienna*78.370406f, zmienna*57.945261f, zmienna*78.370406f, zmienna*57.945261f)
        path18.close()


        val path19 = Path()

        path19.moveTo(zmienna*78.353788f, zmienna*60.022879f)
        path19.cubicTo(zmienna*78.353788f, zmienna*60.022879f, zmienna*77.39044f, zmienna*62.141535f, zmienna*76.737841f, zmienna*62.975596f)
        path19.cubicTo(zmienna*73.673704f, zmienna*66.89176f, zmienna*77.761079f, zmienna*70.302245f, zmienna*77.761079f, zmienna*70.302245f)
        path19.cubicTo(zmienna*77.761079f, zmienna*70.302245f, zmienna*79.622449f, zmienna*67.301036f, zmienna*79.754009f, zmienna*65.599955f)
        path19.cubicTo(zmienna*79.901919f, zmienna*63.687379f, zmienna*78.353788f, zmienna*60.022879f, zmienna*78.353788f, zmienna*60.022879f)
        path19.close()
        path19.moveTo(zmienna*117.99697f, zmienna*60.132227f)
        path19.cubicTo(zmienna*117.99697f, zmienna*60.132227f, zmienna*116.44884f, zmienna*63.796728f, zmienna*116.59675f, zmienna*65.709304f)
        path19.cubicTo(zmienna*116.72831f, zmienna*67.410384f, zmienna*118.58937f, zmienna*70.411594f, zmienna*118.58937f, zmienna*70.411594f)
        path19.cubicTo(zmienna*118.58937f, zmienna*70.411594f, zmienna*122.67674f, zmienna*67.001108f, zmienna*119.61261f, zmienna*63.084944f)
        path19.cubicTo(zmienna*118.96001f, zmienna*62.250883f, zmienna*117.99697f, zmienna*60.132227f, zmienna*117.99697f, zmienna*60.132227f)
        path19.close()


        val path20 = Path()

        path20.moveTo(zmienna*75.128971f, zmienna*64.076889f)
        path20.cubicTo(zmienna*73.482014f, zmienna*63.988114f, zmienna*70.047246f, zmienna*69.919526f, zmienna*70.047246f, zmienna*69.919526f)
        path20.cubicTo(zmienna*70.047246f, zmienna*69.919526f, zmienna*68.085662f, zmienna*73.772428f, zmienna*69.400991f, zmienna*74.621816f)
        path20.cubicTo(zmienna*70.484979f, zmienna*75.321814f, zmienna*71.394561f, zmienna*72.139691f, zmienna*72.63227f, zmienna*72.489211f)
        path20.cubicTo(zmienna*73.939568f, zmienna*72.858383f, zmienna*73.053122f, zmienna*76.180017f, zmienna*74.409781f, zmienna*76.207367f)
        path20.cubicTo(zmienna*76.425349f, zmienna*76.248005f, zmienna*78.331577f, zmienna*72.366441f, zmienna*77.264078f, zmienna*70.63029f)
        path20.cubicTo(zmienna*73.846781f, zmienna*65.072505f, zmienna*76.274729f, zmienna*64.752328f, zmienna*75.433019f, zmienna*64.178427f)
        path20.cubicTo(zmienna*75.340661f, zmienna*64.115455f, zmienna*75.238769f, zmienna*64.082808f, zmienna*75.128971f, zmienna*64.076889f)
        path20.close()
        path20.moveTo(zmienna*121.31688f, zmienna*64.131564f)
        path20.cubicTo(zmienna*121.20708f, zmienna*64.137482f, zmienna*121.10549f, zmienna*64.170129f, zmienna*121.01314f, zmienna*64.233101f)
        path20.cubicTo(zmienna*120.17143f, zmienna*64.807002f, zmienna*122.59907f, zmienna*65.127179f, zmienna*119.18177f, zmienna*70.684964f)
        path20.cubicTo(zmienna*118.11427f, zmienna*72.421116f, zmienna*120.02081f, zmienna*76.302679f, zmienna*122.03637f, zmienna*76.262041f)
        path20.cubicTo(zmienna*123.39303f, zmienna*76.234691f, zmienna*122.50628f, zmienna*72.913057f, zmienna*123.81358f, zmienna*72.543886f)
        path20.cubicTo(zmienna*125.05129f, zmienna*72.194365f, zmienna*125.96118f, zmienna*75.376488f, zmienna*127.04516f, zmienna*74.67649f)
        path20.cubicTo(zmienna*128.36049f, zmienna*73.827102f, zmienna*126.3986f, zmienna*69.9742f, zmienna*126.3986f, zmienna*69.9742f)
        path20.cubicTo(zmienna*126.3986f, zmienna*69.9742f, zmienna*122.96383f, zmienna*64.042788f, zmienna*121.31688f, zmienna*64.131564f)
        path20.close()


        val path21 = Path()

        path21.moveTo(zmienna*68.542394f, zmienna*72.472028f)
        path21.cubicTo(zmienna*68.503399f, zmienna*72.472506f, zmienna*68.45933f, zmienna*72.483301f, zmienna*68.409757f, zmienna*72.50577f)
        path21.cubicTo(zmienna*64.337741f, zmienna*74.351424f, zmienna*62.231028f, zmienna*85.719393f, zmienna*59.73885f, zmienna*99.242995f)
        path21.cubicTo(zmienna*59.63398f, zmienna*99.812054f, zmienna*60.907101f, zmienna*100.52813f, zmienna*61.246781f, zmienna*100.06311f)
        path21.cubicTo(zmienna*69.361552f, zmienna*88.954105f, zmienna*72.503019f, zmienna*72.833815f, zmienna*72.503019f, zmienna*72.833815f)
        path21.cubicTo(zmienna*72.503019f, zmienna*72.833815f, zmienna*70.357104f, zmienna*75.455117f, zmienna*69.217885f, zmienna*75.021094f)
        path21.cubicTo(zmienna*68.59771f, zmienna*74.784819f, zmienna*69.127306f, zmienna*72.464861f, zmienna*68.542394f, zmienna*72.472028f)
        path21.close()
        path21.moveTo(zmienna*127.93577f, zmienna*72.619492f)
        path21.cubicTo(zmienna*127.35085f, zmienna*72.612325f, zmienna*127.88076f, zmienna*74.932283f, zmienna*127.26058f, zmienna*75.168558f)
        path21.cubicTo(zmienna*126.12136f, zmienna*75.602581f, zmienna*123.97514f, zmienna*72.981279f, zmienna*123.97514f, zmienna*72.981279f)
        path21.cubicTo(zmienna*123.97514f, zmienna*72.981279f, zmienna*127.11661f, zmienna*89.101575f, zmienna*135.23138f, zmienna*100.21057f)
        path21.cubicTo(zmienna*135.57106f, zmienna*100.67559f, zmienna*136.84418f, zmienna*99.959518f, zmienna*136.73931f, zmienna*99.390459f)
        path21.cubicTo(zmienna*134.24713f, zmienna*85.86686f, zmienna*132.14042f, zmienna*74.498888f, zmienna*128.0684f, zmienna*72.653234f)
        path21.cubicTo(zmienna*128.01883f, zmienna*72.630765f, zmienna*127.97476f, zmienna*72.61997f, zmienna*127.93577f, zmienna*72.619492f)
        path21.close()


        val path22 = Path()

        path22.moveTo(zmienna*72.906775f, zmienna*73.323383f)
        path22.cubicTo(zmienna*72.906775f, zmienna*73.323383f, zmienna*62.869938f, zmienna*102.21791f, zmienna*65.012606f, zmienna*100.90821f)
        path22.cubicTo(zmienna*67.519343f, zmienna*99.37597f, zmienna*76.306501f, zmienna*83.974963f, zmienna*76.124821f, zmienna*75.913688f)
        path22.cubicTo(zmienna*76.108511f, zmienna*75.189853f, zmienna*74.704488f, zmienna*76.839902f, zmienna*74.068189f, zmienna*76.512917f)
        path22.cubicTo(zmienna*73.07198f, zmienna*76.000984f, zmienna*72.906775f, zmienna*73.323383f, zmienna*72.906775f, zmienna*73.323383f)
        path22.close()
        path22.moveTo(zmienna*123.56739f, zmienna*73.336505f)
        path22.cubicTo(zmienna*123.56739f, zmienna*73.336505f, zmienna*123.40187f, zmienna*76.014418f, zmienna*122.40566f, zmienna*76.526351f)
        path22.cubicTo(zmienna*121.76936f, zmienna*76.853336f, zmienna*120.36565f, zmienna*75.203287f, zmienna*120.34934f, zmienna*75.927122f)
        path22.cubicTo(zmienna*120.16766f, zmienna*83.988397f, zmienna*128.95451f, zmienna*99.389099f, zmienna*131.46125f, zmienna*100.92134f)
        path22.cubicTo(zmienna*133.60391f, zmienna*102.23103f, zmienna*123.56739f, zmienna*73.336505f, zmienna*123.56739f, zmienna*73.336505f)
        path22.close()


        val path23 = Path()

        path23.moveTo(zmienna*59.713f, zmienna*99.944699f)
        path23.cubicTo(zmienna*59.630765f, zmienna*99.946162f, zmienna*59.560295f, zmienna*99.955849f, zmienna*59.503429f, zmienna*99.975004f)
        path23.cubicTo(zmienna*52.960235f, zmienna*102.17905f, zmienna*55.705614f, zmienna*112.42594f, zmienna*59.65576f, zmienna*112.96558f)
        path23.cubicTo(zmienna*62.745167f, zmienna*113.38763f, zmienna*65.80307f, zmienna*105.42528f, zmienna*65.063691f, zmienna*102.68153f)
        path23.cubicTo(zmienna*64.824797f, zmienna*101.79503f, zmienna*60.946531f, zmienna*99.922743f, zmienna*59.713f, zmienna*99.944699f)
        path23.close()
        path23.moveTo(zmienna*136.43926f, zmienna*100.17652f)
        path23.cubicTo(zmienna*135.20573f, zmienna*100.15456f, zmienna*131.32747f, zmienna*102.02685f, zmienna*131.08857f, zmienna*102.91335f)
        path23.cubicTo(zmienna*130.34919f, zmienna*105.6571f, zmienna*133.4071f, zmienna*113.61976f, zmienna*136.4965f, zmienna*113.19771f)
        path23.cubicTo(zmienna*140.44665f, zmienna*112.65807f, zmienna*143.19203f, zmienna*102.41117f, zmienna*136.64883f, zmienna*100.20713f)
        path23.cubicTo(zmienna*136.59197f, zmienna*100.18798f, zmienna*136.5215f, zmienna*100.17798f, zmienna*136.43926f, zmienna*100.17652f)
        path23.close()


        drawPath(//stopa_prawa
            path = path1,
            color = Color.LightGray
        )
        drawPath(//glowa
            path = path2,
            color = Color.LightGray
        )
        drawPath(//barki_szersze
            path = path3,
            color = if (selectedMuscle == "barki_szersze") Color.Green else Color.Black
        )
        drawPath(//gorne_plecy
            path = path4,
            color = if (selectedMuscle == "gorne_plecy") Color.Green else Color.Black
        )
        drawPath(//barki
            path = path5,
            color = if (selectedMuscle == "barki") Color.Green else Color.Black
        )
        drawPath(//stopa-lewa
            path = path6,
            color = Color.LightGray
        )
        drawPath(//plecy
            path = path7,
            color = if (selectedMuscle == "plecy") Color.Green else Color.Black
        )
        drawPath(//plecy_srodek_wieksze
            path = path8,
            color = if (selectedMuscle == "plecy_srodek_wieksze") Color.Green else Color.Black
        )
        drawPath(//plecy_srodek_wieksze
            path = path9,
            color = if (selectedMuscle == "plecy_srodek_wieksze") Color.Green else Color.Black
        )
        drawPath(//posladki
            path = path10,
            color = if (selectedMuscle == "posladki") Color.Green else Color.Black
        )
        drawPath(//posladki_gorne
            path = path11,
            color = if (selectedMuscle == "posladki_gorne") Color.Green else Color.Black
        )
        drawPath(//plecy_dol
            path = path12,
            color = if (selectedMuscle == "plecy_dol") Color.Green else Color.Black
        )
        drawPath(//uda_duze
            path = path13,
            color = if (selectedMuscle == "uda_duze") Color.Green else Color.Black
        )
        drawPath(//uda_srednie
            path = path14,
            color = if (selectedMuscle == "uda_srednie") Color.Green else Color.Black
        )
        drawPath(//uda_male
            path = path15,
            color = if (selectedMuscle == "uda_male") Color.Green else Color.Black
        )
        drawPath(//lydki2
            path = path16,
            color = if (selectedMuscle == "lydki2") Color.Green else Color.Black
        )
        drawPath(//lydki1
            path = path17,
            color = if (selectedMuscle == "lydki1") Color.Green else Color.Black
        )
        drawPath(//tric2
            path = path18,
            color = if (selectedMuscle == "tric2") Color.Green else Color.Black
        )
        drawPath(//tric1
            path = path19,
            color = if (selectedMuscle == "tric1") Color.Green else Color.Black
        )
        drawPath(//tric3
            path = path20,
            color = if (selectedMuscle == "tric3") Color.Green else Color.Black
        )
        drawPath(//przedramie2
            path = path21,
            color = if (selectedMuscle == "przedramie2") Color.Green else Color.Black
        )
        drawPath(//przedramie1
            path = path22,
            color = if (selectedMuscle == "przedramie1") Color.Green else Color.Black
        )
        drawPath(//dlon
            path = path23,
            color = if (selectedMuscle == "dlon") Color.Green else Color.Black
        )


    }














}