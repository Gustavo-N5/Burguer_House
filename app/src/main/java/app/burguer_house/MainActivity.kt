package app.burguer_house

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.burguer_house.list_lanches.LancheItem
import app.burguer_house.model.Lanches
import app.burguer_house.ui.theme.Burguer_houseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodList()
        }
    }
}

@Composable
private fun FoodList(){
    val lanchesList: MutableList<Lanches> = mutableListOf(
        Lanches(
            imgLanches = R.drawable.hamburguer1,
            lancheName = "Chicken Burger",
            lancheDescription = "Feito com um filé de frango suculento, temperado com ervas, grelhado, montado em um pão de hambúrguer tostado e acompanhado de alface, tomate, cebola, picles.",
            preco = "R$ 15.00"
        ),
        Lanches(
            imgLanches = R.drawable.hamburguer2,
            lancheName = "Hamburguer Simples",
            lancheDescription = "Um hambúrguer simples com um suculento disco de carne moída, grelhado. Colocado entre duas metades de um pão de hambúrguer, acompanhado por alface, tomate e cebola.",
            preco = "R$ 12.00"
        ),
        Lanches(
            imgLanches = R.drawable.hamburguer3,
            lancheName = "Hamburguer Triplo",
            lancheDescription = "Três discos suculentos de carne moída, normalmente bovina, grelhados, queijo derretido entre as camadas de carne, acompanhamentos clássicos como alface, tomate e cebola, e molhos saborosos para intensificar o sabor.",
            preco = "R$ 20.00"
        ),
        Lanches(
            imgLanches = R.drawable.batata,
            lancheName = "Batata Frita",
            lancheDescription = "Batata Frita, porção com 300g",
            preco = "R$ 10.00"
        ),
        Lanches(
            imgLanches = R.drawable.refrigerante1l,
            lancheName = "Refrigerante 1L",
            lancheDescription = "Temos as opções de: Coca-Cola, Guarana, Pepsi e Fanta",
            preco = "R$ 10.00"
        ),
        Lanches(
            imgLanches = R.drawable.refrigerante350ml,
            lancheName = "Refrigerante 350ml",
            lancheDescription = "Temos as opções de: Coca-Cola, Guarana, Pepsi e Fanta",
            preco = "R$ 7.00"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        LazyColumn{
            itemsIndexed(lanchesList){position, lanche ->
                LancheItem(lanche)
            }
        }
    }
}
