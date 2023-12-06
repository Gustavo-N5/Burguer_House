package app.burguer_house.list_lanches

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import app.burguer_house.model.Lanches

@Composable
fun LancheItem(
    lanches: Lanches

){

    val imageLanhce = lanches.imgLanches
    val nomeLanches = lanches.lancheName
    val lanchesDescript = lanches.lancheDescription
    val lanchesPreco = lanches.preco

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
    ) {
        val (
            imgLanche,
            txtLancheNome,
            txtLancheDescription,
            txtPreco,
            btAddCart,
            containerImg,
            rowItem
        ) = createRefs()

        Card(
            modifier = Modifier
                .constrainAs(containerImg) {
                    top.linkTo(parent.top, 0.dp)
                    start.linkTo(parent.start, 0.dp)
                }
                .size(130.dp)
                .padding(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = ShapeDefaults.Medium,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

        }
        Image(
            painter = painterResource(imageLanhce!!),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imgLanche) {
                    top.linkTo(containerImg.top, 0.dp)
                    start.linkTo(containerImg.start, 0.dp)
                    end.linkTo(containerImg.end, 0.dp)
                    bottom.linkTo(containerImg.bottom, 0.dp)
                }
                .size(80.dp)
        )
        Text(
            text = nomeLanches!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtLancheNome){
                top.linkTo(parent.top, 30.dp)
                start.linkTo(containerImg.end,0.dp)
            }
        )

        Text(
            text = lanchesDescript!!,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .constrainAs(txtLancheDescription) {
                    top.linkTo(txtLancheNome.bottom, 0.dp)
                    start.linkTo(containerImg.end, 0.dp)
                    end.linkTo(parent.end)
                }
                .padding(60.dp, 10.dp, 60.dp, 10.dp),
            maxLines = 8
        )
        Text(
            text = lanchesPreco!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(txtPreco){
                top.linkTo(txtLancheDescription.bottom, 20.dp)
                start.linkTo(containerImg.end,0.dp)
            }
        )

        Button(
            onClick = { },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .constrainAs(btAddCart) {
                    top.linkTo(txtLancheDescription.bottom, 10.dp)
                    start.linkTo(txtPreco.end, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF44336)
            )
        ) {
            Text(text = "Add Carrinho", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

        Row (
            modifier = Modifier.width(350.dp).height(3.dp).background(Color.White)
                .constrainAs(rowItem){
                    top.linkTo(txtPreco.bottom, 30.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }
        ) {

        }
    }
}
