package com.example.geti_bug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        String name = getIntent().getStringExtra("이름");

        TextView title = findViewById(R.id.name);
        TextView information = findViewById(R.id.information);
        TextView kill = findViewById(R.id.kill);
        TextView prevention = findViewById(R.id.prevention);
        TextView insecticide = findViewById(R.id.insecticide);
        TextView uri = findViewById(R.id.uri);
        ImageView image = findViewById(R.id.imageView3);

        information.setMovementMethod(new ScrollingMovementMethod());
        kill.setMovementMethod(new ScrollingMovementMethod());
        prevention.setMovementMethod(new ScrollingMovementMethod());

        title.setText(name);

        if(name.equals("빈대")){
            uri.setText("https://namu.wiki/w/%EB%B9%88%EB%8C%80");
        }else if(name.equals("곱등이")){
            uri.setText("https://namu.wiki/w/%EA%BC%BD%EB%93%B1%EC%9D%B4?from=%EA%B3%B1%EB%93%B1%EC%9D%B4");
        }else if(name.equals("나방파리")){
            uri.setText("https://namu.wiki/w/%EB%82%98%EB%B0%A9%ED%8C%8C%EB%A6%AC");
        }else if(name.equals("그리마")){
            uri.setText("https://namu.wiki/w/%EA%B7%B8%EB%A6%AC%EB%A7%88");
        }else if(name.equals("쌀바구미")){
            uri.setText("https://namu.wiki/w/%EC%8C%80%EB%B0%94%EA%B5%AC%EB%AF%B8");
        }else if(name.equals("집게벌레")){
            uri.setText("https://namu.wiki/w/%EC%A7%91%EA%B2%8C%EB%B2%8C%EB%A0%88");
        }

        if(name.equals("빈대")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EB%B9%88%EB%8C%80+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }else if(name.equals("곱등이")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EA%B3%B1%EB%93%B1%EC%9D%B4+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }else if(name.equals("나방파리")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EB%82%98%EB%B0%A9%ED%8C%8C%EB%A6%AC+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }else if(name.equals("그리마")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EA%B7%B8%EB%A6%AC%EB%A7%88+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }else if(name.equals("쌀바구미")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EC%8C%80%EB%B0%94%EA%B5%AC%EB%AF%B8+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }else if(name.equals("집게벌레")){
            insecticide.setText("https://www.coupang.com/np/search?component=&q=%EC%A7%91%EA%B2%8C%EB%B2%8C%EB%A0%88+%EC%82%B4%EC%B6%A9%EC%A0%9C&channel=user");
        }

        if(name.equals("곱등이")){
            information.setText(" 메뚜기목 꼽등이과의 곤충으로, 야산이나 민간의 습한 곳에 서식한다. 종에 따라 다르지만 그 크기는 20~30mm로 메뚜기나 귀뚜라미와 비슷하다. 색은 밝은 갈색에서 짙은 갈색까지 다양하며, 다리가 발달되어 높이 뛰어오른다. 더듬이는 보통 몸길이의 4배 이상으로 길며, 가슴 앞쪽에서부터 배에 이르기까지 불규칙한 황갈색 무늬가 있다. 청력이 없고, 날개가 없어 날지 못하며, 모든 감각은 더듬이에 의존한다. 우리나라·일본을 포함한 거의 모든 대륙에 서식하며, 부식질이나 썩은 사체 등을 먹고 산다. 수명은 보통 1년 안팎이다.");
        }else if(name.equals("빈대")){
            information.setText("먹이를 먹기 전의 몸길이는 6.5∼9mm이고, 몸빛깔은 대개 갈색이다. 그러나 먹이를 먹은 후에는 몸이 부풀어오르고 몸빛깔은 붉은색이 된다. 몸은 편평하고 약간 사각형으로 보이며 머리는 작다. 촉각(더듬이)은 겹눈 사이에서 올라와 있다. 모두 4마디로, 제1마디는 짧고 제2마디가 가장 길며 다른 것은 실 모양이다.");
        }else if(name.equals("나방파리")){
            information.setText("화장실과 보일러실, 하수도 주변, 창고 등의 구석지고 습한 장소에서 어른벌레들을 볼 수 있다.\n" +
                    "몸은 전제적으로 회갈색이며 매우 긴 회색의 털들이 전체 표면을 빽빽이 덮고 있다. 머리는 작고 앞으로 휘어있으며 회색 털이 많고 작은 겹눈은 가로로 길며 짙은 갈색이다. 더듬이는 염주 모양으로 가늘고 길며 각 마디마다 긴 털이 많이 있어 마치 깃털처럼 보인다. 주둥이는 길이가 짧고 작은턱수염은 4마디이며 회색이다. 가슴의 윗면은 회갈색이며 긴 회색 센털들이 빽빽하고, 배는 짙은 갈색이며 가슴의 센털보다는 길이가 짧은 털들이 있다.");
        }else if(name.equals("그리마")){
            information.setText("몸빛깔은 파란빛을 띤 쪽빛, 잿빛을 띤 노랑, 검은 갈색 등이다. 몸은 머리와 몸통으로 나뉘고 100개 이상의 작은 몸마디가 있다. 머리에는 1쌍의 긴 더듬이와 200개의 육각형 눈이 모인 원시적인 1쌍의 겹눈이 달려있다. 몸통은 막대모양이다. 몸통에는 8개의 등판이 있는데, 제8·9몸마디의 등판은 합쳐져서 특히 크다. 등판 뒷가장자리 가운데에 기문이 존재한다.");
        }else if(name.equals("쌀바구미")){
            information.setText("몸 길이는 3~4mm이고, 흑갈색으로서 앞가슴의 등면과 앞날개 위에 원형의 작은 점각이 있다. 수컷의 주둥이는 뭉뚝하고 등면이 거칠며 광택이 없다. 암컷의 주둥이는 가늘고 길며 등면이 반드럽고 광택이 있다.");
        }else if(name.equals("집게벌레")){
            information.setText("집게벌레목에 속한 무리들은 딱지날개가 축소되어 배 부분이 드러나 있고, 배 끝에 집게 모양 부속지가 있다. 잡식성으로 우리나라에는 5과 21종이 알려졌다. 산지나 평지 등 다양한 곳에서 볼 수 있으며, 이른 밤부터 등불에 찾아온다. 각 종의 특징은 등 쪽 모습을 보고 표기했다.");
        }

        if(name.equals("빈대")){
            prevention.setText("매트리스를 뒤집어 구석구석을 확인해 빈대나 빈대의 흔적이 있는지 확인하고 이용자들이 직접 침대 커버를 씌우게 하는 숙소를 이용하자. 일단 빈대는 검은색~갈색으로 새하얀 침대 시트 위에서 눈에 매우 잘 띈다. 또 시트에 거뭇거뭇한 흔적이 남아있다면 역시 조심해야 한다. 빈대가 빤 피가 떨어진 흔적 내지는 빈대 배설물의 흔적으로 의심할 수 있다. 저런 얼룩이 남은 시트를 계속 쓴다는 것부터가 청결 면에서 실격이다. 이런 의미에서 커버를 직접 씌우게 하는 곳은 청결에 자신이 있다는 뜻이고, 커버를 씌우는 과정에서 매트리스를 확인할 수 있다. 더구나 혹시 모를 빈대 피해를 예방하는 효과도 있다.");
        }else if(name.equals("곱등이")){
            prevention.setText("끈끈이 설치: 곱등이는 어둡고 습한 곳을 좋아하므로, 싱크대 밑이나 화장실 하수구, 세면대 뒷쪽, 세탁기 아래 등에 해충 전용 끈끈이를 설치해두면 효과적입니다. 끈끈이에 붙은 곱등이는 장갑을 끼고 처리하시기 바랍니다.\n" +
                    "살충제 사용: 곱등이는 살충제에 내성이 있으므로, 일반 살충제보다는 살충력이 강력한 약제나 잔류성 살충제를 사용하는 것이 좋습니다. 살충제는 곱등이가 자주 출몰하는 곳이나 숨어있을 수 있는 곳에 뿌려주시면 됩니다.\n" +
                    "불로 태우기: 곱등이는 불에 약하므로, 라이터나 성냥 등으로 태워서 죽일 수 있습니다. 하지만 이 방법은 화재의 위험이 있으므로 주의하시기 바랍니다.\n" +
                    "직접 잡기: 곱등이는 손으로 직접 잡거나 책이나 신발로 때려잡을 수 있습니다. 하지만 이 방법은 연가시가 나올 수 있으므로 권장하지 않습니다. 만약 이 방법을 사용한다면, 장갑을 끼고 처리하시고, 연가시가 나오면 즉시 소독하시기 바랍니다.\n");
        }else if(name.equals("나방파리")){
            prevention.setText("방충망 보수하기, 배수구 열소독, 창가 실물 두기, 날파리 퇴치제, 과일 껍질 트랩, 맥주 트랩, 깨끗이 청소하기");
        }else if(name.equals("그리마")){
            prevention.setText("가옥 내에 침입을 방지하는 방법을 추천한다. 서식할 수 있는 주변 환경을 개선하고, 가옥 내 벽 틈이나, 배수구 트랩의 설치로 실내 서식을 억제한다.  알에서 성충이 되어 산란할 때까지 기간이 1년이라 끈끈이 트랩을 이용하여 목격되는 장소 주변에 설치를 해놓으면 1년 안에 다 잡을 수 있으니, 다른 방법은 사용하지 않아도 된다.");
        }else if(name.equals("쌀바구미")){
            prevention.setText("바구미가 집에 사는 것을 막을 수 있는 방법은 식료품 저장실의 균열과 선반을 깔끔하고 깨끗하게 유지하는 것입니다. 집안 환경을 청결하게 하면, 바구미뿐만 아니라, 개미나 바퀴벌레 등의 해충도 예방할 수 있습니다. 또한 바구미가 서식하는 것을 방지하는 방법은 곡물을 구입 후에는 냉장고나 밀폐 용기에 담아 보관하는 것입니다.");
        }else if(name.equals("집게벌레")){
            prevention.setText("이들은 먹이를 찾아다니는 성격이 있으므로 음식물 쓰레기나 쓸모없는 물건이나 쓰레기가 없는 청결한 환경을 유지해야 합니다. 습기가 많은 곳을 선호하므로, 습기가 많은 곳을 제거하고 건조한 환경을 유지해야 합니다. 집 내부를 자주 환기하여 공기를 순환시켜야 합니다. 이렇게 하면 집 안의 습기와 냄새가 제거되어 해충 벌레가 생기지 않을 가능성이 높아집니다.");
        }

        if(name.equals("빈대")){
            kill.setText("가장 확실한 방역법으로, 빈대는 살충제에 강한 내성을 가지고 있으나 열에 취약하다. 괜히 빈대 잡는데 초가삼간 태운다는 말이 있는 것이 아니다. 50도 이상의 고온을 가하면 완전히 박멸할수 있으며 실제로 북미의 일부 방역업체들이 집안의 온도를 통째로 50도 이상으로 달구는 방법으로 방역을 하기도 한다. 사실상 집 온도를 50도 이상으로 달구는 것이 가장 확실하게 빈대를 몰살시키는 방법이지만, 문제는 열을 가해서는 안 되는 소재로 된 가구가 있으면 이 방법을 쓰기도 애매하다는 점.");
        }else if(name.equals("곱등이")){
            kill.setText("끈끈이 설치: 곱등이는 어둡고 습한 곳을 좋아하므로, 싱크대 밑이나 화장실 하수구, 세면대 뒷쪽, 세탁기 아래 등에 해충 전용 끈끈이를 설치해두면 효과적입니다. 끈끈이에 붙은 곱등이는 장갑을 끼고 처리하시기 바랍니다.\n" +
                    "살충제 사용: 곱등이는 살충제에 내성이 있으므로, 일반 살충제보다는 살충력이 강력한 약제나 잔류성 살충제를 사용하는 것이 좋습니다. 살충제는 곱등이가 자주 출몰하는 곳이나 숨어있을 수 있는 곳에 뿌려주시면 됩니다.\n" +
                    "불로 태우기: 곱등이는 불에 약하므로, 라이터나 성냥 등으로 태워서 죽일 수 있습니다. 하지만 이 방법은 화재의 위험이 있으므로 주의하시기 바랍니다.\n" +
                    "직접 잡기: 곱등이는 손으로 직접 잡거나 책이나 신발로 때려잡을 수 있습니다. 하지만 이 방법은 연가시가 나올 수 있으므로 권장하지 않습니다. 만약 이 방법을 사용한다면, 장갑을 끼고 처리하시고, 연가시가 나오면 즉시 소독하시기 바랍니다.\n");
        }else if(name.equals("나방파리")){
            kill.setText("모기와 마찬가지로 더러운 물에 알을 낳는다. 그래서 유충이 있는 곳으로 의심되는 곳, 그러니까 물 고인 화분 밑그릇이나 배수구, 정화조 등에 모기 방제도 할 겸 뜨거운 물, 쌀뜨물 또는 식초물을 부어 주면 예방이 가능하다. 보다 확실한 효과를 보기 위해서는 주로 모기 유충 구제용으로 쓰이는 아발론, 아베이트 등의 약제를 구입해 정기적으로 사용해 주는 것이 좋다. 정화조 구제용 약품이지만 변기통에 넣고 내리는 방식으로 사용할 수 있으니 가정에서도 편리하게 이용할 수 있다.");
        }else if(name.equals("그리마")){
            kill.setText("그리마는 주로 하수구, 환풍구, 외부 출입문을 통해 들어오기 때문에 배수구나 출입문 같은 유입구를 거름망으로 잘 막아주시고 보이는 녀석들은 분무형, 가루형 살충제로 제거하셔야 합니다. ");
        }else if(name.equals("쌀바구미")){
            kill.setText("정향과 월계수 잎은 바구미에 대한 천연 기피제 역할을 합니다. 이러한 해충을 막기 위해 말린 식품 용기에 월계수 잎 몇 개를 넣고 식료품 저장실과 부엌 주변에 마늘 몇 쪽을 놓아 이러한 벌레가 식료품 저장실에 집을 만드는 것을 방지 하십시오. 백 식초는 성가신 식료품 저장실 바구미를 죽이는 것으로도 알려져 있습니다.");
        }else if(name.equals("집게벌레")){
            kill.setText("분무기에 따뜻한 물을 채우세요. 그 다음, 물비누를 몇 방울 넣은 뒤 거품이 생길 때까지 부드럽게 섞으세요. 식물 잎사귀에 분무기를 뿌려서 집게벌레를 죽이세요. 집 또는 정원에서 집게벌레를 발견할 경우에도 마찬가지입니다. 참고로 집게벌레는 습한 곳을 좋아합니다.");
        }

        if(name.equals("빈대")){
            image.setImageResource(R.drawable.binde);
        }else if(name.equals("곱등이")){
            image.setImageResource(R.drawable.gop);
        }else if(name.equals("나방파리")){
            image.setImageResource(R.drawable.pari);
        }else if(name.equals("그리마")){
            image.setImageResource(R.drawable.grima);
        }else if(name.equals("쌀바구미")){
            image.setImageResource(R.drawable.rice2);
        }else if(name.equals("집게벌레")){
            image.setImageResource(R.drawable.jip);
        }

    }

}