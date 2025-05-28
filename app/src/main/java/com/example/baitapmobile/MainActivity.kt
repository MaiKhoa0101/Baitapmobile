package com.example.baitapmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitapmobile.tuan2.BaiTapVeNha2
import com.example.baitapmobile.tuan2.bai2
import com.example.baitapmobile.tuan3.BaiTuan3_2
import com.example.baitapmobile.tuan3.GetStarted1
import com.example.baitapmobile.tuan3.GetStarted2
import com.example.baitapmobile.tuan3.GetStarted3
import com.example.baitapmobile.tuan3.ImageScreen
import com.example.baitapmobile.tuan3.LayoutScreen
import com.example.baitapmobile.tuan3.PassFieldScreen
import com.example.baitapmobile.tuan3.ScaffoldScreen
import com.example.baitapmobile.tuan3.TextFieldScreen
import com.example.baitapmobile.tuan3.TextScreen
import com.example.baitapmobile.tuan3.baitapvenha3.UIComponentsList
import com.example.baitapmobile.tuan3.baituan3
import com.example.baitapmobile.ui.theme.BaitapMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaitapMobileTheme {
                val navHostController = rememberNavController()
                NavHost(navHostController, startDestination = "home"){
                    composable("home") { UIComponentsList(navHostController) } // Truyền navController vào UIComponentsList
                    composable("text") { TextScreen(navHostController) }
                    composable("image") { ImageScreen(navHostController) }
                    composable("textfield") { TextFieldScreen(navHostController) }
                    composable("passwordfield") { PassFieldScreen(navHostController) }
                    composable("layout") { LayoutScreen(navHostController) }
                    composable("scaffold") { ScaffoldScreen(navHostController) }

                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Tuan 1
//                    Bai1(
//                        name = "Mai Nguyen Dang Khoa",
//                        avatar = R.drawable.avatar,
//                        address = "Hà Tiên, Kiên Giang",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    BaiTapVeNha1(
//                        name = "Mai Nguyen Dang Khoa-CN22H",
//                        avatar = R.drawable.avatar,
//                        text = "Mong muốn và định hướng của em sau khi học xong môn học là nắm chắc được kiến thức cơ bản của lập trình thiết bị di động mobile, được thử sức và tiếp cận thêm nhiều kiến thức công nghệ mới, đồng thời khơi gợi niềm yêu thích của em đối với lập trình Mobile và các kiến thức chuyên môn liên quan. Cuối cùng là tự tay làm được sản phẩm đạt đủ tiêu chuẩn để đem ra ngoài sử dụng cũng như là thêm 1 dự án đưa vào CV. ",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //Tuan 2
//                    bai2(modifier = Modifier.padding(innerPadding))
//                    BaiTapVeNha2(modifier = Modifier.padding(innerPadding))
//                    baituan3()
//                    BaiTuan3_2(navHostController)
//                }
            }
        }
    }
}




