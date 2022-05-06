class Ex2_02_1_Player {
        //定数
        final String HAND_G = "グー";
        final String HAND_C = "チョキ";
        final String HAND_P = "パー";

        //フィールド
        String name;
        String handStatus;

        //コンストラクタ
        Ex2_02_1_Player(String name) {
            this.name = name;
        }

        //メソッド
        //フィールドhandStatusに「グー」「チョキ」「パー」のいずれかをランダムに設定
        void makeHandStatus(){
            int random1to3 = 1 + (int)( Math.random() * 3.0 );
            switch(random1to3){
                case 1:
                    this.handStatus = HAND_G;
                    break;
                case 2:
                    this.handStatus = HAND_C;
                    break;
                case 3:
                    this.handStatus = HAND_P;
                    break;
            }
        }
}
