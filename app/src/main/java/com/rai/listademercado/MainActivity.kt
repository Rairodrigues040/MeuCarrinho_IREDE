package com.rai.listademercado

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rai.listademercado.components.CategoryCard
import com.rai.listademercado.components.Header
import com.rai.listademercado.components.ItemPill
import com.rai.listademercado.components.ProgressCard
import com.rai.listademercado.ui.theme.GreenPrimary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            var items by remember {
                mutableStateOf<List<Item>>(emptyList())
            }

            val addItemLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) { result ->

                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data

                    val itemName = data?.getStringExtra("item_name")
                    val itemQuantity = data?.getStringExtra("item_quantity")
                    val itemCategoryName = data?.getStringExtra("item_category")

                    if (
                        !itemName.isNullOrBlank() &&
                        !itemQuantity.isNullOrBlank() &&
                        !itemCategoryName.isNullOrBlank()
                    ) {

                        val category = Category.valueOf(itemCategoryName)

                        val newItem = Item(
                            name = itemName,
                            category = category,
                            quantityText = itemQuantity,
                            checked = false
                        )

                        items = items + newItem
                    }
                }
            }

            MainScreen(
                items = items,

                onItemsChange = { updatedItems ->
                    items = updatedItems
                },

                onAddClick = {
                    val intent = Intent(this, AddItemActivity::class.java)
                    addItemLauncher.launch(intent)
                }
            )
        }
    }
}

@Composable
fun MainScreen(
    items: List<Item>,
    onItemsChange: (List<Item>) -> Unit,
    onAddClick: () -> Unit
) {

    var expandedCategories by remember {
        mutableStateOf(setOf<Category>())
    }


    val checked = items.count { it.checked }
    val total = items.size
    val progress = if (items.isEmpty()) 0f else checked.toFloat() / items.size

    Scaffold(
        containerColor = Color.White,

        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = GreenPrimary,
                contentColor = Color.White,
                shape = RoundedCornerShape(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Adicionar"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 25.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(18.dp))
            Header(title = "Meu carrinho")
            Spacer(Modifier.height(25.dp))

            ProgressCard(
                progress = progress,
                checked = checked,
                total = total
            )

            Spacer(Modifier.height(25.dp))

            Category.entries.forEach { category ->

                CategoryCard(
                    category = category,


                    expanded = category in expandedCategories,

                    onToggle = {
                        expandedCategories =
                            if (category in expandedCategories) {
                                expandedCategories - category
                            } else {
                                expandedCategories + category
                            }
                    }
                ) {
                    
                    val categoryItems = items.filter { it.category == category }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Para cada item da categoria, mostramos um ItemPill
                        categoryItems.forEach { item ->
                            ItemPill(
                                item = item,

                                onToggle = {
                                    onItemsChange(
                                        items.map { currentItem ->
                                            if (currentItem == item) {
                                                currentItem.copy(checked = !currentItem.checked)
                                            } else {
                                                currentItem
                                            }
                                        }
                                    )
                                }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}