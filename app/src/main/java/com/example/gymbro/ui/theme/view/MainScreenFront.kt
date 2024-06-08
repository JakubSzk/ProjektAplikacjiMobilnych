package com.example.gymbro.ui.theme.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.gymbro.ui.theme.viewModel.FrontHitboxes

@Composable
fun MainScreenFront(modifier: Modifier = Modifier.fillMaxSize()) {
    val zmienna = 5f
    val miesnie = FrontHitboxes(zmienna)
    var selectedMuscle by remember { mutableStateOf("") }

    Canvas(modifier = Modifier.size((zmienna*210).dp, (zmienna*297).dp)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {tapOffset ->
                    var index = 0
                    //var porown: Pair<Float, Float> = Pair<Float, Float>(tapOffset.x, tapOffset.y)

                    val prawa: Boolean = tapOffset.x > 525
                    for (miesien in miesnie.miesnie)
                    {
                        var counter: Int = 0
                        for (trojkot in miesien.value)
                        {
                            val d1 = tapOffset.x*(trojkot.first.second-trojkot.second.second) + tapOffset.y*(trojkot.second.first-trojkot.first.first) + (trojkot.first.first*trojkot.second.second-trojkot.first.second*trojkot.second.first)
                            val d2 = tapOffset.x*(trojkot.second.second-trojkot.third.second) + tapOffset.y*(trojkot.third.first-trojkot.second.first) + (trojkot.second.first*trojkot.third.second-trojkot.second.second*trojkot.third.first)
                            val d3 = tapOffset.x*(trojkot.third.second-trojkot.first.second) + tapOffset.y*(trojkot.first.first-trojkot.third.first) + (trojkot.third.first*trojkot.first.second-trojkot.third.second*trojkot.first.first)
                            if ((d1<=0)&&(d2<=0)&&(d3<=0) || (d1>=0)&&(d2>=0)&&(d3>=0) )
                            {
                                println(miesien.key)
                                selectedMuscle = miesien.key
                            }
                        }
                    }
                })})
    {
        val path = Path()


        path.relativeMoveTo(zmienna*108.25747F, zmienna*92.855831F)
        path.relativeCubicTo(zmienna*-0.50534F, zmienna*0.0013F, zmienna*-0.87129F, zmienna*0.05015F, zmienna*-1.01492F, zmienna*0.159163F)
        path.relativeCubicTo(zmienna*-0.70075F, zmienna*0.531888F, zmienna*-1.69616F, zmienna*6.334486F, zmienna*-0.95911F, zmienna*6.906555F)
        path.relativeCubicTo(zmienna*0.93339F, zmienna*0.724481F, zmienna*8.82694F, zmienna*5.860081F, zmienna*10.26397F, zmienna*5.819281F)
        path.relativeCubicTo(zmienna*0.64976F, zmienna*-0.0185F, zmienna*1.73653F, zmienna*-9.077607F, zmienna*-0.54364F, zmienna*-11.287164F)
        path.relativeCubicTo(zmienna*-0.74274F, zmienna*-0.719734F, zmienna*-5.55636F, zmienna*-1.603548F, zmienna*-7.7463F, zmienna*-1.597835F)
        path.close()
        path.relativeMoveTo(zmienna*-4.71444F, zmienna*0.06408F)
        path.relativeCubicTo(zmienna*-2.18991F, zmienna*-0.0057F, zmienna*-7.003559F, zmienna*0.878101F, zmienna*-7.746293F, zmienna*1.597835F)
        path.relativeCubicTo(zmienna*-2.280165F, zmienna*2.209557F, zmienna*-1.19339F, zmienna*11.268694F, zmienna*-0.543636F, zmienna*11.287164F)
        path.relativeCubicTo(zmienna*1.437025F, zmienna*0.0408F, zmienna*9.330549F, zmienna*-5.09532F, zmienna*10.263969F, zmienna*-5.819798F)
        path.relativeCubicTo(zmienna*0.73705F, zmienna*-0.572069F, zmienna*-0.25836F, zmienna*-6.374667F, zmienna*-0.95911F, zmienna*-6.906555F)
        path.relativeCubicTo(zmienna*-0.14363F, zmienna*-0.109016F, zmienna*-0.50956F, zmienna*-0.157328F, zmienna*-1.01493F, zmienna*-0.158646F)
        path.close()
        path.relativeMoveTo(zmienna*1.42679F, zmienna*9.153449F)
        path.relativeCubicTo(zmienna*-1.79772F, zmienna*0.12357F, zmienna*-8.040283F, zmienna*4.25312F, zmienna*-9.50898F, zmienna*5.77794F)
        path.relativeCubicTo(zmienna*-0.748448F, zmienna*0.77705F, zmienna*-0.998691F, zmienna*5.20586F, zmienna*-0.19172F, zmienna*5.11596F)
        path.relativeCubicTo(zmienna*1.768658F, zmienna*-0.1969F, zmienna*8.73347F, zmienna*-0.74881F, zmienna*10.29601F, zmienna*-2.19056F)
        path.relativeCubicTo(zmienna*0.40917F, zmienna*-0.37754F, zmienna*0.18371F, zmienna*-7.59585F, zmienna*-0.12815F, zmienna*-8.50542F)
        path.relativeCubicTo(zmienna*-0.041F, zmienna*-0.11942F, zmienna*-0.14716F, zmienna*-0.18227F, zmienna*-0.30748F, zmienna*-0.19741F)
        path.relativeCubicTo(zmienna*-0.0484F, zmienna*-0.005F, zmienna*-0.10169F, zmienna*-0.004F, zmienna*-0.15968F, zmienna*-5.1e-4F)
        path.close()
        path.relativeMoveTo(zmienna*1.90428F, zmienna*0.032F)
        path.relativeCubicTo(zmienna*-0.058F, zmienna*-0.004F, zmienna*-0.11125F, zmienna*-0.004F, zmienna*-0.15968F, zmienna*5.1e-4F)
        path.relativeCubicTo(zmienna*-0.16033F, zmienna*0.0151F, zmienna*-0.26653F, zmienna*0.078F, zmienna*-0.30748F, zmienna*0.19741F)
        path.relativeCubicTo(zmienna*-0.3119F, zmienna*0.90957F, zmienna*-0.53733F, zmienna*8.12788F, zmienna*-0.12816F, zmienna*8.50542F)
        path.relativeCubicTo(zmienna*1.56254F, zmienna*1.44175F, zmienna*8.52736F, zmienna*1.99362F, zmienna*10.29602F, zmienna*2.19056F)
        path.relativeCubicTo(zmienna*0.80697F, zmienna*0.0899F, zmienna*0.55673F, zmienna*-4.33891F, zmienna*-0.19172F, zmienna*-5.11596F)
        path.relativeCubicTo(zmienna*-1.46871F, zmienna*-1.52482F, zmienna*-7.71129F, zmienna*-5.65437F, zmienna*-9.50898F, zmienna*-5.77794F)
        path.close()
        path.relativeMoveTo(zmienna*-4.86379F, zmienna*10.90114F)
        path.relativeCubicTo(zmienna*-2.451649F, zmienna*0.0166F, zmienna*-5.460042F, zmienna*0.73061F, zmienna*-6.693131F, zmienna*1.55908F)
        path.relativeCubicTo(zmienna*-0.849504F, zmienna*0.57075F, zmienna*-0.778446F, zmienna*6.88429F, zmienna*0.159681F, zmienna*7.22643F)
        path.relativeCubicTo(zmienna*2.265641F, zmienna*0.8263F, zmienna*9.45492F, zmienna*1.06124F, zmienna*9.81645F, zmienna*-0.38344F)
        path.relativeCubicTo(zmienna*0.51614F, zmienna*-2.06249F, zmienna*0.69077F, zmienna*-7.11917F, zmienna*-0.22375F, zmienna*-7.77007F)
        path.relativeCubicTo(zmienna*-0.6435F, zmienna*-0.45798F, zmienna*-1.77505F, zmienna*-0.64069F, zmienna*-3.05925F, zmienna*-0.632F)
        path.close()
        path.relativeMoveTo(zmienna*7.90029F, zmienna*0.0641F)
        path.relativeCubicTo(zmienna*-1.28417F, zmienna*-0.009F, zmienna*-2.41575F, zmienna*0.17402F, zmienna*-3.05924F, zmienna*0.632F)
        path.relativeCubicTo(zmienna*-0.91456F, zmienna*0.6509F, zmienna*-0.7399F, zmienna*5.70706F, zmienna*-0.22376F, zmienna*7.76955F)
        path.relativeCubicTo(zmienna*0.36153F, zmienna*1.44468F, zmienna*7.55029F, zmienna*1.21026F, zmienna*9.81594F, zmienna*0.38396F)
        path.relativeCubicTo(zmienna*0.93813F, zmienna*-0.34214F, zmienna*1.00967F, zmienna*-6.65568F, zmienna*0.1602F, zmienna*-7.22643F)
        path.relativeCubicTo(zmienna*-1.23309F, zmienna*-0.82847F, zmienna*-4.24148F, zmienna*-1.54249F, zmienna*-6.69314F, zmienna*-1.55908F)
        path.close()
        path.relativeMoveTo(zmienna*4.52686F, zmienna*9.97665F)
        path.relativeCubicTo(zmienna*-1.9526F, zmienna*-0.0282F, zmienna*-4.92664F, zmienna*0.21301F, zmienna*-6.93808F, zmienna*0.56741F)
        path.relativeCubicTo(zmienna*-0.6139F, zmienna*0.10816F, zmienna*-0.0468F, zmienna*2.14652F, zmienna*-1.56683F, zmienna*2.17454F)
        path.relativeCubicTo(zmienna*-1.52003F, zmienna*0.028F, zmienna*-1.20735F, zmienna*-2.01834F, zmienna*-1.82263F, zmienna*-2.11046F)
        path.relativeCubicTo(zmienna*-3.01616F, zmienna*-0.4516F, zmienna*-8.817448F, zmienna*-1.04709F, zmienna*-8.856819F, zmienna*0.0956F)
        path.relativeCubicTo(zmienna*-0.167322F, zmienna*4.8564F, zmienna*3.162116F, zmienna*25.73025F, zmienna*10.968839F, zmienna*25.98807F)
        path.relativeCubicTo(zmienna*7.80672F, zmienna*0.25784F, zmienna*10.19834F, zmienna*-26.33947F, zmienna*10.19834F, zmienna*-26.33947F)
        path.relativeCubicTo(zmienna*-0.007F, zmienna*-0.24493F, zmienna*-0.81126F, zmienna*-0.35878F, zmienna*-1.98282F, zmienna*-0.37569F)
        path.close()

        val path1 = Path()

        path1.relativeMoveTo(zmienna*99.585136F, zmienna*69.070203F)
        path1.relativeCubicTo(zmienna*-5.890465F, zmienna*0.02347F, zmienna*-16.140966F, zmienna*2.419274F, zmienna*-16.324585F, zmienna*4.935099F)
        path1.relativeCubicTo(zmienna*-0.31824F, zmienna*4.360297F, zmienna*19.117609F, zmienna*15.123776F, zmienna*20.710359F, zmienna*14.650785F)
        path1.relativeCubicTo(zmienna*2.10382F, zmienna*-0.624756F, zmienna*0.35576F, zmienna*-19.03766F, zmienna*-2.17041F, zmienna*-19.444291F)
        path1.relativeCubicTo(zmienna*-0.62148F, zmienna*-0.100038F, zmienna*-1.37387F, zmienna*-0.144946F, zmienna*-2.215364F, zmienna*-0.141593F)
        path1.close()
        path1.relativeMoveTo(zmienna*12.784234F, zmienna*0.06408F)
        path1.relativeCubicTo(zmienna*-0.8415F, zmienna*-0.0034F, zmienna*-1.59389F, zmienna*0.04156F, zmienna*-2.21537F, zmienna*0.141594F)
        path1.relativeCubicTo(zmienna*-2.52617F, zmienna*0.40663F, zmienna*-4.27423F, zmienna*18.819535F, zmienna*-2.17041F, zmienna*19.444291F)
        path1.relativeCubicTo(zmienna*1.59276F, zmienna*0.472991F, zmienna*21.0286F, zmienna*-10.290489F, zmienna*20.71036F, zmienna*-14.650785F)
        path1.relativeCubicTo(zmienna*-0.18362F, zmienna*-2.515825F, zmienna*-10.43412F, zmienna*-4.91163F, zmienna*-16.32458F, zmienna*-4.9351F)
        path1.close()

        val path2 = Path()

        path2.relativeMoveTo(zmienna*83.232646F, zmienna*75.895109F)
        path2.relativeCubicTo(zmienna*-0.914268F, zmienna*0.07149F, zmienna*1.062395F, zmienna*9.046752F, zmienna*3.163631F, zmienna*11.619963F)
        path2.relativeCubicTo(zmienna*3.877819F, zmienna*4.748849F, zmienna*9.730727F, zmienna*6.682659F, zmienna*17.586523F, zmienna*4.796089F)
        path2.relativeCubicTo(zmienna*0.62182F, zmienna*-0.14933F, zmienna*1.02188F, zmienna*-3.201911F, zmienna*0.38344F, zmienna*-3.165181F)
        path2.relativeCubicTo(zmienna*-5.647121F, zmienna*0.324929F, zmienna*-20.359026F, zmienna*-12.643513F, zmienna*-20.911386F, zmienna*-13.141834F)
        path2.relativeCubicTo(zmienna*-0.08747F, zmienna*-0.07891F, zmienna*-0.161257F, zmienna*-0.113803F, zmienna*-0.222208F, zmienna*-0.109037F)
        path2.close()
        path2.relativeMoveTo(zmienna*45.496444F, zmienna*0.06408F)
        path2.relativeCubicTo(zmienna*-0.061F, zmienna*-0.0048F, zmienna*-0.13473F, zmienna*0.03012F, zmienna*-0.22221F, zmienna*0.109037F)
        path2.relativeCubicTo(zmienna*-0.55235F, zmienna*0.498321F, zmienna*-15.26426F, zmienna*13.466247F, zmienna*-20.91138F, zmienna*13.141317F)
        path2.relativeCubicTo(zmienna*-0.63844F, zmienna*-0.03673F, zmienna*-0.23838F, zmienna*3.016368F, zmienna*0.38344F, zmienna*3.165698F)
        path2.relativeCubicTo(zmienna*7.8558F, zmienna*1.88657F, zmienna*13.70819F, zmienna*-0.04724F, zmienna*17.58601F, zmienna*-4.79609F)
        path2.relativeCubicTo(zmienna*2.10123F, zmienna*-2.57321F, zmienna*4.07841F, zmienna*-11.54847F, zmienna*3.16414F, zmienna*-11.619962F)
        path2.close()

        val path3 = Path()

        path3.relativeMoveTo(zmienna*83.534953F, zmienna*64.849272F)
        path3.relativeCubicTo(zmienna*-4.779812F, zmienna*-0.186271F, zmienna*-10.466136F, zmienna*6.701531F, zmienna*-10.980725F, zmienna*10.395748F)
        path3.relativeCubicTo(zmienna*-0.42058F, zmienna*3.019315F, zmienna*2.411379F, zmienna*9.990453F, zmienna*3.481958F, zmienna*10.038663F)
        path3.relativeCubicTo(zmienna*4.396035F, zmienna*0.197962F, zmienna*5.34789F, zmienna*-11.307803F, zmienna*7.099308F, zmienna*-13.113928F)
        path3.relativeCubicTo(zmienna*2.581497F, zmienna*-2.662136F, zmienna*10.237576F, zmienna*-1.833402F, zmienna*10.717175F, zmienna*-2.984314F)
        path3.relativeCubicTo(zmienna*0.4935F, zmienna*-1.184263F, zmienna*-7.721108F, zmienna*-3.999789F, zmienna*-9.857796F, zmienna*-4.295862F)
        path3.relativeCubicTo(zmienna*-0.152096F, zmienna*-0.02107F, zmienna*-0.305733F, zmienna*-0.0343F, zmienna*-0.45992F, zmienna*-0.04031F)
        path3.close()
        path3.relativeMoveTo(zmienna*45.075797F, zmienna*0F)
        path3.relativeCubicTo(zmienna*-0.15418F, zmienna*0.006F, zmienna*-0.3073F, zmienna*0.01923F, zmienna*-0.4594F, zmienna*0.04031F)
        path3.relativeCubicTo(zmienna*-2.13669F, zmienna*0.296073F, zmienna*-10.35129F, zmienna*3.111599F, zmienna*-9.8578F, zmienna*4.295862F)
        path3.relativeCubicTo(zmienna*0.4796F, zmienna*1.150912F, zmienna*8.13568F, zmienna*0.322178F, zmienna*10.71718F, zmienna*2.984314F)
        path3.relativeCubicTo(zmienna*1.75142F, zmienna*1.806125F, zmienna*2.70327F, zmienna*13.31189F, zmienna*7.09931F, zmienna*13.113928F)
        path3.relativeCubicTo(zmienna*1.07058F, zmienna*-0.04821F, zmienna*3.90254F, zmienna*-7.019348F, zmienna*3.48196F, zmienna*-10.038663F)
        path3.relativeCubicTo(zmienna*-0.51459F, zmienna*-3.694217F, zmienna*-6.20143F, zmienna*-10.582019F, zmienna*-10.98125F, zmienna*-10.395748F)
        path3.close()

        val path4 = Path()

        path4.relativeMoveTo(zmienna*98.628605F, zmienna*55.122217F)
        path4.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.06388F, zmienna*5.931529F, zmienna*-10.400399F, zmienna*10.129097F)
        path4.relativeCubicTo(zmienna*-1.727388F, zmienna*0.701479F, zmienna*12.755704F, zmienna*5.915131F, zmienna*14.741224F, zmienna*2.260844F)
        path4.relativeCubicTo(zmienna*1.22502F, zmienna*-2.254638F, zmienna*-4.340825F, zmienna*-12.389941F, zmienna*-4.340825F, zmienna*-12.389941F)
        path4.close()
        path4.relativeMoveTo(zmienna*14.600145F, zmienna*0.04548F)
        path4.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-5.56585F, zmienna*10.135304F, zmienna*-4.34082F, zmienna*12.389941F)
        path4.relativeCubicTo(zmienna*1.98552F, zmienna*3.654287F, zmienna*16.46912F, zmienna*-1.559365F, zmienna*14.74173F, zmienna*-2.260843F)
        path4.relativeCubicTo(zmienna*-10.33652F, zmienna*-4.197568F, zmienna*-10.40091F, zmienna*-10.129098F, zmienna*-10.40091F, zmienna*-10.129098F)
        path4.close()

        val path5 = Path()

        path5.relativeMoveTo(zmienna*124.93914F, zmienna*89.520634F)
        path5.relativeCubicTo(zmienna*-1.73031F, zmienna*0.109051F, zmienna*-4.02142F, zmienna*2.469621F, zmienna*-5.35316F, zmienna*4.357357F)
        path5.relativeCubicTo(zmienna*-1.97021F, zmienna*2.792767F, zmienna*-1.09016F, zmienna*12.981019F, zmienna*-0.89555F, zmienna*15.731859F)
        path5.relativeCubicTo(zmienna*0.0799F, zmienna*1.1291F, zmienna*-2.20989F, zmienna*28.07157F, zmienna*2.87786F, zmienna*25.57983F)
        path5.relativeCubicTo(zmienna*6.42944F, zmienna*-3.14883F, zmienna*3.11835F, zmienna*-21.49888F, zmienna*3.32538F, zmienna*-25.00416F)
        path5.relativeCubicTo(zmienna*0.13919F, zmienna*-2.35658F, zmienna*3.13366F, zmienna*-13.813625F, zmienna*3.13366F, zmienna*-13.813625F)
        path5.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.31002F, zmienna*-6.54166F, zmienna*-2.74971F, zmienna*-6.842476F)
        path5.relativeCubicTo(zmienna*-0.10991F, zmienna*-0.01355F, zmienna*-0.22312F, zmienna*-0.01606F, zmienna*-0.33848F, zmienna*-0.0088F)
        path5.close()
        path5.relativeMoveTo(zmienna*-38.1186F, zmienna*0.664042F)
        path5.relativeCubicTo(zmienna*-0.115354F, zmienna*-0.0073F, zmienna*-0.228564F, zmienna*-0.0048F, zmienna*-0.33848F, zmienna*0.0088F)
        path5.relativeCubicTo(zmienna*-2.439688F, zmienna*0.300816F, zmienna*-2.749703F, zmienna*6.842993F, zmienna*-2.749703F, zmienna*6.842993F)
        path5.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*2.994469F, zmienna*11.456531F, zmienna*3.133659F, zmienna*13.813101F)
        path5.relativeCubicTo(zmienna*0.207029F, zmienna*3.50528F, zmienna*-3.104066F, zmienna*21.85534F, zmienna*3.325378F, zmienna*25.00416F)
        path5.relativeCubicTo(zmienna*5.087755F, zmienna*2.49174F, zmienna*2.797444F, zmienna*-24.45073F, zmienna*2.877344F, zmienna*-25.57983F)
        path5.relativeCubicTo(zmienna*0.19461F, zmienna*-2.75084F, zmienna*1.075172F, zmienna*-12.939085F, zmienna*-0.895036F, zmienna*-15.731852F)
        path5.relativeCubicTo(zmienna*-1.331736F, zmienna*-1.887736F, zmienna*-3.622849F, zmienna*-4.248305F, zmienna*-5.353162F, zmienna*-4.357357F)
        path5.close()

        drawPath( //brzuch
            path = path,
            color =  if (selectedMuscle == "brzuch") Color.Green else Color.Black
        )
        drawPath( //klata gora
            path = path1,
            color = if (selectedMuscle == "klata_gora") Color.Green else Color.Black
        )
        drawPath( //klata dol
            path = path2,
            color = if (selectedMuscle == "klata_dol") Color.Green else Color.Black
        )
        drawPath( //barki
            path = path3,
            color = if (selectedMuscle == "barki") Color.Green else Color.Black
        )
        drawPath( //szyja
            path = path4,
            color = if (selectedMuscle == "szyja") Color.Green else Color.Black
        )
        drawPath( //boki
            path = path5,
            color = if (selectedMuscle == "boki") Color.Green else Color.Black
        )
    }
}