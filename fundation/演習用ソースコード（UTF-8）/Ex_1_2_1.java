/*-< 演習：Ex1_2_1 >---------------------------------
注文を受け付け、会計額を表示するケーキ屋プログラムを作成しましょう。
≪要件≫ ・商品は以下の5種類とする。
- ショートケーキ :320円 - モンブラン :350円 - チョコレートケーキ:370円 - いちごのタルト :400円 - チーズケーキ :300円
・「ケーキ名」「個数」を注文情報とし、これをコマンドライン引数として受け取って会計額の計算を行う。 ・特売期間のため、合計金額が1000円以上である場合は2割り引きとする。 ・消費税は8パーセントとし、小数点以下切り捨てで会計額を算出する。
----------------------------------------------------*/
class Ex1_2_1 {
    public static void main (String[] args) {

        final String CAKE_NAME_SHT  = "ショートケーキ";  //ショートケーキ - 名前
        final int CAKE_PRICE_SHT = 320;  //ショートケーキ - 値段
        final String CAKE_NAME_MNB  = "モンブラン";  //モンブラン - 名前
        final int CAKE_PRICE_MNB = 350;  //モンブラン - 値段
        final String CAKE_NAME_CHO  = "チョコレートケーキ";  //チョコレートケーキ - 名前
        final int CAKE_PRICE_CHO = 370;  //チョコレートケーキ - 値段
        final String CAKE_NAME_ICH  = "いちごのタルト";  //いちごのタルト - 名前
        final int CAKE_PRICE_ICH = 400;  //いちごのタルト - 値段
        final String CAKE_NAME_CHZ  = "チーズケーキ";  //チーズケーキ - 名前
        final int CAKE_PRICE_CHZ = 300;  //チーズケーキ - 値段

        final int DISCOUNT_APPLYING_PRICE = 1000;  //割引が適用される金額
        final double DISCOUNT_RATE  = 0.8;  //割引率
        final double TAX            = 1.08;  //消費税


        //------------支払い額の計算------------

        String cakeName = "";
        int checkCakeCount  = 0;  //処理対象のケーキの個数
        int totalPrice      = 0;  //合計金額
        int payment         = 0;  //支払い額
        int checkCakePrice  = 0;  //処理対象のケーキの値段

        for (int i = 0 ; i < args.length ; i++) {
            if(i % 2 == 0){
                cakeName  = args[i];

                switch (cakeName){

                    //ケーキ名が「ショートケーキ」の場合
                    case CAKE_NAME_SHT :
                        checkCakePrice = CAKE_PRICE_SHT ;
                        break;

                    //ケーキ名が「モンブラン」の場合
                    case CAKE_NAME_MNB :
                        checkCakePrice = CAKE_PRICE_MNB ;
                        break;

                    //ケーキ名が「チョコレートケーキ」の場合
                    case CAKE_NAME_CHO :
                        checkCakePrice = CAKE_PRICE_CHO ;
                        break;

                    //ケーキ名が「いちごのタルト」の場合
                    case CAKE_NAME_ICH :
                        checkCakePrice = CAKE_PRICE_ICH ;
                        break;

                    //ケーキ名が「チーズケーキ」の場合
                    case CAKE_NAME_CHZ :
                        checkCakePrice = CAKE_PRICE_CHZ ;
                        break;
                }
            }else{
                //処理対象のケーキの個数を取得
                checkCakeCount = Integer.parseInt(args[i]) ;

                //小計を算出し、合計金額に加算する
                totalPrice += checkCakePrice * checkCakeCount ;
            }
        }

        //支払い額を計算する
        if (totalPrice > DISCOUNT_APPLYING_PRICE) {        //合計金額が割引対象である場合
            //割引率を加味した税込み額を計算して支払額とする
            payment = (int)(totalPrice * DISCOUNT_RATE * TAX);
        }else{                                    //合計金額が割引対象でない場合
            //税込み額を計算して支払額とする
            payment = (int)(totalPrice * TAX);

        }

        //------------メッセージの表示------------

        System.out.println("合計金額は" + payment + "円です。");

    }
}
